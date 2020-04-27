package com.epam.izh.rd.online.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

public class SimpleFileRepository implements FileRepository {

    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {
        class FileCounter {
            private long fileCount = 0;
            public long scanCount(File file) {
//                System.out.println("файл " + file + " существует " + file.exists());
                if (!file.exists()) {
//                    System.out.println("файл " + file + " not exist");
                    return 0;
                }

                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
//                    System.out.println(files[i]);
                    if (files[i].isDirectory()) {
//                        System.out.println(files[i].getPath());
//                        this.scanCount(files[i].getPath());
                        this.scanCount(new File(files[i].getPath()));
                    } else {
                        fileCount++;
                    }
                }
                return fileCount;
            }
        }

        ClassLoader classLoader = SimpleFileRepository.class.getClassLoader();
        File file = new File(classLoader.getResource(path).getPath());

        if (path != null ) {
            return new FileCounter().scanCount(file);
        } else {
            return 0;
        }
    }

    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {

        class DirCounter {
            private long dirCount = 1;
            public long scanCount(File file) {
                if (!file.exists()) {
                    return 0;
                }
                File[] dirs = file.listFiles();
                for (int i = 0; i < dirs.length; i++) {
                    if (dirs[i].isDirectory()) {
                        dirCount++;
                        this.scanCount(new File(dirs[i].getPath()));
                    }
                }
                return dirCount;
            }
        }

        ClassLoader classLoader = SimpleFileRepository.class.getClassLoader();
        File file = new File(classLoader.getResource(path).getPath());

        if (path != null ) {
            return new DirCounter().scanCount(file);
        } else {
            return 0;
        }

    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        return;
    }

    /**
     * Метод создает файл на диске с расширением txt
     *
     * @param path путь до нового файла
     * @param name имя файла
     * @return был ли создан файл
     */
    @Override
    public boolean createFile(String path, String name) {
        return false;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        try {
            return new  String (readAllBytes(Paths.get("src/main/resources/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

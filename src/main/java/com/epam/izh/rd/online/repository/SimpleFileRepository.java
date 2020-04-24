package com.epam.izh.rd.online.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllBytes;

public class SimpleFileRepository implements FileRepository {

    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) { // не выдает желаемый результат. прототип см на гитхабе git@github.com:zuFrost/epam-learn025-File-NIO.git
        class FileCounter {
            private long fileCount;

            public long scanCount(String folderPath) {
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    return 0;
                }
                File[] files = folder.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (!files[i].isDirectory()) {
                        fileCount++;
                    } else if (files[i].isDirectory()) {
                        this.scanCount(files[i].getPath());
                    }
                }
                return fileCount;
            }
        }


        if (path != null ) {
            return new FileCounter().scanCount(path);
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
        return 0;
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

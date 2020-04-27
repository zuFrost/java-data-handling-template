package com.epam.izh.rd.online.service;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\java\\JavaProjects\\Ihar_Blinov\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt"))));
            String line = reader.readLine();
            Pattern pattern  = Pattern.compile("(?<=\\d{4}\\s)((\\d{4}\\s\\d{4}))(?=\\s\\d{4})");
            Matcher matcher = pattern.matcher(line);
            return matcher.replaceAll("**** ****");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\java\\JavaProjects\\Ihar_Blinov\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt"))));
            String line = reader.readLine();
            System.out.println(line);
            Pattern pattern  = Pattern.compile("(\\$\\{payment_amount\\})");
            Matcher matcher = pattern.matcher(line);
            String result = matcher.replaceAll(String.valueOf((int)paymentAmount));

            pattern  = Pattern.compile("(\\$\\{balance\\})");
            matcher = pattern.matcher(result);
            return matcher.replaceAll(String.valueOf((int)balance));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

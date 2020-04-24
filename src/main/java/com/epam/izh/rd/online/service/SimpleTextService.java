package com.epam.izh.rd.online.service;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     * <p>
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base   - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, ""); //TODO
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     * <p>
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        if (text.length() != 0 && (text.charAt(text.length() - 1)) == '?') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Реализовать функционал соединения переданных строк.
     * <p>
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        return null; //TODO
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     * <p>
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        //строку в массив символов
        char[] chars = text.toCharArray();

        //массив символов подвергнуть изменению, согласно условия
        for (int i = 0; i < chars.length; i++) {
            //проверка на четность. четные в нижнем регистре, нечетные в верхнем
            if (i % 2 == 0) {       //четные в нижний регистр
                String tempSt = String.valueOf(chars[i]);
                tempSt = tempSt.toLowerCase();
                chars[i] = tempSt.toCharArray()[0];
            } else {                //нечетные в верхнем регистре
                String tempSt = String.valueOf(chars[i]);
                tempSt = tempSt.toUpperCase();
                chars[i] = tempSt.toCharArray()[0];
            }
        }

        //преобразовать массив символов в строку и вернуть в результат
        return new String(chars); //TODO
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     * <p>
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     * <p>
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
        return false; //TODO
    }
}

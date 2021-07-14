package ru.sber.android.viewtask;

import java.util.HashMap;
import java.util.Map;

public class Transliteration {
    private static final Map<String, String> letters = new HashMap<>();

    static {
        letters.put("А", "A");
        letters.put("Б", "B");
        letters.put("В", "V");
        letters.put("Г", "G");
        letters.put("Д", "D");
        letters.put("Е", "E");
        letters.put("Ё", "E");
        letters.put("Ж", "ZH");
        letters.put("З", "Z");
        letters.put("И", "I");
        letters.put("Й", "I");
        letters.put("К", "K");
        letters.put("Л", "L");
        letters.put("М", "M");
        letters.put("Н", "N");
        letters.put("О", "O");
        letters.put("П", "P");
        letters.put("Р", "R");
        letters.put("С", "S");
        letters.put("Т", "T");
        letters.put("У", "U");
        letters.put("Ф", "F");
        letters.put("Х", "KH");
        letters.put("Ц", "TS");
        letters.put("Ч", "CH");
        letters.put("Ш", "SH");
        letters.put("Щ", "SHCH");
        letters.put("Ы", "Y");
        letters.put("Ь", "-");
        letters.put("Ъ", "IE");
        letters.put("Э", "E");
        letters.put("Ю", "IU");
        letters.put("Я", "IA");
        letters.put("а", "a");
        letters.put("б", "b");
        letters.put("в", "v");
        letters.put("г", "g");
        letters.put("д", "d");
        letters.put("е", "e");
        letters.put("ё", "e");
        letters.put("ж", "zh");
        letters.put("з", "z");
        letters.put("и", "i");
        letters.put("й", "i");
        letters.put("к", "k");
        letters.put("л", "l");
        letters.put("м", "m");
        letters.put("н", "n");
        letters.put("о", "o");
        letters.put("п", "p");
        letters.put("р", "r");
        letters.put("с", "s");
        letters.put("т", "t");
        letters.put("у", "u");
        letters.put("ф", "f");
        letters.put("х", "kh");
        letters.put("ц", "ts");
        letters.put("ч", "ch");
        letters.put("ш", "sh");
        letters.put("щ", "shch");
        letters.put("ы", "y");
        letters.put("ь", "-");
        letters.put("ъ", "ie");
        letters.put("э", "e");
        letters.put("ю", "iu");
        letters.put("я", "ia");
    }

    public static String toTranslit(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            String letter = text.substring(i, i+1);
            stringBuilder.append(letters.get(letter));
        }

        return stringBuilder.toString();
    }


    //todo пока не придумал нормальный вариант для случаев: ZH, TS, CH, SH, SHCH, IE, IU, IA

    public static String toCyrillic(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            String letter = text.substring(i, i+1);

            for (Map.Entry<String, String> entry : letters.entrySet()) {
                if (entry.getValue().equals(letter)) {
                    stringBuilder.append(entry.getKey());
                    break;
                }
            }
        }

        return stringBuilder.toString();
    }
}

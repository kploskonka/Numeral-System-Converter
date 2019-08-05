package pl.ksoai.util;

public class FractionParser {

    public static double parseFraction(String string, int sourceRadix) {
        double doublePart = 0.0;

        String[] stringArray = lettersToValues(string);

        for (int i = 1; i <= string.length(); i++) {
            doublePart += Double.parseDouble(stringArray[i]) / Math.pow(sourceRadix, i); //np. 0.234 w systemie osemkowym daje 2/8 + 3/64 + 4/512
        }

        return doublePart;
    }

    private static String[] lettersToValues(String string) {
        String[] strArray = string.split("");
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (strArray[i].equals(letters[j])) {
                    strArray[i] = String.valueOf(j + 10);
                }
            }
        }

        return strArray;
    }

    private FractionParser() {}
}

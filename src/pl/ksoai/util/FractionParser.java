package pl.ksoai.util;

public class FractionParser {
    private static String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static double parseFraction(String fraction, int sourceRadix) throws NumberFormatException {
        if (isFractionValid(fraction, sourceRadix)) {
            double doublePart = 0;

            String[] stringArray = lettersToValues(fraction);

            for (int i = 1; i <= fraction.length(); i++) {
                doublePart += Double.parseDouble(stringArray[i - 1]) / Math.pow(sourceRadix, i);
            }

            return doublePart;
        }
        throw new NumberFormatException();
    }

    private static String[] lettersToValues(String string) {
        String[] strArray = string.split("");
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (strArray[i].equals(letters[j])) {
                    strArray[i] = String.valueOf(j + 10);
                }
            }
        }

        return strArray;
    }

    private static boolean isFractionValid(String fraction, int sourceRadix) {
        for (int i = 0; i < fraction.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (String.valueOf(fraction.charAt(i)).equals(letters[j])) {
                    if (sourceRadix <= j + 10) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private FractionParser() {}
}

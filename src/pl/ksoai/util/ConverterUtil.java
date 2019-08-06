package pl.ksoai.util;

public class ConverterUtil {

    private static final char[] radixChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void decimalToRadix(int decNum, int radix) {
        StringBuilder radixNum = new StringBuilder();
        int remainder;

        if (decNum == 0) {
            System.out.print("0");
        } else {
            while (decNum != 0) {
                remainder = decNum % radix;
                radixNum.append(radixChars[remainder]);
                decNum = decNum / radix;
            }

            System.out.print(radixNum.reverse().toString());
        }
    }

    public static void fractionToRadix(double fraction, int targetRadix) {
        StringBuilder stringFraction = new StringBuilder();
        stringFraction.append(fraction);

        String[] fractionArray;
        StringBuilder radixFraction = new StringBuilder();
        int fractionLength = String.valueOf(fraction).length();

        for (int i = 0; i < fractionLength; i++) {
            fraction *= targetRadix;
            stringFraction.replace(0, stringFraction.length(), String.valueOf(fraction));
            fractionArray = stringFraction.toString().split("\\.");
            radixFraction.append(radixChars[Integer.parseInt(fractionArray[0])]);
            fraction -= Integer.parseInt(fractionArray[0]);
        }

        /*Print the first 5 digits of the fraction*/
        if (radixFraction.length() > 5) {
            System.out.print(radixFraction.substring(0, 5));
        } else {
            System.out.print(radixFraction.toString());
        }
    }

    public static void oneToRadix(int number, int radix) {
        int i = 0;

        while (i < number) {
            i++;
        }

        decimalToRadix(i, radix);
    }

    public static void decimalToOne(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(1);
        }
    }

    private ConverterUtil() {}
}

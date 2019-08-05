package pl.ksoai.util;

public class ConverterUtil {

    private static final char[] radixChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static String decimalToRadix(int decNum, int radix) {
        StringBuilder radixNum = new StringBuilder();
        int remainder;

        if (decNum == 0) {
            return "0";
        }

        while (decNum != 0) {
            remainder = decNum % radix;
            radixNum.append(radixChars[remainder]);
            decNum = decNum / radix;
        }

        radixNum = radixNum.reverse();
        return radixNum.toString();
    }

    public static String fractionToRadix(double fraction, int targetRadix) {
        StringBuilder stringFraction = new StringBuilder();
        stringFraction.append(fraction);

        String[] fractionArray;
        StringBuilder radixFraction = new StringBuilder();
        int fractionLength = String.valueOf(fraction).length();

        for (int i = 0; i < fractionLength; i++) {
            fraction *= targetRadix; //mnozymy przez baze na ktora chcemy zmienic
            stringFraction.replace(0, stringFraction.length(), String.valueOf(fraction)); //podmieniamy fraction w stringu na ten przemnozony
            fractionArray = stringFraction.toString().split("\\."); // rozdzielamy jednosc od czesci po .
            radixFraction.append(radixChars[Integer.parseInt(fractionArray[0])]); // jednosc leci jako numer do wyniku
            fraction -= Integer.parseInt(fractionArray[0]); //odejmujemy jednosc od przemnozonego ulamka
        }

        if (radixFraction.length() > 5) {
            return radixFraction.substring(0, 5);
        }

        return radixFraction.toString();
    }

    public static void oneToRadix(int number, int radix) {
        int i = 0;

        while (i < number) {
            i++;
        }

        System.out.println(decimalToRadix(i, radix));
    }

    public static void decimalToOne(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(1);
        }
    }

    private ConverterUtil() {}
}

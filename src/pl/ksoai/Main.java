package pl.ksoai;

import pl.ksoai.util.ConverterUtil;
import pl.ksoai.util.FractionParser;
import pl.ksoai.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the number's source radix, the number and the radix you want it to convert to i.e \"10 20 2\"");
        Scanner scanner = new Scanner(System.in);
        String[] validatedInput = InputValidator.getValidatedInput(scanner);

        if (validatedInput != null) {
            int sourceRadix = Integer.parseInt(validatedInput[0]);
            int targetRadix = Integer.parseInt(validatedInput[1]);
            String numberInteger = validatedInput[2];

            if (validatedInput.length == 3) {
                if (sourceRadix == targetRadix) {
                    System.out.println(numberInteger);
                } else if (sourceRadix != 1 && targetRadix != 1) {
                    int decimalNumber = Integer.parseInt(numberInteger, sourceRadix);

                    System.out.println(ConverterUtil.decimalToRadix(decimalNumber, targetRadix));
                } else if (sourceRadix == 1) {
                    ConverterUtil.oneToRadix(numberInteger.length(), targetRadix);
                } else {
                    ConverterUtil.decimalToOne(Integer.parseInt(numberInteger));
                }
            } else if (validatedInput.length == 4) {
                String numberFraction = validatedInput[3];

                if (sourceRadix == targetRadix) {
                    System.out.println(numberInteger + "." + numberFraction);
                } else if (targetRadix != 1) {
                    int decimalNumber = Integer.parseInt(numberInteger, sourceRadix);
                    double fraction = FractionParser.parseFraction(numberFraction, sourceRadix);

                    System.out.println(ConverterUtil.decimalToRadix(decimalNumber, targetRadix) + "."
                            + ConverterUtil.fractionToRadix(fraction, targetRadix));
                } else {
                    ConverterUtil.decimalToOne(Integer.parseInt(numberInteger, sourceRadix));
                }
            }
        }

        scanner.close();
    }

}

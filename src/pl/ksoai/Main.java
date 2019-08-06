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
            int decimalNumber = Integer.parseInt(validatedInput[2]);
            String numberInteger = validatedInput[3];

            if (validatedInput.length == 4) {
                if (sourceRadix == targetRadix) {
                    System.out.println(numberInteger);
                } else if (sourceRadix != 1 && targetRadix != 1) {
                    ConverterUtil.decimalToRadix(decimalNumber, targetRadix);
                } else if (sourceRadix == 1) {
                    ConverterUtil.oneToRadix(numberInteger.length(), targetRadix);
                } else {
                    ConverterUtil.decimalToOne(Integer.parseInt(numberInteger));
                }
            } else if (validatedInput.length == 5) {
                String numberFraction = validatedInput[4];

                if (sourceRadix == targetRadix) {
                    System.out.println(numberInteger + "." + numberFraction);
                } else if (targetRadix != 1) {
                    try {
                        double fraction = FractionParser.parseFraction(numberFraction, sourceRadix);

                        ConverterUtil.decimalToRadix(decimalNumber, targetRadix);
                        System.out.print(".");
                        ConverterUtil.fractionToRadix(fraction, targetRadix);
                    } catch (NumberFormatException e) {
                        System.out.println("Fraction does not match with its source radix!");
                    }
                } else {
                    ConverterUtil.decimalToOne(Integer.parseInt(numberInteger, sourceRadix));
                }
            }
        }

        scanner.close();
    }

}

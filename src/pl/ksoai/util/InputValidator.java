package pl.ksoai.util;

import java.util.Scanner;

public class InputValidator {

    public static String[] getValidatedInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int sourceRadix = scanner.nextInt();

            if (isInBounds(sourceRadix)) {
                String stringNumber = scanner.next().toLowerCase();

                if (scanner.hasNextInt()) {
                    int targetRadix = scanner.nextInt();

                    if (isInBounds(targetRadix)) {
                        String[] strings = stringNumber.split("\\.");
                        int numberInDecimal;

                        try {
                            numberInDecimal = Integer.parseInt(strings[0], sourceRadix);
                        } catch (NumberFormatException e) {
                            System.out.println("Number does not match with its source radix!");
                            return null;
                        }

                        if (strings.length == 1) {
                            return new String[] {String.valueOf(sourceRadix), String.valueOf(targetRadix), String.valueOf(numberInDecimal), strings[0]};
                        } else if (strings.length == 2) {
                            return new String[] {String.valueOf(sourceRadix), String.valueOf(targetRadix), String.valueOf(numberInDecimal), strings[0], strings[1]};
                        } else {
                            System.out.println("You must enter a valid number optionally with a fraction! i.e. 1.23");
                        }
                    }
                } else {
                    System.out.println("Target radix must be an integer!");
                }
            }
        } else {
            System.out.println("Source radix must be an integer!");
        }

        return null;
    }

    private static boolean isInBounds(int number) {
       if (number > 0 && number <= 36) {
           return true;
       } else {
           System.out.println("Radix must be a number between 1 and 36!");
           return false;
       }
    }

    private InputValidator() {}
}

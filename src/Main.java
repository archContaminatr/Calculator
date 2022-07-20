import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static int numOne = 0;
    static int numTwo = 0;
    static int result = 0;
    static boolean isRoman = false;

    public static int operation(int numOne, int numTwo, String typeOfOperation) throws Exception {
        return switch (typeOfOperation) {
            case "+" -> numOne + numTwo;
            case "-" -> numOne - numTwo;
            case "*" -> numOne * numTwo;
            case "/" -> numOne / numTwo;
            default -> throw new Exception();
        };
    }

    public static void main(String[] args) {
        System.out.println("Input mathematical expression");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        ArrayList<String> inputArray = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        try {
            if (inputArray.toArray().length != 3) {
                throw new Exception("Incorrect mathematical expression");
            }
        } catch (Exception e) {
            System.out.println("Incorrect mathematical operation");
            System.exit(-1);
        }

        try {
            numOne = parseInt(inputArray.get(0));
            numTwo = parseInt(inputArray.get(2));
        } catch (NumberFormatException e) {
            try {
                isRoman = true;
                numOne = Conversion.toArabic(inputArray.get(0));
                numTwo = Conversion.toArabic(inputArray.get(2));
            } catch (Exception e1) {
                System.out.println("Incorrect values");
                System.exit(-1);
            }
        }
        try {
            if (numOne < 0 || numOne > 10 || numTwo < 0 || numTwo > 10) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Values must be between 1 and 10");
            System.exit(-1);
        }

        try {
            result = operation(numOne, numTwo, inputArray.get(1));
        } catch (Exception e) {
            System.out.println("Incorrect mathematical operation");
            System.exit(-1);
        }
        try {
            printResult(result);
        } catch (Exception e) {
            System.out.println("Roman numerals can not be negative or equal to 0");
            System.exit(-1);
        }

    }


    public static void printResult(Integer result) throws Exception {
        if (isRoman) {
            if (result > 0) {
                System.out.println(Conversion.toRoman(result));
            } else {
                throw new Exception();
            }
        } else {
            System.out.println(result);
        }
    }


}
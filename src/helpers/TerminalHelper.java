/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * TerminalHelper (Version 2024.07.29.2234)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package helpers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final public class TerminalHelper {
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                                         *
    // *                    TERMINAL PRINTERS                    *
    // *                                                         *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    // Prints a given value, of almost any kind, once in the terminal
    public static void print(Object obj) {
        System.out.print(obj);
    }

    // Prints a given value, of almost any kind, once in the terminal, and then breaks the line
    public static void printLine(Object obj) {
        System.out.println(obj);
    }

    // Prints a given value, of almost any kind, N given times in the terminal
    public static void printNTimes(Object obj, int times) {
        for (int i = 0; i < times; i += 1) {
            print(obj);
        }
    }

    // Prints a given value, of almost any kind, N given times in the terminal, and then breaks the line
    public static void printLineNTimes(Object obj, int times) {
        for (int i = 0; i < times; i += 1) {
            printLine(obj);
        }
    }

    // Prints a given value, of almost any kind, N given times in the terminal, and then breaks the line
    public static void printNTimesAndBreak(Object obj, int times) {
        printNTimes(obj, times);
        printLine("");
    }


    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                                         *
    // *                  TERMINAL VALIDATORS                     *
    // *                                                         *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    // Determines if a given string is a valid integer, using a regular expression
    public static boolean isInteger(String input) {
        // Regex pattern for integer validation
        // Pattern pattern = Pattern.compile("^-?\\d+$");
        Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
        return pattern.matcher(input).matches();
    }

    // Determines if a given string is a valid floating point number, using a regular expression
    public static boolean isFloatingPoint(String input) {
        String regex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean containsSingleChar(String input) {
        return input.length() == 1;
    }


    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                                         *
    // *                    TERMINAL GETTERS                     *
    // *                                                         *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *


    // Receives and validates an integer number from the console
    public static int getInteger(final String message, final Integer minValue, final Integer maxValue, final boolean showRange, final String errorMessage, final ArrayList<Integer> sentinelValues) {
        int number = 0; // Integer conversion (if possible) of the value typed by the user
        boolean keepAsking = true; // If we must keep asking for a value to the user, until receiving an integer
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message + (showRange ? (" (" + minValue + " - " + maxValue + ")") : "") + ": ");
            String numberAsString = scanner.nextLine();  // Value typed by the user, that can be an integer or not

            if (!isInteger(numberAsString)) {
                System.out.println("That's not an integer number. Try again.");
                continue; // There is no point in keep validating any further, as it's not even an integer
            }

            number = Integer.parseInt(numberAsString); // When we reach this point, that means we have a proper integer
            final boolean invalidInput = number < minValue || maxValue < number; // If the input is valid, based only in minimum & maximum possible values
            // If the typed number is not among the given sentinel values (aka breaking values)
            final boolean numberIsNotSentinel = !sentinelValues.contains(number);
            keepAsking = invalidInput && numberIsNotSentinel;
            if (keepAsking)
                System.out.println(errorMessage.isBlank() ? "You must type an integer number between " + minValue + " and " + maxValue + ". Please try again." : errorMessage);
        } while (keepAsking);
        // scanner.close();

        return number;
    }

    // Receives and validates an integer number from the console
    public static int getInteger(final String message, final Integer minValue, final Integer maxValue, final boolean showRange, final String errorMessage) {
        return getInteger(message, minValue, maxValue, showRange, errorMessage, new ArrayList<>());
    }

    // Receives and validates an integer number from the console
    public static int getInteger(final String message, final Integer minValue, final Integer maxValue, final boolean showRange) {
        return getInteger(message, minValue, maxValue, showRange, "", new ArrayList<>());
    }

    // Receives and validates an integer number from the console
    public static int getInteger(final String message, final Integer minValue, final Integer maxValue) {
        return getInteger(message, minValue, maxValue, true, "", new ArrayList<>());
    }

    // Receives and validates a double number from the console
    public static double getDouble(final String message, final Double minValue, final Double maxValue, final boolean showRange, final String errorMessage, final ArrayList<Double> sentinelValues) {
        double number = 0; // Double conversion (if possible) of the value typed by the user
        boolean keepAsking = true; // If we must keep asking for a value to the user, until receiving an integer
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message + (showRange ? (" (" + minValue + " - " + maxValue + ")") : "") + ": ");
            String numberAsString = scanner.nextLine();  // Value typed by the user, that can be a valid (integer or floating point) number or not

            if (!isInteger(numberAsString) || !isFloatingPoint(numberAsString)) {
                System.out.println("That's not an integer number nor a valid floating point number. Try again.");
                continue; // There is no point in keep validating any further, as it's not even a valid integer nor a floating point number
            }

            number = Double.parseDouble(numberAsString); // When we reach this point, that means we have a proper integer or a floating point number
            final boolean invalidInput = number < minValue || maxValue < number; // If the input is valid, based only in minimum & maximum possible values
            // If the typed number is not among the given sentinel values (aka breaking values)
            final boolean numberIsNotSentinel = !sentinelValues.contains(number);
            keepAsking = invalidInput && numberIsNotSentinel;
            if (keepAsking)
                System.out.println(errorMessage.isBlank() ? "You must type a double number between " + minValue + " and " + maxValue + ". Please try again." : errorMessage);
        } while (keepAsking);
        // scanner.close();

        return number;
    }

    // Receives and validates a double number from the console
    public static double getDouble(final String message, final Double minValue, final Double maxValue, final boolean showRange, final String errorMessage) {
        return getDouble(message, minValue, maxValue, showRange, errorMessage, new ArrayList<>());
    }

    // Receives and validates a double number from the console
    public static double getDouble(final String message, final Double minValue, final Double maxValue, final boolean showRange) {
        return getDouble(message, minValue, maxValue, showRange, "", new ArrayList<>());
    }

    // Receives and validates a double number from the console
    public static double getDouble(final String message, final Double minValue, final Double maxValue) {
        return getDouble(message, minValue, maxValue, true, "", new ArrayList<>());
    }

    // Receives and validates a char from the console
    public static char getAlphaChar(final String message, final String errorMessage) {
        char character = 'A'; // Char conversion (if possible) of the value typed by the user
        boolean isNotAlphaCharacter = true; // If the character is alphabetic
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message + ": ");
            String characterAsString = scanner.nextLine();  // Value typed by the user, that can be a char or not

            if (!containsSingleChar(characterAsString)) {
                System.out.println("That's not a single character. Try again.");
                continue; // There is no point in keep validating any further, as it's not even a valid char
            }

            character = characterAsString.charAt(0);
            isNotAlphaCharacter = !Character.isLetter(character);
            if (isNotAlphaCharacter)
                System.out.println(errorMessage.isBlank() ? "You must type a valid single character. Please try again." : errorMessage);
        } while (isNotAlphaCharacter);

        return character;
    }

    // Receives and validates a char from the console
    public static char getAlphaChar(final String message) {
        return getAlphaChar(message, "");
    }

    // Gets a string with or without spaces, from the terminal, as a response of a given question
    public static String getStringFromMessage(final String message, int minLength, int maxLength, final boolean showRange, final String errorMessage) {
        String typedInput;
        boolean keepAsking = true; // If we must keep asking for a value to the user, until receiving an integer
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message + (showRange ? (" (" + minLength + " - " + maxLength + " characters)") : "") + ": ");

            typedInput = scanner.nextLine();  // Value typed by the user, that can be a char or not

            if (typedInput.isBlank()) {
                System.out.println("That's not a valid string. Try again.");
                continue; // There is no point in keep validating any further, as it's not even a valid none-empty string
            }

            // When we reach this point, that means we have at least a none-empty string
            final boolean invalidInput = typedInput.length() < minLength || maxLength < typedInput.length(); // If the string input is valid, based only in minimum & maximum possible lengths
            keepAsking = invalidInput;
            if (keepAsking)
                System.out.println(errorMessage.isBlank() ? "You must type a valid none-empty string, with a length between " + minLength + " and " + maxLength + ". Please try again." : errorMessage);
        } while (keepAsking);

        return typedInput;
    }

    // Gets a string with or without spaces, from the terminal, as a response of a given question
    public static String getStringFromMessage(final String message, int minLength, int maxLength, final boolean showRange) {
        return getStringFromMessage(message, minLength, maxLength, showRange, "");
    }

    // Gets a string with or without spaces, from the terminal, as a response of a given question
    public static String getStringFromMessage(final String message, int minLength, int maxLength) {
        return getStringFromMessage(message, minLength, maxLength, true, "");
    }

    // Gets a string with or without spaces, from the terminal, as a response of a given question
    public static String getStringFromMessage(final String message, int minLength) {
        String typedInput;
        boolean keepAsking = true; // If we must keep asking for a value to the user, until receiving an integer
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(message + " (at least " + minLength + " characters): ");

            typedInput = scanner.nextLine();  // Value typed by the user, that can be a char or not

            if (typedInput.isBlank()) {
                System.out.println("That's not a valid string. Try again.");
                continue; // There is no point in keep validating any further, as it's not even a valid none-empty string
            }

            // When we reach this point, that means we have at least a none-empty string
            final boolean invalidInput = typedInput.length() < minLength; // If the string input is valid, based only in the given minimum length
            keepAsking = invalidInput;
            if (keepAsking)
                System.out.println("You must type a valid string, with a length of at least " + minLength + " characters. Please try again.");
        } while (keepAsking);

        return typedInput;
    }

    // Gets a string with or without spaces, from the terminal, as a response of a given question
    public static String getStringFromMessage(final String message) {
        return getStringFromMessage(message, 1, Integer.MAX_VALUE, false, "");
    }
}

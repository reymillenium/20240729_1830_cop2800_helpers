/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * MathHelper (Version 2024.07.30.1931)
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

public class MathHelper {
    // Formats a given negative or positive Integer by inserting a comma every 3 digits of its equivalent string, to make it more readable, by US standards
    public static String humanizeInteger(final Integer integerValue) {
        final boolean isNegative = integerValue < 0;
        String integerAsString = integerValue.toString();
        final int initialIndex = integerAsString.length() - 3;

        // We insert commas into the string every three digits, fromm right to left.
        for (int j = initialIndex; j > (isNegative ? 1 : 0); j -= 3) {
            StringBuilder stringBuilder = new StringBuilder(integerAsString);
            stringBuilder.insert(j, ",");
            integerAsString = stringBuilder.toString();
        }

        return integerAsString;
    }

    // Formats a given negative or positive Double by inserting a comma every 3 digits of its equivalent string, to make it more readable, by US standards
    public static String humanizeDouble(final Double doubleValue, final int precision) {
        final Integer integerValue = doubleValue.intValue();
        final Double decimals = doubleValue - integerValue;
        final boolean hasNegativeDecimals = decimals < 0;

        final String decimalsAsString = decimals.toString(); // It still includes the zero & the dot. Ex: -0.2345, 0.2345 (a possible negative sign and the zero must be removed next)
        return humanizeInteger(integerValue) + decimalsAsString.substring(hasNegativeDecimals ? 2 : 1, hasNegativeDecimals ? (precision + 3) : (precision + 2));
    }

    // Formats a given negative or positive Double by inserting a comma every 3 digits of its equivalent string, to make it more readable, by US standards
    public static String humanizeDoubleAndRoundDecimals(final Double doubleValue, final int precision) {
        final Integer integerValue = doubleValue.intValue(); // Ex: -3908.8099899801 -> -3908
        double decimals = doubleValue - integerValue; // Ex: -0.8099899800999992
        final boolean hasNegativeDecimals = decimals < 0; // Ex: true

        // Rounding the decimals
        double precisionProduct = Math.pow(10, precision); // Keeps as many digits as desired by the user (given precision, though not always can be done, so we need to fix it in another step)
        decimals = Math.floor(decimals * precisionProduct + .5) / precisionProduct; // Like in this for example:  -0.80999 (but our precision is 6, so we need to fix it)

        // Adjusting the rounded decimals
        String format = "%." + precision + "f"; // Example: "%.6f"
        String decimalsAsString = String.format(format, decimals); // We keep the desired precision no matter what. Final state: -0.80999 -> -0.809990 (with a 6 digits precision, exactly as desired by the user)

        decimalsAsString = decimalsAsString.substring(hasNegativeDecimals ? 2 : 1); // Removes a possible negative sign and the zero. Ex: -0.809990 -> .809990

        return humanizeInteger(integerValue) + decimalsAsString; // Final concatenation: -3,908 + .809990 (Final State: -3,908.809990)
    }

    // Formats a given positive Integer by inserting a comma every 3 digits of its equivalent string, to make it more readable, by US standards
    public static String humanizeUnsignedInteger(final Integer integerValue) {
        String integerAsString = integerValue.toString();
        final int initialIndex = integerAsString.length() - 3;

        // We insert commas into the string every three digits, fromm right to left.
        for (int j = initialIndex; j > 0; j -= 3) {
            StringBuilder stringBuilder = new StringBuilder(integerAsString);
            stringBuilder.insert(j, ",");
            integerAsString = stringBuilder.toString();
        }

        return integerAsString;
    }

    // Formats a given positive Double by inserting a comma every 3 digits of its equivalent string, to make it more readable, by US standards
    public static String humanizeUnsignedDouble(final Double doubleValue, final int precision) {
        final Integer integerValue = doubleValue.intValue();
        final double decimals = doubleValue - integerValue;
        final String decimalsAsString = Double.toString(decimals); // It still includes the "0" & the dot ("."). Ex: 0.34 (so the "0" must be removed next)
        return humanizeInteger(integerValue) + decimalsAsString.substring(1, precision + 2);
    }

    // Formats a given positive Double by inserting a comma every 3 digits of its equivalent string, to make it more readable, by US standards
    public static String humanizeUnsignedDoubleAndRoundDecimals(final Double doubleValue, final int precision) {
        final Integer integerValue = doubleValue.intValue(); // Ex: 3908.8099899801 -> 3908
        double decimals = doubleValue - integerValue; // Ex: 0.8099899800999992

        // Rounding the decimals
        double precisionProduct = Math.pow(10, precision); // Keeps as many digits as desired by the user (given precision, though not always can be done, so we need to fix it in another step)
        decimals = Math.floor(decimals * precisionProduct + .5) / precisionProduct; // Like in this for example:  0.80999 (but our precision is 6, so we need to fix it)

        // Adjusting the rounded decimals
        String format = "%." + precision + "f"; // Example: "%.6f"
        String decimalsAsString = String.format(format, decimals); // We keep the desired precision no matter what. Final state: 0.80999 -> 0.809990 (with a 6 digits precision, exactly as desired by the user)

        decimalsAsString = decimalsAsString.substring(1); // Removes the zero. Ex: 0.809990 -> .809990

        return humanizeInteger(integerValue) + decimalsAsString; // Final concatenation: 3,908 + .809990 (Final State: 3,908.809990)
    }

    // Formats a given int by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a customizable currency symbol
    public static String monetizeInteger(final int integerValue, final boolean prepend, final String symbol) {
        return (prepend ? (symbol + " ") : "") + humanizeUnsignedInteger(integerValue) + (prepend ? "" : " " + symbol);
    }

    // Formats a given int by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a customizable currency symbol
    public static String monetizeInteger(final int integerValue, final boolean prepend) {
        return monetizeInteger(integerValue, prepend, "$");
    }

    // Formats a given int by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a customizable currency symbol
    public static String monetizeInteger(final int integerValue) {
        return monetizeInteger(integerValue, true, "$");
    }

    // Formats a given double by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a customizable currency symbol
    public static String monetizeDouble(final double doubleValue, final int precision, final boolean prepend, final String symbol) {
        return (prepend ? (symbol + " ") : "") + humanizeUnsignedDoubleAndRoundDecimals(doubleValue, precision) + (prepend ? "" : " " + symbol);
    }

    // Formats a given double by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a hardcoded currency symbol ($)
    public static String monetizeDouble(final double doubleValue, final int precision, final boolean prepend) {
        return monetizeDouble(doubleValue, precision, prepend, "$");
    }

    // Formats a given double by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a hardcoded currency symbol ($)
    public static String monetizeDouble(final double doubleValue, final int precision) {
        return monetizeDouble(doubleValue, precision, true, "$");
    }

    // Formats a given double by inserting a comma every 3 digits of its equivalent string, to make it more readable, and adds a hardcoded currency symbol ($)
    public static String monetizeDouble(final double doubleValue) {
        return monetizeDouble(doubleValue, 2, true, "$");
    }

    // Rounds up a given double number, with a given amount of decimal places
    public static double roundUp(final double value, final int decimalPlaces) {
        // Rounding the decimals
        double precisionProduct = Math.pow(10, decimalPlaces); // Keeps as many digits as desired by the user (given precision, though not always can be done, so we need to fix it in another step)
        return Math.floor(value * precisionProduct + .5) / precisionProduct; // Like in this for example:  -0.80999 (but our precision is 6, so we need to fix it)
    }

    // Calculates the Recursive Sum of a given int number. Example: recursiveSum(5) == 5 + 4 + 3 + 2 + 1 = 15
    public static int recursiveSum(final int number) {
        if (number != 0) return number + recursiveSum(number - 1);
        return 0;
    }

    // Returns the string grammatical representation of an ordinal number, from a given int number
    public static String ordinalFromNumber(final int number) {
        final int lastDigit = number % 10;
        String additive = "th";

        switch (number) {
            case 11:
            case 12:
            case 13:
                break;
            default:
                switch (lastDigit) {
                    case 1:
                        additive = "st";
                        break;
                    case 2:
                        additive = "nd";
                        break;
                    case 3:
                        additive = "rd";
                        break;
                    default:
                }
        }

        return number + additive;
    }

    // Returns the string grammatical representation of an ordinal number, from a given int number, even if is negative
    public static String neatOrdinalFromNumber(final int number) {
        final int lastDigit = Math.abs(number % 10);
        return number + switch (Math.abs(number)) {
            case 11, 12, 13 -> "th";
            default -> switch (lastDigit) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };
        };

    }

    // Determines is a given int number is prime or not
    public static boolean isPrime(final int value) {
        if (value <= 1) return false;

        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0)
                return false;
        }

        return true;
    }

    // Determines if two doubles are equals after rounding them to a given amount of decimals
    public static boolean doublesAreEqualsRoundedByNDecimalPlaces(double firstNumber, double secondNumber, int decimalPlaces) {
        // Rounding the decimals
        double precisionProduct = Math.pow(10, decimalPlaces); // Keeps as many digits as desired by the user (given precision, though not always can be done, so we need to fix it in another step)
        double firstRounded = Math.floor(firstNumber * precisionProduct + .5) / precisionProduct; // Like in this for example:  -0.80999 (but our precision is 6, so we need to fix it)
        double secondRounded = Math.floor(secondNumber * precisionProduct + .5) / precisionProduct; // Like in this for example:  -0.80999 (but our precision is 6, so we need to fix it)

        // Adjusting the rounded decimals
        String format = "%." + decimalPlaces + "f"; // Example: "%.6f"
        String firstAccurateAsString = String.format(format, firstRounded); // We keep the desired precision no matter what. Final state: -0.80999 -> -0.809990 (with a 6 digits precision, exactly as desired by the user)
        String secondAccurateAsString = String.format(format, secondRounded); // We keep the desired precision no matter what. Final state: -0.80999 -> -0.809990 (with a 6 digits precision, exactly as desired by the user)

        return firstAccurateAsString.equals(secondAccurateAsString);
    }

    // Determines if two doubles are equals after trimming them to a given amount of decimals
    public static boolean doublesAreEqualsByNDecimalPlaces(double firstNumber, double secondNumber, int decimalPlaces) {
        double precisionProduct = Math.pow(10, decimalPlaces);
        double firstRounded = (firstNumber < 0 ? Math.ceil(firstNumber * precisionProduct) : Math.floor(firstNumber * precisionProduct)) / precisionProduct;
        double secondRounded = (secondNumber < 0 ? Math.ceil(secondNumber * precisionProduct) : Math.floor(secondNumber * precisionProduct)) / precisionProduct;
        return firstRounded == secondRounded;
    }
}

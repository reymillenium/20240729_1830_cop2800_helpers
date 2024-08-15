/*
 * MIT License
 *
 * Copyright (c) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * JHArray (Version 2024.08.14.2132)
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

package dev.reiniergarcia.helpers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class JHArray {
    // Calculates the sum of all the elements inside an array of integers
    public static int simpleSumOfIntegersInArray(final int[] integersArray) {
        int sum = 0;

        for (int j : integersArray) {
            sum += j;
        }

        return sum;
    }

    // Calculates the sum of all the elements inside an array of integers
    public static int neatSumOfIntegersInArray(final int[] integersArray) {
        return Arrays.stream(integersArray).sum();
    }

    // Calculates the sum of all the elements inside an array of doubles
    public static double simpleSumOfDoublesInArray(final double[] doublesArray) {
        double sum = 0.0;

        for (double j : doublesArray) {
            sum += j;
        }

        return sum;
    }

    // Calculates the sum of all the elements inside an array of doubles
    public static double neatSumOfDoublesInArray(final double[] doublesArray) {
        return Arrays.stream(doublesArray).sum();
    }

    // Calculates the average among all the numbers inside an array of integers
    public static double simpleAverageAmongIntegersInArray(final int[] integersArray) {
        return (double) simpleSumOfIntegersInArray(integersArray) / integersArray.length;
    }

    // Calculates the average among all the numbers inside an array of integers
    public static double neatAverageAmongIntegersInArray(final int[] integersArray) {
        return (double) neatSumOfIntegersInArray(integersArray) / integersArray.length;
    }

    // Calculates the average among all the numbers inside an array of doubles
    public static double simpleAverageAmongDoublesInArray(final double[] doublesArray) {
        return (double) simpleSumOfDoublesInArray(doublesArray) / doublesArray.length;
    }

    // Calculates the average among all the numbers inside an array of doubles
    public static double neatAverageAmongDoublesInArray(final double[] doublesArray) {
        return (double) neatSumOfDoublesInArray(doublesArray) / doublesArray.length;
    }

    // Calculates the sum of all the elements inside a two-dimensional array of integers
    public static int sumOfIntegersInTwoDimensionsArray(final int[][] twoDimensionsIntegersArray) {
        int sum = 0;

        for (int[] row : twoDimensionsIntegersArray) {
            for (int number : row) {
                sum += number;
            }
        }

        return sum;
    }

    // Calculates the average among all the numbers inside an array of integers
    public static int averageAmongIntegersInTwoDimensionsArray(final int[][] twoDimensionsIntegersArray) {
        final int rows = twoDimensionsIntegersArray.length;
        final int columns = twoDimensionsIntegersArray[0].length;

        return sumOfIntegersInTwoDimensionsArray(twoDimensionsIntegersArray) / (rows * columns);
    }

    // Calculates the sum of all the elements inside a two-dimensional array of doubles
    public static double sumOfDoublesInTwoDimensionsArray(final double[][] twoDimensionsDoublesArray) {
        double sum = 0.0;

        for (double[] row : twoDimensionsDoublesArray) {
            for (double number : row) {
                sum += number;
            }
        }

        return sum;
    }

    // Calculates the average among all the numbers inside an array of doubles
    public static double averageAmongDoublesInTwoDimensionsArray(final double[][] twoDimensionsDoublesArray) {
        final int rows = twoDimensionsDoublesArray.length;
        final int columns = twoDimensionsDoublesArray[0].length;

        return sumOfDoublesInTwoDimensionsArray(twoDimensionsDoublesArray) / (rows * columns);
    }

    // Determines the highest number among an array of integers
    public static int simpleHighestIntegerInArray(final int[] integersArray) {
        final int length = integersArray.length;
        int highest = integersArray[0];
        if (length == 1) return highest;

        for (int i = 1; i < length; i++) {
            if (integersArray[i] > highest) highest = integersArray[i];
        }

        return highest;
    }

    // Determines the highest number among an array of integers
    public static int neatHighestIntegerInArray(final int[] integersArray) {
        return Arrays.stream(integersArray).max().orElseThrow(() -> new IllegalArgumentException("The array is empty"));
    }

    // Determines the lower number among an array of integers
    public static int simpleLowestIntegerInArray(final int[] integersArray) {
        final int length = integersArray.length;
        int lowest = integersArray[0];
        if (length == 1) return lowest;

        for (int i = 1; i < length; i++) {
            if (integersArray[i] < lowest) lowest = integersArray[i];
        }

        return lowest;
    }

    // Determines the lower number among an array of integers
    public static int neatLowestIntegerInArray(final int[] integersArray) {
        return Arrays.stream(integersArray).min().orElseThrow(() -> new IllegalArgumentException("The array is empty"));
    }

    // Determines the highest number among an array of doubles
    public static double simpleHighestDoubleInArray(final double[] integersArray) {
        final int length = integersArray.length;
        double highest = integersArray[0];
        if (length == 1) return highest;

        for (int i = 1; i < length; i++) {
            if (integersArray[i] > highest) highest = integersArray[i];
        }

        return highest;
    }

    // Determines the highest number among an array of doubles
    public static double neatHighestDoubleInArray(final double[] integersArray) {
        return Arrays.stream(integersArray).max().orElseThrow(() -> new IllegalArgumentException("The array is empty"));
    }

    // Determines the lower number among an array of doubles
    public static double simpleLowestDoubleInArray(final double[] integersArray) {
        final int length = integersArray.length;
        double lowest = integersArray[0];
        if (length == 1) return lowest;

        for (int i = 1; i < length; i++) {
            if (integersArray[i] < lowest) lowest = integersArray[i];
        }

        return lowest;
    }

    // Determines the lower number among an array of doubles
    public static double neatLowestDoubleInArray(final double[] integersArray) {
        return Arrays.stream(integersArray).min().orElseThrow(() -> new IllegalArgumentException("The array is empty"));
    }

    // Determines the higher number among a two-dimensional array of integers
    public static int highestIntegerInTwoDimensionsArray(int[][] twoDimensionsDoublesArray) {
        final int rows = twoDimensionsDoublesArray.length;
        final int columns = twoDimensionsDoublesArray[0].length;
        int highest = twoDimensionsDoublesArray[0][0];

        for (int row = 0; row < rows; row++) {
            for (int col = (row == 0 ? 1 : 0); col < columns; col++) {
                int number = twoDimensionsDoublesArray[row][col];
                if (number > highest) highest = number;
            }
        }

        return highest;
    }

    // Determines the lowest number among a two-dimensional array of integers
    public static int lowestIntegerInTwoDimensionsArray(int[][] twoDimensionsDoublesArray) {
        final int rows = twoDimensionsDoublesArray.length;
        final int columns = twoDimensionsDoublesArray[0].length;
        int lowest = twoDimensionsDoublesArray[0][0];

        for (int row = 0; row < rows; row++) {
            for (int col = (row == 0 ? 1 : 0); col < columns; col++) {
                int number = twoDimensionsDoublesArray[row][col];
                if (number < lowest) lowest = number;
            }
        }

        return lowest;
    }

    // Determines the higher number among a two-dimensional array of doubles
    public static double highestDoubleInTwoDimensionsArray(double[][] twoDimensionsDoublesArray) {
        final int rows = twoDimensionsDoublesArray.length;
        final int columns = twoDimensionsDoublesArray[0].length;
        double highest = twoDimensionsDoublesArray[0][0];

        for (int row = 0; row < rows; row++) {
            for (int col = (row == 0 ? 1 : 0); col < columns; col++) {
                double number = twoDimensionsDoublesArray[row][col];
                if (number > highest) highest = number;
            }
        }

        return highest;
    }

    // Determines the lowest number among a two-dimensional array of doubles
    public static double lowestDoubleInTwoDimensionsArray(double[][] twoDimensionsDoublesArray) {
        final int rows = twoDimensionsDoublesArray.length;
        final int columns = twoDimensionsDoublesArray[0].length;
        double lowest = twoDimensionsDoublesArray[0][0];

        for (int row = 0; row < rows; row++) {
            for (int col = (row == 0 ? 1 : 0); col < columns; col++) {
                double number = twoDimensionsDoublesArray[row][col];
                if (number < lowest) lowest = number;
            }
        }

        return lowest;
    }

    // Returns an array of random Integer numbers, given a minimum and a maximum, and then either sorted or not, asc or desc
    public static Integer[] getRandomArrayOfIntegersBetween(int length, int min, int max, boolean isSorted, boolean sortedAsc) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * (max - min + 1)) + min;
        }

        if (isSorted) Arrays.sort(array, sortedAsc ? null : Collections.reverseOrder());

        return array;
    }

    // Returns an array of random Integer numbers, given a minimum and a maximum, and then either sorted or not, buy always asc in any case
    public static Integer[] getRandomArrayOfIntegersBetween(int length, int min, int max, boolean isSorted) {
        return getRandomArrayOfIntegersBetween(length, min, max, isSorted, true);
    }

    // Returns an array of random Integer numbers, given a minimum and a maximum, and not sorted at all
    public static Integer[] getRandomArrayOfIntegersBetween(int length, int min, int max) {
        return getRandomArrayOfIntegersBetween(length, min, max, false);
    }

    // Returns an array of random Double numbers, given a minimum and a maximum, and then either sorted or not, asc or desc
    public static Double[] getRandomArrayOfDoublesBetween(int length, double min, double max, boolean isSorted, boolean sortedAsc) {
        Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            double randomValue = (random.nextDouble() * (max - min)) + min;
            array[i] = randomValue;
        }

        if (isSorted) Arrays.sort(array, sortedAsc ? null : Collections.reverseOrder());

        return array;
    }

    // Returns an array of random Double numbers, given a minimum and a maximum, and then either sorted or not, buy always asc in any case
    public static Double[] getRandomArrayOfDoublesBetween(int length, double min, double max, boolean isSorted) {
        return getRandomArrayOfDoublesBetween(length, min, max, isSorted, true);
    }

    // Returns an array of random Double numbers, given a minimum and a maximum, and not sorted at all
    public static Double[] getRandomArrayOfDoublesBetween(int length, double min, double max) {
        return getRandomArrayOfDoublesBetween(length, min, max, false);
    }

    // Returns an array of given length, and filled with a given Integer value
    public static Integer[] getArrayOfIntegersFilledWithValue(int length, int value) {
        Integer[] array = new Integer[length];
        Arrays.fill(array, value);
        return array;
    }

    // Returns an array of given length, and filled with a given Double value
    public static Double[] getArrayOfDoublesFilledWithValue(int length, double value) {
        Double[] array = new Double[length];
        Arrays.fill(array, value);
        return array;
    }

    // Converts an array of int numbers into an array of Integer numbers
    public static Integer[] intArrayToIntegerArray(int[] intArray) {
        Integer[] integerArray = new Integer[intArray.length];
        for (int j = 0; j < intArray.length; j++) {
            integerArray[j] = intArray[j];
        }
        return integerArray;
    }

    // Converts an array of Integer numbers into an array of int numbers
    public static int[] integerArrayToIntArray(Integer[] intArray) {
        return Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
    }

    // Allows to reverse in place (reference copy) a given array of integers
    private static void reverseIntArray(int[] array) {
        // In-place reversal of array
        for (int i = 0; i < array.length / 2; i++) {
            // Swapping the elements
            int j = array[i];
            array[i] = array[array.length - i - 1]; // Last element & approaching
            array[array.length - i - 1] = j;
        }
    }

    // Allows to reverse in place (reference copy) a given array of doubles
    private static void reverseDoubleArray(double[] array) {
        // In-place reversal of array
        for (int i = 0; i < array.length / 2; i++) {
            // Swapping the elements
            double j = array[i];
            array[i] = array[array.length - i - 1]; // Last element & approaching
            array[array.length - i - 1] = j;
        }
    }
}
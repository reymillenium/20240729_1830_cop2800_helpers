/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * Array Helper (Version 2024.07.29.0146)
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

import java.util.Arrays;

public class ArrayHelper {
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

    // Calculates the average among all the numbers inside an array of integers
    public static double simpleAverageAmongDoublesInArray(final double[] doublesArray) {
        return (double) simpleSumOfDoublesInArray(doublesArray) / doublesArray.length;
    }

    // Calculates the average among all the numbers inside an array of integers
    public static double neatAverageAmongDoublesInArray(final double[] doublesArray) {
        return (double) neatSumOfDoublesInArray(doublesArray) / doublesArray.length;
    }

    // Calculates the sum of all the elements inside a two-dimensional array of doubles
    public static int sumOfIntegersInTwoDimensionsArray(final double[][] twoDimensionsIntegersArray) {
        int sum = 0;

        for (double[] row : twoDimensionsIntegersArray) {
            for (double number : row) {
                sum += number;
            }
        }

        return sum;
    }

    // Calculates the average among all the numbers inside an array of doubles
    public static int averageAmongIntegersInTwoDimensionsArray(final double[][] twoDimensionsIntegersArray) {
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
            if (integersArray[i] > highest)
                highest = integersArray[i];
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
            if (integersArray[i] < lowest)
                lowest = integersArray[i];
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
            if (integersArray[i] > highest)
                highest = integersArray[i];
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
            if (integersArray[i] < lowest)
                lowest = integersArray[i];
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
        int higher = twoDimensionsDoublesArray[0][0];

        for (int row = 0; row < rows; row++) {
            for (int col = (row == 0 ? 1 : 0); col < columns; col++) {
                int number = twoDimensionsDoublesArray[row][col];
                if (number > higher) higher = number;
            }
        }

        return higher;
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
        double higher = twoDimensionsDoublesArray[0][0];

        for (int row = 0; row < rows; row++) {
            for (int col = (row == 0 ? 1 : 0); col < columns; col++) {
                double number = twoDimensionsDoublesArray[row][col];
                if (number > higher) higher = number;
            }
        }

        return higher;
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
}

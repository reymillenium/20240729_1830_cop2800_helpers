
/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
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


import helpers.*;

// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
// *                                                         *
// *           CUSTOM MADE FUNCTIONS PROTOTYPES              *
// *                                                         *
// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

public class Main {
    public static void main(String[] args) {
        Rangy openRange = Rangy.open(1, 5); // (a..b)	{x | a < x < b}
        System.out.println("openRange.contains(0) = " + openRange.contains(0));
        System.out.println("openRange.contains(1) = " + openRange.contains(1));
        System.out.println("openRange.contains(2) = " + openRange.contains(2));
        System.out.println("openRange.contains(3) = " + openRange.contains(3));
        System.out.println("openRange.contains(4) = " + openRange.contains(4));
        System.out.println("openRange.contains(5) = " + openRange.contains(5));
        System.out.println("openRange.contains(6) = " + openRange.contains(6));

        System.out.println(" ");

        Rangy closedRange = Rangy.closed(1, 5); // [a..b]	{x | a <= x <= b}
        System.out.println("closedRange.contains(0) = " + closedRange.contains(0));
        System.out.println("closedRange.contains(1) = " + closedRange.contains(1));
        System.out.println("closedRange.contains(2) = " + closedRange.contains(2));
        System.out.println("closedRange.contains(3) = " + closedRange.contains(3));
        System.out.println("closedRange.contains(4) = " + closedRange.contains(4));
        System.out.println("closedRange.contains(5) = " + closedRange.contains(5));
        System.out.println("closedRange.contains(6) = " + closedRange.contains(6));

        System.out.println(" ");

        Rangy openClosedRange = Rangy.openClosed(1, 5); // (a..b]	{x | a < x <= b}
        System.out.println("openClosedRange.contains(0) = " + openClosedRange.contains(0));
        System.out.println("openClosedRange.contains(1) = " + openClosedRange.contains(1));
        System.out.println("openClosedRange.contains(2) = " + openClosedRange.contains(2));
        System.out.println("openClosedRange.contains(3) = " + openClosedRange.contains(3));
        System.out.println("openClosedRange.contains(4) = " + openClosedRange.contains(4));
        System.out.println("openClosedRange.contains(5) = " + openClosedRange.contains(5));
        System.out.println("openClosedRange.contains(6) = " + openClosedRange.contains(6));

        System.out.println(" ");

        Rangy closedOpenRange = Rangy.closedOpen(1, 5);  // [a..b)	{x | a <= x < b}
        System.out.println("closedOpenRange.contains(0) = " + closedOpenRange.contains(0));
        System.out.println("closedOpenRange.contains(1) = " + closedOpenRange.contains(1));
        System.out.println("closedOpenRange.contains(2) = " + closedOpenRange.contains(2));
        System.out.println("closedOpenRange.contains(3) = " + closedOpenRange.contains(3));
        System.out.println("closedOpenRange.contains(4) = " + closedOpenRange.contains(4));
        System.out.println("closedOpenRange.contains(5) = " + closedOpenRange.contains(5));
        System.out.println("closedOpenRange.contains(6) = " + closedOpenRange.contains(6));

        System.out.println(" ");

        Rangy lessThanRange = Rangy.lessThan(3); // (-∞..b)	{x | x < b}
        System.out.println("lessThanRange.contains(0) = " + lessThanRange.contains(0));
        System.out.println("lessThanRange.contains(1) = " + lessThanRange.contains(1));
        System.out.println("lessThanRange.contains(2) = " + lessThanRange.contains(2));
        System.out.println("lessThanRange.contains(3) = " + lessThanRange.contains(3));
        System.out.println("lessThanRange.contains(4) = " + lessThanRange.contains(4));
        System.out.println("lessThanRange.contains(5) = " + lessThanRange.contains(5));
        System.out.println("lessThanRange.contains(6) = " + lessThanRange.contains(6));

        System.out.println(" ");

        Rangy greaterThanRange = Rangy.greaterThan(3); // (a..+∞)	{x | x > a}
        System.out.println("greaterThanRange.contains(0) = " + greaterThanRange.contains(0));
        System.out.println("greaterThanRange.contains(1) = " + greaterThanRange.contains(1));
        System.out.println("greaterThanRange.contains(2) = " + greaterThanRange.contains(2));
        System.out.println("greaterThanRange.contains(3) = " + greaterThanRange.contains(3));
        System.out.println("greaterThanRange.contains(4) = " + greaterThanRange.contains(4));
        System.out.println("greaterThanRange.contains(5) = " + greaterThanRange.contains(5));
        System.out.println("greaterThanRange.contains(6) = " + greaterThanRange.contains(6));

        System.out.println(" ");

        Rangy atMostRange = Rangy.atMost(3); // (-∞..b]	{x | x <= b}
        System.out.println("atMostRange.contains(0) = " + atMostRange.contains(0));
        System.out.println("atMostRange.contains(1) = " + atMostRange.contains(1));
        System.out.println("atMostRange.contains(2) = " + atMostRange.contains(2));
        System.out.println("atMostRange.contains(3) = " + atMostRange.contains(3));
        System.out.println("atMostRange.contains(4) = " + atMostRange.contains(4));
        System.out.println("atMostRange.contains(5) = " + atMostRange.contains(5));
        System.out.println("atMostRange.contains(6) = " + atMostRange.contains(6));

        System.out.println(" ");

        Rangy atLeastRange = Rangy.atLeast(3); // [a..+∞)	{x | x >= a}
        System.out.println("atLeastRange.contains(0) = " + atLeastRange.contains(0));
        System.out.println("atLeastRange.contains(1) = " + atLeastRange.contains(1));
        System.out.println("atLeastRange.contains(2) = " + atLeastRange.contains(2));
        System.out.println("atLeastRange.contains(3) = " + atLeastRange.contains(3));
        System.out.println("atLeastRange.contains(4) = " + atLeastRange.contains(4));
        System.out.println("atLeastRange.contains(5) = " + atLeastRange.contains(5));
        System.out.println("atLeastRange.contains(6) = " + atLeastRange.contains(6));

        System.out.println(" ");

//        Rangy<Double> atLeastRange2 = Rangy.atLeast(3);
    }
}




/*
 * This is free and unencumbered software released into the public domain.
 *
 * Created by: Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * Main (Version 2024.08.15.2006)
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */


import dev.reiniergarcia.helpers.JHArray;
import dev.reiniergarcia.helpers.Rangy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        // *                    Range Helper Class Usage Examples:                         *
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

        Rangy openRange = Rangy.open(1, 5); // (a..b)	{x | a < x < b}
        System.out.println("openRange.contains(0) = " + openRange.contains(0)); // false
        System.out.println("openRange.contains(1) = " + openRange.contains(1)); // false
        System.out.println("openRange.contains(2) = " + openRange.contains(2)); // true
        System.out.println("openRange.contains(3) = " + openRange.contains(3)); // true
        System.out.println("openRange.contains(4) = " + openRange.contains(4)); // true
        System.out.println("openRange.contains(5) = " + openRange.contains(5)); // false
        System.out.println("openRange.contains(6) = " + openRange.contains(6)); // false
        System.out.println("openRange.containsAll(new Number[]{1, 2, 3}) = " + openRange.containsAll(new Number[]{1, 2, 3})); // false
        System.out.println("openRange.containsAll(new Number[]{2, 3, 4}) = " + openRange.containsAll(new Number[]{2, 3, 4})); // true

        System.out.println(" ");

        Rangy closedRange = Rangy.closed(1, 5); // [a..b]	{x | a <= x <= b}
        System.out.println("closedRange.contains(0) = " + closedRange.contains(0)); // false
        System.out.println("closedRange.contains(1) = " + closedRange.contains(1)); // true
        System.out.println("closedRange.contains(2) = " + closedRange.contains(2)); // true
        System.out.println("closedRange.contains(3) = " + closedRange.contains(3)); // true
        System.out.println("closedRange.contains(4) = " + closedRange.contains(4)); // true
        System.out.println("closedRange.contains(5) = " + closedRange.contains(5)); // true
        System.out.println("closedRange.contains(6) = " + closedRange.contains(6)); // false

        System.out.println(" ");

        Rangy openClosedRange = Rangy.openClosed(1, 5); // (a..b]	{x | a < x <= b}
        System.out.println("openClosedRange.contains(0) = " + openClosedRange.contains(0)); // false
        System.out.println("openClosedRange.contains(1) = " + openClosedRange.contains(1)); // false
        System.out.println("openClosedRange.contains(2) = " + openClosedRange.contains(2)); // true
        System.out.println("openClosedRange.contains(3) = " + openClosedRange.contains(3)); // true
        System.out.println("openClosedRange.contains(4) = " + openClosedRange.contains(4)); // true
        System.out.println("openClosedRange.contains(5) = " + openClosedRange.contains(5)); // true
        System.out.println("openClosedRange.contains(6) = " + openClosedRange.contains(6)); // false

        System.out.println(" ");

        Rangy closedOpenRange = Rangy.closedOpen(1, 5);  // [a..b)	{x | a <= x < b}
        System.out.println("closedOpenRange.contains(0) = " + closedOpenRange.contains(0)); // false
        System.out.println("closedOpenRange.contains(1) = " + closedOpenRange.contains(1)); // true
        System.out.println("closedOpenRange.contains(2) = " + closedOpenRange.contains(2)); // true
        System.out.println("closedOpenRange.contains(3) = " + closedOpenRange.contains(3)); // true
        System.out.println("closedOpenRange.contains(4) = " + closedOpenRange.contains(4)); // true
        System.out.println("closedOpenRange.contains(5) = " + closedOpenRange.contains(5)); // false
        System.out.println("closedOpenRange.contains(6) = " + closedOpenRange.contains(6)); // false

        System.out.println(" ");

        Rangy lessThanRange = Rangy.lessThan(3); // (-∞..b)	{x | x < b}
        System.out.println("lessThanRange.contains(0) = " + lessThanRange.contains(0)); // true
        System.out.println("lessThanRange.contains(1) = " + lessThanRange.contains(1)); // true
        System.out.println("lessThanRange.contains(2) = " + lessThanRange.contains(2)); // true
        System.out.println("lessThanRange.contains(3) = " + lessThanRange.contains(3)); // false
        System.out.println("lessThanRange.contains(4) = " + lessThanRange.contains(4)); // false
        System.out.println("lessThanRange.contains(5) = " + lessThanRange.contains(5)); // false
        System.out.println("lessThanRange.contains(6) = " + lessThanRange.contains(6)); // false
        System.out.println("lessThanRange.contains(6) = " + lessThanRange.contains(6)); // false

        System.out.println(" ");

        Rangy greaterThanRange = Rangy.greaterThan(3); // (a..+∞)	{x | x > a}
        System.out.println("greaterThanRange.contains(0) = " + greaterThanRange.contains(0)); // false
        System.out.println("greaterThanRange.contains(1) = " + greaterThanRange.contains(1)); // false
        System.out.println("greaterThanRange.contains(2) = " + greaterThanRange.contains(2)); // false
        System.out.println("greaterThanRange.contains(3) = " + greaterThanRange.contains(3)); // false
        System.out.println("greaterThanRange.contains(4) = " + greaterThanRange.contains(4)); // true
        System.out.println("greaterThanRange.contains(5) = " + greaterThanRange.contains(5)); // true
        System.out.println("greaterThanRange.contains(6) = " + greaterThanRange.contains(6)); // true

        System.out.println(" ");

        Rangy atMostRange = Rangy.atMost(3); // (-∞..b]	{x | x <= b}
        System.out.println("atMostRange.contains(0) = " + atMostRange.contains(0)); // true
        System.out.println("atMostRange.contains(1) = " + atMostRange.contains(1)); // true
        System.out.println("atMostRange.contains(2) = " + atMostRange.contains(2)); // true
        System.out.println("atMostRange.contains(3) = " + atMostRange.contains(3)); // true
        System.out.println("atMostRange.contains(4) = " + atMostRange.contains(4)); // false
        System.out.println("atMostRange.contains(5) = " + atMostRange.contains(5)); // false
        System.out.println("atMostRange.contains(6) = " + atMostRange.contains(6)); // false

        System.out.println(" ");

        Rangy atLeastRange = Rangy.atLeast(3); // [a..+∞)	{x | x >= a}
        System.out.println("atLeastRange.contains(0) = " + atLeastRange.contains(0)); // false
        System.out.println("atLeastRange.contains(1) = " + atLeastRange.contains(1)); // false
        System.out.println("atLeastRange.contains(2) = " + atLeastRange.contains(2)); // false
        System.out.println("atLeastRange.contains(3) = " + atLeastRange.contains(3)); // true
        System.out.println("atLeastRange.contains(4) = " + atLeastRange.contains(4)); // true
        System.out.println("atLeastRange.contains(5) = " + atLeastRange.contains(5)); // true
        System.out.println("atLeastRange.contains(6) = " + atLeastRange.contains(6)); // true

        System.out.println(" ");

        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        // *                   JHArray Helper Class Usage Examples:                        *
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

        Integer[] randomIntegersArray = JHArray.getRandomArrayOfIntegersBetween(10, 1, 8, true, true);
        System.out.println(Arrays.toString(randomIntegersArray)); // Ex: [1, 1, 1, 2, 3, 3, 4, 5, 7, 8]

        Double[] randomDoublesArray = JHArray.getRandomArrayOfDoublesBetween(10, 1.3, 4.6, true, true);
        // Ex: [1.3335017457367042, 1.4766294095608694, 2.287119715569509, 2.828057459338784, 3.0665487094922264, 3.135150590738596, 3.332479242652111, 3.406945970565829, 3.862520441343709, 3.966527946556732]
        System.out.println(Arrays.toString(randomDoublesArray));

        System.out.println(" ");
    }
}



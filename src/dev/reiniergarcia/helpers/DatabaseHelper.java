/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * DatabaseHelper (Version 2024.07.29.0146)
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

import java.util.Random;

public class DatabaseHelper {
    // Generates a Universally Unique IDentifier (the usual 36-character alphanumeric string. UUID style) as a string. Format: bdc0a2fb-d39e-0242-9a0a-4e760153f18d
    public static String getUUID() {
        int min = 0; // Minimum value of the range (inclusive)
        int max = 15; // Maximum value of the range (inclusive)
        Random random = new Random();

        // basic random int distribution of the indexes for 16 possible characters to choose from
        final boolean[] mustAddDashes = {false, false, false, false, true, false, true, false, true, false, true, false, false, false, false, false};
        StringBuilder generatedID = new StringBuilder(); // The conformed string to return

        final String allowedCharacters = "0123456789abcdef";
        for (final boolean mustAddDashNow : mustAddDashes) {
            if (mustAddDashNow)
                generatedID.append("-"); // We insert the dash according to the planification inside the boolean array
            generatedID.append(allowedCharacters.charAt(random.nextInt(max - min + 1) + min)); // Fully random index
            generatedID.append(allowedCharacters.charAt(random.nextInt(max - min + 1) + min)); // Fully random index again, so we have at least a pair of characters (as string) added per iteration
        }

        return generatedID.toString();
    }
}

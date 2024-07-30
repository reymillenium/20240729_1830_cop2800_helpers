/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * DateTimeHelper (Version 2024.07.29.0306)
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

final public class DateTimeHelper {
    // Function to convert from a military Time (24 hours format) to civilian Time (12 hours format with meridian)
    public static String convertTimeToCivilian(final int militaryHours, final int minutes) {
        String meridian;
        int civilianHours;

        // Handle midnight and noon
        if (militaryHours == 0) {
            civilianHours = 12;
            meridian = "AM";
        } else if (militaryHours == 12) {
            civilianHours = 12;
            meridian = "PM";
        } else if (militaryHours < 12) {
            civilianHours = militaryHours;
            meridian = "AM";
        } else {
            civilianHours = militaryHours - 12;
            meridian = "PM";
        }

        return civilianHours + ":" + (minutes < 10 ? "0" : "") + minutes + " " + meridian;
    }

    // Function to convert from a military Time (24 hours format) to civilian Time (12 hours format with meridian)
    public static String convertTimeToCivilian(final String militaryTime) { //Ex: 0012, 1200, 0631
        int militaryHours = Integer.parseInt(militaryTime.substring(0, 2));
        int minutes = Integer.parseInt(militaryTime.substring(2, 4));

        String meridian;
        int civilianHours;

        // Handle midnight and noon
        if (militaryHours == 0) {
            civilianHours = 12;
            meridian = "AM";
        } else if (militaryHours == 12) {
            civilianHours = 12;
            meridian = "PM";
        } else if (militaryHours < 12) {
            civilianHours = militaryHours;
            meridian = "AM";
        } else {
            civilianHours = militaryHours - 12;
            meridian = "PM";
        }

        return civilianHours + ":" + (minutes < 10 ? "0" : "") + minutes + " " + meridian;
    }
}

/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * TFile (Version 2024.07.29.2214)
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

final public class TFile {
    // Detects if a given filename exist or not
    public static boolean fileExist(final String fileName) {
        return new File(fileName).exists();
    }

    // Gets all the non-empty lines of text inside a given file name
    public static List<String> getLinesFromFile(final String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return List.of();
    }

    // Either creates a .txt file and adds text to it, or adds to an existent one
    public static void addTextToFile(final String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            final String textLine = Terminus.getStringFromMessage("Write a single line of text please: ");
            writer.write(textLine);
            writer.close();
        } catch (IOException e) {
            // e.printStackTrace();
            System.err.println("Error reading file: " + e.getMessage());

        }
    }

    // Adds text to a .txt file only if it already exists
    public static void addTextToExistingFile(final String fileName) {
        if (fileExist(fileName)) addTextToFile(fileName);
    }

    // Either creates a .txt file and adds a new line of text to it, or adds to an existent one
    public static void addTextLineToFile(final String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            final String textLine = Terminus.getStringFromMessage("Write a single line of text please: ");
            writer.write(textLine);
            writer.newLine(); // Add a new line character
        } catch (IOException e) {
            // e.printStackTrace();
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Adds a text line to a given .txt file name only if it already exists
    public static void addTextLineToExistingFile(final String fileName) {
        if (fileExist(fileName)) addTextLineToFile(fileName);
    }
}

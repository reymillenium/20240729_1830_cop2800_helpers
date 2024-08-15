/*
 * MIT License
 *
 * Copyright (c) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * Rangy (Version 2024.08.02.0112)
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

public class Rangy {
    // Instance Attributes
    Bound upperBound = null;
    Bound lowerBound = null;

    // Constructor
    private Rangy(Bound lowerBound, Bound upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    static Rangy create(Bound lowerBound, Bound upperBound) {
        return new Rangy(lowerBound, upperBound);
    }

    // (a..b)	{x | a < x < b}
    public static Rangy open(Number lower, Number upper) {
        return create(new Bound(lower, CutType.ABOVE_VALUE), new Bound(upper, CutType.BELOW_VALUE));
    }

    // [a..b]	{x | a <= x <= b}
    public static Rangy closed(Number lower, Number upper) {
        return create(new Bound(lower, CutType.BELOW_VALUE), new Bound(upper, CutType.ABOVE_VALUE));
    }

    // [a..b)	{x | a <= x < b}
    public static Rangy closedOpen(Number lower, Number upper) {
        return create(new Bound(lower, CutType.BELOW_VALUE), new Bound(upper, CutType.BELOW_VALUE));
    }

    // (a..b]	{x | a < x <= b}
    public static Rangy openClosed(Number lower, Number upper) {
        return create(new Bound(lower, CutType.ABOVE_VALUE), new Bound(upper, CutType.ABOVE_VALUE));
    }

    // (-∞..b)	{x | x < b}
    public static Rangy lessThan(Number endPoint) {
        return create(new Bound(null, CutType.BELOW_ALL), new Bound(endPoint, CutType.BELOW_VALUE));
    }

    // (a..+∞)	{x | x > a}
    public static Rangy greaterThan(Number endPoint) {
        return create(new Bound(endPoint, CutType.ABOVE_VALUE), new Bound(null, CutType.ABOVE_ALL));
    }

    // (-∞..b]	{x | x <= b}
    public static Rangy atMost(Number endPoint) {
        return create(new Bound(null, CutType.BELOW_ALL), new Bound(endPoint, CutType.ABOVE_VALUE));
    }

    // [a..+∞)	{x | x >= a}
    public static Rangy atLeast(Number endPoint) {
        return create(new Bound(endPoint, CutType.BELOW_VALUE), new Bound(null, CutType.ABOVE_ALL));
    }

    // Instance Methods

    // Determines if the given Number object is included in the defined Rangy
    public boolean contains(Number value) {
        return this.lowerBound.isLessThan(value) && !this.upperBound.isLessThan(value);
    }

    // Determines if all the number inside the given array of Number objects are included in the defined Rangy
    public boolean containsAll(Number[] values) {
        if (values.length == 0) return false;
        boolean result = true;

        for (Number value : values) {
            if (!this.contains(value)) {
                result = false;
                break;
            }
        }

        return result;
    }

    // Determines if any of the numbers inside the given array of Number objects is included in the defined Rangy
    public boolean containsAny(Number[] values) {
        if (values.length == 0) return false;
        boolean result = false;

        for (Number value : values) {
            if (!this.contains(value)) {
                result = true;
                break;
            }
        }

        return result;
    }
}

enum CutType {
    ABOVE_ALL, ABOVE_VALUE, BELOW_VALUE, BELOW_ALL,
}

class Bound {
    Number value;
    CutType cutType;

    public Bound(Number value, CutType type) {
        this.value = value;
        this.cutType = type;
    }

    boolean isLessThan(Number aValue) {
        return switch (cutType) {
            case ABOVE_ALL -> false;
            case BELOW_ALL -> true;
            case ABOVE_VALUE -> {
                final Class<? extends Number> instanceClass = value.getClass();
                final String className = instanceClass.getName();

                yield switch (className) {
                    case "java.lang.Byte" -> value.byteValue() < aValue.byteValue();
                    case "java.lang.Short" -> value.shortValue() < aValue.shortValue();
                    case "java.lang.Integer" -> value.intValue() < aValue.intValue();
                    case "java.lang.Long" -> value.longValue() < aValue.longValue();
                    case "java.lang.Float" -> value.floatValue() < aValue.floatValue();
                    case "java.lang.Double" -> value.doubleValue() < aValue.doubleValue();
                    default -> throw new IllegalStateException("Unexpected value: " + value + " of class name " + className);
                };
            }
            case BELOW_VALUE -> {
                final Class<? extends Number> instanceClass = value.getClass();
                final String className = instanceClass.getName();

                yield switch (className) {
                    case "java.lang.Byte" -> value.byteValue() <= aValue.byteValue();
                    case "java.lang.Short" -> value.shortValue() <= aValue.shortValue();
                    case "java.lang.Integer" -> value.intValue() <= aValue.intValue();
                    case "java.lang.Long" -> value.longValue() <= aValue.longValue();
                    case "java.lang.Float" -> value.floatValue() <= aValue.floatValue();
                    case "java.lang.Double" -> value.doubleValue() <= aValue.doubleValue();
                    default -> throw new IllegalStateException("Unexpected value: " + value + " of class name " + className);
                };
            }
        };
    }
}

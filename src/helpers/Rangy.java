/*
 * MIT License
 *
 * Copyright (C) 2024 | Reinier Garcia Ramos | reymillenium@gmail.com | https://www.reiniergarcia.dev/
 *
 * Rangy (Version 2024.07.21.2041)
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

enum CutType {
    ABOVE_ALL,
    ABOVE_VALUE,
    BELOW_VALUE,
    BELOW_ALL,
}

class Bound {
    Number value;
    CutType cutType;

    public Bound(Number value, CutType type) {
        this.value = value;
        this.cutType = type;
    }

    boolean isLessThan(Number aValue) {
        if (cutType == CutType.ABOVE_ALL)
            return false;
        else if (cutType == CutType.BELOW_ALL)
            return true;
        else if (cutType == CutType.ABOVE_VALUE) {
            Class<? extends Number> instanceClass = value.getClass();
            String className = instanceClass.getName();
            switch (className) {
                case "java.lang.Byte":
                    return value.byteValue() < aValue.byteValue();
                case "java.lang.Short":
                    return value.shortValue() < aValue.shortValue();
                case "java.lang.Integer":
                    return value.intValue() < aValue.intValue();
                case "java.lang.Long":
                    return value.longValue() < aValue.longValue();
                case "java.lang.Float":
                    return value.floatValue() < aValue.floatValue();
                case "java.lang.Double":
                    return value.doubleValue() < aValue.doubleValue();
            }
        } else if (cutType == CutType.BELOW_VALUE) {
            Class<? extends Number> instanceClass = value.getClass();
            String className = instanceClass.getName();
            switch (className) {
                case "java.lang.Byte":
                    return value.byteValue() <= aValue.byteValue();
                case "java.lang.Short":
                    return value.shortValue() <= aValue.shortValue();
                case "java.lang.Integer":
                    return value.intValue() <= aValue.intValue();
                case "java.lang.Long":
                    return value.longValue() <= aValue.longValue();
                case "java.lang.Float":
                    return value.floatValue() <= aValue.floatValue();
                case "java.lang.Double":
                    return value.doubleValue() <= aValue.doubleValue();
            }
        }

        System.out.println("We should not be here ");
        return false;
    }
}


public class Rangy<C extends Comparable> {
    // Instance Attributes
    Bound upperBound = null;
    Bound lowerBound = null;

    // Constructor
    private Rangy(Bound lowerBound, Bound upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    static <C extends Comparable<?>> Rangy<C> create(Bound lowerBound, Bound upperBound) {
        return new Rangy<>(lowerBound, upperBound);
    }

    // (a..b)	{x | a < x < b}
    public static <C extends Comparable<?>> Rangy<C> open(Number lower, Number upper) {
        return create(new Bound(lower, CutType.ABOVE_VALUE), new Bound(upper, CutType.BELOW_VALUE));
    }

    // [a..b]	{x | a <= x <= b}
    public static <C extends Comparable<?>> Rangy<C> closed(Number lower, Number upper) {
        return create(new Bound(lower, CutType.BELOW_VALUE), new Bound(upper, CutType.ABOVE_VALUE));
    }

    // [a..b)	{x | a <= x < b}
    public static <C extends Comparable<?>> Rangy<C> closedOpen(Number lower, Number upper) {
        return create(new Bound(lower, CutType.BELOW_VALUE), new Bound(upper, CutType.BELOW_VALUE));
    }

    // (a..b]	{x | a < x <= b}
    public static <C extends Comparable<?>> Rangy<C> openClosed(Number lower, Number upper) {
        return create(new Bound(lower, CutType.ABOVE_VALUE), new Bound(upper, CutType.ABOVE_VALUE));
    }

    // (-∞..b)	{x | x < b}
    public static <C extends Comparable<?>> Rangy<C> lessThan(Number endPoint) {
        return create(new Bound(null, CutType.BELOW_ALL), new Bound(endPoint, CutType.BELOW_VALUE));
    }

    // (a..+∞)	{x | x > a}
    public static <C extends Comparable<?>> Rangy<C> greaterThan(Number endPoint) {
        return create(new Bound(endPoint, CutType.ABOVE_VALUE), new Bound(null, CutType.ABOVE_ALL));
    }

    // (-∞..b]	{x | x <= b}
    public static <C extends Comparable<?>> Rangy<C> atMost(Number endPoint) {
        return create(new Bound(null, CutType.BELOW_ALL), new Bound(endPoint, CutType.ABOVE_VALUE));
    }

    // [a..+∞)	{x | x >= a}
    public static <C extends Comparable<?>> Rangy<C> atLeast(Number endPoint) {
        return create(new Bound(endPoint, CutType.BELOW_VALUE), new Bound(null, CutType.ABOVE_ALL));
    }

    // Instance Method
    public boolean contains(Number value) {
        return this.lowerBound.isLessThan(value) && !this.upperBound.isLessThan(value);
    }
}

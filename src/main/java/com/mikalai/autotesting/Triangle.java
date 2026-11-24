
package com.mikalai.autotesting;

import java.util.Arrays;

public class Triangle {

    public static boolean isTriangle(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        return (long) a + b > c
                && (long) a + c > b
                && (long) b + c > a;
    }

    public static TriangleType classify(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return TriangleType.INVALID_INPUT;
        }

        if (!isTriangle(a, b, c)) {
            return TriangleType.NOT_A_TRIANGLE;
        }

        long[] sides = {a, b, c};
        Arrays.sort(sides);

        long x = sides[0];
        long y = sides[1];
        long z = sides[2];

        long sumOfSquares = x * x + y * y;
        long largestSquare = z * z;

        if (sumOfSquares == largestSquare) {
            return TriangleType.RIGHT;
        }

        if (sumOfSquares > largestSquare) {
            return TriangleType.ACUTE;
        }

        return TriangleType.OBTUSE;
    }
}

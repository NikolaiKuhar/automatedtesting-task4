
package com.mikalai.autotesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {

    @DataProvider(name = "triangleValidityData")
    public Object[][] triangleValidityData() {
        return new Object[][]{
                {3, 4, 5, true},
                {5, 3, 4, true},
                {3, 3, 3, true},
                {4, 5, 6, true},
                {2, 3, 4, true},
                {3, 3, 5, true},
                {1, 1, 1, true},
                {1, 2, 3, false},
                {1, 2, 4, false},
                {2, 3, 5, false},
                {2, 3, 6, false},
                {0, 3, 4, false},
                {-1, 3, 4, false},
                {3, 0, 4, false},
                {3, 4, -1, false},
                {Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MAX_VALUE, true}
        };
    }

    @Test(dataProvider = "triangleValidityData")
    public void testIsTriangle(int a, int b, int c,
                               boolean expected) {

        boolean actual = Triangle.isTriangle(a, b, c);

        Assert.assertEquals(actual, expected,
                "Incorrect triangle validity result");
    }

    @DataProvider(name = "triangleClassificationData")
    public Object[][] triangleClassificationData() {
        return new Object[][]{
                {3, 4, 5, TriangleType.RIGHT},
                {5, 3, 4, TriangleType.RIGHT},
                {3, 3, 3, TriangleType.ACUTE},
                {4, 5, 6, TriangleType.ACUTE},
                {2, 3, 4, TriangleType.OBTUSE},
                {3, 3, 5, TriangleType.OBTUSE},
                {1, 1, 1, TriangleType.ACUTE},
                {1, 2, 3, TriangleType.NOT_A_TRIANGLE},
                {1, 2, 4, TriangleType.NOT_A_TRIANGLE},
                {2, 3, 5, TriangleType.NOT_A_TRIANGLE},
                {2, 3, 6, TriangleType.NOT_A_TRIANGLE},
                {0, 3, 4, TriangleType.INVALID_INPUT},
                {-1, 3, 4, TriangleType.INVALID_INPUT},
                {3, 0, 4, TriangleType.INVALID_INPUT},
                {3, 4, -1, TriangleType.INVALID_INPUT},
                {Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MAX_VALUE, TriangleType.ACUTE}
        };
    }

    @Test(dataProvider = "triangleClassificationData")
    public void testClassify(int a, int b, int c,
                             TriangleType expected) {

        TriangleType actual = Triangle.classify(a, b, c);

        Assert.assertEquals(actual, expected,
                "Incorrect triangle classification");
    }
}

package com.code.challenges.outlier;

import org.junit.Assert;
import org.junit.Test;

public class Outlier {

    public static int outlier(final int[] integers) {
        int firstOdd = 0;
        int firstEven = 1;

        for (final int value : integers) {
            if (value % 2 == 0) {
                if (firstEven == 1) {
                    firstEven = value;
                } else if (firstOdd != 0) {
                    return firstOdd;
                }
            } else {
                if (firstOdd == 0) {
                    firstOdd = value;
                } else if (firstEven != 1) {
                    return firstEven;
                }
            }
        }
        return integers[integers.length - 1];
    }

    @Test
    public void basicTests() {
        Assert.assertEquals(11, Outlier.outlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
        Assert.assertEquals(160, Outlier.outlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));
        Assert.assertEquals(3, Outlier.outlier(new int[]{2, 6, 8, -10, 3}));
        Assert.assertEquals(0, Outlier.outlier(new int[]{Integer.MAX_VALUE, 0, 1}));
    }
}

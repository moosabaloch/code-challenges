package com.code.challenges.tribonacci;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Tribonacci {

    public static double[] tribonacci(final double[] s, final int n) {
        final double[] tritab = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            tritab[i] = tritab[i - 1] + tritab[i - 2] + tritab[i - 3];
        }
        return tritab;
    }

    @Test
    public void basicTests() {
        final double precision = 1e-10;
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, Tribonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, Tribonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, Tribonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0}, Tribonacci.tribonacci(new double[]{0, 1, 1}, 1), precision);
    }
}

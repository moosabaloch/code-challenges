package com.code.challenges.greatestcommondivisor;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GreatestCommonDivisor {
    public int generalizedGCD(final int num, final int[] arr) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return arr[0];
        }
        if (num == 2) {
            return gcd(arr[0], arr[1]);
        }

        final int initialGCD = generalizedGCD((int) Math.ceil(num >> 1), Arrays.copyOfRange(arr, 0, (int) Math.ceil(num >> 1)));
        final int finalGCD = generalizedGCD(Math.floorDiv(num, 2), Arrays.copyOfRange(arr, Math.floorDiv(num, 2), num));
        return gcd(initialGCD, finalGCD);
    }

    private int gcd(final int a, final int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    @Test
    public void testGCD() {
        final GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        assertEquals(Integer.valueOf(2), Integer.valueOf(gcd.generalizedGCD(5, new int[]{2, 4, 6, 8, 10})));
        assertEquals(Integer.valueOf(4), Integer.valueOf(gcd.generalizedGCD(2, new int[]{4, 8})));
        assertEquals(Integer.valueOf(8), Integer.valueOf(gcd.generalizedGCD(3, new int[]{16, 8, 64})));
    }
}

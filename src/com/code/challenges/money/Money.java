package com.code.challenges.money;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Money {
    public static int calculateYears(double principal, final double interest, final double tax, final double desired) {
        for (int i = 0; ; i++) {
            if (principal >= desired) {
                return i;
            } else {
                principal = principal * (1 + (interest * (1 - tax)));
            }
        }
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests calculateYears");
        assertEquals(3, Money.calculateYears(1000, 0.05, 0.18, 1100));
        assertEquals(14, Money.calculateYears(1000, 0.01625, 0.18, 1200));
        assertEquals(0, Money.calculateYears(1000, 0.05, 0.18, 1000));
    }
}

package com.code.challenges.popular;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MostPopularNumber {

    public static Integer mostPopularNumber(final int[] values, final int length) {
        final Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(values).forEach(value -> counter.merge(value, 1, (a, b) -> (a + b)));
        int maxValue = Integer.MAX_VALUE;
        int maxCount = 0;
        for (final Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > maxCount && entry.getKey() < maxValue) {
                maxCount = entry.getValue();
                maxValue = entry.getKey();
            }
        }
        return maxValue;
    }

    @Test
    public void mostPopularNumber() {
        assertEquals(Integer.valueOf(34), MostPopularNumber.mostPopularNumber(new int[]{34, 31, 34, 77, 82}, 5));
        assertEquals(Integer.valueOf(101), MostPopularNumber.mostPopularNumber(new int[]{22, 101, 102, 101, 102, 525, 88}, 7));
        assertEquals(Integer.valueOf(66), MostPopularNumber.mostPopularNumber(new int[]{66}, 1));
        assertEquals(Integer.valueOf(2342), MostPopularNumber.mostPopularNumber(new int[]{14, 14, 2342, 2342, 2342}, 5));
    }
}

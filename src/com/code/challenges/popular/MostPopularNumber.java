package com.code.challenges.popular;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * MostPopularNumber
 *
 * @author Luiz Azevedo
 * @version 1.0 31/05/18
 */
public class MostPopularNumber {

    public static Integer mostPopularNumber(final int[] values, final int length) {
        final Map<Integer, Integer> counterMap = new HashMap<>();

        for (final int value : values) {
            Integer valueCount = counterMap.get(value);
            if (valueCount == null) {
                counterMap.put(value, 1);
            } else {
                counterMap.put(value, valueCount++);
            }
        }
        int maxValue = Integer.MAX_VALUE;
        int maxCount = 0;
        for (final Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
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

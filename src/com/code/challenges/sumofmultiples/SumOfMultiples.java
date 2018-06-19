package com.code.challenges.sumofmultiples;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SumOfMultiples {

    public static int solution(final int number) {
        return IntStream.range(0, number).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
    }

    @Test
    public void test() {
        assertEquals(23, SumOfMultiples.solution(10));
    }
}

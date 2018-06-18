package com.code.challenges.highandlow;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class HighAndLow {
    public static String highAndLow(final String numbers) {
        final Integer[] values = Stream.of(numbers.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        return Stream.of(values).max(Integer::compareTo).orElseThrow(AssertionError::new)
                + " "
                + Stream.of(values).min(Integer::compareTo).orElseThrow(AssertionError::new);
    }

    @Test
    public void Test1() {
        assertEquals("42 -9", HighAndLow.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
}

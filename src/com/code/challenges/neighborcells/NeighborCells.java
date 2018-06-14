package com.code.challenges.neighborcells;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class NeighborCells {
    public List<Integer> cellCompete(final int[] states, final int days) {
        if (days > 1) {
            return cellCompete(cellCompete(states), days - 1);
        }
        return Arrays.stream(cellCompete(states)).boxed().collect(Collectors.toList());
    }

    private int[] cellCompete(final int[] states) {
        final int[] newStates = new int[states.length];
        for (int i = 0; i < states.length; i++) {
            newStates[i] = compete(i - 1 >= 0 ? states[i - 1] : 0,
                    i + 1 < states.length ? states[i + 1] : 0);
        }
        return newStates;
    }

    private int compete(final int before, final int after) {
        return before == after ? 0 : 1;
    }

    @Test
    public void testNeighborsCells() {
        final NeighborCells cells = new NeighborCells();
        assertEquals(Collections.singletonList(0), cells.cellCompete(new int[]{1}, 1));
        assertEquals(Collections.singletonList(0), cells.cellCompete(new int[]{1}, 10));
        assertEquals(Arrays.asList(0, 0), cells.cellCompete(new int[]{0, 0}, 10));
        assertEquals(Arrays.asList(0, 1), cells.cellCompete(new int[]{1, 0}, 9));
        assertEquals(Arrays.asList(0, 0, 0), cells.cellCompete(new int[]{1, 0, 1}, 1));
        assertEquals(Arrays.asList(1, 1, 1), cells.cellCompete(new int[]{0, 1, 1}, 1));
        assertEquals(Arrays.asList(1, 0, 1), cells.cellCompete(new int[]{0, 1, 1}, 2));
    }
}

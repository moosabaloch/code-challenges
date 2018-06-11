package com.code.challenges.backupsystem;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class BackupSystem {

    public int getMinimumTapeCount(final Batch batch) {
        final List<Integer> filesSortedBySize = Arrays.stream(batch.getFileSizes()).sorted().boxed()
                .collect(Collectors.toList());
        final List<Tape> tapes = new LinkedList<>();

        while (!filesSortedBySize.isEmpty()) {
            final Integer file = filesSortedBySize.get(filesSortedBySize.size() - 1);

            writeFile(tapes, file, batch.getTapeSize());

            filesSortedBySize.remove(file);
        }

        return tapes.size();
    }

    private void writeFile(final List<Tape> tapes, final Integer file, final int tapeSize) {
        for (final Tape tape : tapes) {
            if (tape.getWritenSize() + file <= tapeSize && tape.supportsMoreFiles()) {
                tape.addFile(file);
                return;
            }
        }
        tapes.add(new Tape(file));
    }

    @Test
    public void testTapeWriting() {
        assertEquals(Integer.valueOf(2), Integer.valueOf(new BackupSystem().getMinimumTapeCount(new Batch() {

            @Override
            public int[] getFileSizes() {
                return new int[]{70, 10, 20, 90};
            }

            @Override
            public int getTapeSize() {
                return 100;
            }

        })));
    }
}

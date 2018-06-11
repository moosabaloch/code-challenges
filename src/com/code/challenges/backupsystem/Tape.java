package com.code.challenges.backupsystem;

import java.util.LinkedList;
import java.util.List;

public class Tape {
    private final List<Integer> files = new LinkedList<>();
    private int count = 1;
    private int writtenSize = 0;

    public Tape(final int file) {
        files.add(file);
    }

    public void addFile(final Integer fileSize) {
        files.add(fileSize);
        writtenSize += fileSize;
        count++;
    }

    public int getWritenSize() {
        return writtenSize;
    }

    public boolean supportsMoreFiles() {
        return count < 2;
    }
}

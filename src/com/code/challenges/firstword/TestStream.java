package com.code.challenges.firstword;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TestStream
 *
 * @author Luiz Azevedo
 * @version 1.0 11/06/18
 */
class TestStream implements Stream {
    private final Iterator<Character> iterator;

    public TestStream(final String sentence) {
        final ArrayList<Character> chars = new ArrayList<>();
        for (final char c : sentence.toCharArray()) {
            chars.add(c);
        }
        iterator = chars.iterator();
    }

    @Override
    public char next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

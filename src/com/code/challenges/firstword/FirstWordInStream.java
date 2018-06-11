package com.code.challenges.firstword;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FirstWordInStream {
    private static final Set<Character> SPACING_CHARACTERS = new HashSet<>(Arrays.asList(' ', '.', ',', ';', '-', '_'));

    public String firstWord(final Stream input) {
        final Map<String, Integer> wordCount = new LinkedHashMap<>();

        while (input.hasNext()) {
            final String word = readNextWord(input);
            final String key = word.toLowerCase();
            wordCount.merge(key, 1, (a, b) -> a + b);
        }

        return wordCount.entrySet().stream().filter(c -> c.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse("");
    }

    private String readNextWord(final Stream input) {
        final StringBuilder buffer = new StringBuilder();

        while (input.hasNext()) {
            final char nextCharacter = input.next();
            if (isSpacingCharacter(nextCharacter)) {
                break;
            }
            buffer.append(nextCharacter);
        }

        return buffer.toString();
    }

    private boolean isSpacingCharacter(final char character) {
        return FirstWordInStream.SPACING_CHARACTERS.contains(character);
    }

    @Test
    public void testFirstWord() {
        final FirstWordInStream firstWord = new FirstWordInStream();
        assertEquals("red", firstWord.firstWord(new TestStream("The angry dog was red. And the cat was also angry dog.")));

        assertEquals("lorem", firstWord.firstWord(new TestStream("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")));
    }
}

package com.code.challenges.gropuingwords;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordGrouper {
    public static Map<CharacterGrouper, List<String>> groupWordsByCharacter(final String[] values) {
        return Stream.of(values).collect(Collectors.groupingBy(CharacterGrouper::new));
    }

    private static class CharacterGrouper {

        private final Map<Character, Integer> count;

        public CharacterGrouper(final String value) {
            count = new HashMap<>();
            value.chars().forEach((c) -> count.merge((char) c, 1, (a, b) -> (a + b)));
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final CharacterGrouper that = (CharacterGrouper) o;
            return Objects.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Objects.hash(count);
        }
    }

    public static void main(final String[] args) {
        System.out.println(WordGrouper.groupWordsByCharacter(new String[]{"124", "412", "425", "241", "524", "324", "2141"}));
    }
}

package com.code.challenges.commonwords;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CommonWords {

    private static final String WHITESPACE_PATTERN = " ";

    List<String> retrieveMostFrequentlyUsedWords(final String literatureText, final List<String> wordsToExclude) {
        final HashSet<String> exclusionSet = new HashSet<>(wordsToExclude);
        final Map<String, Integer> wordCount = new LinkedHashMap<>();

        Arrays.stream(literatureText.split(CommonWords.WHITESPACE_PATTERN)).forEach(word -> {
            if (!exclusionSet.contains(word)) {
                wordCount.merge(word, 1, (a, b) -> a + b);
            }
        });

        final Integer maximumWordCount = wordCount.entrySet().stream().map(Map.Entry::getValue).max(Integer::compareTo).orElse(0);

        return wordCount.entrySet().stream().filter(entry -> entry.getValue() == maximumWordCount).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Test
    public void testCommonWords() {
        final CommonWords commonWords = new CommonWords();
        assertEquals(Arrays.asList("jack", "cheese"), commonWords.retrieveMostFrequentlyUsedWords("jack and jill went to the market to buy bread and cheese cheese is jack favorite food", Arrays.asList("and", "he", "the", "to", "is")));

        assertEquals(Arrays.asList("jack", "cheese"), commonWords.retrieveMostFrequentlyUsedWords("and and and and jack and jill went to the market to buy bread and cheese cheese is jack favorite food", Arrays.asList("and", "he", "the", "to", "is")));

        assertEquals(Arrays.asList(""), commonWords.retrieveMostFrequentlyUsedWords("", Arrays.asList("and", "he", "the", "to", "is")));
    }

}

package com.code.challenges.balancedsentence;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BalancedSentence {

    private enum Bracket {

        ROUND('(', ')'),
        SQUARE('[', ']'),
        CURLY('{', '}'),
        ANGLE('<', '>');

        private final Character opening;
        private final Character closing;

        private static final Map<Character, Bracket> OPENING_BRACKETS = Stream.of(Bracket.values()).collect(Collectors.toMap(Bracket::getOpening, bracket -> bracket));
        private static final Map<Character, Bracket> CLOSING_BRACKETS = Stream.of(Bracket.values()).collect(Collectors.toMap(Bracket::getClosing, bracket -> bracket));

        Bracket(final Character opening, final Character closing) {
            this.opening = opening;
            this.closing = closing;
        }

        Character getOpening() {
            return opening;
        }

        Character getClosing() {
            return closing;
        }

        public static Optional<Bracket> getOpeningBracket(final Character character) {
            return Optional.ofNullable(Bracket.OPENING_BRACKETS.get(character));
        }

        public static Optional<Bracket> getClosingBracket(final Character character) {
            return Optional.ofNullable(Bracket.CLOSING_BRACKETS.get(character));
        }
    }

    public static boolean isBalanced(final String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return true;
        }
        final Map<Bracket, Integer> balance = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            final Optional<Bracket> openingBracket = Bracket.getOpeningBracket(sentence.charAt(i));
            if (openingBracket.isPresent()) {
                balance.merge(openingBracket.get(), 1, (a, b) -> (a + b));
            } else {
                final Optional<Bracket> closingBracket = Bracket.getClosingBracket(sentence.charAt(i));
                if (closingBracket.isPresent()) {
                    balance.merge(closingBracket.get(), 1, (a, b) -> (a - b));
                    if (balance.get(closingBracket.get()) < 0) {
                        return false;
                    }
                }
            }
        }
        return balance.entrySet().stream().allMatch(entry -> entry.getValue() == 0);
    }

    @Test
    public void testBalancedBrackets() {
        Assert.assertTrue(BalancedSentence.isBalanced(""));
        Assert.assertTrue(BalancedSentence.isBalanced("[]"));
        Assert.assertTrue(BalancedSentence.isBalanced("[{}]"));
        Assert.assertTrue(BalancedSentence.isBalanced("[{()}]"));
        Assert.assertTrue(BalancedSentence.isBalanced("[{(<>)}]"));
        Assert.assertFalse(BalancedSentence.isBalanced("["));
        Assert.assertFalse(BalancedSentence.isBalanced("]["));
    }
}

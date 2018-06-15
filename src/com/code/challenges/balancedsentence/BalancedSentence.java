package com.code.challenges.balancedsentence;

import java.util.*;

public class BalancedSentence {
    private static final Set<Character> OPENING_BRACKETS =
            new HashSet<>(Arrays.asList('[', '{', '('));

    private static final Map<Character, Character> CLOSING_BRACKETS =
            new HashMap<>();

    static {
        BalancedSentence.CLOSING_BRACKETS.put(']', '[');
        BalancedSentence.CLOSING_BRACKETS.put('}', '{');
        BalancedSentence.CLOSING_BRACKETS.put(')', '(');
    }

    public static void main(final String[] args) {
        System.out.println(BalancedSentence.parensMatch("{([])}"));
    }

    public static boolean parensMatch(final String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return true;
        }
        final Map<Character, Integer> balance = new HashMap<>();

        for (int i = 0; i < sentence.length(); i++) {
            if (BalancedSentence.OPENING_BRACKETS.contains(sentence.charAt(i))) {
                balance.merge(sentence.charAt(i), 1, (a, b) -> (a + b));
            } else if (BalancedSentence.CLOSING_BRACKETS.containsKey(sentence.charAt(i))) {
                balance.merge(BalancedSentence.CLOSING_BRACKETS.get(sentence.charAt(i)), 1, (a, b) -> (a - b));
                if (balance.get(BalancedSentence.CLOSING_BRACKETS.get(sentence.charAt(i))) < 0) {
                    return false;
                }
            }
        }
        return balance.entrySet().stream().allMatch(entry -> entry.getValue() == 0);
    }
}

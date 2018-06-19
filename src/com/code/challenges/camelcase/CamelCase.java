package com.code.challenges.camelcase;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CamelCase {

    public static String toCamelCase(final String s) {
        final String[] words = s.split("[-_]");
        final StringBuilder result = new StringBuilder(words[0]);
        IntStream.range(1, words.length).forEach(i -> {
            result.append(Character.toUpperCase(words[i].charAt(0)));
            result.append(words[i].substring(1));
        });
        return result.toString();
    }

    @Test
    public void testSomeUnderscoreLowerStart() {
        final String input = "the_Stealth_Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        final String input = "the-Stealth-Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }
}

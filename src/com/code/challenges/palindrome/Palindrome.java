package com.code.challenges.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Palindrome
 *
 * @author Luiz Azevedo
 * @version 1.0 31/05/18
 */
public class Palindrome {

    public static boolean isAlmostPalindrome(final String value) {
        int missCount = 0;
        final int n = value.length();
        for (int i = 0; i < n / 2; i++) {
            if (value.charAt(i) != value.charAt(n - i - 1)) {
                if (missCount++ > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testPalindromes() {
        assertTrue(Palindrome.isAlmostPalindrome("abccba"));
        assertTrue(Palindrome.isAlmostPalindrome("abcacba"));
        assertTrue(Palindrome.isAlmostPalindrome("abccbx"));
        assertFalse(Palindrome.isAlmostPalindrome("abccfg"));
    }
}

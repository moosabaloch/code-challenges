package com.code.challenges.findclosingbrackets;

import org.junit.Assert;
import org.junit.Test;

public class FindClosingBrackets {

    public static int findClosingBracket(final String text, final int openingBracketIndex) {

        int bracketBalance = 0;

        if (openingBracketIndex < text.length() && text.charAt(openingBracketIndex) == '[') {
            for (int i = openingBracketIndex; i < text.length(); i++) {
                if (text.charAt(i) == '[') {
                    bracketBalance++;
                } else if (text.charAt(i) == ']') {
                    bracketBalance--;
                }
                if (bracketBalance == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void testFindClosingBracket() {
        Assert.assertEquals(8, FindClosingBrackets.findClosingBracket("[ABC[23]][89]", 0));
        Assert.assertEquals(-1, FindClosingBrackets.findClosingBracket("[ABC[23]][89]", 1));
        Assert.assertEquals(-1, FindClosingBrackets.findClosingBracket("[ABC[23]][89]", 13));
    }
}

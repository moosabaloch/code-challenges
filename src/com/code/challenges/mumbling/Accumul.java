package com.code.challenges.mumbling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Accumul {

    public static String accum(final String s) {
        final StringBuilder result = new StringBuilder();
        final String sentence = s.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            if (i != 0) {
                result.append("-");
            }
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    result.append(Character.toUpperCase(sentence.charAt(i)));
                } else {
                    result.append(sentence.charAt(i));
                }
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests accum");
        assertEquals("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu", Accumul.accum("ZpglnRxqenU"));
        assertEquals("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb", Accumul.accum("NyffsGeyylB"));
        assertEquals("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu", Accumul.accum("MjtkuBovqrU"));
        assertEquals("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm", Accumul.accum("EvidjUnokmM"));
        assertEquals("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc", Accumul.accum("HbideVbxncC"));
    }
}

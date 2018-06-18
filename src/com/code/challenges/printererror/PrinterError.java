package com.code.challenges.printererror;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrinterError {

    public static String printerError(final String s) {
        return s.chars().filter(c -> c > 'm').count() + "/" + s.length();
    }

    @Test
    public void test() {
        System.out.println("printerError Fixed Tests");
        final String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", PrinterError.printerError(s));
    }
}

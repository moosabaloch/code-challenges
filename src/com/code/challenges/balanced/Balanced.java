package com.code.challenges.balanced;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Balanced {

    static int[] balancedOrNot(final String[] expressions, final int[] maxReplacements) {
        final int[] results = new int[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            results[i] = Balanced.balancedOrNot(expressions[i], maxReplacements[i]);
        }
        return results;
    }

    static int balancedOrNot(final String expression, final int maxReplacements) {
        int replacementsPerformed = 0;
        int balance = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '<') {
                balance--;
            } else if (expression.charAt(i) == '>') {
                balance++;
                if (balance > 0) {
                    if (replacementsPerformed < maxReplacements) {
                        replacementsPerformed++;
                        balance--;
                    } else {
                        return 0;
                    }
                }
            }
        }
        return balance >= 0 && balance <= maxReplacements - replacementsPerformed ? 1 : 0;
    }

    public static void main(final String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        final int[] res;

        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        final String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for (int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (final Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }

        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        final int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for (int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }

        res = Balanced.balancedOrNot(_expressions, _maxReplacements);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }

    @Test
    public void balancedOrNot() {
        assertEquals(Integer.valueOf(1), Integer.valueOf(Balanced.balancedOrNot("<>>>", 2)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(Balanced.balancedOrNot("<<<>", 2)));
        assertEquals(Integer.valueOf(1), Integer.valueOf(Balanced.balancedOrNot("<<<>>>", 0)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(Balanced.balancedOrNot("<>>>>", 2)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(Balanced.balancedOrNot("<>><", 1)));
        assertEquals(Integer.valueOf(1), Integer.valueOf(Balanced.balancedOrNot(">", 1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(Balanced.balancedOrNot("<", 1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(Balanced.balancedOrNot(">><>", 1)));
        assertEquals(Integer.valueOf(0), Integer.valueOf(Balanced.balancedOrNot("><", 0)));
    }
}

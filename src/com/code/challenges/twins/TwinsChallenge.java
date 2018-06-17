package com.code.challenges.twins;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwinsChallenge {

    static boolean[] twins(final String[] a, final String[] b) {
        final boolean[] result = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            final Counter counterA = new Counter(a[i]);
            final Counter counterB = new Counter(b[i]);
            result[i] = counterA.equals(counterB);
        }

        return result;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(final String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);

        final int n = Integer.parseInt(in.nextLine().trim());
        final String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }

        final int m = Integer.parseInt(in.nextLine().trim());
        final String[] b = new String[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }

        // call twins function
        final boolean[] results = TwinsChallenge.twins(a, b);

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i] ? "Yes" : "No");
        }
    }

    private static class Counter {
        private final int[] oddCounter = new int[26];
        private final int[] evenCounter = new int[26];

        Counter(final String value) {
            for (int i = 0; i < value.length(); i++) {
                if (i % 2 == 0) {
                    evenCounter[value.charAt(i) - 'a']++;
                } else {
                    oddCounter[value.charAt(i) - 'a']++;
                }
            }
        }

        @Override
        public boolean equals(final Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Counter) {
                return Arrays.equals(oddCounter, ((Counter) other).oddCounter) && Arrays.equals(evenCounter, ((Counter) other).evenCounter);
            }
            return false;
        }
    }
}

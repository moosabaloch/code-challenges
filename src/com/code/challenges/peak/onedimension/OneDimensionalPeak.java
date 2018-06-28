package com.code.challenges.peak.onedimension;

import org.junit.Test;

public class OneDimensionalPeak {

    public static int naivePeak(final int[] values) {
        if (values == null || values.length == 0) {
            return -1;
        }
        if (values.length == 1) {
            return 0;
        }

        for (int i = 0; i < values.length; i++) {
            if (i == 0 && values[i] > values[i + 1]) {
                return i;
            } else if (i == values.length - 1 && values[i] > values[i - 1]) {
                return i;
            } else if (values[i] > values[i + 1] && values[i] > values[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static int peak(final int[] values) {
        return OneDimensionalPeak.peak(values, 0, values.length - 1);
    }

    private static int peak(final int[] values, final int lowerIndex, final int upperIndex) {
        final int middleIndex = (upperIndex + lowerIndex) / 2;
        if (middleIndex > 0 && middleIndex < values.length - 1) {
            if (values[middleIndex - 1] > values[middleIndex]) {
                return OneDimensionalPeak.peak(values, lowerIndex, middleIndex - 1);
            } else if (values[middleIndex + 1] > values[middleIndex]) {
                return OneDimensionalPeak.peak(values, middleIndex + 1, upperIndex);
            }
        }
        return middleIndex;
    }

    @Test
    public void basicTest() {
        final int[] values = OneDimensionalPeak.createPeak(100000000, 99999999);
        System.out.println(OneDimensionalPeak.measuring(OneDimensionalPeak::naivePeak, values));
        System.out.println(OneDimensionalPeak.measuring(OneDimensionalPeak::peak, values));
    }

    private static int[] createPeak(final int size, final int peakPosition) {
        final int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = size - Math.abs(peakPosition - i);
        }
        return values;
    }

    private static int measuring(final PeakFinderFunction function, final int[] values) {
        final long start = System.currentTimeMillis();
        final int result = function.findPeak(values);
        final long end = System.currentTimeMillis();
        System.out.println("Computation time " + (long) (end - start) + "ms");
        return result;
    }

    @FunctionalInterface
    public interface PeakFinderFunction {
        int findPeak(int[] values);
    }
}

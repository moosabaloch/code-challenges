package com.code.challenges.orderedlogfiles;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderedLogFiles {

    public List<String> reorderLines(final int logFileSize, final List<String> logLines) {
        final LinkedList<LogLine> alphaNumericLogLines = new LinkedList<>();
        final LinkedList<LogLine> numericLogLines = new LinkedList<>();

        for (final String logLineValue : logLines) {
            final LogLine logLine = new LogLine(logLineValue);
            if (logLine.isNumeric()) {
                numericLogLines.add(logLine);
            } else {
                alphaNumericLogLines.add(logLine);
            }
        }

        alphaNumericLogLines.sort(LogLine::compareTo);
        alphaNumericLogLines.addAll(numericLogLines);
        return alphaNumericLogLines.stream().map(LogLine::toString).collect(Collectors.toList());
    }

    private static class LogLine implements Comparable<LogLine> {
        private final String identifier;
        private final String data;
        private static final String WHITESPACE = " ";
        private static final Pattern NUMERIC_PATTERN = Pattern.compile("([0-9]|\\s)*");
        private static final Comparator<LogLine> COMPARATOR = Comparator.comparing(LogLine::getData)
                .thenComparing(LogLine::getIdentifier);

        LogLine(final String logline) {
            identifier = logline.substring(0, logline.indexOf(LogLine.WHITESPACE));
            data = logline.substring(logline.indexOf(LogLine.WHITESPACE) + 1);
        }

        public boolean isNumeric() {
            return LogLine.NUMERIC_PATTERN.matcher(data).matches();
        }

        @Override
        public int compareTo(final LogLine other) {
            return LogLine.COMPARATOR.compare(this, other);
        }

        public String getData() {
            return data;
        }

        public String getIdentifier() {
            return identifier;
        }

        @Override
        public String toString() {
            return identifier + LogLine.WHITESPACE + data;
        }
    }

    @Test
    public void testLogLineConstructor() {
        final LogLine logLine = new LogLine("a1 9 2 3 1");
        assertEquals("a1", logLine.identifier);
        assertEquals("9 2 3 1", logLine.data);
        assertTrue(logLine.isNumeric());
    }

    @Test
    public void testOrdering() {
        final OrderedLogFiles orderedLogFiles = new OrderedLogFiles();
        assertEquals(
                Arrays.asList("g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"),
                orderedLogFiles.reorderLines(5, Arrays.asList("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo")));
    }
}

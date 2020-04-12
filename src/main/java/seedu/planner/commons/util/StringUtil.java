package seedu.planner.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {
    public static final int MAX_COLUMNS = 60;

    /**
     * Returns true if the {@code sentence} contains the {@code word}.
     * Ignores case, but a full word match is required.
     * <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     *
     * @param sentence cannot be null
     * @param word     cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsWordIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
        requireNonNull(word);

        String preppedWord = word.trim();
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Word parameter should be a single word");

        String preppedSentence = sentence;
        String[] wordsInPreppedSentence = preppedSentence.split("\\s+");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns true if {@code s} represents a non-zero unsigned integer
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     *
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroUnsignedInteger(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Returns true if {@code s} represents a non-negative unsigned integer
     * e.g. 0, 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "+0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     *
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonNegativeUnsignedInteger(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            return value >= 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Wraps a comma-separated list of collection elements according to a maximum column count.
     *
     * @param elements   {@link Collection} of elements
     * @param maxColumns Maximum length per line
     * @return Wrapped comma-separated element string
     */
    public static String wrapCollection(Collection elements, int maxColumns) {
        StringBuffer allLines = new StringBuffer();
        StringBuffer currentLine = new StringBuffer();

        int count = 0;
        for (Object element : elements) {
            count++;
            String representation = element.toString() + (count < elements.size() ? ", " : "");
            if (currentLine.length() > 0 && representation.length() + currentLine.length() > maxColumns) {
                allLines.append(currentLine.toString()).append("\n");
                currentLine = new StringBuffer();
            }
            currentLine.append(representation);
        }

        if (currentLine.length() > 0) {
            allLines.append(currentLine.toString());
        }

        return allLines.toString();
    }

    /**
     * Wraps a comma-separated list of collection elements according to the maximum column count given by {@code
     * MAX_COLUMNS}.
     *
     * @param elements {@link Collection} of elements
     * @return Wrapped comma-separated element string
     */
    public static String wrapCollection(Collection elements) {
        return wrapCollection(elements, MAX_COLUMNS);
    }
}

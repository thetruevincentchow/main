package seedu.planner.model.time;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Semester {
    ONE("Semester 1"),
    TWO("Semester 2"),
    SPECIAL_ONE("Special Semester 1"),
    SPECIAL_TWO("Special Semester 2");

    public static final String MESSAGE_CONSTRAINTS = "Semester must be one of the following: "
        + getConcatenatedString();
    private final String fullName;

    Semester(String fullName) {
        this.fullName = fullName;
    }

    private static String getConcatenatedString() {
        return Arrays.stream(Semester.values()).map(Semester::toString)
            .collect(Collectors.joining(", "));
    }
}

package seedu.address.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's name in the application.
 * Guarantees: immutable; is valid as declared in {@link #isValidMajor(String)}
 */
public class Major {

    public static final String MESSAGE_CONSTRAINTS =
            "Majors should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String major;

    /**
     * Constructs a {@code Name}.
     *
     * @param major A valid major.
     */
    public Major(String major) {
        requireNonNull(major);
        checkArgument(isValidMajor(major), MESSAGE_CONSTRAINTS);
        this.major = major;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidMajor(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return major;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Major // instanceof handles nulls
                && major.equals(((Major) other).major)); // state check
    }

    @Override
    public int hashCode() {
        return major.hashCode();
    }

}

package seedu.planner.model.time;

import java.util.Objects;

import seedu.planner.commons.core.index.Index;

public class DegreeYear {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 6;
    public static final String MESSAGE_CONSTRAINTS = String.format(
        "Year must be a non-negative unsigned integer, from %1$s to %2$s, representing your current year of study.",
        MIN_VALUE, MAX_VALUE);

    private int year;

    /**
     * Index can only be created by calling {@link Index#fromZeroBased(int)} or
     * {@link Index#fromOneBased(int)}.
     */
    public DegreeYear(int year) {
        if (year < MIN_VALUE || year > MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }

        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof DegreeYear // instanceof handles nulls
            && year == ((DegreeYear) other).year); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }
}

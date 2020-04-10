package seedu.planner.model.time;

import java.util.Objects;

import seedu.planner.commons.core.index.Index;

public class DegreeYear {
    public static final String MESSAGE_CONSTRAINTS =
        "Year must be a non-negative unsigned integer, from 1 to 6, representing your current year of study.";

    private int year;

    /**
     * Index can only be created by calling {@link Index#fromZeroBased(int)} or
     * {@link Index#fromOneBased(int)}.
     */
    public DegreeYear(int year) {
        if (year < 0) {
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

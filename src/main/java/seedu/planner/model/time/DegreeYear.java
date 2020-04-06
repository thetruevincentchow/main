package seedu.planner.model.time;

import seedu.planner.commons.core.index.Index;

public class DegreeYear {
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
}

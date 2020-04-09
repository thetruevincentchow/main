package seedu.planner.model.student.exceptions;

import java.util.NoSuchElementException;

/**
 * Signals that the TimeTableMap is empty.
 */
public class TimeTableEmptyException extends NoSuchElementException {
    public TimeTableEmptyException() {
        super("The active student has no timetables");
    }
}

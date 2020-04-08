package seedu.planner.model.student.exceptions;

/**
 * Signals that the operation is unable to find the specified TimeTable value given a Semester as the key.
 */
public class SemesterKeyNotFoundException extends RuntimeException {
    public SemesterKeyNotFoundException() {
        super("Semester does not exist in specified TimeTableMap");
    }
}

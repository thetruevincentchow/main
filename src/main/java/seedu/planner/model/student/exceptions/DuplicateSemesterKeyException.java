package seedu.planner.model.student.exceptions;

/**
 * Signals that the operation will result in duplicate Semesters (Semesters are considered duplicates if they have the
 * same identity).
 */
//Semester already exists in timetable list
public class DuplicateSemesterKeyException extends RuntimeException {
    public DuplicateSemesterKeyException() {
        super("Operation would result in duplicate semester keys");
    }
}

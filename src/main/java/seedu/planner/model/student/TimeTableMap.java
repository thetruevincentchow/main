package seedu.planner.model.student;

import java.util.HashMap;

import seedu.planner.model.time.StudentSemester;

/**
 * Stores a key-value mapping of {@link StudentSemester} objects to {@link TimeTable} objects.
 * Represents the timetables of a student associated with a student's semesters.
 */
public class TimeTableMap extends HashMap<StudentSemester, TimeTable> {
}

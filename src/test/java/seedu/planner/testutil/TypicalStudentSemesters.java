package seedu.planner.testutil;

import seedu.planner.model.time.Semester;
import seedu.planner.model.time.SemesterYear;
import seedu.planner.model.time.StudentSemester;

//@@author thetruevincentchow

/**
 * A utility class containing a list of {@code StudentSemester} objects to be used in tests.
 */
public class TypicalStudentSemesters {
    public static final StudentSemester YEAR_1_SEM_ONE = new StudentSemester(new SemesterYear(Semester.ONE), 1);
    public static final StudentSemester YEAR_1_SEM_TWO = new StudentSemester(new SemesterYear(Semester.TWO), 1);
    public static final StudentSemester YEAR_2_SEM_ONE = new StudentSemester(new SemesterYear(Semester.ONE), 2);
    public static final StudentSemester YEAR_6_SEM_ONE = new StudentSemester(new SemesterYear(Semester.ONE), 6);
}
//@@author

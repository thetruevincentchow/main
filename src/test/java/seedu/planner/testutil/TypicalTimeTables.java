package seedu.planner.testutil;

import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_ONE;

import java.util.Optional;

import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.TimeTableMap;

//@@author thetruevincentchow

/**
 * A utility class containing a list of {@code TimeTable} and {@code TimeTableMap} objects to be used in tests.
 */
public class TypicalTimeTables {
    private TypicalTimeTables() {
    } // prevents instantiation

    public static TimeTable getTypicalTimeTable() {
        TimeTable timeTable = new TimeTable();
        timeTable.addEnrollment(new Enrollment(new ModuleCode("CS2040"), Optional.empty(), 4));
        return timeTable;
    }

    public static TimeTableMap getTypicalTimeTableMap() {
        TimeTableMap timeTableMap = new TimeTableMap();
        timeTableMap.put(YEAR_1_SEM_ONE, getTypicalTimeTable());
        return timeTableMap;
    }
}
//@@author

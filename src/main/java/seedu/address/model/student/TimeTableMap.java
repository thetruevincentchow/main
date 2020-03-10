package seedu.address.model.student;

import seedu.address.model.time.Semester;
import seedu.address.model.time.SemesterYear;
import seedu.address.model.time.StudentSemester;

import java.util.HashMap;

public class TimeTableMap extends HashMap<StudentSemester, TimeTable> {
    /**
     * Returns a non-empty (@code TimeTableMap) which (@code Student) can immediately use.
     * @return Non-empty (@code TimeTableMap)
     */
    public static TimeTableMap sampleTimeTableMap() {
        TimeTableMap timeTableMap = new TimeTableMap();
        timeTableMap.put(new StudentSemester(new SemesterYear(Semester.ONE, 2019), 1), TimeTable.sampleTimeTable());
        return timeTableMap;
    }
}

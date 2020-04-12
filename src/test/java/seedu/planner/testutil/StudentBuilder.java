package seedu.planner.testutil;

import java.util.ArrayList;

import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTableMap;

/**
 * A utility class to help with building Student objects.
 * Example usage: <br>
 * {@code Student ab = new StudentBuilder().withModule("CS2103T").build();}
 */
public class StudentBuilder {

    private static final String DEFAULT_NAME = "Alice";
    private static final String DEFAULT_MAJOR = "CS";

    private Name name;
    private Major major;
    private TimeTableMap timeTableMap;

    public StudentBuilder() {
        name = new Name(DEFAULT_NAME);
        major = new Major(DEFAULT_MAJOR);
        timeTableMap = new TimeTableMap();
    }

    /**
     * Copies the name, major and timetable map of the {@code student} provided.
     */
    public StudentBuilder(Student student) {
        this.name = student.getName();
        this.major = student.getMajor();
        this.timeTableMap = student.getTimeTableMap();
    }

    /**
     * Sets the {@code Name} of the {@code Student} that we are building.
     */
    public StudentBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public StudentBuilder withName(String name) {
        return withName(new Name(name));
    }

    /**
     * Sets the {@code Major} of the {@code Student} that we are building.
     */
    public StudentBuilder withMajor(Major major) {
        this.major = major;
        return this;
    }

    public StudentBuilder withMajor(String major) {
        return withMajor(new Major(major));
    }

    /**
     * Sets the {@code TimeTableMap} of the {@code Student} that we are building.
     */
    public StudentBuilder withTimeTableMap(TimeTableMap timeTableMap) {
        this.timeTableMap = timeTableMap;
        return this;
    }

    public Student build() {
        return new Student(name, major, timeTableMap, new ArrayList<>());
    }
}

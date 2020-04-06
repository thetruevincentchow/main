package seedu.planner.testutil;

import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;

/**
 * A utility class to help with building Student objects.
 * Example usage: <br>
 * {@code Student ab = new StudentBuilder().withModule("CS2103T").build();}
 */
public class StudentBuilder {

    private Name name;
    private Major major;

    public StudentBuilder() {
        name = null;
        major = null;
    }

    public StudentBuilder(Student student) {
        this.name = student.getName();
        this.major = student.getMajor();
    }

    public StudentBuilder withName(Name name) {
        this.name = name;
        return this;
    }

    public Student build() {
        return new Student(name, major);
    }
}

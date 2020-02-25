package seedu.address.model.planner;

import seedu.address.model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Planner {

    protected Student student;
    protected List<Student> students;

    public Planner() {
        students = new ArrayList<>();
    }

    public boolean setStudent(Student student) {
        this.student = student;
        return true;
    }

    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public boolean resetData() {
        return true;
    }

    public boolean hasStudent(Student student) {
        return false;
    }
}

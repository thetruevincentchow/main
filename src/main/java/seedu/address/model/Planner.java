package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.student.Student;
import seedu.address.model.student.UniqueStudentList;

/**
 * Wraps all data at the planner level
 * Duplicates are not allowed (by .isSameStudent comparison)
 */
public class Planner implements ReadOnlyPlanner {

    protected Student student;
    protected UniqueStudentList students;

    /**
     * Creates an Planner using the UniqueStudentList in the {@code toBeCopied}
     */
    public Planner() {
        students = new UniqueStudentList();
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

    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }
}

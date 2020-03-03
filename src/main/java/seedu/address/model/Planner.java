package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.module.Module;
import seedu.address.model.module.UniqueModuleList;
import seedu.address.model.student.Major;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.UniqueStudentList;

/**
 * Wraps all data at the planner level
 * Duplicates are not allowed (by .isSameStudent comparison)
 */
public class Planner implements ReadOnlyPlanner {

    protected Student student;
    protected UniqueStudentList students;
    protected UniqueModuleList modules;

    /**
     * Creates an Planner using the UniqueStudentList in the {@code toBeCopied}
     */
    public Planner() {
        student = new Student(new Name("Placeholder Name"), new Major("Placeholder Major"));
        students = new UniqueStudentList();
        modules = new UniqueModuleList();
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

    public boolean hasModule(Module module) {
        // TODO
        return false;
    }


    public boolean addModule(Module module) {
        // TODO
        return true;
    }

    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }
    public ObservableList<Module> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }
}

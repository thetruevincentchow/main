package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.module.Module;
import seedu.address.model.module.UniqueModuleList;
import seedu.address.model.student.*;

/**
 * Wraps all data at the planner level
 * Duplicates are not allowed (by .isSameStudent comparison)
 */
public class Planner implements ReadOnlyPlanner {

    protected Student activeStudent;
    protected UniqueStudentList students; //TOOD: use list of students in storage
    protected UniqueModuleList modules;

    /**
     * Creates an Planner using the UniqueStudentList in the {@code toBeCopied}
     */
    public Planner() {
        //TODO: serialize `activeStudent` in `JsonSerializablePlanner`
        activeStudent = null; //new Student(new Name("Placeholder Name"), new Degrees(), new Major("Placeholder Major"));

        students = new UniqueStudentList();
        //students.add(activeStudent);
        modules = new UniqueModuleList();
    }


    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public boolean resetData(Planner planner) {
        activeStudent = planner.activeStudent;
        students = planner.students;
        modules = planner.modules;
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

    public Student getActiveStudent() {
        if (activeStudent == null) {
            //TODO: handle `activeStudents` being null (e.g. if data file is missing)
            activeStudent = students.iterator().next();
        }
        return activeStudent;
    }

    public void setActiveStudent(Student editedStudent) {
        //TODO: mutate `students`
        if (activeStudent != null) {
            students.setStudent(activeStudent, editedStudent);
        }
        activeStudent = editedStudent;
    }
}

package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.UniqueModuleCodeList;
import seedu.address.model.module.UniqueModuleList;
import seedu.address.model.student.*;

/**
 * Wraps all data at the planner level
 * Duplicates are not allowed (by .isSameStudent comparison)
 */
public class Planner implements ReadOnlyPlanner {

    /**
     * The current student that the user can immediately modify.
     * `activeStudent` must be an element of `students`, i.e. `students.contains(activeStudent)` is `true`
     */
    protected Student activeStudent;

    /**
     * The list of students created by the user.
     */
    protected UniqueStudentList students; //TOOD: use list of students in storage

    /**
     * The list of available modules in NUS.
     */
    protected UniqueModuleList modules;

    //TODO: move to `Student` or `User`
    //TODO: replace `UniqueModuleCodeList` with `TimeTable` (once loading available module list is implemented)
    protected UniqueModuleCodeList enrolledModules;

    /**
     * Creates an Planner using the UniqueStudentList in the {@code toBeCopied}.
     */
    public Planner() {
        activeStudent = null; //new Student(new Name("Placeholder Name"), new Degrees(), new Major("Placeholder Major"));

        students = new UniqueStudentList();
        //students.add(activeStudent);
        modules = new UniqueModuleList();
        enrolledModules = new UniqueModuleCodeList();
    }


    public boolean addStudent(Student student) {
        students.add(student);
        return true;
    }

    public boolean resetData(Planner planner) {
        activeStudent = planner.activeStudent;
        students = planner.students;
        modules = planner.modules;
        enrolledModules = planner.enrolledModules;
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

    //TODO: replace with `TimeTable` and `Enrollment`
    public boolean hasEnrollment(ModuleCode moduleCode) {
        return enrolledModules.contains(moduleCode);
    }

    public boolean addEnrollment(ModuleCode moduleCode) {
        enrolledModules.add(moduleCode);
        return true;
    }

    public boolean removeEnrollment(ModuleCode moduleCode) {
        enrolledModules.remove(moduleCode);
        return true;
    }

    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }

    public ObservableList<Module> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }

    public ObservableList<ModuleCode> getEnrolledModulesList() {
        return enrolledModules.asUnmodifiableObservableList();
    }

    public Student getActiveStudent() {
        if (activeStudent == null) {
            //TODO: handle `activeStudents` being null (e.g. if data file is missing)
            //TODO: handle all students being removed
            activeStudent = students.iterator().next();
        }
        return activeStudent;
    }

    /**
     * Replaces the currently active student with the student given by (@code editedStudent).
     * @params editedStudent Student to copy for replacement
     */
    public void setActiveStudent(Student editedStudent) {
        if (activeStudent != null) {
            students.setStudent(activeStudent, editedStudent);
        }
        activeStudent = editedStudent;
    }

    public void activateStudent(Student student) {
        if (!students.contains(student)) {
            throw new IllegalArgumentException("Student does not exist in student list");
        }
        activeStudent = student;
    }

    public void removeStudent(Student toRemove) {
        //TODO: handle all students being removed
        if (toRemove == activeStudent) {
            activeStudent = null;
        }
        students.remove(toRemove);
    }
}

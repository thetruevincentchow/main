package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.ModuleDataImporter;
import seedu.address.model.module.UniqueModuleCodeList;
import seedu.address.model.module.UniqueModuleList;
import seedu.address.model.student.*;
import seedu.address.model.time.SemesterYear;
import seedu.address.model.time.StudentSemester;

import java.util.List;
import java.util.Map;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

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

    protected StudentSemester activeSemester;

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
        loadModules();
    }


    private void loadModules() {
        List<Module> modulesToImport = ModuleDataImporter.run();
        if (modulesToImport == null) {

        } else {
            modulesToImport.forEach(x -> modules.add(x));
        }
    }

    public UniqueModuleList getModules() {
        return modules;
    }

    /**
     * Returns a valid planner state.
     * @return Sample planner
     */
    public static Planner samplePlanner() {
        Planner planner = new Planner();
        Student student = new Student(new Name("Placeholder name"), new Major("Placeholder major"), TimeTableMap.sampleTimeTableMap());
        planner.students.add(student);
        planner.activeStudent = student;
        return planner;
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

    public void activateValidStudent() {
        //TODO: handle `activeStudents` being null (e.g. if data file is missing)
        //TODO: handle all students being removed
        activeStudent = students.iterator().next();

    }

    public Student getActiveStudent() {
        if (activeStudent == null) {
            activateValidStudent();
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

        activateValidStudent();
    }

    public TimeTable getTimeTable() {
        requireAllNonNull(activeStudent);
        if (activeSemester == null) {
            activateValidSemester();
        }
        return activeStudent.getTimeTable(activeSemester);
    }

    private void activateValidSemester() {
        if (activeStudent == null) {
            throw new IllegalArgumentException("No active student selected");
        }
        requireAllNonNull(activeStudent);

        //TODO: handle `activeStudents` being null (e.g. if data file is missing)
        //TODO: handle all students being removed
        activeSemester = activeStudent.getTimeTableMap().keySet().iterator().next();
    }

    public void setActiveTimeTable(TimeTable timeTable) {
        requireAllNonNull(activeStudent);
        activeStudent.setTimeTable(activeSemester, timeTable);
    }

    public void removeTimeTable(StudentSemester keyToRemove) {
        requireAllNonNull(keyToRemove);
        activeStudent.removeTimeTable(keyToRemove);
        keyToRemove = null;
    }

    public void activateSemester(StudentSemester semester) {
        if (!activeStudent.getTimeTableMap().containsKey(semester)) {
            throw new IllegalArgumentException("Semester does not exist in timetable list");
        }
        activeSemester = semester;
    }
}

package seedu.address.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.module.Module;
import seedu.address.model.module.*;
import seedu.address.model.student.*;
import seedu.address.model.time.StudentSemester;

import java.util.List;

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
    protected static UniqueModuleList modules = new UniqueModuleList();

    /**
     * Creates an Planner using the UniqueStudentList in the {@code toBeCopied}.
     */
    public Planner() {
        activeStudent = null; //new Student(new Name("Placeholder Name"), new Degrees(), new Major("Placeholder Major"));
        students = new UniqueStudentList();
        loadModules();
    }


    private void loadModules() {
        if (modules.isEmpty()) {
            System.out.println("Loading modules. This might take awhile...");
            List<Module> modulesToImport = ModuleDataImporter.run();
            System.out.println("Done!");
            if (modulesToImport != null) {
                modulesToImport.forEach(x -> modules.add(x));
            }
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
        Student student = new Student(new Name("Mark Suckerberg"), new Major("CS"), TimeTableMap.sampleTimeTableMap());
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

    //TODO: Replace `ModuleCode` with`Enrollment`.
    //      Currently we can query with `ModuleCode` and add `Enrollment`.
    public boolean hasEnrollment(ModuleCode moduleCode) {
        TimeTable timeTable = getActiveTimeTable();
        return timeTable.hasModuleCode(moduleCode);
        //return enrolledModules.contains(moduleCode);
    }

    public boolean addEnrollment(Enrollment enrollment) {
        getActiveTimeTable().addEnrollment(enrollment);
        return true;
    }

    public boolean removeEnrollment(ModuleCode moduleCode) {
        getActiveTimeTable().removeModuleCode(moduleCode);
        return true;
    }

    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }

    public ObservableList<Module> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }

    public ObservableList<ModuleCode> getActiveModuleCodes() {
        ObservableList<ModuleCode> moduleCodes = FXCollections.observableArrayList();
        moduleCodes.addAll(getActiveTimeTable().getModuleCodes());
        return moduleCodes;
    }

    public ObservableList<ModuleCode> getAllEnrolledModuleCodes() {
        return activeStudent.getAllEnrolledModules();
    }

    public void activateValidStudent() {
        //TODO: handle `activeStudents` being null (e.g. if data file is missing)
        //TODO: handle all students being removed
        activeStudent = students.iterator().next();
        activeSemester = null; //TODO: possibly validate existing value first
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
        // TODO: ensure that `activeStudent` is not null
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
        activeSemester = null; //TODO: validate existing value first
    }

    public void removeStudent(Student toRemove) {
        //TODO: handle all students being removed
        if (toRemove == activeStudent) {
            activeStudent = null;
            activeSemester = null; //TODO: validate existing value first
        }
        students.remove(toRemove);

        activateValidStudent();
    }

    public TimeTable getActiveTimeTable() {
        requireAllNonNull(activeStudent);

        if (activeSemester == null && !activeStudent.getTimeTableMap().isEmpty()) {
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
        if (activeStudent.getTimeTableMap().isEmpty()) {
            throw new IllegalArgumentException("Active student has no timetables");
        }
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

    public boolean hasSemester(StudentSemester semester) {
        if (activeStudent == null) {
            throw new IllegalArgumentException("No active student selected");
        }
        return activeStudent.getTimeTableMap().containsKey(semester);
    }

    public void activateSemester(StudentSemester semester) {
        if (!activeStudent.getTimeTableMap().containsKey(semester)) {
            throw new IllegalArgumentException("Semester does not exist in timetable list");
        }
        activeSemester = semester;
    }

    public void addSemesterTimeTable(StudentSemester studentSemester) {
        if (activeStudent == null) {
            throw new IllegalArgumentException("No active student selected");
        }
        if (hasSemester(studentSemester)) {
            throw new IllegalArgumentException("Semester already exists in timetable list");
        }

        activeStudent.setTimeTable(studentSemester, new TimeTable());
    }

    public void removeSemesterTimeTable(StudentSemester studentSemester) {
        if (activeStudent == null) {
            throw new IllegalArgumentException("No active student selected");
        }
        if (!hasSemester(studentSemester)) {
            throw new IllegalArgumentException("Semester does not exists in timetable list");
        }

        activeStudent.removeTimeTable(studentSemester);
    }
}

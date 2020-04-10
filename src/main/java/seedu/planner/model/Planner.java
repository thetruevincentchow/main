package seedu.planner.model;

import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.module.Lesson;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.module.ModuleDataImporter;
import seedu.planner.model.module.UniqueModuleList;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.UniqueStudentList;
import seedu.planner.model.student.exceptions.DuplicateSemesterKeyException;
import seedu.planner.model.student.exceptions.NoActiveStudentException;
import seedu.planner.model.student.exceptions.SemesterKeyNotFoundException;
import seedu.planner.model.student.exceptions.StudentNotFoundException;
import seedu.planner.model.student.exceptions.TimeTableEmptyException;
import seedu.planner.model.time.StudentSemester;

/**
 * Wraps all data at the planner level
 * Duplicates are not allowed (by Student#isSameStudent comparison)
 */
public class Planner implements ReadOnlyPlanner {

    /**
     * The list of available modules in NUS.
     */
    protected static UniqueModuleList modules = new UniqueModuleList();
    /**
     * The current student that the user can immediately modify.
     * `activeStudent` must be an element of `students`, i.e. `students.contains(activeStudent)` is `true`
     */
    protected int activeStudentIndex = -1;
    protected StudentSemester activeSemester;
    /**
     * The list of students created by the user.
     */
    protected UniqueStudentList students;


    public Planner(boolean loadModules) {
        students = new UniqueStudentList();
        if (loadModules) {
            loadModules();
        }
    }

    /**
     * Creates an Planner using an empty {@code UniqueStudentList}
     */
    public Planner() {
        students = new UniqueStudentList();
        loadModules();
    }

    /**
     * Creates an Planner from an existing {@code ReadOnlyPlanner}
     */
    public Planner(ReadOnlyPlanner planner) {
        this();
        resetData(planner);
    }

    /**
     * Loads list of {@code Module} using {@code ModuleDataImporter}
     */
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

    /**
     * Returns the {@code UniqueModuleList}
     *
     * @return The {@code UniqueModuleList}
     */
    public UniqueModuleList getModules() {
        return modules;
    }

    /**
     * Adds a {@code Student} to the {@code Planner}
     *
     * @param student {@code Student} to added to the {@code Planner}
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Sets the list of {@code Student} to be set for the {@code Planner}
     *
     * @param students list of {@code Student} to be set for the {@code Planner}
     */
    public void setStudents(List<Student> students) {
        this.students.setStudents(students);
    }

    /**
     * Sets or Resets the current active {@code Student}
     *
     * @param target Index to be set as the active {@code Student}
     */
    public void resetActiveStudent(Student target) {
        if (target == null) {
            activeStudentIndex = -1;
        } else {
            activeStudentIndex = getStudentIndex(target);
        }
    }

    /**
     * Resets the current data in the {@code Planner} to a given {@code ReadOnlyPlanner}
     *
     * @param planner {@code ReadOnlyPlanner} to have data reset to
     */
    public void resetData(ReadOnlyPlanner planner) {
        setStudents(planner.getStudentList());
        resetActiveStudent(planner.getActiveStudent());
        activeSemester = planner.getActiveSemester();
    }

    /**
     * Returns if the {@code Planner} contains a given {@code Student}
     *
     * @param student {@code Student} to be checked if exists in {@code Planner}
     * @return boolean | True if {@code Student} exists in {@code Planner}, False if {@code Student} does not exists in
     * {@code Planner}
     */
    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    /**
     * Returns if the {@code Planner} contains a given {@code Module}
     *
     * @param module {@code Module} to be checked if exists in {@code Planner}
     * @return boolean | True if {@code Module} exists in {@code Planner}, False if {@code Module} does not exists in
     * {@code Planner}
     */
    public boolean hasModule(Module module) {
        return modules.contains(module);
    }

    /**
     * Adds a {@code Module} to the {@code Planner}
     *
     * @param module {@code Module} to added to the {@code Planner}
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    // TODO: Replace `ModuleCode` with`Enrollment` Currently we can query with `ModuleCode` and add `Enrollment`.
    public boolean hasEnrollment(ModuleCode moduleCode) {
        TimeTable timeTable = getActiveTimeTable();
        return timeTable.hasModuleCode(moduleCode);
    }

    public Enrollment getEnrollment(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        TimeTable timeTable = getActiveTimeTable();
        return timeTable.getEnrollment(moduleCode);
    }

    public Optional<Grade> getModuleGrade(ModuleCode moduleCode) {
        Enrollment enrollment = getEnrollment(moduleCode);
        return enrollment.getGrade();
    }

    public void setModuleGrade(ModuleCode moduleCode, Grade grade) {
        Enrollment enrollment = getEnrollment(moduleCode);
        enrollment.setGrade(Optional.of(grade));
    }

    public void addEnrollment(Enrollment enrollment) {
        getActiveTimeTable().addEnrollment(enrollment);
    }

    public void removeEnrollment(ModuleCode moduleCode) {
        getActiveTimeTable().removeModuleCode(moduleCode);
    }

    /**
     * Gets an {@code ObservableList} of {@code Student} in the {@code Planner}
     *
     * @return an {@code ObservableList} of {@code Student} in the {@code Planner}
     */
    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner}
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner}
     */
    public ObservableList<Module> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in
     */
    public ObservableList<ModuleCode> getEnrolledModulesList() {
        return getActiveStudent().getAllEnrolledModules();
    }

    /**
     * Gets the current active {@code StudentSemester}
     *
     * @return The current active {@code StudentSemester}
     */
    @Override
    public StudentSemester getActiveSemester() {
        return activeSemester;
    }

    /**
     * Gets the current active student index
     *
     * @return The current active student index
     */
    @Override
    public int getActiveStudentIndex() {
        return activeStudentIndex;
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} is
     * exempted from
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * exempted from
     */
    @Override
    public ObservableList<ModuleCode> getExemptedModulesList() {
        return getActiveStudent().getExemptedModules();
    }

    @Override
    public boolean hasActiveTimeTable() {
        return isValidActiveStudentIndex() && getActiveTimeTable() != null;
    }

    @Override
    public boolean hasActiveStudent() {
        return isValidActiveStudentIndex();
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in for the active {@code TimeTable}
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in for the active {@code TimeTable}
     */
    public ObservableList<ModuleCode> getActiveModuleCodes() {
        ObservableList<ModuleCode> moduleCodes = FXCollections.observableArrayList();
        moduleCodes.addAll(getActiveTimeTable().getModuleCodes());
        return moduleCodes;
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in
     */
    public ObservableList<ModuleCode> getAllEnrolledModuleCodes() {
        return getActiveStudent().getAllEnrolledModules();
    }

    public void activateValidStudent() {
        activeStudentIndex = -1;
        if (!students.isEmpty()) {
            activeStudentIndex = 0;
        }
    }

    public Student getEqualStudent(Student student) {
        return students.getEqualStudent(student);
    }

    private int getStudentIndex(Student student) {
        return students.indexOf(student);
    }

    private boolean isValidStudentIndex(int index) {
        return 0 <= index && index < students.size();
    }

    private boolean isValidActiveStudentIndex() {
        return isValidStudentIndex(activeStudentIndex);
    }

    public Student getActiveStudent() {
        if (!isValidActiveStudentIndex()) {
            return null;
        } else {
            return students.get(activeStudentIndex);
        }
    }

    /**
     * Replaces the currently active student with the student given by {@code editedStudent}.
     *
     * @param student Student to copy for replacement.
     */
    public void replaceActiveStudent(Student student) {
        requireAllNonNull(student, getActiveStudent());
        students.setStudent(getActiveStudent(), student);
    }

    /**
     * Activates the given {@code student}. Any active semester will be deactivated.
     * If {@code student} is {@code null}, then the active student (if any) will be deactivated.
     * Only one {@link Student} may be active at a time.
     * @param student Student to activate
     */
    public void activateStudent(Student student) {
        if (student == null) {
            activeStudentIndex = -1;
            activeSemester = null;
            return;
        }

        if (!students.contains(student)) {
            throw new StudentNotFoundException();
        }
        activeStudentIndex = students.indexOf(student);
        activeSemester = null;
    }

    public void removeStudent(Student toRemove) {
        Student activeStudent = getActiveStudent();
        if (toRemove.equals(activeStudent)) {
            students.remove(toRemove);
            activeStudentIndex = -1;
            activeSemester = null;
        } else {
            students.remove(toRemove);
            activeStudentIndex = getStudentIndex(activeStudent);
        }
    }

    public void requireActiveStudentNonNull() {
        if (getActiveStudent() == null) {
            throw new NoActiveStudentException();
        }
    }

    public TimeTable getActiveTimeTable() {
        requireAllNonNull(getActiveStudent());

        if (activeSemester == null && !getActiveStudent().getTimeTableMap().isEmpty()) {
            activateValidSemester();
        }

        return getActiveStudent().getTimeTable(activeSemester);
    }

    public void setActiveTimeTable(TimeTable timeTable) {
        requireAllNonNull(getActiveStudent());
        getActiveStudent().setTimeTable(activeSemester, timeTable);
    }

    private void activateValidSemester() {
        requireActiveStudentNonNull();
        requireAllNonNull(activeStudentIndex);

        if (getActiveStudent().getTimeTableMap().isEmpty()) {
            throw new TimeTableEmptyException();
        }
        activeSemester = getActiveStudent().getTimeTableMap().keySet().iterator().next();
    }

    public boolean hasSemester(StudentSemester semester) {
        requireActiveStudentNonNull();
        return getActiveStudent().getTimeTableMap().containsKey(semester);
    }

    public void activateSemester(StudentSemester semester) {
        requireActiveStudentNonNull();
        if (!getActiveStudent().getTimeTableMap().containsKey(semester)) {
            throw new SemesterKeyNotFoundException();
        }
        activeSemester = semester;
    }

    public void addSemesterTimeTable(StudentSemester studentSemester) {
        requireActiveStudentNonNull();
        if (hasSemester(studentSemester)) {
            throw new DuplicateSemesterKeyException();
        }

        getActiveStudent().setTimeTable(studentSemester, new TimeTable());
    }

    public void removeSemesterTimeTable(StudentSemester studentSemester) {
        requireActiveStudentNonNull();
        if (!hasSemester(studentSemester)) {
            throw new SemesterKeyNotFoundException();
        }

        getActiveStudent().removeTimeTable(studentSemester);
    }

    public void addExemptedModule(ModuleCode moduleCode) {
        requireActiveStudentNonNull();
        getActiveStudent().addExemptedModule(moduleCode);
    }

    public void removeExemptedModule(ModuleCode moduleCode) {
        requireActiveStudentNonNull();
        getActiveStudent().removeExemptedModule(moduleCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Planner planner = (Planner) o;
        return activeStudentIndex == planner.activeStudentIndex
                && Objects.equals(activeSemester, planner.activeSemester)
                && students.equals(planner.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activeStudentIndex, activeSemester, students);
    }

    public boolean hasExemptedModule(ModuleCode moduleCode) {
        requireActiveStudentNonNull();
        return getExemptedModulesList().contains(moduleCode);
    }

    public void addLesson(Lesson lesson) {
        requireActiveStudentNonNull();
        getActiveStudent().addLessons(lesson);
    }

    public List<Lesson> getLessons() {
        requireActiveStudentNonNull();
        return getActiveStudent().getLesson();
    }

    public boolean hasLesson(Lesson lesson) {
        requireActiveStudentNonNull();
        return getActiveStudent().getLesson().contains(lesson);

    }
}

package seedu.planner.model;

import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.commons.util.ModuleDataImporterUtil;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.module.Lesson;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
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
 * Wraps all data at the planner level.
 * Duplicates are not allowed (by Student#isSameStudent comparison).
 */
public class Planner implements ReadOnlyPlanner {

    /**
     * The list of available modules in NUS.
     */
    protected static UniqueModuleList modules = new UniqueModuleList();
    /**
     * The current student that the user can immediately modify.
     * `activeStudent` must be an element of `students`, i.e. `students.contains(activeStudent)` is `true`.
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
     * Creates an Planner using an empty {@code UniqueStudentList}.
     */
    public Planner() {
        students = new UniqueStudentList();
        loadModules();
    }

    /**
     * Creates an Planner from an existing {@code ReadOnlyPlanner}.
     */
    public Planner(ReadOnlyPlanner planner) {
        this();
        resetData(planner);
    }

    /**
     * Loads list of {@code Module} using {@code ModuleDataImporter}.
     */
    private void loadModules() {
        if (modules.isEmpty()) {
            System.out.println("Loading modules. This might take awhile...");
            List<Module> modulesToImport = ModuleDataImporterUtil.run();
            System.out.println("Done!");
            if (modulesToImport != null) {
                modulesToImport.forEach(x -> modules.add(x));
            }
        }
    }

    /**
     * Returns the {@code UniqueModuleList}.
     *
     * @return The {@code UniqueModuleList}.
     */
    public UniqueModuleList getModules() {
        return modules;
    }

    /**
     * Adds a {@code Student} to the {@code Planner}.
     *
     * @param student {@code Student} to added to the {@code Planner}.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Sets the list of {@code Student} to be set for the {@code Planner}.
     *
     * @param students list of {@code Student} to be set for the {@code Planner}.
     */
    public void setStudents(List<Student> students) {
        this.students.setStudents(students);
    }

    /**
     * Sets or Resets the current active {@code Student}.
     *
     * @param target Index to be set as the active {@code Student}.
     */
    public void resetActiveStudent(Student target) {
        if (target == null) {
            activeStudentIndex = -1;
        } else {
            activeStudentIndex = getStudentIndex(target);
        }
    }

    /**
     * Resets the current data in the {@code Planner} to a given {@code ReadOnlyPlanner}.
     *
     * @param planner {@code ReadOnlyPlanner} to have data reset to.
     */
    public void resetData(ReadOnlyPlanner planner) {
        setStudents(planner.getStudentList());
        resetActiveStudent(planner.getActiveStudent());
        activeSemester = planner.getActiveSemester();
    }

    /**
     * Returns if the {@code Planner} contains a given {@code Student}.
     *
     * @param student {@code Student} to be checked if exists in {@code Planner}.
     * @return boolean | True if {@code Student} exists in {@code Planner}, False if {@code Student} does not exists in
     * {@code Planner}.
     */
    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    /**
     * Returns if the {@code Planner} contains a given {@code Module}.
     *
     * @param module {@code Module} to be checked if exists in {@code Planner}.
     * @return boolean | True if {@code Module} exists in {@code Planner}, False if {@code Module} does not exists in
     * {@code Planner}.
     */
    public boolean hasModule(Module module) {
        return modules.contains(module);
    }

    /**
     * Adds a {@code Module} to the {@code Planner}.
     *
     * @param module {@code Module} to added to the {@code Planner}.
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    /**
     * Returns if the active timetable has an enrollment with the given {@code moduleCode}.
     *
     * @param moduleCode Module code to match.
     * @return {@code true} if the active timetable has an enrollment with the given {@code moduleCode}.
     */
    public boolean hasEnrollment(ModuleCode moduleCode) {
        TimeTable timeTable = getActiveTimeTable();
        return timeTable.hasModuleCode(moduleCode);
    }

    /**
     * Returns the enrollment in the active timetable corresponding to the given {@code moduleCode}.
     *
     * @param moduleCode Module code to match an enrollment.
     * @return {@link Enrollment} corresponding to {@code moduleCode}.
     */
    public Enrollment getEnrollment(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        TimeTable timeTable = getActiveTimeTable();
        return timeTable.getEnrollment(moduleCode);
    }

    /**
     * Returns the grade of the enrollment in the active timetable corresponding to the given {@code moduleCode}.
     *
     * @param moduleCode Module code to match.
     * @return {@link Optional&lt;Grade&gt;} of the enrollment corresponding to {@code moduleCode}.
     */
    public Optional<Grade> getModuleGrade(ModuleCode moduleCode) {
        Enrollment enrollment = getEnrollment(moduleCode);
        return enrollment.getGrade();
    }

    /**
     * Sets the {@code grade} of the enrollment in the active timetable corresponding to the given {@code moduleCode}.
     *
     * @param moduleCode Module code to match.
     * @param grade      Grade to set.
     */
    public void setModuleGrade(ModuleCode moduleCode, Grade grade) {
        Enrollment enrollment = getEnrollment(moduleCode);
        enrollment.setGrade(Optional.of(grade));
    }

    /**
     * Resets the grade of the enrollment in the active timetable corresponding to the given {@code moduleCode}.
     *
     * @param moduleCode Module code to match.
     */
    public void resetModuleGrade(ModuleCode moduleCode) {
        Enrollment enrollment = getEnrollment(moduleCode);
        enrollment.setGrade(Optional.empty());
    }

    /**
     * Adds the {@code enrollment} to the active timetable.
     * The {@code enrollment} cannot have the same module code as any enrollment in the active timetable.
     *
     * @param enrollment Module code to match.
     */
    public void addEnrollment(Enrollment enrollment) {
        getActiveTimeTable().addEnrollment(enrollment);
    }

    /**
     * Removes the enrollment in the active timetable corresponding to the given {@code moduleCode}.
     *
     * @param moduleCode Module code to match.
     */
    public void removeEnrollment(ModuleCode moduleCode) {
        getActiveTimeTable().removeModuleCode(moduleCode);
    }

    /**
     * Gets an {@code ObservableList} of {@code Student} in the {@code Planner}.
     *
     * @return an {@code ObservableList} of {@code Student} in the {@code Planner}.
     */
    public ObservableList<Student> getStudentList() {
        return students.asUnmodifiableObservableList();
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner}.
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner}.
     */
    public ObservableList<Module> getModuleList() {
        return modules.asUnmodifiableObservableList();
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in.
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in.
     */
    public ObservableList<ModuleCode> getEnrolledModulesList() {
        return getActiveStudent().getAllEnrolledModules();
    }

    /**
     * Gets the current active {@code StudentSemester}.
     *
     * @return The current active {@code StudentSemester}.
     */
    @Override
    public StudentSemester getActiveSemester() {
        return activeSemester;
    }

    /**
     * Gets the current active student index.
     *
     * @return The current active student index.
     */
    @Override
    public int getActiveStudentIndex() {
        return activeStudentIndex;
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} is
     * exempted from.
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * exempted from.
     */
    @Override
    public ObservableList<ModuleCode> getExemptedModulesList() {
        return getActiveStudent().getExemptedModules();
    }

    /**
     * Returns whether a timetable is selected.
     *
     * @return {@code true} if a timetable is selected.
     */
    @Override
    public boolean hasActiveTimeTable() {
        return isValidActiveStudentIndex() && getActiveTimeTable() != null;
    }

    /**
     * Returns whether a student is selected.
     *
     * @return {@code true} if a student is selected.
     */
    @Override
    public boolean hasActiveStudent() {
        return isValidActiveStudentIndex();
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in for the active {@code TimeTable}.
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in for the active {@code TimeTable}.
     */
    public ObservableList<ModuleCode> getActiveModuleCodes() {
        ObservableList<ModuleCode> moduleCodes = FXCollections.observableArrayList();
        moduleCodes.addAll(getActiveTimeTable().getModuleCodes());
        return moduleCodes;
    }

    /**
     * Gets an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in.
     *
     * @return an {@code ObservableList} of {@code Module} in the {@code Planner} which the active {@code Student} has
     * enrolled in.
     */
    public ObservableList<ModuleCode> getAllEnrolledModuleCodes() {
        return getActiveStudent().getAllEnrolledModules();
    }

    /**
     * Firstly, deselects the active timetable, if any.
     * Then if the student list is non-empty, select any valid student.
     */
    public void activateValidStudent() {
        activeStudentIndex = -1;
        activeSemester = null;
        if (!students.isEmpty()) {
            activeStudentIndex = 0;
        }
    }

    /**
     * Returns the {@link Student} in the students list which matches the given {@code student}
     * under {@code Student#equals()} equality.
     *
     * @return {@link Student} equal to {@code student}.
     */
    public Student getEqualStudent(Student student) {
        return students.getEqualStudent(student);
    }

    /**
     * Returns the index of the {@link Student} in the students list which matches the given {@code student}
     * under {@code Student#equals()} equality.
     *
     * @return index of {@link Student} if present, -1 otherwise.
     */
    private int getStudentIndex(Student student) {
        return students.indexOf(student);
    }

    /**
     * Returns whether the given student {@code index} is in the bounds of the student list.
     *
     * @return {@code true} if {@code index} refers to a valid student.
     */
    private boolean isValidStudentIndex(int index) {
        return 0 <= index && index < students.size();
    }

    /**
     * Returns whether the index of the active student is valid.
     *
     * @return {@code true} if the index of the active student is valid.
     */
    private boolean isValidActiveStudentIndex() {
        return isValidStudentIndex(activeStudentIndex);
    }

    /**
     * Returns the active {@link Student} if present, {@code null} otherwise.
     *
     * @return Active {@link Student} if present, {@code null} otherwise.
     */
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
     *
     * @param student Student to activate.
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

    /**
     * Remove {@code toRemove} from the student list. The student to be removed is matched with {@code Student#equals
     * ()}.
     * If the {@link Student} to be removed is the active student, deselect the active student and active timetable.
     *
     * @param toRemove Student to remove.
     */
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

    /**
     * Asserts that the a student in the student list is selected.
     */
    public void requireActiveStudentNonNull() {
        if (getActiveStudent() == null) {
            throw new NoActiveStudentException();
        }
    }

    /**
     * Returns the active timetable.
     *
     * @return Active timetable.
     */
    public TimeTable getActiveTimeTable() {
        requireAllNonNull(getActiveStudent());

        return getActiveStudent().getTimeTable(activeSemester);
    }

    /**
     * Replace the active timetable of the active student with the given {@code timeTable}.
     * The original active timetable is lost.
     *
     * @param timeTable Active timetable to use as replacement.
     */
    public void replaceActiveTimeTable(TimeTable timeTable) {
        requireAllNonNull(getActiveStudent());
        getActiveStudent().replaceTimeTable(activeSemester, timeTable);
    }

    /**
     * Activate any valid timetable of the active student.
     * There is no guarantee of the timetable that is selected.
     */
    private void activateValidSemester() {
        requireActiveStudentNonNull();
        requireAllNonNull(getActiveStudent());

        if (getActiveStudent().getTimeTableMap().isEmpty()) {
            throw new TimeTableEmptyException();
        }
        activeSemester = getActiveStudent().getTimeTableMap().keySet().iterator().next();
    }

    /**
     * Returns if the active student has a timetable corresponding to the given {@code semester}.
     *
     * @return {@code true} if the active student has a timetable corresponding to the given {@code semester}.
     */
    public boolean hasSemester(StudentSemester semester) {
        requireActiveStudentNonNull();
        return getActiveStudent().getTimeTableMap().containsKey(semester);
    }

    /**
     * Activate the timetable of the active student corresponding to the given {@code semester}.
     *
     * @param semester {@link StudentSemester} to add timetable.
     */
    public void activateSemester(StudentSemester semester) {
        requireActiveStudentNonNull();
        if (!getActiveStudent().getTimeTableMap().containsKey(semester)) {
            throw new SemesterKeyNotFoundException();
        }
        activeSemester = semester;
    }

    /**
     * Adds an empty timetable to the active student in the specified {@code studentSemester}.
     *
     * @param studentSemester {@link StudentSemester} of {@code TimeTable} to add.
     */
    public void addSemesterTimeTable(StudentSemester studentSemester) {
        requireActiveStudentNonNull();
        if (hasSemester(studentSemester)) {
            throw new DuplicateSemesterKeyException();
        }

        getActiveStudent().replaceTimeTable(studentSemester, new TimeTable());
    }

    /**
     * Remove the timetable of the specified {@code studentSemester} from the active student.
     *
     * @param studentSemester {@link StudentSemester} of {@code TimeTable} to remove.
     */
    public void removeSemesterTimeTable(StudentSemester studentSemester) {
        requireActiveStudentNonNull();
        if (!hasSemester(studentSemester)) {
            throw new SemesterKeyNotFoundException();
        }

        getActiveStudent().removeTimeTable(studentSemester);
    }

    /**
     * Add an exempted module with the given {@code moduleCode} to the active student.
     *
     * @param moduleCode Exempted {@link ModuleCode}.
     */
    public void addExemptedModule(ModuleCode moduleCode) {
        requireActiveStudentNonNull();
        getActiveStudent().addExemptedModule(moduleCode);
    }

    /**
     * Removes an exempted module from the given {@code moduleCode} of the active student.
     *
     * @param moduleCode Exempted {@link ModuleCode}.
     */
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

    /**
     * Returns if the active student is exempted from {@code moduleCode}.
     *
     * @param moduleCode Exempted {@link ModuleCode}.
     */
    public boolean hasExemptedModule(ModuleCode moduleCode) {
        requireActiveStudentNonNull();
        return getExemptedModulesList().contains(moduleCode);
    }

    /**
     * Adds a {@link Lesson} to the active student.
     *
     * @param lesson {@link Lesson}.
     */
    public void addLesson(Lesson lesson) {
        requireActiveStudentNonNull();
        getActiveStudent().addLessons(lesson);
    }

    /**
     * Returns the list of {@link Lesson} of the active student.
     *
     * @return List of {@link Lesson}.
     */
    public List<Lesson> getLessons() {
        requireActiveStudentNonNull();
        return getActiveStudent().getLesson();
    }

    /**
     * Returns if the active student has the given {@code lesson}.
     *
     * @return {@code true} if the active student has the given {@code lesson}.
     */
    public boolean hasLesson(Lesson lesson) {
        requireActiveStudentNonNull();
        return getActiveStudent().getLesson().contains(lesson);

    }
}

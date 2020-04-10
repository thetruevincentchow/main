package seedu.planner.model;

import java.util.List;
import java.util.Optional;

import javafx.collections.ObservableList;
import seedu.planner.commons.core.GuiSettings;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.module.Lesson;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.time.StudentSemester;

//@@author thetruevincentchow
public class ModelStub implements Model {
    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public GuiSettings getGuiSettings() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyPlanner getPlanner() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setPlanner(Planner planner) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Student> getStudentList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasStudent(Student student) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Student getActiveStudent() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void replaceActiveStudent(Student editedStudent) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void activateStudent(Student student) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void activateValidStudent() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addStudent(Student student) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeStudent(Student student) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public List<StudentSemester> getStudentSemesters() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<ModuleCode> getEnrolledModuleCodes() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasEnrollment(ModuleCode moduleCode) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addEnrollment(Enrollment enrollment) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeEnrollment(ModuleCode moduleCode) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void activateSemester(StudentSemester studentSemester) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public TimeTable getActiveTimeTable() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addSemesterTimeTable(StudentSemester studentSemester) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeSemesterTimeTable(StudentSemester studentSemester) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Optional<Grade> getModuleGrade(ModuleCode moduleCode) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setModuleGrade(ModuleCode moduleCode, Grade grade) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<ModuleCode> getExemptedModulesList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addExemptedModule(ModuleCode moduleCode) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeExemptedModule(ModuleCode moduleCode) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasExemptedModule(ModuleCode moduleCode) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addLesson(Lesson lesson) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public List<Lesson> getLessons() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeLesson(Lesson removedLesson) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasLesson(Lesson lesson) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasSemester(StudentSemester studentSemester) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasActiveTimeTable() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasActiveStudent() {
        throw new AssertionError("This method should not be called.");
    }
}
//@@author

package seedu.address.model;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Enrollment;

import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

import seedu.address.model.student.Student;
import seedu.address.model.student.TimeTable;
import seedu.address.model.time.StudentSemester;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents the in-memory model of the address book data.
 */
public class PlannerModelManager extends ModelManager {
    private static final Logger logger = LogsCenter.getLogger(PlannerModelManager.class);

    private final Planner planner;
    //private final ModuleBook moduleBook;
    //private final FilteredList<Module> filteredmodules;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public PlannerModelManager(Planner planner) {
        super();
        requireAllNonNull(planner);

        // logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.planner = planner;
        //this.moduleBook = new ModuleBook(moduleBook);
        //filteredmodules = new FilteredList<>(this.moduleBook.getModuleList());

        // this.userPrefs = new UserPrefs(userPrefs);
    }

    public PlannerModelManager() {
        this(new Planner());
    }


    //=========== Planner ================================================================================

    public void setPlanner(Planner planner) {
        this.planner.resetData(planner);
    }

    public Planner getPlanner() {
        return planner;
    }

    @Override
    public ObservableList<Student> getStudentList() {
        return planner.getStudentList();
    }

    @Override
    public boolean hasStudent(Student student) {
        return planner.hasStudent(student);
    }

    @Override
    public Student getActiveStudent() {
        return planner.getActiveStudent();
    }

    @Override
    public void setActiveStudent(Student editedStudent) {
        planner.setActiveStudent(editedStudent);
    }

    @Override
    public void activateStudent(Student student) {
        planner.activateStudent(student);
    }

    @Override
=======
    /*public ObservableList<Module> getFilteredModuleList() {
        return filteredmodules;
    }

    public void updateFilteredModuleList(Predicate<Module> predicate) {
        requireNonNull(predicate);
        filteredmodules.setPredicate(predicate);
    }*/


    public void addStudent(Student student) {
        requireAllNonNull(student);
        planner.addStudent(student);
    }

    @Override
    public void removeStudent(Student student) {
        requireAllNonNull(student);
        planner.removeStudent(student);
    }
    @Override
    public ObservableList<ModuleCode> getEnrolledModuleCodes() {
        return planner.getActiveModuleCodes();
    }

    @Override
    public boolean hasEnrollment(ModuleCode moduleCode) {
        return planner.hasEnrollment(moduleCode);
    }

    @Override
    public void addEnrollment(Enrollment enrollment) {
        planner.addEnrollment(enrollment);
    }

    @Override
    public void removeEnrollment(ModuleCode moduleCode) {
        planner.removeEnrollment(moduleCode);
    }

    @Override
    public void activateSemester(StudentSemester studentSemester) {
        planner.activateSemester(studentSemester);
    }

    @Override
    public TimeTable getActiveTimeTable() {
        return planner.getActiveTimeTable();
    }

    @Override
    public void addSemesterTimeTable(StudentSemester studentSemester) {
        planner.addSemesterTimeTable(studentSemester);
    }

    @Override
    public void removeSemesterTimeTable(StudentSemester studentSemester) {
        planner.removeSemesterTimeTable(studentSemester);
    }
}

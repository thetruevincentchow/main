package seedu.address.model;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.grades.Grade;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.person.Person;
import seedu.address.model.student.Enrollment;
import seedu.address.model.student.Student;
import seedu.address.model.student.TimeTable;
import seedu.address.model.time.StudentSemester;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Returns the AddressBook
     */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /**
     * Returns the Planner
     */
    ReadOnlyPlanner getPlanner();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Returns an unmodifiable view of the filtered person list
     */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Returns an unmodifiable view of the filtered person list
     */
    ObservableList<Module> getFilteredModuleList();


    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    ObservableList<Student> getStudentList();

    boolean hasStudent(Student student);

    Student getActiveStudent();

    void setActiveStudent(Student editedStudent);

    void activateStudent(Student student);

    void addStudent(Student student);

    void removeStudent(Student student);

    ObservableList<ModuleCode> getEnrolledModuleCodes();

    boolean hasEnrollment(ModuleCode moduleCode);

    void addEnrollment(Enrollment enrollment);

    void removeEnrollment(ModuleCode moduleCode);

    void activateSemester(StudentSemester studentSemester);

    TimeTable getActiveTimeTable();

    void addSemesterTimeTable(StudentSemester studentSemester);

    void removeSemesterTimeTable(StudentSemester studentSemester);

    Optional<Grade> getModuleGrade(ModuleCode moduleCode);

    void setModuleGrade(ModuleCode moduleCode, Grade grade);
}

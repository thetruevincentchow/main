package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.grades.Grade;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.person.Person;
import seedu.address.model.student.Enrollment;
import seedu.address.model.student.Student;
import seedu.address.model.student.TimeTable;
import seedu.address.model.time.StudentSemester;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final Planner planner;
    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;

    // TODO: remove dependence on `ReadOnlyAddressBook` and `AddressBook`.
    //       This would require removal of all related tests for `AddressBook` and other associated classes,
    //       since they may require functionality from `AddressBook`.
    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs, Planner planner) {
        super();
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);
        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());

        requireAllNonNull(planner);
        logger.fine("Initializing with planner: " + planner + " and user prefs " + userPrefs);

        this.planner = planner;
        // this.userPrefs = new UserPrefs(userPrefs);
    }

    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs) {
        this(addressBook, userPrefs, new Planner());
    }

    public ModelManager(Planner planner) {
        this(new AddressBook(), new UserPrefs(), planner);
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public ReadOnlyPlanner getPlanner() {
        return planner;
    }

    @Override
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return addressBook.hasPerson(person);
    }

    @Override
    public void deletePerson(Person target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        addressBook.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);

        addressBook.setPerson(target, editedPerson);
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredPersons.equals(other.filteredPersons);
    }

    public void setPlanner(Planner planner) {
        this.planner.resetData(planner);
    }

    public ObservableList<Student> getStudentList() {
        return planner.getStudentList();
    }

    public boolean hasStudent(Student student) {
        return planner.hasStudent(student);
    }

    public Student getActiveStudent() {
        return planner.getActiveStudent();
    }

    public void setActiveStudent(Student editedStudent) {
        planner.setActiveStudent(editedStudent);
    }

    public void activateStudent(Student student) {
        planner.activateStudent(student);
    }

    public void addStudent(Student student) {
        requireAllNonNull(student);
        planner.addStudent(student);
    }

    public void removeStudent(Student student) {
        requireAllNonNull(student);
        planner.removeStudent(student);
    }

    public ObservableList<ModuleCode> getEnrolledModuleCodes() {
        return planner.getActiveModuleCodes();
    }

    // TODO: replace with `TimeTable` and `Enrollment`
    public boolean hasEnrollment(ModuleCode moduleCode) {
        return planner.hasEnrollment(moduleCode);
    }

    public void addEnrollment(Enrollment enrollment) {
        planner.addEnrollment(enrollment);
    }

    public void removeEnrollment(ModuleCode moduleCode) {
        planner.removeEnrollment(moduleCode);
    }

    public void activateSemester(StudentSemester studentSemester) {
        planner.activateSemester(studentSemester);
    }

    public TimeTable getActiveTimeTable() {
        return planner.getActiveTimeTable();
    }

    public void addSemesterTimeTable(StudentSemester studentSemester) {
        planner.addSemesterTimeTable(studentSemester);
    }

    public void removeSemesterTimeTable(StudentSemester studentSemester) {
        planner.removeSemesterTimeTable(studentSemester);
    }

    public void setModuleGrade(ModuleCode moduleCode, Grade grade) {
        planner.setModuleGrade(moduleCode, grade);
    }
}

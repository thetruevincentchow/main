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

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);
        this.planner = new Planner();
        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs());
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


    // TODO: place implementation of methods in PlannerModelManager into ModelManager
    //       and remove PlannerModelManager
    public ObservableList<Student> getStudentList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean hasStudent(Student student) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Student getActiveStudent() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setActiveStudent(Student editedStudent) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void activateStudent(Student student) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addStudent(Student student) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void removeStudent(Student student) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ObservableList<ModuleCode> getEnrolledModulesList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // TODO: replace with `TimeTable` and `Enrollment`
    public boolean hasEnrollment(ModuleCode moduleCode) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addEnrollment(Enrollment enrollment) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void removeEnrollment(ModuleCode moduleCode) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void activateSemester(StudentSemester studentSemester) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public TimeTable getActiveTimeTable() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

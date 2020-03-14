package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.Planner;
import seedu.address.model.ReadOnlyPlanner;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "planner")
class JsonSerializablePlanner {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";

    private final JsonAdaptedStudent activeStudent;
    private final List<JsonAdaptedStudent> students = new ArrayList<>();
    private final List<JsonAdaptedModuleCode> enrolledModules = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializablePlanner(@JsonProperty("activeStudent") JsonAdaptedStudent activeStudent,
                                   @JsonProperty("students") List<JsonAdaptedStudent> students,
                                   @JsonProperty("enrolledModules") List<JsonAdaptedModuleCode> enrolledModules) {
        this.activeStudent = activeStudent;
        this.students.addAll(students);
        this.enrolledModules.addAll(enrolledModules);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializablePlanner(ReadOnlyPlanner source) {
        //TODO: allow serialization of planner with no active student
        activeStudent = new JsonAdaptedStudent(source.getActiveStudent());

        students.addAll(source.getStudentList().stream().map(JsonAdaptedStudent::new).collect(Collectors.toList()));
        //enrolledModules.addAll(source.getEnrolledModulesList().stream().map(JsonAdaptedModuleCode::new)
        //        .collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Planner toModelType() throws IllegalValueException {
        Planner planner = new Planner();

        for (JsonAdaptedStudent jsonAdaptedStudent : students) {
            Student student = jsonAdaptedStudent.toModelType();
            if (planner.hasStudent(student)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            planner.addStudent(student);
        }

        planner.setActiveStudent(activeStudent.toModelType());
        return planner;
    }

}

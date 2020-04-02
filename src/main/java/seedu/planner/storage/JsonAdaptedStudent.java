package seedu.planner.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTableMap;


/**
 * Jackson-friendly version of {@link Student}.
 */
class JsonAdaptedStudent {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Student's %s field is missing!";

    public final JsonAdaptedTimeTableMap timeTableMap;
    public final List<JsonAdaptedModuleCode> exemptedModules;
    private final String name;
    private final String major;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedStudent(@JsonProperty("name") String name, @JsonProperty("major") String major,
                              @JsonProperty("timeTableMap") JsonAdaptedTimeTableMap timeTableMap,
                              @JsonProperty("exemptedModules") List<JsonAdaptedModuleCode> exemptedModules) {
        this.name = name;
        this.major = major;
        this.timeTableMap = timeTableMap;
        this.exemptedModules = exemptedModules;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedStudent(Student source) {
        name = source.getName().fullName;
        major = source.getMajor().toString();
        timeTableMap = new JsonAdaptedTimeTableMap(source.getTimeTableMap());
        exemptedModules = new ArrayList<JsonAdaptedModuleCode>();
        exemptedModules.addAll(source.getExemptedModules().stream()
            .map(JsonAdaptedModuleCode::new)
            .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Student toModelType() throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (major == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Major.class.getSimpleName()));
        }
        if (!Major.isValidMajor(major)) {
            throw new IllegalValueException(Major.MESSAGE_CONSTRAINTS);
        }
        final Major modelMajor = new Major(major);

        if (timeTableMap == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                TimeTableMap.class.getSimpleName()));
        }
        final TimeTableMap modelTimeTableMap = timeTableMap.toModelType();

        final List<ModuleCode> modelExemptedModules = new ArrayList<>();
        if (exemptedModules != null) {
            for (JsonAdaptedModuleCode moduleCode : exemptedModules) {
                modelExemptedModules.add(moduleCode.toModelType());
            }
        }

        return new Student(modelName, modelMajor, modelTimeTableMap, modelExemptedModules);
    }

}

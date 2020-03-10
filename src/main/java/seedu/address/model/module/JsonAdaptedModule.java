package seedu.address.model.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;

/**
 * Jackson-friendly version of {@link Person}.
 */
public class JsonAdaptedModule {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Module's %s field is missing!";

    private final String acadYear;
    private final String preclusion;
    private final String description;
    private final String title;
    private final String department;
    private final String faculty;
    // private final String workload;
    private final String prerequisite;
    private final String moduleCredit;
    private final String moduleCode;
    private final String semesterData;
    private final String prereqTree;
    private final String fulfillRequirements;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedModule(
        @JsonProperty("acadYear") String acadYear,
        @JsonProperty("preclusion") String preclusion,
        @JsonProperty("description") String description,
        @JsonProperty("title") String title,
        @JsonProperty("department") String department,
        @JsonProperty("faculty") String faculty,
        // @JsonProperty("workload") String workload,
        @JsonProperty("prerequisite") String prerequisite,
        @JsonProperty("moduleCredit") String moduleCredit,
        @JsonProperty("moduleCode") String moduleCode,
        @JsonProperty("semesterData") String semesterData,
        @JsonProperty("prereqTree") String prereqTree,
        @JsonProperty("fulfillRequirements") String fulfillRequirements

        ) {
        this.acadYear = acadYear;
        this.preclusion = preclusion;
        this.description = description;
        this.title = title;
        this.department = department;
        this.faculty = faculty;
        // this.workload = workload;
        this.prerequisite = prerequisite;
        this.moduleCredit = moduleCredit;
        this.moduleCode = moduleCode;
        this.semesterData = semesterData;
        this.prereqTree = prereqTree;
        this.fulfillRequirements = fulfillRequirements;

    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedModule(Module module) {
        this.acadYear = module.acadYear;
        this.preclusion = module.preclusion;
        this.description = module.description;
        this.title = module.title;
        this.department = module.department;
        this.faculty = module.faculty;
        // this.workload = module.workload;
        this.prerequisite = module.prerequisite;
        this.moduleCredit = module.moduleCredit;
        this.moduleCode = module.moduleCode.toString();
        this.semesterData = module.semesterData;
        this.prereqTree = module.prereqTree;
        this.fulfillRequirements = module.fulfillRequirements;
    }

    /**
     * Converts this Jackson-friendly adapted Module object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Module toModelType() throws IllegalValueException {
//        if (name == null) { // TODO Data validation
//            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
//        }
//        if (!Name.isValidName(name)) {
//            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
//        }
//        final Name modelName = new Name(name);
//
//        if (major == null) {
//            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Major.class.getSimpleName()));
//        }
//        if (!Major.isValidMajor(major)) {
//            throw new IllegalValueException(Major.MESSAGE_CONSTRAINTS);
//        }
//        final Major modelMajor = new Major(major);
        return new Module(
            acadYear,
            preclusion,
            description,
            title,
            department,
            faculty,
            null, // workload,
            prerequisite,
            moduleCredit,
            moduleCode,
            semesterData,
            prereqTree,
            fulfillRequirements
            );
    }
}

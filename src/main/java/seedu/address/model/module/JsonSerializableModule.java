package seedu.address.model.module;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * An Immutable ModuleList that is serializable to JSON format.
 */
public class JsonSerializableModule {

    public static final String MESSAGE_DUPLICATE_MODULE = "Module list contains duplicate module(s).";

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
    private final List<JsonSerializableSemesterData> semesterData;
    private final String prereqTree;
    private final String fulfillRequirements;

    /**
     * Constructs a {@code JsonSerializableModule} with the given Module.
     */
    @JsonCreator
    public JsonSerializableModule(
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
        @JsonProperty("semesterData") List<JsonSerializableSemesterData> semesterData,
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
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    /*public JsonSerializableModule(ReadOnlyPlanner source) {
        // TODO: Don't think we will need to use this. KIV
        // modules.addAll(source.getModuleList().stream().map(JsonAdaptedModule::new).collect(Collectors.toList()));
    }*/

    /**
     * Converts this module into the model's {@code Module} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Module toModelType() throws IllegalValueException {
        return new Module(
            this.acadYear,
            this.preclusion,
            this.description,
            this.title,
            this.department,
            this.faculty,
            null, // this.workload,
            this.prerequisite,
            this.moduleCredit,
            this.moduleCode.replaceAll("[^a-zA-Z0-9]", ""),
            this.semesterData.stream().map(x -> x.toModelType()).collect(Collectors.toList()), // this.semesterData,
            this.prereqTree,
            this.fulfillRequirements
        );
    }

}

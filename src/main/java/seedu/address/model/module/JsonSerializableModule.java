package seedu.address.model.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.Planner;
import seedu.address.model.ReadOnlyPlanner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An Immutable ModuleList that is serializable to JSON format.
 */
public class JsonSerializableModule {

    public static final String MESSAGE_DUPLICATE_MODULE = "Module list contains duplicate module(s).";

    public String ModuleCode;
    public String ModuleTitle;
    public String AcadYear;
    public String SemesterName;
    public String Faculty;
    public String Department;
    public String ModuleDescription;
    public String CrossModule;
    public String ModuleCredit;
    public String Workload;
    public String Prerequisite;
    public String Preclusion;
    public String Corequisite;

    /**
     * Constructs a {@code JsonSerializableModule} with the given persons.
     */
    @JsonCreator
    public JsonSerializableModule(
        @JsonProperty("ModuleCode") String ModuleCode,
        @JsonProperty("ModuleTitle") String ModuleTitle,
        @JsonProperty("AcadYear") String AcadYear,
        @JsonProperty("SemesterName") String SemesterName,
        @JsonProperty("Faculty") String Faculty,
        @JsonProperty("Department") String Department,
        @JsonProperty("ModuleDescription") String ModuleDescription,
        @JsonProperty("CrossModule") String CrossModule,
        @JsonProperty("ModuleCredit") String ModuleCredit,
        @JsonProperty("Workload") String Workload,
        @JsonProperty("Prerequisite") String Prerequisite,
        @JsonProperty("Preclusion") String Preclusion,
        @JsonProperty("Corequisite") String Corequisite
        ) {
        this.ModuleCode = ModuleCode;
        this.ModuleTitle = ModuleTitle;
        this.AcadYear = AcadYear;
        this.SemesterName = SemesterName;
        this.Faculty = Faculty;
        this.Department = Department;
        this.ModuleDescription = ModuleDescription;
        this.CrossModule = CrossModule;
        this.ModuleCredit = ModuleCredit;
        this.Workload = Workload;
        this.Prerequisite = Prerequisite;
        this.Preclusion = Preclusion;
        this.Corequisite = Corequisite;
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableModule(ReadOnlyPlanner source) {
        // TODO: Don't think we will need to use this. KIV
        // modules.addAll(source.getModuleList().stream().map(JsonAdaptedModule::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Module toModelType() throws IllegalValueException {
        return new Module(
            this.ModuleCode,
            this.ModuleTitle,
            this.AcadYear,
            this.SemesterName,
            this.Faculty,
            this.Department,
            this.ModuleDescription,
            this.CrossModule,
            this.ModuleCredit,
            this.Workload,
            this.Prerequisite,
            this.Preclusion,
            this.Corequisite
        );
    }

}

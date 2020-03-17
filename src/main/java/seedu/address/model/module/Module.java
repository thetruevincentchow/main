package seedu.address.model.module;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.time.Semester;

import java.util.List;

public class Module {

    public String acadYear;
    public String preclusion;
    public String description;
    public String title;
    public String department;
    public String faculty;
    public String workload;
    public String prerequisite;
    public String moduleCredit;
    public ModuleCode moduleCode;
    public List<SemesterData> semesterData;
    public String prereqTree;
    public String fulfillRequirements;

    public Module (
        String acadYear,
        String preclusion,
        String description,
        String title,
        String department,
        String faculty,
        String workload,
        String prerequisite,
        String moduleCredit,
        String moduleCode,
        List<SemesterData> semesterData,
        String prereqTree,
        String fulfillRequirements
    ) throws IllegalValueException {
        this.acadYear = acadYear;
        this.preclusion = preclusion;
        this.description = description;
        this.title = title;
        this.department = department;
        this.faculty = faculty;
        this.workload = workload;
        this.prerequisite = prerequisite;
        this.moduleCredit = moduleCredit;
        this.moduleCode = new ModuleCode(moduleCode);
        this.semesterData = semesterData;
        this.prereqTree = prereqTree;
        this.fulfillRequirements = fulfillRequirements;
    }

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public boolean isSameModule(Module module) {
        return false; // TODO
    }

    public int getModuleCredit() {
        //TODO: make `moduleCredit` an `int`
        return Integer.parseInt(moduleCredit);
    }
}

package seedu.address.model.module;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.time.Semester;

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
    public String semesterData;
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
            String semesterData,
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

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public boolean isSameModule(Module module) {
        return false; // TODO
    }

    public String getModuleTitle() {
        return title;
    }

    public String getSemesterName() {
        return semesterData;
    }

    public Semester convertSem(String semesterName) {
        String convertedValue;
        switch (semesterName){
            case "Semester 1":
                convertedValue = "ONE";
                break;
            case "Semester 2":
                convertedValue = "TWO";
                break;
            case "Special Semester 1":
                convertedValue = "SPECIAL_ONE";
                break;
            case "Special Semester 2":
                convertedValue = "SPECIAL_TWO";
                break;
            default:
                convertedValue = "NULL";
                break;
        }
        return Semester.valueOf(convertedValue);

    }


}

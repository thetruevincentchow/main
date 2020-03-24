package seedu.address.model.module;

import java.util.List;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.time.Semester;

public class Module {

    public final String acadYear;
    public final String preclusion;
    public final String description;
    public final String title;
    public final String department;
    public final String faculty;
    public final String workload;
    public final String prerequisite;
    public final String moduleCredit;
    public final ModuleCode moduleCode;
    public final List<SemesterData> semesterData;
    public final String prereqTree;
    public final String fulfillRequirements;

    public Module(

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

    public String getModuleTitle() {
        return title;
    }

    public List<SemesterData> getSemesterName() {
        return semesterData;
    }

    public Semester convertSem(String semesterName) {
        String convertedValue;
        switch (semesterName) {
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

package seedu.address.model.module;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.time.Semester;

import java.lang.invoke.SwitchPoint;

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

    public Module(
        String ModuleCode,
        String ModuleTitle,
        String AcadYear,
        String SemesterName,
        String Faculty,
        String Department,
        String ModuleDescription,
        String CrossModule,
        String ModuleCredit,
        String Workload,
        String Prerequisite,
        String Preclusion,
        String Corequisite
    ) {
        this.ModuleCode = new ModuleCode(ModuleCode);
        this.ModuleTitle = ModuleTitle;
        this.AcadYear = AcadYear;
        this.SemesterName = convertSem(SemesterName);
        this.Faculty = Faculty;
        this.Department = Department;
        this.ModuleDescription = new Description(ModuleDescription);
        this.CrossModule = CrossModule;
        this.ModuleCredit = new Credit(ModuleCredit);
        this.Workload = Workload;
        this.Prerequisite = Prerequisite;
        this.Preclusion = Preclusion;
        this.Corequisite = Corequisite;

    }

    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    public boolean isSameModule(Module module) {
        return false; // TODO
    }

    public ModuleCode getModuleCode() {
        return ModuleCode;
    }

    public String getModuleTitle() {
        return ModuleTitle;
    }

    public Semester getSemesterName() {
        return SemesterName;
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

package seedu.address.model.module;

import seedu.address.model.time.Semester;

public class Module {

    public ModuleCode ModuleCode;
    public String ModuleTitle;
    public String AcadYear;
    public Semester SemesterName;
    public String Faculty;
    public String Department;
    public Description ModuleDescription;
    public String CrossModule;
    public Credit ModuleCredit;
    public String Workload;
    public String Prerequisite;
    public String Preclusion;
    public String Corequisite;

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
        this.SemesterName = Semester.valueOf(SemesterName);
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

    public boolean isSameModuleOffering(Module module) {
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


}

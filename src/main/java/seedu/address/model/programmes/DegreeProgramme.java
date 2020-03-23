package seedu.address.model.programmes;

import seedu.address.model.graduation.GraduationRequirement;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

import java.util.List;

public abstract class DegreeProgramme extends Programme {

    public DegreeType degreeType;

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        for (GraduationRequirement requirement : this.graduationRequirementList) {
            if (!requirement.isFulfilled(moduleCodes)) {
                return false;
            }
        }
        return true;
    }
}

package seedu.address.model.programmes;

import seedu.address.model.graduation.GraduationRequirement;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

import java.util.List;

public abstract class Programme {
    protected String name;
    protected List<GraduationRequirement> graduationRequirementList;

    public String getName() {
        return name;
    }
    public List<GraduationRequirement> getGraduationRequirementList() {
        return graduationRequirementList;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);
}

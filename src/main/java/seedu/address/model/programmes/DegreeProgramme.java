package seedu.address.model.programmes;

import seedu.address.model.Graduation.GraduationRequirement;

public abstract class DegreeProgramme extends Programme {

    public DegreeType degreeType;

    public boolean isFulfilled() {
        for (GraduationRequirement requirement : this.graduationRequirementList) {
            if (!requirement.isFulfilled()) {
                return false;
            }
        }
        return true;
    }
}

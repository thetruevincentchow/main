package seedu.address.model.programmes;

import seedu.address.model.graduation.GraduationRequirement;

public abstract class DegreeProgramme extends Programme {

    private DegreeType degreeType;

    public boolean isFulfilled() {
        for (GraduationRequirement requirement : this.graduationRequirementList) {
            if (!requirement.isFulfilled()) {
                return false;
            }
        }
        return true;
    }
}

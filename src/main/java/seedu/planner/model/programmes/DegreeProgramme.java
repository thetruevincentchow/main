package seedu.planner.model.programmes;

import java.util.List;

import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;

/**
 * Abstract class to represent the Degree Programme relationships.
 */
public abstract class DegreeProgramme extends Programme {

    private DegreeType degreeType;

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    /**
     * Determines if a {@code DegreeProgramme} has been fulfilled based on a given list of {@code ModuleCode}.
     *
     * @param moduleCodes List of {@code ModuleCode} that a {@code Student} has enrolled in
     * @return True if all requirements from a {@code DegreeProgramme} has been fulfilled. False otherwise.
     */
    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        for (GraduationRequirement requirement : this.graduationRequirementList) {
            if (!requirement.isFulfilled(moduleCodes).getKey()) {
                return false;
            }
        }
        return true;
    }
}

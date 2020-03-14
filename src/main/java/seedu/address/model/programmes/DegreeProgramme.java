package seedu.address.model.programmes;

import seedu.address.model.graduation.GraduationRequirement;
import seedu.address.model.student.Student;

public abstract class DegreeProgramme extends Programme {

    public DegreeType degreeType;

    public boolean isFulfilled(Student student) {
        for (GraduationRequirement requirement : this.graduationRequirementList) {
            if (!requirement.isFulfilled(student)) {
                return false;
            }
        }
        return true;
    }
}

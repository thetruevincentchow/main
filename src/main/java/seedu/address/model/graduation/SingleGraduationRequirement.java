package seedu.address.model.graduation;

import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

public class SingleGraduationRequirement extends GraduationRequirement {

    public SingleGraduationRequirement(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }
    public boolean isFulfilled(Student student) {
        return student.getAllEnrolledModules().contains(moduleCode);
    }

}

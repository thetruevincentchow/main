package seedu.address.model.graduation;

import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

public abstract class GraduationRequirement {

    public ModuleCode moduleCode;
    public abstract boolean isFulfilled(Student student);

    @Override
    public String toString() {
        return "[X] " + moduleCode.toString();
    }
}

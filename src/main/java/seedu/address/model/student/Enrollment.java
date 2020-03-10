package seedu.address.model.student;

import seedu.address.model.grades.Grade;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;

import java.util.Optional;
import java.util.OptionalDouble;

public class Enrollment {
    public ModuleCode code;
    public Optional<Grade> grade;
    public int credit;

    public Enrollment(ModuleCode code) {
        this.code = code;
        this.grade = Optional.empty();
        this.credit = 0;
    }

    public ModuleCode getModuleCode() {
        //return module.getModuleCode();
        return code;
    }

    public OptionalDouble getGradePoint() {
        if (grade.isPresent()) {
            return grade.get().getGradePoint(credit);
        } else {
            return OptionalDouble.empty();
        }
    }
}

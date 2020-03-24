package seedu.address.model.student;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Optional;
import java.util.OptionalDouble;

import seedu.address.model.grades.Grade;
import seedu.address.model.module.ModuleCode;

public class Enrollment {
    public ModuleCode code;
    public Optional<Grade> grade;
    public int credit;

    public Enrollment(ModuleCode code, Optional<Grade> grade, int credit) {
        requireAllNonNull(code, grade, credit);
        this.code = code;
        this.grade = grade;
        this.credit = credit;
    }

    public ModuleCode getModuleCode() {
        return code;
    }

    public Optional<Grade> getGrade() {
        return grade;
    }

    public OptionalDouble getGradePoint() {
        if (grade.isPresent()) {
            return grade.get().getGradePoint();
        } else {
            return OptionalDouble.empty();
        }
    }
}

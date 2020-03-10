package seedu.address.model.student;

import seedu.address.model.grades.Grade;

import java.util.Optional;
import java.util.OptionalDouble;

public class Enrollment {
    public Module module;
    public Optional<Grade> grade;
    public int credit;

    public OptionalDouble getGradePoint() {
        if (grade.isPresent()) {
            return grade.get().getGradePoint(credit);
        } else {
            return OptionalDouble.empty();
        }
    }
}

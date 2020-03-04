package seedu.address.model.grades;

import java.util.OptionalDouble;

public class Grade {
    protected LetterGrade letterGrade;
    protected boolean isSu;

    public Grade(LetterGrade letterGrade, boolean isSu) {
        this.letterGrade = letterGrade;
        this.isSu = isSu;
    }

    public OptionalDouble getGradePoint(int credit) {
        return OptionalDouble.empty();
    }
}

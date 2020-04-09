package seedu.planner.model.grades;

import java.util.Objects;
import java.util.OptionalDouble;

/**
 * Encapsulates a grade and the option to exercise S/U.
 * This correctly handles CS/CU grades (which are not counted as exercising the S/U option voluntarily).
 */
public class Grade {
    public final LetterGrade letterGrade;
    public final boolean isSu;

    public Grade(LetterGrade letterGrade, boolean isSu) {
        this.letterGrade = letterGrade;
        this.isSu = isSu;
    }

    /**
     * The grade point of the letter grade. This ranges from 0.0 to 5.0.
     * This does not account the S/U declaration (@code isSu).
     *
     * @return Grade point of letter grade
     */
    public OptionalDouble getGradePoint() {
        return letterGrade.points;
    }

    @Override
    public String toString() {
        if (isSu && !letterGrade.isSu) {
            return String.format("%s (S/U exercised)", this.letterGrade);
        } else {
            return String.format("%s", this.letterGrade);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Grade grade = (Grade) o;
        return isSu == grade.isSu && letterGrade == grade.letterGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letterGrade, isSu);
    }
}

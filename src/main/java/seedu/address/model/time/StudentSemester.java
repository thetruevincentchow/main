package seedu.address.model.time;

import seedu.address.model.module.ModuleCode;

import java.util.Objects;

public class StudentSemester {
    protected final SemesterYear semYear;
    protected final int degreeYear;

    public StudentSemester(SemesterYear semYear, int degreeYear) {
        this.semYear = semYear;
        this.degreeYear = degreeYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(semYear, degreeYear);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StudentSemester)) {
            return false;
        } else {
            return semYear.equals(((StudentSemester) other).semYear)
                    && degreeYear == ((StudentSemester) other).degreeYear;
        }
    }
}

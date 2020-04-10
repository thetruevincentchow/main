package seedu.planner.model.time;

import java.util.Comparator;
import java.util.Objects;

public class StudentSemester implements Comparable<StudentSemester> {
    protected final SemesterYear semYear;
    protected final DegreeYear degreeYear;

    public StudentSemester(SemesterYear semYear, DegreeYear degreeYear) {
        this.semYear = semYear;
        this.degreeYear = degreeYear;
    }

    public StudentSemester(SemesterYear semYear, int degreeYear) {
        this(semYear, new DegreeYear(degreeYear));
    }

    public SemesterYear getSemesterYear() {
        return semYear;
    }

    public int getDegreeYear() {
        return degreeYear.getYear();
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
                && degreeYear.equals(((StudentSemester) other).degreeYear);
        }
    }

    @Override
    public String toString() {
        return String.format("Year %d, %s", degreeYear.getYear(), semYear);
    }

    @Override
    public int compareTo(StudentSemester other) {
        return Comparator.comparing(StudentSemester::getDegreeYear)
            .thenComparing(StudentSemester::getSemesterYear)
            .compare(this, other);
    }
}

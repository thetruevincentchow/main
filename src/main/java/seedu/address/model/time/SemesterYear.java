package seedu.address.model.time;

import java.util.Objects;

public class SemesterYear {
    protected final Semester sem;
    protected final int academicYear;

    public SemesterYear(Semester sem, int academicYear) {
        this.sem = sem;
        this.academicYear = academicYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sem, academicYear);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SemesterYear)) {
            return false;
        } else {
            return sem.equals(((SemesterYear) other).sem)
                    && academicYear == ((SemesterYear) other).academicYear;
        }
    }
}

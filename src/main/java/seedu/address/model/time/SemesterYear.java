package seedu.address.model.time;

public class SemesterYear {
    protected Semester sem;
    protected int academicYear;

    public SemesterYear(Semester sem, int academicYear) {
        this.sem = sem;
        this.academicYear = academicYear;
    }
}

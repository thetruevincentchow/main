package seedu.address.model.time;

public class StudentSemester {
    protected SemesterYear semYear;
    protected int degreeYear;

    public StudentSemester(SemesterYear semYear, int degreeYear) {
        this.semYear = semYear;
        this.degreeYear = degreeYear;
    }
}

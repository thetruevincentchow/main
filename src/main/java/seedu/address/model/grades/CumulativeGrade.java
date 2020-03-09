package seedu.address.model.grades;

import java.util.OptionalDouble;

public class CumulativeGrade {
    protected int numSu;
    protected double totalGradePoints;
    protected int totalCredits;

    public CumulativeGrade(int numSu, double totalGradePoints, int totalCredits) {
        this.numSu = numSu;
        this.totalGradePoints = totalGradePoints;
        this.totalCredits = totalCredits;
    }

    public OptionalDouble getValue() {
        return OptionalDouble.empty();
    }
}

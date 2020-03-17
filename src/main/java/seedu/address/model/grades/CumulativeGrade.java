package seedu.address.model.grades;

import java.util.OptionalDouble;

public class CumulativeGrade {
    protected int numSu;
    protected int totalCredits;
    protected double totalGradePoints;
    protected int totalGradedCredits;
    protected int totalSuCredits;

    public CumulativeGrade(int numSu, int totalCredits, double totalGradePoints, int totalGradedCredits, int totalSuCredits) {
        this.numSu = numSu;
        this.totalCredits = totalCredits;
        this.totalGradePoints = totalGradePoints;
        this.totalGradedCredits = totalGradedCredits;
        this.totalSuCredits = totalSuCredits;
    }

    public CumulativeGrade() {
        this(0,0,0,0,0);
    }

    /**
     * Accumulates the grade to the counter.
     * @param isSu Whether the grade is declared S/U
     * @param gradePoint Weighted grade points, equal to grade point of the grade multiplied by number of credits
     * @param credits Number of credits
     */
    private void accumulate(boolean isSu, double gradePoint, int credits) {
        totalCredits += credits;
        if (isSu) {
            numSu++;
            totalSuCredits += credits;
        } else {
            totalGradePoints += gradePoint;
            totalGradedCredits += credits;
        }
    }

    public void accumulate(Grade grade, int credits) {
        accumulate(grade.isSu || grade.letterGrade.isSu, grade.getGradePoint().getAsDouble(), credits);
    }

    /**2
     * Accumulates pending module credits. This does not affect the calculated CAP.
     * The number of S/U modules declared is not affected.
     * @param credits Number of credits
     */
    public void accumulate(int credits) {
        totalCredits += credits;
    }

    public OptionalDouble getAverage() {
        if (totalGradedCredits > 0) {
            return OptionalDouble.of(totalGradePoints / (double) totalGradedCredits);
        } else {
            return OptionalDouble.empty();
        }
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public int getTotalGradedCredits() {
        return totalGradedCredits;
    }

    public Object getTotalSuCredits() {
        return totalSuCredits;
    }
}

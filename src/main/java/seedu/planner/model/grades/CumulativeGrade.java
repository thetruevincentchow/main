package seedu.planner.model.grades;

import java.util.Objects;
import java.util.OptionalDouble;


//@@author thetruevincentchow

/**
 * Accumulates grade statistics of individual {@link Grade} and {@code credits}.
 * Calculates Cumulative Average Point (CAP) and other statistics from inputs.
 */
public class CumulativeGrade {
    protected int numSu;
    protected int totalCredits;
    protected double totalGradePoints;
    protected int totalGradedCredits;
    protected int totalSuCredits;

    public CumulativeGrade(int numSu, int totalCredits, double totalGradePoints, int totalGradedCredits,
                           int totalSuCredits) {
        this.numSu = numSu;
        this.totalCredits = totalCredits;
        this.totalGradePoints = totalGradePoints;
        this.totalGradedCredits = totalGradedCredits;
        this.totalSuCredits = totalSuCredits;
    }

    public CumulativeGrade() {
        this(0, 0, 0, 0, 0);
    }

    /**
     * Accumulates the letter grade to the counter.
     *
     * @param gradePoint Grade points, from 0.0 to 5.0
     * @param credits    Number of credits
     */
    private void accumulateGraded(double gradePoint, int credits) {
        totalCredits += credits;
        totalGradePoints += gradePoint * credits;
        totalGradedCredits += credits;
    }

    /**
     * Accumulates module credits and the S/U to the counter.
     *
     * @param credits Number of credits
     */
    private void accumulateSu(int credits) {
        totalCredits += credits;
        numSu++;
        totalSuCredits += credits;
    }

    /**
     * Accumulates pending module credits. This does not affect the calculated CAP.
     * The number of S/U modules declared is not affected.
     *
     * @param credits Number of credits
     */
    public void accumulatePending(int credits) {
        totalCredits += credits;
    }

    /**
     * Accumulates ungraded module credits. This does not affect the calculated CAP.
     * The number of S/U modules declared is not affected.
     *
     * @param credits Number of credits
     */
    public void accumulateUngraded(int credits) {
        totalCredits += credits;
    }

    /**
     * Accumulates module credits and a grade.
     *
     * @param credits Number of credits
     * @param grade   Grade of module
     */
    public void accumulate(Grade grade, int credits) {
        if (grade.letterGrade.isSu) {
            accumulateUngraded(credits);
        } else if (grade.isSu) {
            accumulateSu(credits);
        } else {
            accumulateGraded(grade.getGradePoint().getAsDouble(), credits);
        }
    }

    /**
     * Returns Cumulative Average Point (CAP) of accumulated grades.
     * This excludes modules which are declared S/U.
     * If there were no graded modules accumulated, then returns a {@code OptionalDouble.empty()}
     *
     * @return Cumulative Average Point
     */
    public OptionalDouble getAverage() {
        if (totalGradedCredits > 0) {
            return OptionalDouble.of(totalGradePoints / (double) totalGradedCredits);
        } else {
            return OptionalDouble.empty();
        }
    }

    /**
     * Returns total number of credits taken, including S/U credits.
     */
    public int getTotalCredits() {
        return totalCredits;
    }

    /**
     * Returns total number of graded credits taken. This excludes S/U credits.
     */
    public int getTotalGradedCredits() {
        return totalGradedCredits;
    }

    /**
     * Returns total number of S/U credits taken. This excludes graded credits.
     */
    public int getTotalSuCredits() {
        return totalSuCredits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CumulativeGrade that = (CumulativeGrade) o;
        return numSu == that.numSu
                && totalCredits == that.totalCredits
                && Double.compare(that.totalGradePoints, totalGradePoints) == 0
                && totalGradedCredits == that.totalGradedCredits
                && totalSuCredits == that.totalSuCredits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSu, totalCredits, totalGradePoints, totalGradedCredits, totalSuCredits);
    }
}
//@@author

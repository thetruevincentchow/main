package seedu.planner.model.graduation;

import java.util.List;

import seedu.planner.model.module.ModuleCode;

/**
 * Class that implements {@code GraduationRequirement} to determine if it has fulfilled requirements
 */

public class UnrestrictedElectiveGraduationRequirement extends GraduationRequirement {

    /**
     * Default constructor of {@code UnrestrictedElectiveGraduationRequirement}
     *
     */
    public UnrestrictedElectiveGraduationRequirement() {

    }

    /**
     * Returns a boolean representing if the {@code UnrestrictedElectiveGraduationRequirement} is fulfilled, given a
     * list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        return false;
    }

    /**
     * Method to override the default {@code toString} function of {@code UnrestrictedElectiveGraduationRequirement}
     *
     * @return String representation of {@code UnrestrictedElectiveGraduationRequirement}
     */
    @Override
    public String toString() {
        return "[?] Unrestricted Elective\n";
    }

    /**
     * Returns a String representation of the {@code UnrestrictedElectiveGraduationRequirement} object
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return A String representation of the {@code UnrestrictedElectiveGraduationRequirement} object
     */
    public String getString(List<ModuleCode> moduleCodes) {
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] Unrestricted Elective\n";
    }
}

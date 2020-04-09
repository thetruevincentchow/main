package seedu.planner.model.graduation;

import java.util.List;
import java.util.regex.Pattern;

import seedu.planner.model.module.ModuleCode;

/**
 * Class that implements {@code GraduationRequirement}, consisting of only 1 {@code ModuleCode} that needs to be
 * fulfilled based on a regex expression
 */
public class WildcardGraduationRequirement extends GraduationRequirement {

    /**
     * Name of {@code WildcardGraduationRequirement}
     */
    protected String name;
    /**
     * Minimum number of ModuleCredits
     */
    protected int minMCs;
    /**
     * Regex expression to be used to match {@code ModuleCode}
     */
    protected String regex;
    /**
     * Label of {@code WildcardGraduationRequirement}
     */

    protected String label;

    /**
     * Default constructor of {@code WildcardGraduationRequirement}
     * @param name Name of {@code WildcardGraduationRequirement}
     * @param minMCs Minimum number of ModuleCredits
     * @param regex Regex expression to be used to match {@code ModuleCode}
     * @param label Label of {@code WildcardGraduationRequirement}
     */
    public WildcardGraduationRequirement(String name, int minMCs, String regex, String label) {
        this.name = name;
        this.minMCs = minMCs;
        this.regex = regex;
        this.label = label;
    }

    /**
     * Returns a boolean representing if the {@code WildcardGraduationRequirement} is fulfilled, given a list of
     * {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        for (ModuleCode moduleCode : moduleCodes) {
            if (Pattern.matches(regex, moduleCode.value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String representation of the {@code WildcardGraduationRequirement} object
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return A String representation of the {@code WildcardGraduationRequirement} object
     */
    public String getString(List<ModuleCode> moduleCodes) {
        if (!label.equals("")) {
            return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] [" + label + "] " + name + "\n";
        }
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + name + "\n";
    }

    /**
     * Method to override the default {@code toString} function of {@code WildcardGraduationRequirement}
     *
     * @return String representation of {@code WildcardGraduationRequirement}
     */
    @Override
    public String toString() {
        return "[X] " + name + "\n";
    }

}

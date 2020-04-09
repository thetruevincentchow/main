package seedu.planner.model.graduation;

import java.util.List;

import seedu.planner.model.module.ModuleCode;

/**
 * Class that implements {@code GraduationRequirement}, consisting of only 1 {@code ModuleCode} that needs to be
 * fulfilled
 */

public class SingleGraduationRequirement extends GraduationRequirement {

    /**
     * {@code ModuleCode} that needs to be fulfilled
     */
    protected ModuleCode moduleCode;

    /**
     * Default constructor of {@code SingleGraduationRequirement}
     *
     * @param moduleCode {@code ModuleCode} that needs to be fulfilled
     */
    public SingleGraduationRequirement(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }


    /**
     * Returns the {@code ModuleCode} that needs to be fulfilled
     *
     * @return The {@code ModuleCode} that needs to be fulfilled
     */
    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    /**
     * Sets the {@code ModuleCode} that needs to be fulfilled
     *
     * @param moduleCode that needs to be fulfilled
     */
    public void setModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Returns a boolean representing if the {@code SingleGraduationRequirement} is fulfilled, given a list of
     * {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        return moduleCodes.contains(moduleCode);
    }

    /**
     * Returns a String representation of the {@code SingleGraduationRequirement} object
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return A String representation of the {@code SingleGraduationRequirement} object
     */
    public String getString(List<ModuleCode> moduleCodes) {
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + moduleCode.toString();
    }

    /**
     * Method to override the default {@code toString} function of {@code SingleGraduationRequirement}
     *
     * @return String representation of {@code SingleGraduationRequirement}
     */
    @Override
    public String toString() {
        return moduleCode.toString();
    }

}

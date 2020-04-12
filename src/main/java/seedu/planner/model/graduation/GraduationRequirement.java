package seedu.planner.model.graduation;

import java.util.List;

import javafx.util.Pair;
import seedu.planner.model.module.ModuleCode;

/**
 * Abstract class used for the processing of requirements needed to graduation in a given {@DegreeProgramme}.
 */
public abstract class GraduationRequirement {


    /**
     * Returns a boolean representing if the {@code GraduationRequirement} is fulfilled, given a list of
     * {@code ModuleCode}.
     *
     * @param moduleCodes List of {@code ModuleCode}.
     * @return True if fulfilled. False otherwise.
     */
    public abstract Pair<Boolean, List<ModuleCode>> isFulfilled(List<ModuleCode> moduleCodes);

    /**
     * Helper function to return a tick or cross icon to represent if a graduation has been fulfilled.
     *
     * @param done Boolean of whether the requirement is fulfilled or not.
     * @return A String representation of a unicode tick or cross symbol.
     */
    protected String getStatusIcon(boolean done) {
        return done ? "\u2713" : "\u2718";
    }

    /**
     * Abstract method to override the default {@code toString} function of {@code GraduationRequirement}.
     *
     * @return String representation of {@code GraduationRequirement}.
     */
    @Override
    public abstract String toString();

    /**
     * Abstract method to return a String representation of the {@code GraduationRequirement} object.
     *
     * @param moduleCodes List of {@code ModuleCode}.
     * @return A String representation of the {@code GraduationRequirement} object.
     */
    public abstract String getString(List<ModuleCode> moduleCodes);


}

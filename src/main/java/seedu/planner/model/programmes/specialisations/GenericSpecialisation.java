package seedu.planner.model.programmes.specialisations;

import java.util.ArrayList;
import java.util.List;

import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;

/**
 * Abstract class to represent specialisations for Degree Programmes
 */
public abstract class GenericSpecialisation {

    /**
     * Name of {@code GenericSpecialisation}
     */
    private String name;

    private List<GraduationRequirement> graduationRequirements = new ArrayList<>();

    /**
     * Returns the Name of {@code GenericSpecialisation}
     *
     * @return the Name of {@code GenericSpecialisation}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of {@code GenericSpecialisation}
     *
     * @param name Name of {@code GenericSpecialisation}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the list of {@code GraduationRequirement}
     *
     * @return The list of {@code GraduationRequirement}
     */
    private List<GraduationRequirement> getGraduationRequirements() {
        return graduationRequirements;
    }

    /**
     * Returns a boolean representing if the {@code GenericSpecialisation} has been fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);

    /**
     * Returns a String Representation of {@code GenericSpecialisation}
     *
     * @return A String Representation of {@code GenericSpecialisation}
     */
    public String toString() {
        return name;
    }
}

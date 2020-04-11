package seedu.planner.model.programmes.specialisations;

import java.util.ArrayList;
import java.util.List;

import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.graduation.SingleGraduationRequirement;
import seedu.planner.model.module.ModuleCode;

/**
 * Abstract class to represent specialisations for Degree Programmes
 */
public abstract class GenericSpecialisation {

    /**
     * Name of {@code GenericSpecialisation}
     */
    protected static String name;

    protected int minPrimaryModules = 3;
    protected int minPrimary4kModules = 1;
    protected int minElectiveModules = 0;

    /**
     * List of {@code ModuleCode} which are valid Primaries for a given Specialisation
     */
    protected List<ModuleCode> primaries;
    /**
     * List of {@code ModuleCode} which are valid Electives for a given Specialisation
     */
    protected List<ModuleCode> electives;

    private List<GraduationRequirement> graduationRequirements = new ArrayList<>();



    /**
     * Returns the Name of {@code GenericSpecialisation}
     *
     * @return the Name of {@code GenericSpecialisation}
     */
    public abstract String getName();

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
     * Returns the list of {@code ModuleCode} which are valid Primaries for a given Specialisation
     *
     * @return The list of {@code ModuleCode} which are valid Primaries for a given Specialisation
     */
    public List<ModuleCode> getPrimaries() {
        return primaries;
    }

    /**
     * Returns the list of {@code ModuleCode} which are valid Electives for a given Specialisation
     *
     * @return The list of {@code ModuleCode} which are valid Electives for a given Specialisation
     */
    public List<ModuleCode> getElectives() {
        return electives;
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its primaries fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean arePrimariesFulfilled(List<ModuleCode> moduleCodes) {
        int primaryModules = 0;
        int currentPrimary4kModules = 0;
        ArrayList<SingleGraduationRequirement> primaryRequirements = new ArrayList<>();
        for (ModuleCode primaries : getPrimaries()) {
            primaryRequirements.add(new SingleGraduationRequirement(primaries));
        }
        for (SingleGraduationRequirement primaryRequirement : primaryRequirements) {
            if (primaryRequirement.isFulfilled(moduleCodes)) {
                primaryModules++;
                ArrayList<Character> valid4kCharacters = new ArrayList<>();
                valid4kCharacters.add('4');
                valid4kCharacters.add('5');
                valid4kCharacters.add('6');
                valid4kCharacters.add('7');
                if (valid4kCharacters.contains(primaryRequirement.getModuleCode().toString().charAt(2))) {
                    currentPrimary4kModules++;
                }
            }
        }
        return primaryModules >= minPrimaryModules && currentPrimary4kModules >= minPrimary4kModules;
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its electives fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean areElectivesFulfilled(List<ModuleCode> moduleCodes) {
        int electiveModules = 0;
        ArrayList<SingleGraduationRequirement> electiveRequirements = new ArrayList<>();
        for (ModuleCode electives : getElectives()) {
            electiveRequirements.add(new SingleGraduationRequirement(electives));
        }
        for (SingleGraduationRequirement electiveRequirement : electiveRequirements) {
            if (electiveRequirement.isFulfilled(moduleCodes)) {
                electiveModules++;
            }
        }
        return electiveModules >= minElectiveModules;
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its primaries and electives fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        return arePrimariesFulfilled(moduleCodes) && areElectivesFulfilled(moduleCodes);
    }

    /**
     * Returns a String Representation of {@code GenericSpecialisation}
     *
     * @return A String Representation of {@code GenericSpecialisation}
     */
    public String toString() {
        return getName();
    }
}

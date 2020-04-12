package seedu.planner.model.programmes.specialisations;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
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
    protected int minElective4kModules = 0;

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
     * Check if a given {@code ModuleCode} is Level 4000 or above
     * @param moduleCode {@code ModuleCode} to be checked
     * @return True if a given {@code ModuleCode} is Level 4000 or above, false otherwise
     */
    public boolean is4kAndAbove(ModuleCode moduleCode) {
        ArrayList<Character> valid4kCharacters = new ArrayList<>();
        valid4kCharacters.add('4');
        valid4kCharacters.add('5');
        valid4kCharacters.add('6');
        valid4kCharacters.add('7');
        return valid4kCharacters.contains(moduleCode.toString().charAt(2));
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its primaries fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public Pair<Boolean, List<ModuleCode>> arePrimariesFulfilled(List<ModuleCode> moduleCodes) {
        int primaryModules = 0;
        int currentPrimary4kModules = 0;
        ArrayList<SingleGraduationRequirement> primaryRequirements = new ArrayList<>();
        ArrayList<ModuleCode> fulfilledModules = new ArrayList<>();
        for (ModuleCode primaries : getPrimaries()) {
            primaryRequirements.add(new SingleGraduationRequirement(primaries));
        }
        Pair<Boolean, List<ModuleCode>> pair;
        for (SingleGraduationRequirement primaryRequirement : primaryRequirements) {
            pair = primaryRequirement.isFulfilled(moduleCodes);
            if (pair.getKey()) {
                fulfilledModules.addAll(pair.getValue());
                primaryModules++;
                for (ModuleCode moduleCode : pair.getValue()) {
                    if (is4kAndAbove(moduleCode)) {
                        currentPrimary4kModules++;
                    }
                }
            }
        }
        if (primaryModules >= minPrimaryModules && currentPrimary4kModules >= minPrimary4kModules) {
            return new Pair<>(true, fulfilledModules);
        } else {
            return new Pair<>(false, fulfilledModules);
        }
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its electives fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public Pair<Boolean, List<ModuleCode>> areElectivesFulfilled(List<ModuleCode> moduleCodes) {
        int electiveModules = 0;
        int currentElective4kModules = 0;
        ArrayList<SingleGraduationRequirement> primaryRequirements = new ArrayList<>();
        ArrayList<ModuleCode> fulfilledModules = new ArrayList<>();
        for (ModuleCode primaries : getPrimaries()) {
            primaryRequirements.add(new SingleGraduationRequirement(primaries));
        }
        Pair<Boolean, List<ModuleCode>> pair;
        for (SingleGraduationRequirement primaryRequirement : primaryRequirements) {
            pair = primaryRequirement.isFulfilled(moduleCodes);
            if (pair.getKey()) {
                fulfilledModules.addAll(pair.getValue());
                electiveModules++;
                for (ModuleCode moduleCode : pair.getValue()) {
                    if (is4kAndAbove(moduleCode)) {
                        currentElective4kModules++;
                    }
                }
            }
        }
        if (electiveModules >= minElectiveModules && currentElective4kModules >= minElective4kModules) {
            return new Pair<>(true, fulfilledModules);
        } else {
            return new Pair<>(false, fulfilledModules);
        }
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its primaries and electives fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public Pair<Boolean, List<ModuleCode>> isFulfilled(List<ModuleCode> moduleCodes) {
        Pair<Boolean, List<ModuleCode>> primaryFulfilled = arePrimariesFulfilled(moduleCodes);
        Pair<Boolean, List<ModuleCode>> electiveFulfilled = areElectivesFulfilled(moduleCodes);
        List<ModuleCode> fulfilledModules = new ArrayList<>();
        fulfilledModules.addAll(primaryFulfilled.getValue());
        fulfilledModules.addAll(electiveFulfilled.getValue());
        if (primaryFulfilled.getKey() && electiveFulfilled.getKey()) {
            return new Pair<>(true, fulfilledModules);
        }
        return new Pair<>(false, fulfilledModules);
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

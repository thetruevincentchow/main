package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.List;

import seedu.planner.model.graduation.SingleGraduationRequirement;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;

/**
 * Abstract class to represent specialisations for Computer Science Degree Programmes
 */
public abstract class GenericCsSpecialisation extends GenericSpecialisation {

    /**
     * List of {@code ModuleCode} which are valid Primaries for a given Specialisation
     */
    protected List<ModuleCode> primaries;
    /**
     * List of {@code ModuleCode} which are valid Electives for a given Specialisation
     */
    protected List<ModuleCode> electives;

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
        int minModules = 3;
        int minimum4kModules = 1;
        int modules = 0;
        int current4kModules = 0;
        ArrayList<SingleGraduationRequirement> primaryRequirements = new ArrayList<>();
        for (ModuleCode primaries : getPrimaries()) {
            primaryRequirements.add(new SingleGraduationRequirement(primaries));
        }
        for (SingleGraduationRequirement primaryRequirement : primaryRequirements) {
            if (primaryRequirement.isFulfilled(moduleCodes)) {
                modules++;
                ArrayList<Character> valid4kCharacters = new ArrayList<>();
                valid4kCharacters.add('4');
                valid4kCharacters.add('5');
                valid4kCharacters.add('6');
                valid4kCharacters.add('7');
                if (valid4kCharacters.contains(primaryRequirement.getModuleCode().toString().charAt(2))) {
                    current4kModules++;
                }
            }
        }
        return modules >= minModules && current4kModules >= minimum4kModules;
    }

    /**
     * Returns a boolean representing if the {@code GenericCsSpecialisation} has its electives fulfilled,
     * given a list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public boolean areElectivesFulfilled(List<ModuleCode> moduleCodes) {
        int minModules = 0;
        int modules = 0;
        ArrayList<SingleGraduationRequirement> electiveRequirements = new ArrayList<>();
        for (ModuleCode electives : getElectives()) {
            electiveRequirements.add(new SingleGraduationRequirement(electives));
        }
        for (SingleGraduationRequirement electiveRequirement : electiveRequirements) {
            if (electiveRequirement.isFulfilled(moduleCodes)) {
                modules++;
            }
        }
        return modules >= minModules;
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
}

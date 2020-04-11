package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Algorithms and Theory Specialisation for Computer Science Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class AlgorithmsAndTheorySpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Algorithms And Theory";

    /**
     * Default constructor for {@code AlgorithmsAndTheorySpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives
     */
    public AlgorithmsAndTheorySpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS3230"));
        primaries.add(new ModuleCode("CS3236"));
        primaries.add(new ModuleCode("CS4231"));
        primaries.add(new ModuleCode("CS4232"));
        primaries.add(new ModuleCode("CS4234"));

        electives.add(new ModuleCode("CS3233"));
        electives.add(new ModuleCode("CS4257"));
        electives.add(new ModuleCode("CS4261"));
        electives.add(new ModuleCode("CS4268"));
        electives.add(new ModuleCode("CS4269"));
        electives.add(new ModuleCode("CS4330"));
        electives.add(new ModuleCode("CS5230"));
        electives.add(new ModuleCode("CS5234"));
        electives.add(new ModuleCode("CS5236"));
        electives.add(new ModuleCode("CS5237"));
        electives.add(new ModuleCode("CS5238"));
        electives.add(new ModuleCode("CS5330"));
    }

    /**
     * Returns the Name of the specialisation
     *
     * @return The Name of the specialisation
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns the Name of the specialisation
     *
     * @return The Name of the specialisation
     */
    public String toString() {
        return getName();
    }

    /**
     * Returns the hash of the current Specialisation
     * @return Hash of the current Specialisation
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    /**
     * Checks if a given object is the same as the current object
     * @param obj Object to inspected
     * @return boolean True if same, False if different
     */
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}

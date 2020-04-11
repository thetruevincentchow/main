package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Algorithms and Theory Specialisation for Computer Science Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class ComputerGraphicsAndGamesSpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Computer Graphics And Games";
    /**
     * Default constructor for {@code ComputerGraphicsAndGamesSpecialisation} specifying the {@code ModuleCode} for
     * primaries and electives
     */
    public ComputerGraphicsAndGamesSpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS3241"));
        primaries.add(new ModuleCode("CS3242"));
        primaries.add(new ModuleCode("CS3247"));
        primaries.add(new ModuleCode("CS4247"));
        primaries.add(new ModuleCode("CS4350"));

        electives.add(new ModuleCode("CS3218"));
        electives.add(new ModuleCode("CS3240"));
        electives.add(new ModuleCode("CS3249"));
        electives.add(new ModuleCode("CS4240"));
        electives.add(new ModuleCode("CS4243"));
        electives.add(new ModuleCode("CS4249"));
        electives.add(new ModuleCode("CS4351"));
        electives.add(new ModuleCode("CS5237"));
        electives.add(new ModuleCode("CS5240"));
        electives.add(new ModuleCode("CS5343"));
        electives.add(new ModuleCode("CS5346"));
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

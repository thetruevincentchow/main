package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Parallel Computing Systems Specialisation for Computer Science Degree Programme, specifying
 * the primaries and electives which are associated with the specialisation.
 */
public class ParallelComputingSpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Parallel Computing";

    /**
     * Default constructor for {@code ParallelComputingSpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives.
     */
    public ParallelComputingSpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS3210"));
        primaries.add(new ModuleCode("CS3211"));
        primaries.add(new ModuleCode("CS4231"));
        primaries.add(new ModuleCode("CS4223"));

        electives.add(new ModuleCode("CS5222"));
        electives.add(new ModuleCode("CS5223"));
        electives.add(new ModuleCode("CS5224"));
        electives.add(new ModuleCode("CS5239"));
        electives.add(new ModuleCode("CS5250"));
    }

    /**
     * Returns the Name of the specialisation.
     *
     * @return The Name of the specialisation.
     */
    public String getName() {
        return NAME;
    }

    /**
     * Returns the Name of the specialisation.
     *
     * @return The Name of the specialisation.
     */
    public String toString() {
        return getName();
    }

    /**
     * Returns the hash of the current Specialisation.
     *
     * @return Hash of the current Specialisation.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    /**
     * Checks if a given object is the same as the current object.
     *
     * @param obj Object to inspected.
     * @return boolean True if same, False if different.
     */
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

}

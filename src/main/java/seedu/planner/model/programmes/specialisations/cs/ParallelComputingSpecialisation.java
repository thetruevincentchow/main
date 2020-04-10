package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Parallel Computing Systems Specialisation for Computer Science Degree Programme, specifying
 * the primaries and electives which are associated with the specialisation.
 */
public class ParallelComputingSpecialisation extends GenericCsSpecialisation {

    /**
     * Default constructor for {@code ParallelComputingSpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives
     */
    public ParallelComputingSpecialisation() {
        setName("Parallel Computing");
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
     * Returns the Name of the specialisation
     *
     * @return The Name of the specialisation
     */
    public String toString() {
        return this.getName();
    }

}

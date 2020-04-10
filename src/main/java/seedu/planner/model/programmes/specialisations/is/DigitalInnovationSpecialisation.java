package seedu.planner.model.programmes.specialisations.is;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Digital Innovation Specialisation for Information Systems Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class DigitalInnovationSpecialisation extends GenericIsSpecialisation {

    /**
     * Default constructor for {@code DigitalInnovationSpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives
     */
    public DigitalInnovationSpecialisation() {
        setName("Digital Innovation");
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("IS3240"));
        primaries.add(new ModuleCode("IS3251"));
        primaries.add(new ModuleCode("IS4261"));

        electives.add(new ModuleCode("IS3150"));
        electives.add(new ModuleCode("IS3261"));
        electives.add(new ModuleCode("IS4204"));
        electives.add(new ModuleCode("IS4233"));
        electives.add(new ModuleCode("IS4242"));
        electives.add(new ModuleCode("IS4243"));
        electives.add(new ModuleCode("IS5002"));
        electives.add(new ModuleCode("IS5128"));
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

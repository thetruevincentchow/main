package seedu.planner.model.programmes.specialisations.is;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Electronic Commerce Specialisation for Information Systems Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class ElectronicCommerceSpecialisation extends GenericIsSpecialisation {

    /**
     * Default constructor for {@code ElectronicCommerceSpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives
     */
    public ElectronicCommerceSpecialisation() {
        setName("Electronic Commerce");
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("IS3150"));
        primaries.add(new ModuleCode("IS4151"));
        primaries.add(new ModuleCode("IS4261"));

        electives.add(new ModuleCode("IS3240"));
        electives.add(new ModuleCode("IS3261"));
        electives.add(new ModuleCode("IS4228"));
        electives.add(new ModuleCode("IS4231"));
        electives.add(new ModuleCode("IS4242"));
        electives.add(new ModuleCode("IS4243"));
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

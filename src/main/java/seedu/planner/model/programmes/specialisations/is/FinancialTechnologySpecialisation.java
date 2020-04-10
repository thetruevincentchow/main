package seedu.planner.model.programmes.specialisations.is;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Financial Technology Specialisation for Information Systems Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class FinancialTechnologySpecialisation extends GenericIsSpecialisation {

    /**
     * Default constructor for {@code FinancialTechnologySpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives
     */
    public FinancialTechnologySpecialisation() {
        setName("Financial Technology");
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("IS4228"));
        primaries.add(new ModuleCode("IS4302"));
        primaries.add(new ModuleCode("IS4303"));

        electives.add(new ModuleCode("IS3221"));
        electives.add(new ModuleCode("IS4231"));
        electives.add(new ModuleCode("IS4233"));
        electives.add(new ModuleCode("IS4234"));
        electives.add(new ModuleCode("IS4242"));
        electives.add(new ModuleCode("IS4301"));
        electives.add(new ModuleCode("IS5002"));
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

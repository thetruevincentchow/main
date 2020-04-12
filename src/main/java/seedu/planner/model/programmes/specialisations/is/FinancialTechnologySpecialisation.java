package seedu.planner.model.programmes.specialisations.is;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Financial Technology Specialisation for Information Systems Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class FinancialTechnologySpecialisation extends GenericIsSpecialisation {

    public static final String NAME = "Financial Technology";

    /**
     * Default constructor for {@code FinancialTechnologySpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives.
     */
    public FinancialTechnologySpecialisation() {
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
     * Returns the Name of the specialisation.
     *
     * @return The Name of the specialisation.
     */
    public String getName() {
        return name;
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

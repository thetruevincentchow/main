package seedu.planner.model.programmes.specialisations.is;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Digital Innovation Specialisation for Information Systems Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class DigitalInnovationSpecialisation extends GenericIsSpecialisation {

    public static final String NAME = "Digital Innovation";

    /**
     * Default constructor for {@code DigitalInnovationSpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives.
     */
    public DigitalInnovationSpecialisation() {
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

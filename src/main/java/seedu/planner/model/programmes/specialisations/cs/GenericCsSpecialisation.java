package seedu.planner.model.programmes.specialisations.cs;

import java.util.Objects;

import seedu.planner.model.programmes.specialisations.GenericSpecialisation;

/**
 * Abstract class to represent specialisations for Computer Science Degree Programmes
 */
public abstract class GenericCsSpecialisation extends GenericSpecialisation {

    /**
     * Default constructor to set the required criteria for Specialisation Graduation Requirement Fulfilment
     */
    public GenericCsSpecialisation() {
        minPrimaryModules = 3;
        minPrimary4kModules = 1;
        minElectiveModules = 0;
    }

    /**
     * Returns the hash of the current Specialisation
     *
     * @return Hash of the current Specialisation
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    /**
     * Checks if a given object is the same as the current object
     *
     * @param obj Object to inspected
     * @return boolean True if same, False if different
     */
    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
}

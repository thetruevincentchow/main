package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Database Systems Specialisation for Computer Science Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class DatabaseSystemsSpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Database Systems";
    /**
     * Default constructor for {@code DatabaseSystemsSpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives
     */
    public DatabaseSystemsSpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS2102"));
        primaries.add(new ModuleCode("CS3223"));
        primaries.add(new ModuleCode("CS4221"));
        primaries.add(new ModuleCode("CS4224"));
        primaries.add(new ModuleCode("CS4225"));

        electives.add(new ModuleCode("CS4220"));
        electives.add(new ModuleCode("CS5226"));
        electives.add(new ModuleCode("CS5228"));
        electives.add(new ModuleCode("CS5322"));
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

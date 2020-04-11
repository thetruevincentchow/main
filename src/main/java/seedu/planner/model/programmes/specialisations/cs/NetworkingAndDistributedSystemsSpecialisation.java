package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Networking and Distributed Systems Specialisation for Computer Science Degree Programme,
 * specifying the primaries and electives which are associated with the specialisation.
 */
public class NetworkingAndDistributedSystemsSpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Networking and Distributed Systems";
    /**
     * Default constructor for {@code NetworkingAndDistributedSystemsSpecialisation} specifying the {@code ModuleCode}
     * for primaries and electives
     */
    public NetworkingAndDistributedSystemsSpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS2105"));
        primaries.add(new ModuleCode("CS3103"));
        primaries.add(new ModuleCode("CS4222"));
        primaries.add(new ModuleCode("CS4226"));
        primaries.add(new ModuleCode("CS4231"));

        electives.add(new ModuleCode("CS3237"));
        electives.add(new ModuleCode("CS4344"));
        electives.add(new ModuleCode("CS5223"));
        electives.add(new ModuleCode("CS5224"));
        electives.add(new ModuleCode("CS5229"));
        electives.add(new ModuleCode("CS5248"));
        electives.add(new ModuleCode("CS5321"));
    }

    /**
     * Returns the Name of the specialisation
     *
     * @return The Name of the specialisation
     */
    public String getName() {
        return name;
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

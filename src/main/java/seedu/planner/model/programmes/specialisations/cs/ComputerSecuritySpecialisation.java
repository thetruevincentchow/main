package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Computer Security Specialisation for Computer Science Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class ComputerSecuritySpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Computer Security";

    /**
     * Default constructor for {@code ComputerSecuritySpecialisation} specifying the {@code ModuleCode} for primaries
     * and electives.
     */
    public ComputerSecuritySpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS2107"));
        primaries.add(new ModuleCode("CS3235"));
        primaries.add(new ModuleCode("CS4236"));
        primaries.add(new ModuleCode("CS4238"));
        primaries.add(new ModuleCode("CS4239"));

        electives.add(new ModuleCode("CS3221"));
        electives.add(new ModuleCode("CS4257"));
        electives.add(new ModuleCode("CS4276"));
        electives.add(new ModuleCode("CS5231"));
        electives.add(new ModuleCode("CS5250"));
        electives.add(new ModuleCode("CS5321"));
        electives.add(new ModuleCode("CS5322"));
        electives.add(new ModuleCode("CS5331"));
        electives.add(new ModuleCode("CS5332"));
        electives.add(new ModuleCode("IFS4101"));
        electives.add(new ModuleCode("IFS4102"));
        electives.add(new ModuleCode("IFS4103"));
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

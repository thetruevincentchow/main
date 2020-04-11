package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.Objects;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Multimedia Information Retrieval Specialisation for Computer Science Degree Programme,
 * specifying the primaries and electives which are associated with the specialisation.
 */
public class MultimediaInformationRetrievalSpecialisation extends GenericCsSpecialisation {

    public static final String NAME = "Multimedia Information Retrieval";
    /**
     * Default constructor for {@code MultimediaInformationRetrievalSpecialisation} specifying the {@code ModuleCode}
     * for primaries and electives
     */
    public MultimediaInformationRetrievalSpecialisation() {
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS2108"));
        primaries.add(new ModuleCode("CS3245"));
        primaries.add(new ModuleCode("CS4242"));
        primaries.add(new ModuleCode("CS4248"));
        primaries.add(new ModuleCode("CS4347"));

        electives.add(new ModuleCode("CS5246"));
        electives.add(new ModuleCode("CS5241"));
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

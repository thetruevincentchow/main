package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Artificial Intelligence Specialisation for Computer Science Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class ArtificialIntelligenceSpecialisation extends GenericCsSpecialisation {

    /**
     * Default constructor for {@code ArtificialIntelligenceSpecialisation} specifying the {@code ModuleCode} for
     * primaries and electives
     */
    public ArtificialIntelligenceSpecialisation() {
        setName("Artificial Intelligence");
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS3243"));
        primaries.add(new ModuleCode("CS3244"));
        primaries.add(new ModuleCode("CS4243"));
        primaries.add(new ModuleCode("CS4244"));
        primaries.add(new ModuleCode("CS4246"));
        primaries.add(new ModuleCode("CS4248"));

        electives.add(new ModuleCode("CS4220"));
        electives.add(new ModuleCode("CS4261"));
        electives.add(new ModuleCode("CS4269"));
        electives.add(new ModuleCode("CS4277"));
        electives.add(new ModuleCode("CS4278"));
        electives.add(new ModuleCode("CS5215"));
        electives.add(new ModuleCode("CS5228"));
        electives.add(new ModuleCode("CS5242"));
        electives.add(new ModuleCode("CS5260"));
        electives.add(new ModuleCode("CS5340"));
        electives.add(new ModuleCode("CS5339"));
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

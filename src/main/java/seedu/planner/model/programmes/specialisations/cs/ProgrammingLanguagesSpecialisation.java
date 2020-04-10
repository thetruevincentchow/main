package seedu.planner.model.programmes.specialisations.cs;

import java.util.ArrayList;

import seedu.planner.model.module.ModuleCode;

/**
 * Class to represent the Programming Languages Specialisation for Computer Science Degree Programme, specifying the
 * primaries and electives which are associated with the specialisation.
 */
public class ProgrammingLanguagesSpecialisation extends GenericCsSpecialisation {

    /**
     * Default constructor for {@code ProgrammingLanguagesSpecialisation} specifying the {@code ModuleCode} for
     * primaries and electives
     */
    public ProgrammingLanguagesSpecialisation() {
        setName("Programming Languages");
        primaries = new ArrayList<>();
        electives = new ArrayList<>();

        primaries.add(new ModuleCode("CS2104"));
        primaries.add(new ModuleCode("CS3211"));
        primaries.add(new ModuleCode("CS4212"));
        primaries.add(new ModuleCode("CS4215"));

        electives.add(new ModuleCode("CS3234"));
        electives.add(new ModuleCode("CS4216"));
        electives.add(new ModuleCode("CS5232"));
        electives.add(new ModuleCode("CS5214"));
        electives.add(new ModuleCode("CS5215"));
        electives.add(new ModuleCode("CS5218"));
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

package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class ProgrammingLanguagesSpecialisationTest {
    @Test
    public void testEqual() {
        ProgrammingLanguagesSpecialisation specialisation = new ProgrammingLanguagesSpecialisation();
        assertEquals(specialisation, new ProgrammingLanguagesSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        ProgrammingLanguagesSpecialisation specialisation = new ProgrammingLanguagesSpecialisation();
        specialisation.setName("Programming Languages");
        assertEquals(specialisation, new ProgrammingLanguagesSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        ProgrammingLanguagesSpecialisation specialisation = new ProgrammingLanguagesSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new ProgrammingLanguagesSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Programming Languages");
        assertNotEquals(specialisation, new ProgrammingLanguagesSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        ProgrammingLanguagesSpecialisation specialisation = new ProgrammingLanguagesSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS2104"),
                new ModuleCode("CS3211"),
                new ModuleCode("CS4212"),
                new ModuleCode("CS4215")
        )));
    }

    @Test
    public void testElectives_equal() {
        ProgrammingLanguagesSpecialisation specialisation = new ProgrammingLanguagesSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3234"),
                new ModuleCode("CS4216"),
                new ModuleCode("CS5232"),
                new ModuleCode("CS5214"),
                new ModuleCode("CS5215"),
                new ModuleCode("CS5218")
        )));
    }
}

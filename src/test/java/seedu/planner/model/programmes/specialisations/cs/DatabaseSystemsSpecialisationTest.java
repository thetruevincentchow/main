package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class DatabaseSystemsSpecialisationTest {
    @Test
    public void testEqual() {
        DatabaseSystemsSpecialisation specialisation = new DatabaseSystemsSpecialisation();
        assertEquals(specialisation, new DatabaseSystemsSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        DatabaseSystemsSpecialisation specialisation = new DatabaseSystemsSpecialisation();
        specialisation.setName("Database Systems");
        assertEquals(specialisation, new DatabaseSystemsSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        DatabaseSystemsSpecialisation specialisation = new DatabaseSystemsSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new DatabaseSystemsSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Database Systems");
        assertNotEquals(specialisation, new DatabaseSystemsSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        DatabaseSystemsSpecialisation specialisation = new DatabaseSystemsSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS2102"),
                new ModuleCode("CS3223"),
                new ModuleCode("CS4221"),
                new ModuleCode("CS4224"),
                new ModuleCode("CS4225")
        )));
    }

    @Test
    public void testElectives_equal() {
        DatabaseSystemsSpecialisation specialisation = new DatabaseSystemsSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS4220"),
                new ModuleCode("CS5226"),
                new ModuleCode("CS5228"),
                new ModuleCode("CS5322")
        )));
    }
}

package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class ComputerGraphicsAndGamesSpecialisationTest {
    @Test
    public void testEqual() {
        ComputerGraphicsAndGamesSpecialisation specialisation = new ComputerGraphicsAndGamesSpecialisation();
        assertEquals(specialisation, new ComputerGraphicsAndGamesSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        ComputerGraphicsAndGamesSpecialisation specialisation = new ComputerGraphicsAndGamesSpecialisation();
        specialisation.setName("Computer Graphics And Games");
        assertEquals(specialisation, new ComputerGraphicsAndGamesSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        ComputerGraphicsAndGamesSpecialisation specialisation = new ComputerGraphicsAndGamesSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new ComputerGraphicsAndGamesSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Computer Graphics And Games");
        assertNotEquals(specialisation, new ComputerGraphicsAndGamesSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        ComputerGraphicsAndGamesSpecialisation specialisation = new ComputerGraphicsAndGamesSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3241"),
                new ModuleCode("CS3242"),
                new ModuleCode("CS3247"),
                new ModuleCode("CS4247"),
                new ModuleCode("CS4350")
        )));
    }

    @Test
    public void testElectives_equal() {
        ComputerGraphicsAndGamesSpecialisation specialisation = new ComputerGraphicsAndGamesSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3218"),
                new ModuleCode("CS3240"),
                new ModuleCode("CS3249"),
                new ModuleCode("CS4240"),
                new ModuleCode("CS4243"),
                new ModuleCode("CS4249"),
                new ModuleCode("CS4351"),
                new ModuleCode("CS5237"),
                new ModuleCode("CS5240"),
                new ModuleCode("CS5343"),
                new ModuleCode("CS5346")
        )));
    }
}

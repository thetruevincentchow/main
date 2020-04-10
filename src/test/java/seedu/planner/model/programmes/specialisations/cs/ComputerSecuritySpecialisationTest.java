package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class ComputerSecuritySpecialisationTest {
    @Test
    public void testEqual() {
        ComputerSecuritySpecialisation specialisation = new ComputerSecuritySpecialisation();
        assertEquals(specialisation, new ComputerSecuritySpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        ComputerSecuritySpecialisation specialisation = new ComputerSecuritySpecialisation();
        specialisation.setName("Computer Security");
        assertEquals(specialisation, new ComputerSecuritySpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        ComputerSecuritySpecialisation specialisation = new ComputerSecuritySpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new ComputerSecuritySpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Computer Security");
        assertNotEquals(specialisation, new ComputerSecuritySpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        ComputerSecuritySpecialisation specialisation = new ComputerSecuritySpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS2107"),
                new ModuleCode("CS3235"),
                new ModuleCode("CS4236"),
                new ModuleCode("CS4238"),
                new ModuleCode("CS4239")
        )));
    }

    @Test
    public void testElectives_equal() {
        ComputerSecuritySpecialisation specialisation = new ComputerSecuritySpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3221"),
                new ModuleCode("CS4257"),
                new ModuleCode("CS4276"),
                new ModuleCode("CS5231"),
                new ModuleCode("CS5250"),
                new ModuleCode("CS5321"),
                new ModuleCode("CS5322"),
                new ModuleCode("CS5331"),
                new ModuleCode("CS5332"),
                new ModuleCode("IFS4101"),
                new ModuleCode("IFS4102"),
                new ModuleCode("IFS4103")
        )));
    }
}

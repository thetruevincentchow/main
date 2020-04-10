package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class SoftwareEngineeringSpecialisationTest {
    @Test
    public void testEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        assertEquals(specialisation, new SoftwareEngineeringSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Software Engineering");
        assertEquals(specialisation, new SoftwareEngineeringSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new SoftwareEngineeringSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        ParallelComputingSpecialisation specialisation = new ParallelComputingSpecialisation();
        specialisation.setName("Software Engineering");
        assertNotEquals(specialisation, new SoftwareEngineeringSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS2103T"),
                new ModuleCode("CS3219"),
                new ModuleCode("CS4211"),
                new ModuleCode("CS4218"),
                new ModuleCode("CS4239")
        )));
    }

    @Test
    public void testElectives_equal() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3216"),
                new ModuleCode("CS3217"),
                new ModuleCode("CS3226"),
                new ModuleCode("CS3234"),
                new ModuleCode("CS5219"),
                new ModuleCode("CS5232"),
                new ModuleCode("CS5272")
        )));
    }
}

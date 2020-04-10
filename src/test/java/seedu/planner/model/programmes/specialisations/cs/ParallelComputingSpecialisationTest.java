package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class ParallelComputingSpecialisationTest {

    @Test
    public void testEqual() {
        ParallelComputingSpecialisation specialisation = new ParallelComputingSpecialisation();
        assertEquals(specialisation, new ParallelComputingSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        ParallelComputingSpecialisation specialisation = new ParallelComputingSpecialisation();
        specialisation.setName("Parallel Computing");
        assertEquals(specialisation, new ParallelComputingSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        ParallelComputingSpecialisation specialisation = new ParallelComputingSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new ParallelComputingSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Parallel Computing");
        assertNotEquals(specialisation, new ParallelComputingSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        ParallelComputingSpecialisation specialisation = new ParallelComputingSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3210"),
                new ModuleCode("CS3211"),
                new ModuleCode("CS4231"),
                new ModuleCode("CS4223")
        )));
    }

    @Test
    public void testElectives_equal() {
        ParallelComputingSpecialisation specialisation = new ParallelComputingSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS5222"),
                new ModuleCode("CS5223"),
                new ModuleCode("CS5224"),
                new ModuleCode("CS5239"),
                new ModuleCode("CS5250")
        )));
    }
}

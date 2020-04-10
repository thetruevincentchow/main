package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class AlgorithmsAndTheorySpecialisationTest {


    @Test
    public void testEqual() {
        AlgorithmsAndTheorySpecialisation specialisation = new AlgorithmsAndTheorySpecialisation();
        assertEquals(specialisation, new AlgorithmsAndTheorySpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        AlgorithmsAndTheorySpecialisation specialisation = new AlgorithmsAndTheorySpecialisation();
        specialisation.setName("Algorithms And Theory");
        assertEquals(specialisation, new AlgorithmsAndTheorySpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        AlgorithmsAndTheorySpecialisation specialisation = new AlgorithmsAndTheorySpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new AlgorithmsAndTheorySpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Algorithms And Theory");
        assertNotEquals(specialisation, new AlgorithmsAndTheorySpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        AlgorithmsAndTheorySpecialisation specialisation = new AlgorithmsAndTheorySpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3230"),
                new ModuleCode("CS3236"),
                new ModuleCode("CS4231"),
                new ModuleCode("CS4232"),
                new ModuleCode("CS4234")
        )));
    }

    @Test
    public void testElectives_equal() {
        AlgorithmsAndTheorySpecialisation specialisation = new AlgorithmsAndTheorySpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3233"),
                new ModuleCode("CS4257"),
                new ModuleCode("CS4261"),
                new ModuleCode("CS4268"),
                new ModuleCode("CS4269"),
                new ModuleCode("CS4330"),
                new ModuleCode("CS5230"),
                new ModuleCode("CS5234"),
                new ModuleCode("CS5236"),
                new ModuleCode("CS5237"),
                new ModuleCode("CS5238"),
                new ModuleCode("CS5330")
        )));
    }
}

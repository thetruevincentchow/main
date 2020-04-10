package seedu.planner.model.programmes.specialisations.is;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.cs.SoftwareEngineeringSpecialisation;

class DigitalInnovationSpecialisationTest {
    @Test
    public void testEqual() {
        DigitalInnovationSpecialisation specialisation = new DigitalInnovationSpecialisation();
        assertEquals(specialisation, new DigitalInnovationSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        DigitalInnovationSpecialisation specialisation = new DigitalInnovationSpecialisation();
        specialisation.setName("Digital Innovation");
        assertEquals(specialisation, new DigitalInnovationSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        DigitalInnovationSpecialisation specialisation = new DigitalInnovationSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new DigitalInnovationSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Digital Innovation");
        assertNotEquals(specialisation, new DigitalInnovationSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        DigitalInnovationSpecialisation specialisation = new DigitalInnovationSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("IS3240"),
                new ModuleCode("IS3251"),
                new ModuleCode("IS4261")
        )));
    }

    @Test
    public void testElectives_equal() {
        DigitalInnovationSpecialisation specialisation = new DigitalInnovationSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("IS3150"),
                new ModuleCode("IS3261"),
                new ModuleCode("IS4204"),
                new ModuleCode("IS4233"),
                new ModuleCode("IS4242"),
                new ModuleCode("IS4243"),
                new ModuleCode("IS5002"),
                new ModuleCode("IS5128")
        )));
    }
}

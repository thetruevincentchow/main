package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class ArtificialIntelligenceSpecialisationTest {
    @Test
    public void testEqual() {
        ArtificialIntelligenceSpecialisation specialisation = new ArtificialIntelligenceSpecialisation();
        assertEquals(specialisation, new ArtificialIntelligenceSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        ArtificialIntelligenceSpecialisation specialisation = new ArtificialIntelligenceSpecialisation();
        specialisation.setName("Artificial Intelligence");
        assertEquals(specialisation, new ArtificialIntelligenceSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        ArtificialIntelligenceSpecialisation specialisation = new ArtificialIntelligenceSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new ArtificialIntelligenceSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Artificial Intelligence");
        assertNotEquals(specialisation, new ArtificialIntelligenceSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        ArtificialIntelligenceSpecialisation specialisation = new ArtificialIntelligenceSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3243"),
                new ModuleCode("CS3244"),
                new ModuleCode("CS4243"),
                new ModuleCode("CS4244"),
                new ModuleCode("CS4246"),
                new ModuleCode("CS4248")
        )));
    }

    @Test
    public void testElectives_equal() {
        ArtificialIntelligenceSpecialisation specialisation = new ArtificialIntelligenceSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS4220"),
                new ModuleCode("CS4261"),
                new ModuleCode("CS4269"),
                new ModuleCode("CS4277"),
                new ModuleCode("CS4278"),
                new ModuleCode("CS5215"),
                new ModuleCode("CS5228"),
                new ModuleCode("CS5242"),
                new ModuleCode("CS5260"),
                new ModuleCode("CS5340"),
                new ModuleCode("CS5339")
        )));
    }
}

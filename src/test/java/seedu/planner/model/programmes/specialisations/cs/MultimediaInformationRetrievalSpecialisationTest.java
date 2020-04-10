package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class MultimediaInformationRetrievalSpecialisationTest {
    @Test
    public void testEqual() {
        MultimediaInformationRetrievalSpecialisation specialisation =
                new MultimediaInformationRetrievalSpecialisation();
        assertEquals(specialisation, new MultimediaInformationRetrievalSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        MultimediaInformationRetrievalSpecialisation specialisation =
                new MultimediaInformationRetrievalSpecialisation();
        specialisation.setName("Multimedia Information Retrieval");
        assertEquals(specialisation, new MultimediaInformationRetrievalSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        MultimediaInformationRetrievalSpecialisation specialisation =
                new MultimediaInformationRetrievalSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new MultimediaInformationRetrievalSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Multimedia Information Retrieval");
        assertNotEquals(specialisation, new MultimediaInformationRetrievalSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        MultimediaInformationRetrievalSpecialisation specialisation =
                new MultimediaInformationRetrievalSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS2108"),
                new ModuleCode("CS3245"),
                new ModuleCode("CS4242"),
                new ModuleCode("CS4248"),
                new ModuleCode("CS4347")
        )));
    }

    @Test
    public void testElectives_equal() {
        MultimediaInformationRetrievalSpecialisation specialisation =
                new MultimediaInformationRetrievalSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS5246"),
                new ModuleCode("CS5241")
        )));
    }
}

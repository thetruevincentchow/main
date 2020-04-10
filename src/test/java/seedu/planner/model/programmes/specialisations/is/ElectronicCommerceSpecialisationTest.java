package seedu.planner.model.programmes.specialisations.is;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.cs.SoftwareEngineeringSpecialisation;

class ElectronicCommerceSpecialisationTest {
    @Test
    public void testEqual() {
        ElectronicCommerceSpecialisation specialisation = new ElectronicCommerceSpecialisation();
        assertEquals(specialisation, new ElectronicCommerceSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        ElectronicCommerceSpecialisation specialisation = new ElectronicCommerceSpecialisation();
        specialisation.setName("Electronic Commerce");
        assertEquals(specialisation, new ElectronicCommerceSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        ElectronicCommerceSpecialisation specialisation = new ElectronicCommerceSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new ElectronicCommerceSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Electronic Commerce");
        assertNotEquals(specialisation, new ElectronicCommerceSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        ElectronicCommerceSpecialisation specialisation = new ElectronicCommerceSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("IS3150"),
                new ModuleCode("IS4151"),
                new ModuleCode("IS4261")
        )));
    }

    @Test
    public void testElectives_equal() {
        ElectronicCommerceSpecialisation specialisation = new ElectronicCommerceSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("IS3240"),
                new ModuleCode("IS3261"),
                new ModuleCode("IS4228"),
                new ModuleCode("IS4231"),
                new ModuleCode("IS4242"),
                new ModuleCode("IS4243")
        )));
    }
}

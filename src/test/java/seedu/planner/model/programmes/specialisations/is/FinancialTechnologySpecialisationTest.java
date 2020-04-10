package seedu.planner.model.programmes.specialisations.is;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.cs.SoftwareEngineeringSpecialisation;

class FinancialTechnologySpecialisationTest {
    @Test
    public void testEqual() {
        FinancialTechnologySpecialisation specialisation = new FinancialTechnologySpecialisation();
        assertEquals(specialisation, new FinancialTechnologySpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        FinancialTechnologySpecialisation specialisation = new FinancialTechnologySpecialisation();
        specialisation.setName("Financial Technology");
        assertEquals(specialisation, new FinancialTechnologySpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        FinancialTechnologySpecialisation specialisation = new FinancialTechnologySpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new FinancialTechnologySpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Financial Technology");
        assertNotEquals(specialisation, new FinancialTechnologySpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        FinancialTechnologySpecialisation specialisation = new FinancialTechnologySpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("IS4228"),
                new ModuleCode("IS4302"),
                new ModuleCode("IS4303")
        )));
    }

    @Test
    public void testElectives_equal() {
        FinancialTechnologySpecialisation specialisation = new FinancialTechnologySpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("IS3221"),
                new ModuleCode("IS4231"),
                new ModuleCode("IS4233"),
                new ModuleCode("IS4234"),
                new ModuleCode("IS4242"),
                new ModuleCode("IS4301"),
                new ModuleCode("IS5002")
        )));
    }
}

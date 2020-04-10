package seedu.planner.model.programmes.specialisations.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.model.module.ModuleCode;

class NetworkingAndDistributedSystemsSpecialisationTest {
    @Test
    public void testEqual() {
        NetworkingAndDistributedSystemsSpecialisation specialisation =
                new NetworkingAndDistributedSystemsSpecialisation();
        assertEquals(specialisation, new NetworkingAndDistributedSystemsSpecialisation());
    }

    @Test
    public void testSameNameSameClassEqual() {
        NetworkingAndDistributedSystemsSpecialisation specialisation =
                new NetworkingAndDistributedSystemsSpecialisation();
        specialisation.setName("Networking and Distributed Systems");
        assertEquals(specialisation, new NetworkingAndDistributedSystemsSpecialisation());
    }

    @Test
    public void testDifferentNameSameClassEqual() {
        NetworkingAndDistributedSystemsSpecialisation specialisation =
                new NetworkingAndDistributedSystemsSpecialisation();
        specialisation.setName("Different Name");
        assertEquals(specialisation, new NetworkingAndDistributedSystemsSpecialisation());
    }

    @Test
    public void testSameNameDifferentClassNotEqual() {
        SoftwareEngineeringSpecialisation specialisation = new SoftwareEngineeringSpecialisation();
        specialisation.setName("Networking and Distributed Systems");
        assertNotEquals(specialisation, new NetworkingAndDistributedSystemsSpecialisation());
    }

    @Test
    public void testPrimaries_equal() {
        NetworkingAndDistributedSystemsSpecialisation specialisation =
                new NetworkingAndDistributedSystemsSpecialisation();
        assertEquals(specialisation.getPrimaries(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS2105"),
                new ModuleCode("CS3103"),
                new ModuleCode("CS4222"),
                new ModuleCode("CS4226"),
                new ModuleCode("CS4231")
        )));
    }

    @Test
    public void testElectives_equal() {
        NetworkingAndDistributedSystemsSpecialisation specialisation =
                new NetworkingAndDistributedSystemsSpecialisation();
        assertEquals(specialisation.getElectives(), new ArrayList<>(Arrays.asList(
                new ModuleCode("CS3237"),
                new ModuleCode("CS4344"),
                new ModuleCode("CS5223"),
                new ModuleCode("CS5224"),
                new ModuleCode("CS5229"),
                new ModuleCode("CS5248"),
                new ModuleCode("CS5321")
        )));
    }
}

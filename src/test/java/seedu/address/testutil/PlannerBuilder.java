package seedu.address.testutil;

import seedu.address.model.Planner;

/**
 * A utility class to help with building Planner objects.
 * Example usage: <br>
 * {@code Planner ab = new PlannerBuilder().withModule("CS2103T"").build();}
 */
public class PlannerBuilder {

    private Planner planner;

    public PlannerBuilder() {
        planner = new Planner();
    }

    public PlannerBuilder(Planner planner) {
        this.planner = planner;
    }

    public Planner build() {
        return planner;
    }
}

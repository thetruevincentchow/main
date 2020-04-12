package seedu.planner.testutil;

import seedu.planner.model.Planner;
import seedu.planner.model.module.Module;
import seedu.planner.model.student.Student;

/**
 * A utility class to help with building Planner objects.
 * Example usage: <br>
 * {@code Planner ab = new PlannerBuilder().withModule("CS2103T").build();}
 */
public class PlannerBuilder {

    private Planner planner;

    public PlannerBuilder() {
        planner = new Planner();
    }

    public PlannerBuilder(Planner planner) {
        this.planner = planner;
    }

    /**
     * Adds a {@code Student} to the {@code Planner} that we are building.
     */
    public PlannerBuilder withStudent(Student student) {
        this.planner.addStudent(student);
        return this;
    }

    /**
     * Adds a {@code Module} to the {@code Planner} that we are building.
     */
    public PlannerBuilder withModule(Module module) {
        this.planner.addModule(module);
        return this;
    }


    public Planner build() {
        return planner;
    }
}

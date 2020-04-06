package seedu.planner.testutil;

import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;

/**
 * A utility class to help with building Person objects.
 */
public class ModuleBuilder {

    public static final String DEFAULT_CODE = "CS2103T";

    private ModuleCode moduleCode;

    public ModuleBuilder() {
        moduleCode = new ModuleCode(DEFAULT_CODE);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public ModuleBuilder(Module moduleToCopy) {
        moduleCode = moduleToCopy.getModuleCode();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public ModuleBuilder withModuleCode(ModuleCode moduleCode) {
        this.moduleCode = moduleCode;
        return this;
    }

    public Module build() {
        return new Module(moduleCode);
    }

}

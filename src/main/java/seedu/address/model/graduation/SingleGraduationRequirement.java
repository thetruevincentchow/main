package seedu.address.model.graduation;

import seedu.address.model.module.ModuleCode;

public class SingleGraduationRequirement extends GraduationRequirement {

    public SingleGraduationRequirement(ModuleCode moduleCode) {

    }
    public boolean isFulfilled() {
        return true;
    }
}

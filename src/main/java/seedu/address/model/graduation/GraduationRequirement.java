package seedu.address.model.graduation;

import java.util.List;

import seedu.address.model.module.ModuleCode;

public abstract class GraduationRequirement {

    protected ModuleCode moduleCode;

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);

    protected String getStatusIcon(boolean done) {
        return done ? "Y" : "X";
    }

    @Override
    public String toString() {
        return moduleCode.toString();
    }


    public String getString(List<ModuleCode> moduleCodes) {
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + moduleCode.toString();
    }
}

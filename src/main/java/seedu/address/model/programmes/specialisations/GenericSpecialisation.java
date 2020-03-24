package seedu.address.model.programmes.specialisations;

import seedu.address.model.graduation.GraduationRequirement;
import seedu.address.model.module.ModuleCode;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericSpecialisation {

    public String name;

    protected List<GraduationRequirement> graduationRequirements = new ArrayList<>();

    public List<GraduationRequirement> getGraduationRequirements() {
        return graduationRequirements;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);

    public String toString() {
        return name;
    }
}

package seedu.address.model.programmes.specialisations;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.graduation.GraduationRequirement;
import seedu.address.model.module.ModuleCode;

public abstract class GenericSpecialisation {

    protected String name;

    protected List<GraduationRequirement> graduationRequirements = new ArrayList<>();

    public List<GraduationRequirement> getGraduationRequirements() {
        return graduationRequirements;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);

    public String toString() {
        return name;
    }
}

package seedu.address.model.programmes;

import seedu.address.model.Graduation.GraduationRequirement;

import java.util.List;

public abstract class Programme {
    protected String name;
    protected List<GraduationRequirement> graduationRequirementList;

    public String getName() {
        return name;
    }

    public abstract boolean isFulfilled();
}

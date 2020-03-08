package seedu.address.model.graduation;

import static seedu.address.model.graduation.AggregationType.ALL;

import java.util.List;

public class CompoundGraduationRequirement extends GraduationRequirement {

    protected AggregationType aggregationType;
    protected String name;
    protected int minMCs;
    protected List<GraduationRequirement> graduationRequirementList;

    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements) {
        this.name = name;
        this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        aggregationType = ALL;

    }

    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements,
                                         AggregationType aggregationType) {
        this.name = name;
        this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        this.aggregationType = aggregationType;

    }
    public boolean isFulfilled() {
        return true;
    }
}

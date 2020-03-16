package seedu.address.model.graduation;

import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

import static seedu.address.model.graduation.AggregationType.ALL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompoundGraduationRequirement extends GraduationRequirement {

    protected AggregationType aggregationType;
    protected String name;
    // protected int minMCs;
    protected List<GraduationRequirement> graduationRequirementList = new ArrayList<>();

    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements) {
        this.name = name;
        // this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        aggregationType = ALL;
    }

    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements,
                                         AggregationType aggregationType) {
        this.name = name;
        // this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        this.aggregationType = aggregationType;
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        if (graduationRequirementList == null) {
            return false;
        }
        switch (aggregationType) {
        case ANY:
            for (GraduationRequirement requirement : graduationRequirementList) {
                if (requirement.isFulfilled(moduleCodes)) {
                    return true;
                }
            }
            return false;
        case ALL:
            for (GraduationRequirement requirement : graduationRequirementList) {
                if (!requirement.isFulfilled(moduleCodes)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public String getString(List<ModuleCode> moduleCodes) {
        StringBuilder sb = new StringBuilder();
        String buffer;
        sb.append("[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + name + "\n");
        if (graduationRequirementList != null) {
            Iterator<GraduationRequirement> iterator = graduationRequirementList.iterator();
            while (iterator.hasNext()) {
                buffer = iterator.next().getString(moduleCodes);
                for (String line : buffer.split("\n")) {
                    sb.append("    " + line + "\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String buffer;
        sb.append("[X] " + name + "\n");
        if (graduationRequirementList != null) {
            Iterator<GraduationRequirement> iterator = graduationRequirementList.iterator();
            while (iterator.hasNext()) {
                buffer = iterator.next().toString();
                for (String line : buffer.split("\n")) {
                    sb.append("    " + line + "\n");
                }
            }
        }
        return sb.toString();
    }
}

package seedu.planner.model.programmes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import seedu.planner.model.graduation.CompoundGraduationRequirement;
import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;

/**
 * Abstract class to represent the Programme a Student is required to undergo in his/her course of study
 */
public abstract class Programme {
    protected String name;
    protected List<GraduationRequirement> graduationRequirementList;

    public String getName() {
        return name;
    }

    public List<GraduationRequirement> getGraduationRequirementList() {
        return graduationRequirementList;
    }

    public List<GraduationRequirement> getTerminalGraduationRequirementList() {
        List<GraduationRequirement> terminalGraduationRequirementList = new ArrayList<>();
        LinkedList<GraduationRequirement> buffer = new LinkedList<>(graduationRequirementList);
        while (!buffer.isEmpty()) {
            GraduationRequirement graduationRequirement = buffer.removeFirst();
            if (graduationRequirement instanceof CompoundGraduationRequirement) {
                List<GraduationRequirement> childGraduationRequirements = ((CompoundGraduationRequirement)
                    graduationRequirement).getGraduationRequirementList();
                if (childGraduationRequirements != null) {
                    buffer.addAll(childGraduationRequirements);
                }
            } else {
                terminalGraduationRequirementList.add(graduationRequirement);
            }
        }
        return terminalGraduationRequirementList;
    }

    public abstract boolean isFulfilled(List<ModuleCode> moduleCodes);
}

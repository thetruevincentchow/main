package seedu.planner.commons;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Student;

public class GraduationRequirementUtil {

    public static String getString(Student student) {
        List<GraduationRequirement> graduationRequirementList = student.getMajor().getGraduationRequirements();
        StringBuilder sb = new StringBuilder();
        List<ModuleCode> modulesFulfilled = student.getAllFulfilledModules();
        List<ModuleCode> modulesUsed = new ArrayList<>();
        Pair<Boolean, List<ModuleCode>> pair;
        for (GraduationRequirement graduationRequirement : graduationRequirementList) {
            pair = graduationRequirement.isFulfilled(modulesFulfilled);
            sb.append(graduationRequirement.getString(modulesFulfilled));
            modulesFulfilled.removeAll(pair.getValue());
            modulesUsed.addAll(pair.getValue());
        }
        return sb.toString();
    }
}

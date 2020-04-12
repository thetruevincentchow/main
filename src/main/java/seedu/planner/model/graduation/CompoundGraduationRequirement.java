package seedu.planner.model.graduation;

import static seedu.planner.model.graduation.AggregationType.ALL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.util.Pair;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.util.ModuleUtil;

/**
 * Class that implements {@code GraduationRequirement}, consisting of multiple other {@code GraduationRequirement}
 * classes. Has an {@code AggregationType} to determine if it has fulfilled requirements.
 */
public class CompoundGraduationRequirement extends GraduationRequirement {

    /**
     * Enum Aggregation Type.
     */
    protected AggregationType aggregationType;
    /**
     * Name of {@code CompoundAggregationType}.
     */
    protected String name;
    /**
     * Minimum number of ModuleCredits, applicable only when {@code AggregationType} is AT_LEAST_MC.
     */
    protected int minMCs;
    /**
     * List of {@code GraduationRequirement}.
     */
    protected List<GraduationRequirement> graduationRequirementList = new ArrayList<>();

    /**
     * Default constructor for {@code CompoundGraduationRequirement}.
     *
     * @param name         String label for {@code CompoundGraduationRequirement}.
     * @param minMCs       Minimum number of ModuleCredits, applicable only when {@code AggregationType} is AT_LEAST_MC.
     * @param requirements List of {@code GraduationRequirement}.
     */
    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements) {
        this.name = name;
        this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        aggregationType = ALL;
    }

    /**
     * Constructor for {@code CompoundGraduationRequirement}.
     *
     * @param name            String label for {@code CompoundGraduationRequirement}.
     * @param minMCs          Minimum number of ModuleCredits, applicable only when {@code AggregationType} is
     *                        AT_LEAST_MC.
     * @param requirements    List of {@code GraduationRequirement}.
     * @param aggregationType Aggregation Type to determine if the @code CompoundGraduationRequirement} is fulfilled.
     */
    public CompoundGraduationRequirement(String name, int minMCs, List<GraduationRequirement> requirements,
                                         AggregationType aggregationType) {
        this.name = name;
        this.minMCs = minMCs;
        this.graduationRequirementList = requirements;
        this.aggregationType = aggregationType;
    }

    /**
     * Returns list of {@code GradudationRequirement}.
     *
     * @return List of {@code GradudationRequirement}.
     */
    public List<GraduationRequirement> getGraduationRequirementList() {
        return graduationRequirementList;
    }

    /**
     * Returns a boolean representing if the {@code CompoundGraduationRequirement} is fulfilled, given a list of
     * {@code ModuleCode}.
     *
     * @param moduleCodes List of {@code ModuleCode}.
     * @return True if fulfilled. False otherwise.
     */
    public Pair<Boolean, List<ModuleCode>> isFulfilled(List<ModuleCode> moduleCodes) {
        if (graduationRequirementList == null) {
            return new Pair<>(false, null);
        }
        Pair<Boolean, List<ModuleCode>> pair = new Pair<>(false, null);
        List<ModuleCode> fulfilledModules = new ArrayList<>();
        switch (aggregationType) {
        case ANY:
            for (GraduationRequirement requirement : graduationRequirementList) {
                pair = requirement.isFulfilled(moduleCodes);
                if (pair.getKey()) {
                    return pair;
                }
            }
            return pair;
        case ALL:
            for (GraduationRequirement requirement : graduationRequirementList) {
                pair = requirement.isFulfilled(moduleCodes);
                if (pair.getKey()) {
                    fulfilledModules.addAll(pair.getValue());
                } else {
                    return new Pair<>(false, fulfilledModules);
                }
            }
            return new Pair<>(true, fulfilledModules);
        case AT_LEAST_MC:
            int currentMc = 0;
            for (GraduationRequirement requirement : graduationRequirementList) {
                pair = requirement.isFulfilled(moduleCodes);
                if (pair.getKey()) {
                    try {
                        fulfilledModules.addAll(pair.getValue());
                        for (ModuleCode moduleCode : pair.getValue()) {
                            Module module = ModuleUtil.getModuleWithCode(moduleCode);
                            if (module != null) {
                                currentMc += module.getModuleCredit();
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error finding modules");
                    }
                }
            }
            if (currentMc >= minMCs) {
                return new Pair<>(true, fulfilledModules);
            }
            return new Pair<>(false, fulfilledModules);
        default:
            return pair;
        }
    }

    /**
     * Returns a String representation of the {@code CompoundGraduationRequirement} object, along with it's child
     * {@code GraduationRequirement}s.
     *
     * @param moduleCodes List of {@code ModuleCode}.
     * @return A String representation of the {@code CompoundGraduationRequirement} object, along with it's child.
     */
    public String getString(List<ModuleCode> moduleCodes) {
        StringBuilder sb = new StringBuilder();
        String buffer;
        sb.append("[")
                .append(getStatusIcon(isFulfilled(moduleCodes).getKey()))
                .append("] [")
                .append(aggregationType.getAggregationType(minMCs))
                .append("] ")
                .append(name)
                .append("\n");
        if (graduationRequirementList != null) {
            Iterator<GraduationRequirement> iterator = graduationRequirementList.iterator();
            while (iterator.hasNext()) {
                buffer = iterator.next().getString(moduleCodes);
                for (String line : buffer.split("\n")) {
                    sb.append("    ").append(line).append("\n");
                }
            }
        }
        return sb.toString();
    }

    /**
     * Method to override the default {@code toString} function of {@code FocusAreaGraduationRequirement}.
     *
     * @return String representation of {@code FocusAreaGraduationRequirement}.
     */
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

package seedu.planner.model.graduation;

import java.util.List;

import javafx.util.Pair;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.util.ModuleUtil;

/**
 * Class that implements {@code GraduationRequirement} to determine if it has fulfilled requirements
 */

public class UnrestrictedElectiveGraduationRequirement extends GraduationRequirement {

    protected int minMc = 0;
    /**
     * Default constructor of {@code UnrestrictedElectiveGraduationRequirement}
     *
     */
    public UnrestrictedElectiveGraduationRequirement(int minMc) {
        this.minMc = minMc;
    }

    /**
     * Returns a boolean representing if the {@code UnrestrictedElectiveGraduationRequirement} is fulfilled, given a
     * list of {@code ModuleCode}
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return True if fulfilled. False otherwise.
     */
    public Pair<Boolean, List<ModuleCode>> isFulfilled(List<ModuleCode> moduleCodes) {
        int currentMc = 0;
        for (ModuleCode moduleCode : moduleCodes) {
            try {
                Module module = ModuleUtil.getModuleWithCode(moduleCode);
                if (module != null) {
                    currentMc += module.getModuleCredit();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return new Pair<>(currentMc >= minMc, moduleCodes);
    }

    /**
     * Method to override the default {@code toString} function of {@code UnrestrictedElectiveGraduationRequirement}
     *
     * @return String representation of {@code UnrestrictedElectiveGraduationRequirement}
     */
    @Override
    public String toString() {
        return "[?] Unrestricted Elective\n";
    }

    /**
     * Returns a String representation of the {@code UnrestrictedElectiveGraduationRequirement} object
     *
     * @param moduleCodes List of {@code ModuleCode}
     * @return A String representation of the {@code UnrestrictedElectiveGraduationRequirement} object
     */
    public String getString(List<ModuleCode> moduleCodes) {
        StringBuilder sb = new StringBuilder();
        sb.append("[")
            .append(getStatusIcon(isFulfilled(moduleCodes).getKey()))
            .append("] [")
            .append(minMc)
            .append(" MCs] Unrestricted Electives\n");
        for (ModuleCode moduleCode : moduleCodes) {
            sb.append("    [\u2713] ").append(moduleCode).append("\n");
        }
        return sb.toString();
    }
}

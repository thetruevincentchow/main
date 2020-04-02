package seedu.planner.model.util;

import seedu.planner.model.Planner;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.TimeTableMap;

/**
 * Contains utility methods for populating {@code Planner} with sample data.
 */
public class ModuleUtil {

    public static Module getModuleWithCode(ModuleCode moduleCode) {
        for (Module module : getSamplePlanner().getModuleList()) {
            if (module.getModuleCode().equals(moduleCode)) {
                return module;
            }
        }
        return null;
    }
    public static Module[] getSampleModules() {
        return SampleDataUtil.getSampleModules();
    }

    public static Planner getSamplePlanner() {
        return SampleDataUtil.getSamplePlanner();
    }

    public static Student getSampleStudent() {
        return SampleDataUtil.getSampleStudent();
    }

    public static TimeTableMap getSampleTimeTableMap() {
        return SampleDataUtil.getSampleTimeTableMap();
    }

    /**
     * Returns a non-empty (@code TimeTableMap) which (@code Student) can immediately use.
     *
     * @return Non-empty (@code TimeTableMap)
     */
    public static TimeTable getSampleTimeTable() {
        return SampleDataUtil.getSampleTimeTable();
    }
}

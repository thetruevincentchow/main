package seedu.address.model.graduation;

import seedu.address.model.module.ModuleCode;

import java.util.List;
import java.util.regex.Pattern;

public class UnrestrictedElectiveGraduationRequirement extends GraduationRequirement {

    public UnrestrictedElectiveGraduationRequirement() {

    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {

        return false;
    }

    @Override
    public String toString() {
        return "[?] Unrestricted Elective\n";
    }

    public String getString(List<ModuleCode> moduleCodes) {
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] Unrestricted Elective\n";
    }
}

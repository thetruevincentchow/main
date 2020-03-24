package seedu.address.model.graduation;

import seedu.address.model.module.ModuleCode;

import java.util.List;
import java.util.regex.Pattern;

public class WildcardGraduationRequirement extends GraduationRequirement {

    protected String name;
    protected int minMCs;
    protected String regex;


    public WildcardGraduationRequirement(String name, int minMCs, String regex) {
        this.name = name;
        this.minMCs = minMCs;
        this.regex = regex;
        // this(name, minMCs, Pattern.compile(regex));
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        for (ModuleCode moduleCode : moduleCodes) {
            if (Pattern.matches(regex, moduleCode.value)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "[X] " + name + "\n";
    }

    public String getString(List<ModuleCode> moduleCodes) {
        return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + name + "\n";
    }
}

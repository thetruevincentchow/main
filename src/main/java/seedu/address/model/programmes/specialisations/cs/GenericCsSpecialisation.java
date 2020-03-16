package seedu.address.model.programmes.specialisations.cs;

import seedu.address.model.module.ModuleCode;
import seedu.address.model.programmes.specialisations.GenericSpecialisation;

import java.util.List;
import java.util.regex.Pattern;

public abstract class GenericCsSpecialisation extends GenericSpecialisation {

    protected List<ModuleCode> primaries;
    protected List<ModuleCode> electives;

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        int minModules = 3;
        int minNumOf4k = 1;
        int modules = 0;
        int numOf4k  = 0;
        for (ModuleCode moduleCode : moduleCodes)  {
            if (primaries.contains(moduleCode)) {
                modules++;
                if (Pattern.matches("...[456].*", moduleCode.value)) {
                    numOf4k++;
                }
            }
        }
        if (numOf4k >= minNumOf4k && modules >= minModules) {
            return true;
        }
        return false;
    }
}

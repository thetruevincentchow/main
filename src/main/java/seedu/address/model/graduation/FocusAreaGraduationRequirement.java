package seedu.address.model.graduation;

import java.util.List;

import seedu.address.model.Model;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.programmes.specialisations.GenericSpecialisation;

public class FocusAreaGraduationRequirement extends GraduationRequirement {

    private GenericSpecialisation genericSpecialisation;

    public FocusAreaGraduationRequirement(Model model) {
        try {
            genericSpecialisation = model.getActiveStudent().getSpecialisation();
        } catch (Exception e) { // TODO: replace with more specific exception
            genericSpecialisation = null;
        }
    }

    public void setGenericSpecialisation(GenericSpecialisation genericSpecialisation) {
        this.genericSpecialisation = genericSpecialisation;
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        if (genericSpecialisation == null) {
            return false;
        }
        return genericSpecialisation.isFulfilled(moduleCodes);
    }

    public String getString(List<ModuleCode> moduleCodes) {
        try {
            return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] ";
            // return "[" + getStatusIcon(isFulfilled(moduleCodes)) + "] " + genericSpecialisation.toString();
        } catch (Exception e) {
            return "???";
        }
    }
}

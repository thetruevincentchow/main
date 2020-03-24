package seedu.address.model.graduation;

import seedu.address.model.Model;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.programmes.specialisations.GenericSpecialisation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static seedu.address.model.graduation.AggregationType.ALL;

public class FocusAreaGraduationRequirement extends GraduationRequirement {

    public GenericSpecialisation genericSpecialisation = null;

    public FocusAreaGraduationRequirement(Model model) {
        try {
            genericSpecialisation = model.getActiveStudent().getSpecialisation();
        } catch (Exception e) {

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

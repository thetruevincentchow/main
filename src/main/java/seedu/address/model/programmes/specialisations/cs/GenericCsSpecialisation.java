package seedu.address.model.programmes.specialisations.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import seedu.address.model.graduation.SingleGraduationRequirement;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.programmes.specialisations.GenericSpecialisation;

public abstract class GenericCsSpecialisation extends GenericSpecialisation {

    public List<ModuleCode> getPrimaries() {
        return primaries;
    }

    public void setPrimaries(List<ModuleCode> primaries) {
        this.primaries = primaries;
    }

    public List<ModuleCode> getElectives() {
        return electives;
    }

    public void setElectives(List<ModuleCode> electives) {
        this.electives = electives;
    }

    protected List<ModuleCode> primaries;
    protected List<ModuleCode> electives;

    public boolean arePrimariesFulfilled(List<ModuleCode> moduleCodes) {
        int minModules  = 3;
        int minimum_4k_modules = 1;
        int modules = 0;
        int current_4k_modules = 0;
        ArrayList<SingleGraduationRequirement> primaryRequirements = new ArrayList<>();
        for (ModuleCode primaries : getPrimaries()) {
            primaryRequirements.add(new SingleGraduationRequirement(primaries));
        }
        for (SingleGraduationRequirement primaryRequirement : primaryRequirements) {
            if (primaryRequirement.isFulfilled(moduleCodes)) {
                modules++;
                ArrayList<Character> valid_4k_characters = new ArrayList<>();
                valid_4k_characters.add('4');
                valid_4k_characters.add('5');
                valid_4k_characters.add('6');
                valid_4k_characters.add('7');
                if (valid_4k_characters.contains(primaryRequirement.getModuleCode().toString().charAt(2))) {
                    current_4k_modules++;
                }
            }
        }
        return modules >= minModules && current_4k_modules >= minimum_4k_modules;
    }

    public boolean areElectivesFulfilled(List<ModuleCode> moduleCodes) {
        int minModules  = 0;
        int modules = 0;
        ArrayList<SingleGraduationRequirement> electiveRequirements = new ArrayList<>();
        for (ModuleCode electives : getElectives()) {
            electiveRequirements.add(new SingleGraduationRequirement(electives));
        }
        for (SingleGraduationRequirement electiveRequirement : electiveRequirements) {
            if (electiveRequirement.isFulfilled(moduleCodes)) {
                modules++;
            }
        }
        return modules >= minModules;
    }

    public boolean isFulfilled(List<ModuleCode> moduleCodes) {
        return arePrimariesFulfilled(moduleCodes) && areElectivesFulfilled(moduleCodes);
    }
}

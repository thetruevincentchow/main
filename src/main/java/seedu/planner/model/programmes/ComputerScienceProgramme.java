package seedu.planner.model.programmes;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.planner.model.Model;
import seedu.planner.model.graduation.AggregationType;
import seedu.planner.model.graduation.CompoundGraduationRequirement;
import seedu.planner.model.graduation.SingleGraduationRequirement;
import seedu.planner.model.graduation.SpecialisationGraduationRequirement;
import seedu.planner.model.graduation.UnrestrictedElectiveGraduationRequirement;
import seedu.planner.model.graduation.WildcardGraduationRequirement;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.cs.GenericCsSpecialisation;

/**
 * Class to represent specialisations for Computer Science Degree Programme.
 */
public class ComputerScienceProgramme extends DegreeProgramme {

    public ComputerScienceProgramme(Model model) {
        GenericCsSpecialisation specialisation = null;
        if (model != null) {
            specialisation = (GenericCsSpecialisation) model.getActiveStudent().getSpecialisation();
        }
        graduationRequirementList = new ArrayList<>();
        graduationRequirementList.add(new CompoundGraduationRequirement("University Level Requirements",
                20, new ArrayList<>(Arrays.asList(
                new WildcardGraduationRequirement("Human Cultures", 4, "GEH.*", "GEH"),
                new WildcardGraduationRequirement("Thinking and Expression", 4, "GET.*",
                        "GET"),
                new WildcardGraduationRequirement("Singapore Studies", 4, "GES.*", "GES"),
                new SingleGraduationRequirement(new ModuleCode("GEQ1000")),
                new SingleGraduationRequirement(new ModuleCode("GER1000"))
        ))));
        graduationRequirementList.add(new CompoundGraduationRequirement("Programme Requirements", 108,
                new ArrayList<>(Arrays.asList(
                        new CompoundGraduationRequirement("Computer Science Foundation", 36,
                                new ArrayList<>(Arrays.asList(
                                        new SingleGraduationRequirement(new ModuleCode("CS1101S")),
                                        new SingleGraduationRequirement(new ModuleCode("CS1231S")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2030")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2040S")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2100")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2103T")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2105")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2106")),
                                        new SingleGraduationRequirement(new ModuleCode("CS3230"))
                                ))),
                        new CompoundGraduationRequirement("Computer Science Breadth and Depth", 44,
                                new ArrayList<>(Arrays.asList(
                                        new SpecialisationGraduationRequirement(specialisation),
                                        new CompoundGraduationRequirement("Computer Systems Team Project", 8,
                                                new ArrayList<>(Arrays.asList(
                                                        new SingleGraduationRequirement(new ModuleCode("CS3203")),
                                                        new SingleGraduationRequirement(new ModuleCode("CS3216")),
                                                        new CompoundGraduationRequirement(
                                                                "Thematic Systems Project", 8,
                                                                new ArrayList<>(Arrays.asList(
                                                                        new SingleGraduationRequirement(
                                                                                new ModuleCode("CS3281")),
                                                                        new SingleGraduationRequirement(
                                                                                new ModuleCode("CS3282"))
                                                                )), AggregationType.ALL)
                                                )), AggregationType.AT_LEAST_MC),
                                        new CompoundGraduationRequirement("Industrial Experience Requirement",
                                                12,
                                                new ArrayList<>(Arrays.asList(
                                                        new SingleGraduationRequirement(new ModuleCode("CP3880")),
                                                        new CompoundGraduationRequirement(
                                                                "Two 3-Month Internships", 12,
                                                                new ArrayList<>(Arrays.asList(
                                                                        new SingleGraduationRequirement(
                                                                                new ModuleCode("CP3200")),
                                                                        new SingleGraduationRequirement(
                                                                                new ModuleCode("CP3202")),
                                                                        new SingleGraduationRequirement(
                                                                                new ModuleCode("CP3107")),
                                                                        new SingleGraduationRequirement(
                                                                                new ModuleCode("CP3110"))
                                                                )), AggregationType.AT_LEAST_MC),
                                                        new SingleGraduationRequirement(new ModuleCode("IS4010")),
                                                        new SingleGraduationRequirement(new ModuleCode("TR3202"))
                                                )), AggregationType.ANY)
                                ))),
                        new CompoundGraduationRequirement("IT Professionalism", 12,
                                new ArrayList<>(Arrays.asList(
                                        new SingleGraduationRequirement(new ModuleCode("IS1103")),
                                        new SingleGraduationRequirement(new ModuleCode("CS2101")),
                                        new SingleGraduationRequirement(new ModuleCode("ES2660"))
                                ))),
                        new CompoundGraduationRequirement("Mathematics and Sciences", 16,
                                new ArrayList<>(Arrays.asList(
                                        new SingleGraduationRequirement(new ModuleCode("MA1521")),
                                        new SingleGraduationRequirement(new ModuleCode("MA1101R")),
                                        new SingleGraduationRequirement(new ModuleCode("ST2334")),
                                        new CompoundGraduationRequirement("One Science Module", 4,
                                                new ArrayList<>(Arrays.asList(
                                                        new SingleGraduationRequirement(new ModuleCode("CM1121")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1131")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1417")),
                                                        new SingleGraduationRequirement(new ModuleCode("LSM1102")),
                                                        new SingleGraduationRequirement(new ModuleCode("LSM1105")),
                                                        new SingleGraduationRequirement(new ModuleCode("LSM1106")),
                                                        new SingleGraduationRequirement(new ModuleCode("LSM1301")),
                                                        new SingleGraduationRequirement(new ModuleCode("LSM1306")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1141")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1142")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1143")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1144")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1221")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1222")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1432")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1111")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1191")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1401")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1402")),
                                                        new SingleGraduationRequirement(new ModuleCode("CM1501")),
                                                        new SingleGraduationRequirement(new ModuleCode("LSM1303")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1421")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1431")),
                                                        new SingleGraduationRequirement(new ModuleCode("PC1433"))
                                                )), AggregationType.ANY
                                        )
                                ))
                        )
                ))));
        graduationRequirementList.add(new UnrestrictedElectiveGraduationRequirement(32));
    }
}





















package seedu.planner.model.programmes;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.planner.model.Model;
import seedu.planner.model.graduation.AggregationType;
import seedu.planner.model.graduation.CompoundGraduationRequirement;
import seedu.planner.model.graduation.SingleGraduationRequirement;
import seedu.planner.model.graduation.SpecialisationGraduationRequirement;
import seedu.planner.model.graduation.WildcardGraduationRequirement;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.programmes.specialisations.cs.GenericCsSpecialisation;

public class ComputerScienceProgramme extends DegreeProgramme {

    public ComputerScienceProgramme(Model model) { // TODO: Load from JSON or XML
        GenericCsSpecialisation specialisation = null;
        if (model != null) {
            specialisation = (GenericCsSpecialisation) model.getActiveStudent().getSpecialisation();
        }
        graduationRequirementList = new ArrayList<>();
        graduationRequirementList.add(new CompoundGraduationRequirement("University Level Requirements",
            20, new ArrayList<>(Arrays.asList(
            new WildcardGraduationRequirement("Human Cultures", 4, "GEH.*", "GEH"),
            new WildcardGraduationRequirement("Thinking and Expression", 4, "GET.*", "GET"),
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
                                new CompoundGraduationRequirement("Thematic Systems Project", 8,
                                    new ArrayList<>(Arrays.asList(
                                        new SingleGraduationRequirement(new ModuleCode("CS3281")),
                                        new SingleGraduationRequirement(new ModuleCode("CS3282"))
                                    )), AggregationType.ALL)
                            )), AggregationType.AT_LEAST_MC),
                        new CompoundGraduationRequirement("Industrial Experience Requirement", 12,
                            new ArrayList<>(Arrays.asList(
                                new SingleGraduationRequirement(new ModuleCode("CP3880")),
                                new CompoundGraduationRequirement("Two 3-Month Internships", 12,
                                    new ArrayList<>(Arrays.asList(
                                        new SingleGraduationRequirement(new ModuleCode("CP3200")),
                                        new SingleGraduationRequirement(new ModuleCode("CP3202")),
                                        new SingleGraduationRequirement(new ModuleCode("CP3107")),
                                        new SingleGraduationRequirement(new ModuleCode("CP3110"))
                                    ))),
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
                        new CompoundGraduationRequirement("One Science Module", 4, null)
                    )))
            ))));
        graduationRequirementList.add(new CompoundGraduationRequirement("Unrestricted Electives", 32,
            null));
    }
}

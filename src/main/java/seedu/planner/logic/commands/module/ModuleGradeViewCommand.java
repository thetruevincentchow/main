package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;

import java.util.Optional;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.module.ModuleCode;


/**
 * Displays the grade of a module in the selected timetable.
 */
public class ModuleGradeViewCommand extends ModuleGradeCommand {
    public static final String MESSAGE_VIEW_GRADE_SUCCESS = "Grade of module %1$s: %2$s";

    public ModuleGradeViewCommand(ModuleCode moduleCode) {
        super(moduleCode);
    }

    /**
     * Generates a command execution success message for displaying the enrollment with the given (@code moduleCode)
     * with a pending grade.
     */
    private String generateViewGradeSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_VIEW_GRADE_SUCCESS, moduleCode.value, "Pending");
    }

    /**
     * Generates a command execution success message for displaying the enrollment with the given (@code moduleCode)
     * with a (@code grade).
     */
    private String generateViewGradeSuccessMessage(ModuleCode moduleCode, Grade grade) {
        return String.format(MESSAGE_VIEW_GRADE_SUCCESS, moduleCode.value, grade);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        validate(model);

        Optional<Grade> optionalGrade = model.getModuleGrade(moduleCode);
        if (optionalGrade.isPresent()) {
            return new CommandResult(generateViewGradeSuccessMessage(moduleCode, optionalGrade.get()));
        } else {
            return new CommandResult(generateViewGradeSuccessMessage(moduleCode));
        }
    }
}

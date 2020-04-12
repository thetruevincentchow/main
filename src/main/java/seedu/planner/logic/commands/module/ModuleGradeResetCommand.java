package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.module.ModuleCode;


//@@author thetruevincentchow

/**
 * Resets the grade of a module in the selected timetable.
 */
public class ModuleGradeResetCommand extends ModuleGradeCommand {
    public static final String MESSAGE_SET_GRADE_SUCCESS = "Set grade of module %1$s to: %2$s";


    public ModuleGradeResetCommand(ModuleCode moduleCode) {
        super(moduleCode);
    }

    /**
     * Generates a command execution success message for setting the enrollment with the given {@code moduleCode}
     * to have a pending grade.
     */
    private String generateSetGradeSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_SET_GRADE_SUCCESS, moduleCode.value, Grade.MESSAGE_PENDING);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        validate(model);

        model.resetModuleGrade(moduleCode);
        return new CommandResult(generateSetGradeSuccessMessage(moduleCode));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
//@@author

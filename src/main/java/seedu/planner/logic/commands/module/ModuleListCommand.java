package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;


//@@author thetruevincentchow
/**
 * Lists modules enrolled in the selected timetable.
 */
public class ModuleListCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": List enrolled modules in the timetable.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Listed enrolled modules in timetable:\n%1$s";

    /**
     * Generates a command execution success message for listing the enrollments for
     * the selected timetable of the selected student.
     */
    private String generateSuccessMessage(ObservableList<ModuleCode> codes) {
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for (ModuleCode moduleCode : codes) {
            if (!isFirst) {
                sb.append(", ");
            }
            sb.append(moduleCode.value);
            isFirst = false;
        }

        return String.format(MESSAGE_SUCCESS, codes.isEmpty() ? "[None]" : sb.toString());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }
        if (!model.hasActiveTimeTable()) {
            throw new CommandException(Messages.MESSAGE_NO_TIMETABLE_ACTIVE);
        }

        return new CommandResult(generateSuccessMessage(model.getEnrolledModuleCodes()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
//@@author

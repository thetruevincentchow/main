package seedu.planner.logic.commands.exemptions;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;


/**
 * Lists modules enrolled in the selected timetable.
 */
public class ExemptListCommand extends ExemptCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": List exempted  modules of the active student.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Listed exempted modules of active student:\n%1$s";

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
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

        // Check if active student exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        return new CommandResult(generateSuccessMessage(model.getExemptedModulesList()));
    }
}

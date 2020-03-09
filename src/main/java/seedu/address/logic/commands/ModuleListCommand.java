package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class ModuleListCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'module list' command not implemented yet";

    public static final String MESSAGE_USAGE = "module " + COMMAND_WORD
            + ": List enrolled modules in the timetable.\n"
            + "Example: " + "module " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Listed enrolled modules in timetable: %1$s";

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

        //Student student = model.getActiveStudent();

        //return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
        return new CommandResult(generateSuccessMessage(model.getEnrolledModulesList()));
    }
}

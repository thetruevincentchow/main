package seedu.address.logic.commands;

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

    public static final String MESSAGE_SUCCESS = "Listed enrolled modules in timetable";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student student = model.getActiveStudent();

        return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
        //return new CommandResult(MESSAGE_SUCCESS);
    }
}

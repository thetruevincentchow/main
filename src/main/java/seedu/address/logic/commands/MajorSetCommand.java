package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Major;

public class MajorSetCommand extends MajorCommand {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'major set' command not implemented yet";
    public static final String MESSAGE_USAGE = "major " + COMMAND_WORD + ": Set's the current Student's Major";
    public static final String MESSAGE_SUCCESS = "Successfully updated Student's Major to: %1$s";

    private final Major major;

    public MajorSetCommand(String major) {
        this.major = new Major(major);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.getActiveStudent().setMajor(major);
        return new CommandResult(String.format(MESSAGE_SUCCESS, major));
    }
}

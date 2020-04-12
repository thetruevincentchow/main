package seedu.planner.logic.commands.major;

import static java.util.Objects.requireNonNull;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Student;

/**
 * Command to set the {@code Major} the active {@code Student}.
 */
public class MajorSetCommand extends MajorCommand {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
            + " command not implemented yet";
    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD) + ": Sets the current student's Major";
    public static final String MESSAGE_SUCCESS = "Successfully updated Student's Major to: %1$s";

    private Major major;

    public MajorSetCommand(String major) {
        this.major = new Major(major);
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        activeStudent.setMajor(major);
        return new CommandResult(String.format(MESSAGE_SUCCESS, major));
    }
}

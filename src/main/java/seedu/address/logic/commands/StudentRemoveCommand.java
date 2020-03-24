package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;

public class StudentRemoveCommand extends StudentCommand {
    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'student remove' command not implemented yet";

    public static final String MESSAGE_USAGE = "student " + COMMAND_WORD
        + ": Removes the student from list of student profiles.\n"
        + "Parameters: INDEX (must be a positive integer) \n"
        + "Example: " + "student " + COMMAND_WORD + " 1";

    public static final String MESSAGE_REMOVE_STUDENT_SUCCESS = "Removed student: %1$s";
    public static final String MESSAGE_WOULD_BE_EMPTY = "Removing student would make student list empty";

    private final Index index;

    public StudentRemoveCommand(Index index) {
        requireAllNonNull(index);
        this.index = index;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student removedStudent) {
        return String.format(MESSAGE_REMOVE_STUDENT_SUCCESS, removedStudent);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Student> lastShownList = model.getStudentList();
        if (lastShownList.size() <= 1) {
            throw new CommandException(MESSAGE_WOULD_BE_EMPTY);
        }

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Student removedStudent = lastShownList.get(index.getZeroBased());
        model.removeStudent(removedStudent);

        return new CommandResult(generateSuccessMessage(removedStudent));
    }
}

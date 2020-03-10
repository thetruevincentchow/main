package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class StudentActiveCommand extends StudentCommand {
    public static final String COMMAND_WORD = "active";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'student active' command not implemented yet";

    public static final String MESSAGE_USAGE = "student " + COMMAND_WORD
            + ": Sets the student from the student list as the active student.\n"
            + "Parameters: INDEX (must be a positive integer) \n"
            + "Example: " + "student " + COMMAND_WORD + " 1";

    public static final String MESSAGE_ACTIVE_STUDENT_SUCCESS = "Set student as active: %1$s";

    private final Index index;

    public StudentActiveCommand(Index index) {
        requireAllNonNull(index);
        this.index = index;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student student) {
        return String.format(MESSAGE_ACTIVE_STUDENT_SUCCESS, student);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Student> lastShownList = model.getStudentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Student student = lastShownList.get(index.getZeroBased());
        model.activateStudent(student);

        return new CommandResult(generateSuccessMessage(student));
    }
}

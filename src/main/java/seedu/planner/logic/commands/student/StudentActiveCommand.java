package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.planner.commons.core.Messages;
import seedu.planner.commons.core.index.Index;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Student;


//@@author thetruevincentchow
/**
 * Sets the currently selected student in the student list.
 */
public class StudentActiveCommand extends StudentCommand {
    public static final String COMMAND_WORD = "active";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Sets the student from the student list as the active student.\n"
        + "Parameters: INDEX (must be a positive integer)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " 1";

    public static final String MESSAGE_ACTIVE_STUDENT_SUCCESS = "Set student as active: %1$s";

    private final Index index;

    public StudentActiveCommand(Index index) {
        requireAllNonNull(index);
        this.index = index;
    }

    /**
     * Generates a command execution success message for selecting the given {@code student}.
     */
    private String generateSuccessMessage(Student student) {
        return String.format(MESSAGE_ACTIVE_STUDENT_SUCCESS, student);
    }

    /**
     * Executes {@code StudentActiveCommand}
     * @param model {@code Model} which the command should operate on
     * @return {@code CommandResult} produced from executing the command
     * @throws CommandException when an exception occurred while executing the command
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Student> lastShownList = model.getStudentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        }

        Student student = lastShownList.get(index.getZeroBased());
        model.activateStudent(student);

        return new CommandResult(generateSuccessMessage(student));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentActiveCommand that = (StudentActiveCommand) o;
        return index.equals(that.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
//@@author

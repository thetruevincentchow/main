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
 * Removes a student from the student list.
 */
public class StudentRemoveCommand extends StudentCommand {
    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Removes the student from list of student profiles.\n"
        + "Parameters: INDEX (must be a positive integer)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " 1";

    public static final String MESSAGE_REMOVE_STUDENT_SUCCESS = "Removed student: %1$s";

    private final Index index;

    public StudentRemoveCommand(Index index) {
        requireAllNonNull(index);
        this.index = index;
    }

    /**
     * Generates a command execution success message for removing the {@code removedStudent} from the list of students.
     */
    private String generateSuccessMessage(Student removedStudent) {
        return String.format(MESSAGE_REMOVE_STUDENT_SUCCESS, removedStudent);
    }
    /**
     * Executes {@code StudentRemoveCommand}
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

        Student removedStudent = lastShownList.get(index.getZeroBased());
        model.removeStudent(removedStudent);

        return new CommandResult(generateSuccessMessage(removedStudent));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentRemoveCommand that = (StudentRemoveCommand) o;
        return index.equals(that.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
//@@author

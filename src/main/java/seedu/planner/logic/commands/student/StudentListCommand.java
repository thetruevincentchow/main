package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Student;


//@@author thetruevincentchow
/**
 * Lists all students in the student list.
 */
public class StudentListCommand extends StudentCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": List students in the student list.\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Listed students in student list:\n%1$s";

    /**
     * Generates a command execution success message for listing the students in the planner.
     */
    private String generateSuccessMessage(ObservableList<Student> students) {
        StringBuffer buffer = new StringBuffer();
        boolean isFirst = true;
        for (int i = 0; i < students.size(); ++i) {
            Student student = students.get(i);
            if (!isFirst) {
                buffer.append("\n");
            }
            buffer.append(i + 1);
            buffer.append(": ");
            buffer.append(student);
            isFirst = false;
        }

        return String.format(MESSAGE_SUCCESS, buffer.length() == 0 ? "[None]" : buffer.toString());
    }

    /**
     * Executes {@code StudentListCommand}
     * @param model {@code Model} which the command should operate on
     * @return {@code CommandResult} produced from executing the command
     * @throws CommandException when an exception occurred while executing the command
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Student> lastShownList = model.getStudentList();

        return new CommandResult(generateSuccessMessage(lastShownList));
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

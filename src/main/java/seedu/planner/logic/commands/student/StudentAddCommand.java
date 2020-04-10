package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.Objects;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.student.Student;


//@@author thetruevincentchow
/**
 * Sets a student to the student list.
 */
public class StudentAddCommand extends StudentCommand {
    public static final String COMMAND_WORD = "add";
    public static final String EXAMPLE_COMMAND =
        getQualifiedCommand(COMMAND_WORD) + " " + PREFIX_NAME + "Mark " + PREFIX_MAJOR + "CS";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Adds the student to list of student profiles.\n"
        + "Parameters: "
        + PREFIX_NAME + "NAME "
        + PREFIX_MAJOR + "MAJOR\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " n/Alice major/CS";

    public static final String MESSAGE_ADD_STUDENT_SUCCESS = "Added student: %1$s";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student already exists in the student list";

    private final Student student;

    public StudentAddCommand(Student student) {
        requireAllNonNull(student);
        this.student = student;
    }

    /**
     * Generates a command execution success message for adding the {@code addedStudent} to the list of students.
     */
    private String generateSuccessMessage(Student addedStudent) {
        return String.format(MESSAGE_ADD_STUDENT_SUCCESS, addedStudent);
    }

    /**
     * Executes {@code StudentAddCommand}
     * @param model {@code Model} which the command should operate on
     * @return {@code CommandResult} produced from executing the command
     * @throws CommandException when an exception occurred while executing the command
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasStudent(student)) {
            throw new CommandException(MESSAGE_DUPLICATE_STUDENT);
        }
        model.addStudent(student);

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
        StudentAddCommand that = (StudentAddCommand) o;
        return student.equals(that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student);
    }
}
//@@author

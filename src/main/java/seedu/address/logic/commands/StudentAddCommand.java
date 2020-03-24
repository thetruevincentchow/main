package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;

public class StudentAddCommand extends StudentCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'student add' command not implemented yet";

    public static final String MESSAGE_USAGE = "student " + COMMAND_WORD
        + ": Adds the student to list of student profiles.\n"
        + "Parameters: "
        + "[" + PREFIX_NAME + "NAME] "
        + "[" + PREFIX_MAJOR + "MAJOR] \n"
        + "Example: " + "student " + COMMAND_WORD + " n/Alice major/CS";

    public static final String MESSAGE_ADD_STUDENT_SUCCESS = "Added student: %1$s";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student already exists in the student list";

    private final Student student;

    public StudentAddCommand(Student student) {
        requireAllNonNull(student);
        this.student = student;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student addedStudent) {
        return String.format(MESSAGE_ADD_STUDENT_SUCCESS, addedStudent);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasStudent(student)) {
            throw new CommandException(MESSAGE_DUPLICATE_STUDENT);
        }
        model.addStudent(student);

        return new CommandResult(generateSuccessMessage(student));
    }
}

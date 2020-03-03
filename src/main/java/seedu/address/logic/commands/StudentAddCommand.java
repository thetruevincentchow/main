package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;


/**
 * Adds a person to the address book.
 */
public class StudentAddCommand extends Command {

    public static final String COMMAND_WORD = "studentadd";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new Student to the planner. "
        + "Parameters: "
        + PREFIX_NAME + "NAME "
        + PREFIX_MAJOR + "MAJOR "
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_NAME + "John Doe "
        + PREFIX_MAJOR + "CS ";

    public static final String MESSAGE_SUCCESS = "New student added: %1$s";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student already exists in the planner";

    private final Student toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public StudentAddCommand(Student student) {
        requireNonNull(student);
        toAdd = student;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.addStudent(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof StudentAddCommand // instanceof handles nulls
            && toAdd.equals(((StudentAddCommand) other).toAdd));
    }
}

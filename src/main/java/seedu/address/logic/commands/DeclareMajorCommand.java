package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.programmes.ComputerScienceProgramme;
import seedu.address.model.student.Major;
import seedu.address.model.student.Student;


public class DeclareMajorCommand extends DeclareCommand {
    public static final String COMMAND_WORD = "major";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'declare major' command not implemented yet";

    //TODO: write usage message
    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Deletes the person identified by the index number used in the displayed person list.\n"
        + "Parameters: INDEX (must be a positive integer)\n"
        + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_EDIT_MAJOR_SUCCESS = "Changed major to: %1$s";

    private final Major major;

    public DeclareMajorCommand(Major major) {
        requireAllNonNull(major);

        this.major = major;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student editedStudent) {
        return String.format(MESSAGE_EDIT_MAJOR_SUCCESS, editedStudent.getMajor().major);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student student = model.getActiveStudent();
        major.setDegreeProgramme(new ComputerScienceProgramme(model));
        student.setMajor(major);

        Student editedStudent = new Student(student.getName(), student.getDegrees(), major);
        assert (model instanceof ModelManager);
        model.setActiveStudent(editedStudent);

        //return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
        return new CommandResult(generateSuccessMessage(editedStudent));
    }
}

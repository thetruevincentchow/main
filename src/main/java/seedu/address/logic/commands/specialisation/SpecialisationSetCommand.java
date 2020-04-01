package seedu.address.logic.commands.specialisation;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.programmes.specialisations.GenericSpecialisation;
import seedu.address.model.student.Student;


public class SpecialisationSetCommand extends SpecialisationCommand {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'" + getQualifiedCommand(COMMAND_WORD)
        + "' command not implemented yet";
    public static final String MESSAGE_SUCCESS = "Successfully updated Student's Focus Area to: %1$s";
    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Set's the current Student's specialisation";

    private GenericSpecialisation specialisation;

    public SpecialisationSetCommand(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
    }

    public GenericSpecialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        activeStudent.setSpecialisation(specialisation);
        return new CommandResult(String.format(MESSAGE_SUCCESS, specialisation.toString()));
    }
}

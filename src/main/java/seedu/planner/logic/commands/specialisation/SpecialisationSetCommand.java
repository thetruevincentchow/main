package seedu.planner.logic.commands.specialisation;

import static java.util.Objects.requireNonNull;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.programmes.specialisations.GenericSpecialisation;
import seedu.planner.model.student.Student;

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

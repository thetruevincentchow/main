package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.programmes.specialisations.GenericSpecialisation;
import seedu.address.model.student.Major;

import static java.util.Objects.requireNonNull;

public class SpecialisationSetCommand extends SpecialisationCommand {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'specialisation set' command not implemented yet";
    public static final String MESSAGE_USAGE = "specialisation " + COMMAND_WORD + ": Set's the current Student's specialisation";
    public static final String MESSAGE_SUCCESS = "Successfully updated Student's Focus Area to: %1$s";

    public GenericSpecialisation specialisation;

    public SpecialisationSetCommand(GenericSpecialisation specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.getActiveStudent().setSpecialisation(specialisation);
        return new CommandResult(String.format(MESSAGE_SUCCESS, specialisation.toString()));
    }
}

package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.student.Major;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class DeclareMajorCommand extends DeclareCommand {
    public static final String COMMAND_WORD = "major";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Declare major command not implemented yet";

    //TODO: write usage message
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person identified by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";


    private final Major major;

    public DeclareMajorCommand(Major major) {
        requireAllNonNull(major);

        this.major = major;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        /*
        Student student = model.getActiveStudent();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deletePerson(personToDelete);
         */
        return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
    }
}

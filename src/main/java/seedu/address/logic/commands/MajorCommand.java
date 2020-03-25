package seedu.address.logic.commands;

public abstract class MajorCommand extends Command {

    public static final String COMMAND_WORD = "major";

    // TODO: fill in usage message
    public static final String MESSAGE_USAGE = COMMAND_WORD
        //+ ": Deletes the person identified by the index number used in the displayed person list.\n"
        //+ "Parameters: INDEX (must be a positive integer)\n"
        + ":\n"
        + "Subcommands: status, set\n"
        + "Example: " + COMMAND_WORD + " set CS";


    public static String getQualifiedCommand(String subCommand) {
        return COMMAND_WORD + " " + subCommand;
    }
}

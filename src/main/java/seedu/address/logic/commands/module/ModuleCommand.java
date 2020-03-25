package seedu.address.logic.commands.module;

import seedu.address.logic.commands.Command;

public abstract class ModuleCommand extends Command {

    public static final String COMMAND_WORD = "module";

    // TODO: fill in usage message
    public static final String MESSAGE_USAGE = COMMAND_WORD
        //+ ": Deletes the person identified by the index number used in the displayed person list.\n"
        //+ "Parameters: INDEX (must be a positive integer)\n"
        + ":\n"
        + "Subcommands: add, remove, list, grade\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";


    public static String getQualifiedCommand(String subCommand) {
        return COMMAND_WORD + " " + subCommand;
    }
}

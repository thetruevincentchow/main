package seedu.planner.logic.commands.exemptions;

import seedu.planner.logic.commands.Command;

/**
 * Base command for subcommands involving queries about modules.
 */
public abstract class ExemptCommand extends Command {

    public static final String COMMAND_WORD = "exempt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ":\n"
        + "Subcommands: add, remove, list\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2101";


    /**
     * Returns the (@code COMMAND_NAME) concatenated with the name of the input (@code subCommand).
     * @param subCommand
     * @return Qualified name
     */
    public static String getQualifiedCommand(String subCommand) {
        return COMMAND_WORD + " " + subCommand;
    }
}

package seedu.planner.logic.commands.exemptions;

import seedu.planner.logic.commands.Command;

//@@author thetruevincentchow

/**
 * Base command for subcommands involving queries about modules.
 */
public abstract class ExemptCommand extends Command {

    public static final String COMMAND_WORD = "exempt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Manage exemptions of the currently active student\n"
            + "Subcommands: add, remove, list\n"
            + "Example: " + getQualifiedCommand("add") + " CS2101";


    /**
     * Returns the {@code COMMAND_WORD} concatenated with the name of the input {@code subCommand}.
     *
     * @param subCommand
     * @return Qualified name
     */
    public static String getQualifiedCommand(String subCommand) {
        return COMMAND_WORD + " " + subCommand;
    }
}
//@@author

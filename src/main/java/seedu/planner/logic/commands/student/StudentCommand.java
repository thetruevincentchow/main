package seedu.planner.logic.commands.student;

import seedu.planner.logic.commands.Command;


//@@author thetruevincentchow

/**
 * Base command for subcommands involving queries about students.
 */
public abstract class StudentCommand extends Command {

    public static final String COMMAND_WORD = "student";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Manage students in the planner\n"
            + "Subcommands: add, remove, list, active, grade\n"
            + "Example: " + getQualifiedCommand("active") + " 1";


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

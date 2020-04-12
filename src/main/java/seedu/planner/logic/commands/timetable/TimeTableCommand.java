package seedu.planner.logic.commands.timetable;

import seedu.planner.logic.commands.Command;


//@@author thetruevincentchow

/**
 * Base command for subcommands involving queries about timetables.
 */
public abstract class TimeTableCommand extends Command {

    public static final String COMMAND_WORD = "timetable";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Manage timetables of the currently active student\n"
            + "Subcommands: add, remove, active, list\n"
            + "Example: " + getQualifiedCommand("active") + " year/1 sem/ONE";


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

package seedu.address.logic.commands;

public abstract class TimeTableCommand extends Command {

    public static final String COMMAND_WORD = "timetable";

    // TODO: fill in usage message
    public static final String MESSAGE_USAGE = COMMAND_WORD
        //+ ": Deletes the person identified by the index number used in the displayed person list.\n"
        //+ "Parameters: INDEX (must be a positive integer)\n"
        + ": Modifies the timetable of the currently active student.\n"
        + "Subcommands: add remove active\n"
        + "Example: " + COMMAND_WORD + " active year/1 sem/ONE";
}

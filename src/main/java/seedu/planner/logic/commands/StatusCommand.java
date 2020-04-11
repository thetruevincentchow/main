package seedu.planner.logic.commands;

import seedu.planner.model.Model;

/**
 * Display currently selected student and timetable (if any).
 */
public class StatusCommand extends Command {

    public static final String COMMAND_WORD = "status";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows currently selected student and timetable.\n"
        + "Example: " + COMMAND_WORD;

    private static final String MESSAGE_SELECTED_STUDENT = "Selected student: %1$s\n";
    private static final String MESSAGE_LIST_TIMETABLE = "Available timetables:\n%1$s\n";
    private static final String MESSAGE_SELECTED_TIMETABLE = "Selected timetable: %1$s\n";

    @Override
    public CommandResult execute(Model model) {
        StringBuffer buffer = new StringBuffer();

        if (model.hasActiveStudent()) {
            buffer.append(String.format(MESSAGE_SELECTED_STUDENT, model.getActiveStudent()));
            buffer.append(String.format(MESSAGE_LIST_TIMETABLE, model.getStudentSemesters()));
            buffer.append("\n");
        } else {
            buffer.append(String.format(MESSAGE_SELECTED_STUDENT, "[None]"));
        }

        if (model.hasActiveTimeTable()) {
            buffer.append(String.format(MESSAGE_SELECTED_TIMETABLE, model.getActiveSemester()));
        } else {
            buffer.append(String.format(MESSAGE_SELECTED_TIMETABLE, "[None]"));
        }

        return new CommandResult(buffer.toString());
    }
}

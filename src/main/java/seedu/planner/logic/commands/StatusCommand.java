package seedu.planner.logic.commands;

import java.util.List;

import seedu.planner.commons.util.StringUtil;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;

/**
 * Display currently selected student and timetable (if any).
 */
public class StatusCommand extends Command {

    public static final String COMMAND_WORD = "status";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows currently selected student and timetable.\n"
        + "Example: " + COMMAND_WORD;

    private static final String MESSAGE_SELECTED_STUDENT = "Selected student: %1$s\n";
    private static final String MESSAGE_LIST_TIMETABLE = "Timetables in selected student:\n%1$s\n";
    private static final String MESSAGE_SELECTED_TIMETABLE = "Selected timetable: %1$s\n";
    private static final String MESSAGE_LIST_MODULES = "Modules in selected timetable:\n%1$s\n";

    private void addModuleListToBuffer(List<ModuleCode> codes, StringBuffer buffer) {
        if (codes.isEmpty()) {
            buffer.append(String.format(MESSAGE_LIST_MODULES, "[None]"));
        } else {
            buffer.append(String.format(MESSAGE_LIST_MODULES, StringUtil.wrapCollection(codes)));
        }
    }

    @Override
    public CommandResult execute(Model model) {
        StringBuffer buffer = new StringBuffer();

        if (model.hasActiveStudent()) {
            buffer.append(String.format(MESSAGE_SELECTED_STUDENT, model.getActiveStudent()));
            buffer.append(String.format(MESSAGE_LIST_TIMETABLE,
                StringUtil.wrapCollection(model.getStudentSemesters())));
            buffer.append("\n");
        } else {
            buffer.append(String.format(MESSAGE_SELECTED_STUDENT, "[None]"));
        }

        if (model.hasActiveTimeTable()) {
            buffer.append(String.format(MESSAGE_SELECTED_TIMETABLE, model.getActiveSemester()));
            addModuleListToBuffer(model.getEnrolledModuleCodes(), buffer);
        } else {
            buffer.append(String.format(MESSAGE_SELECTED_TIMETABLE, "[None]"));
        }

        return new CommandResult(buffer.toString());
    }
}

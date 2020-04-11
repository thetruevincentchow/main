package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;


//@@author thetruevincentchow
/**
 * Removes a module from the selected timetable.
 */
public class ModuleRemoveCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Removes the module from list of enrolled modules.\n"
        + "Parameters: MODULE_CODE (must be a valid NUS module code)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";

    public static final String MESSAGE_REMOVE_MODULE_SUCCESS = "Removed module from timetable: %1$s";
    public static final String MESSAGE_REMOVE_MODULE_NOT_EXISTS = "Module does not exist in timetable: %1$s";

    private final List<ModuleCode> moduleCodes;

    public ModuleRemoveCommand(List<ModuleCode> moduleCodes) {
        requireAllNonNull(moduleCodes);
        this.moduleCodes = new ArrayList<>();
        this.moduleCodes.addAll(moduleCodes);
    }


    public ModuleRemoveCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCodes = null;
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} being absent
     * from the selected timetable of the selected student.
     */
    private String generateFailureMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_REMOVE_MODULE_NOT_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message for removing the given {@code moduleCode}
     * from the selected timetable of the selected student.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_REMOVE_MODULE_SUCCESS, moduleCode);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }
        if (!model.hasActiveTimeTable()) {
            throw new CommandException(Messages.MESSAGE_NO_TIMETABLE_ACTIVE);
        }
        List<String> messages = new ArrayList<>();
        for (ModuleCode moduleCode : moduleCodes) {
            // Check if module is present in active timetable
            if (!model.hasEnrollment(moduleCode)) {
                // throw new CommandException(generateFailureMessage(moduleCode));
                messages.add(generateFailureMessage(moduleCode));
            }
            model.removeEnrollment(moduleCode);
            messages.add(generateSuccessMessage(moduleCode));
        }
        return new CommandResult(String.join("\n", messages));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModuleRemoveCommand that = (ModuleRemoveCommand) o;
        return moduleCodes.equals(that.moduleCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleCodes);
    }
}
//@@author

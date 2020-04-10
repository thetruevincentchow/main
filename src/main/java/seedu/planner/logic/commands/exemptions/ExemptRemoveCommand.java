package seedu.planner.logic.commands.exemptions;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;


//@@author thetruevincentchow
/**
 * Removes a module from the list of exempted modules of the selected student.
 */
public class ExemptRemoveCommand extends ExemptCommand {
    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Removes the module from list of exempted modules.\n"
        + "Parameters: MODULE_CODE (must be a valid NUS module code)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";

    public static final String MESSAGE_ADD_MODULE_SUCCESS = "Removed the module from exemptions list: %1$s";
    public static final String MESSAGE_ADD_MODULE_NOT_EXISTS = "Module does not exist in exemptions list: %1$s";

    private final ModuleCode moduleCode;

    public ExemptRemoveCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);

        this.moduleCode = moduleCode;
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} being absent
     * from the in the list of exempted modules of the selected student.
     */
    private String generateFailureMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_NOT_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message for removing the given {@code moduleCode}
     * from the list of exempted modules of the selected student.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_SUCCESS, moduleCode.value);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        // Check if module is present in exempted modules list
        if (!model.hasExemptedModule(moduleCode)) {
            throw new CommandException(generateFailureMessage(moduleCode));
        }

        model.removeExemptedModule(moduleCode);
        return new CommandResult(generateSuccessMessage(moduleCode));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExemptRemoveCommand that = (ExemptRemoveCommand) o;
        return moduleCode.equals(that.moduleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleCode);
    }
}
//@@author

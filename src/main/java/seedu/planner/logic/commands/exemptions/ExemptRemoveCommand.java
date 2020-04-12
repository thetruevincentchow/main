package seedu.planner.logic.commands.exemptions;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static final String MESSAGE_REMOVE_EXEMPTION_SUCCESS = "Removed the module from exemptions list: %1$s";
    public static final String MESSAGE_REMOVE_EXEMPTION_NOT_EXISTS = "Module does not exist in exemptions list: %1$s";
    public static final String MESSAGE_REMOVE_EXEMPTION_DUPLICATE_ALREADY_EXISTS = "Module appeared more than once in "
            + "your command: %1$s";
    private final List<ModuleCode> moduleCodes;

    public ExemptRemoveCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCodes = Arrays.asList(moduleCode);
    }

    public ExemptRemoveCommand(List<ModuleCode> moduleCodes) {
        requireAllNonNull(moduleCodes);
        this.moduleCodes = new ArrayList<>();
        this.moduleCodes.addAll(moduleCodes);
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} being absent
     * from the in the list of exempted modules of the selected student.
     */
    private String generateFailureMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_REMOVE_EXEMPTION_NOT_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} already being present
     * in the list of exempted modules of the selected student.
     */
    private String generateDuplicateModuleAlreadyExist(ModuleCode moduleCode) {
        return String.format(MESSAGE_REMOVE_EXEMPTION_DUPLICATE_ALREADY_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message for removing the given {@code moduleCode}
     * from the list of exempted modules of the selected student.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_REMOVE_EXEMPTION_SUCCESS, moduleCode.value);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }
        List<ModuleCode> moduleCodesToExempt = new ArrayList<>();
        for (ModuleCode moduleCode : moduleCodes) {
            // Check if module is present in exempted modules list
            if (!model.hasExemptedModule(moduleCode)) {
                throw new CommandException(generateFailureMessage(moduleCode));
            }
            // Check if module already present in list of ModuleCodes to remove
            if (moduleCodesToExempt.contains(moduleCode)) {
                throw new CommandException(generateDuplicateModuleAlreadyExist(moduleCode));
            }
            moduleCodesToExempt.add(moduleCode);
        }
        List<String> messages = new ArrayList<>();
        for (ModuleCode moduleCode : moduleCodesToExempt) {
            model.removeExemptedModule(moduleCode);
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
        ExemptRemoveCommand that = (ExemptRemoveCommand) o;
        return moduleCodes.equals(that.moduleCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleCodes);
    }
}
//@@author

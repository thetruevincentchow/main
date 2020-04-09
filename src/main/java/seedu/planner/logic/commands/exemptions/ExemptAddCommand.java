package seedu.planner.logic.commands.exemptions;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.util.ModuleUtil;

//@@author thetruevincentchow
/**
 * Adds a module to the list of exempted modules of the selected student.
 */
public class ExemptAddCommand extends ExemptCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Adds the module to list of exempted modules.\n"
        + "Parameters: MODULE_CODE (must be a valid NUS module code)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";

    public static final String MESSAGE_ADD_MODULE_SUCCESS = "Added module to exemption list: %1$s";
    public static final String MESSAGE_ADD_MODULE_ALREADY_EXISTS = "Module is already in exemption list: %1$s";
    public static final String MESSAGE_ADD_MODULE_INVALID = "Module code does not exist: %1$s";


    private final ModuleCode moduleCode;

    public ExemptAddCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCode = moduleCode;
    }

    /**
     * Generates a command execution error message due to the given (@code moduleCode) being invalid.
     */
    private String generateModuleDoesNotExist(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_INVALID, moduleCode.value);
    }


    /**
     * Generates a command execution error message due to the given (@code moduleCode) already being present
     * in the list of exempted modules of the selected student.
     */
    private String generateDuplicateMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_ALREADY_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message for adding the (@code moduleCode)
     * to the list of exempted modules of the selected student.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_SUCCESS, moduleCode.value);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        // Check if module is present in exempted modules list
        if (model.hasExemptedModule(moduleCode)) {
            throw new CommandException(generateDuplicateMessage(moduleCode));
        }

        // Check if module exists in module database
        if (!ModuleUtil.hasModuleWithCode(moduleCode)) {
            throw new CommandException(generateModuleDoesNotExist(moduleCode));
        }

        model.addExemptedModule(moduleCode);
        return new CommandResult(generateSuccessMessage(moduleCode));
    }
}
//@@author

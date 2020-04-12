package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.util.ModuleUtil;


//@@author thetruevincentchow
/**
 * Adds a module to the selected timetable.
 */
public class ModuleAddCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": Adds the module to list of enrolled modules.\n"
        + "Parameters: MODULE_CODE (must be a valid NUS module code)\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030";

    public static final String MESSAGE_ADD_MODULE_SUCCESS = "Added module to timetable: %1$s";
    public static final String MESSAGE_ADD_MODULE_ALREADY_EXISTS = "Module is already in timetable: %1$s";
    public static final String MESSAGE_ADD_MODULE_INSERT_ALREADY_EXISTS = "Module appeared more than once in your "
            + "command: %1$s";
    public static final String MESSAGE_ADD_MODULE_INVALID = "Module code does not exist: %1$s";

    private final List<ModuleCode> moduleCodes;

    public ModuleAddCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCodes = Arrays.asList(moduleCode);
    }

    public ModuleAddCommand(List<ModuleCode> moduleCodes) {
        requireAllNonNull(moduleCodes);
        this.moduleCodes = new ArrayList<>();
        this.moduleCodes.addAll(moduleCodes);
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} being invalid.
     */
    private String generateModuleDoesNotExists(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_INVALID, moduleCode.value);
    }


    /**
     * Generates a command execution error message due to the given {@code moduleCode} already being present
     * in the selected timetable of the selected student.
     */
    private String generateDuplicateMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_ALREADY_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} already being present
     * in the list of previously parsed {@code moduleCode}.
     */
    private String generateDuplicateInsertMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_INSERT_ALREADY_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message for adding the given {@code moduleCode}
     * to the selected timetable of the selected student.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_SUCCESS, moduleCode);
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

        // Check if module is duplicate in active timetable
        // TODO: have an option to check globally (across all timetables) to prevent duplicate enrollments
        // NOTE: Multiple enrollments of the same module code in different timetables is intended behaviour,
        //       since you can retake modules under some circumstances.
        List<Enrollment> enrollments = new ArrayList<>();
        for (ModuleCode moduleCode : moduleCodes) {
            if (model.hasEnrollment(moduleCode)) {
                throw new CommandException(generateDuplicateMessage(moduleCode));
            }

            // Check if module exists in module database
            Module module = ModuleUtil.getModuleWithCode(moduleCode);
            if (module == null) {
                throw new CommandException(generateModuleDoesNotExists(moduleCode));
            }

            Enrollment enrollment = new Enrollment(moduleCode, Optional.empty(), module.getModuleCredit());
            if (enrollments.contains(enrollment)) {
                throw new CommandException(generateDuplicateInsertMessage(moduleCode));
            }
            enrollments.add(enrollment);
        }
        List<String> messages = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            model.addEnrollment(enrollment);
            messages.add(generateSuccessMessage(enrollment.getModuleCode()));
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
        ModuleAddCommand that = (ModuleAddCommand) o;
        return moduleCodes.equals(that.moduleCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleCodes);
    }
}
//@@author

package seedu.planner.logic.commands.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_GRADE;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_SU;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.util.ModuleUtil;


//@@author thetruevincentchow
/**
 * Base class for operations on the grade of an enrollment in the selected timetable.
 */
public abstract class ModuleGradeCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "grade";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
        + ": If GRADE is specified, sets the grade of the module specified.\n"
        + "Otherwise, displays grade of module specified.\n"
        + "Parameters: "
        + "MODULE_CODE "
        + "[" + PREFIX_GRADE + "GRADE] "
        + "[" + PREFIX_SU + "GRADE]\n"
        + "Example: " + getQualifiedCommand(COMMAND_WORD) + " CS2030 grade/A";

    public static final String MESSAGE_MODULE_INVALID = "Module code does not exist: %1$s";
    public static final String MESSAGE_MODULE_NOT_ENROLLED = "Module not in selected timetable: %1$s";
    public static final String MESSAGE_BOTH_GRADE_AND_SU = String.format("Only at most one of '%1$s' and '%2$s' "
        + "should be used to specify a grade", PREFIX_GRADE, PREFIX_SU);


    protected final ModuleCode moduleCode;

    public ModuleGradeCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCode = moduleCode;
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} being invalid.
     */
    private String generateModuleInvalidMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_MODULE_INVALID, moduleCode.value);
    }

    /**
     * Generates a command execution error message due to the given {@code moduleCode} being absent from
     * the active student.
     */
    private String generateModuleNotEnrolledMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_MODULE_NOT_ENROLLED, moduleCode.value);
    }

    /**
     * Validate that a student and timetable are selected, and that the requested {@code moduleCode}
     * is valid and is enrolled in the current timetable.
     */
    protected void validate(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (!model.hasActiveStudent()) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }
        if (!model.hasActiveTimeTable()) {
            throw new CommandException(Messages.MESSAGE_NO_TIMETABLE_ACTIVE);
        }

        // Check if module exists in module database
        if (!ModuleUtil.hasModuleWithCode(moduleCode)) {
            throw new CommandException(generateModuleInvalidMessage(moduleCode));
        }

        // Check if module is duplicate in active timetable
        // TODO: have an option to check globally (across all timetables) to prevent duplicate enrollments
        // NOTE: Multiple enrollments of the same module code in different timetables is intended behaviour,
        //       since you can retake modules under some circumstances.
        if (!model.hasEnrollment(moduleCode)) {
            throw new CommandException(generateModuleNotEnrolledMessage(moduleCode));
        }
    }
}
//@@author

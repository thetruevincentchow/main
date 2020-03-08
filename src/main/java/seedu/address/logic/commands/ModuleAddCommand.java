package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.PlannerModelManager;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Major;
import seedu.address.model.student.Student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class ModuleAddCommand extends ModuleCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'module add' command not implemented yet";

    public static final String MESSAGE_USAGE = "module " + COMMAND_WORD
            + ": Adds the module to list of enrolled modules.\n"
            + "Example: " + "module " + COMMAND_WORD + "CS2030";

    public static final String MESSAGE_ADD_MODULE_SUCCESS = "Added module to timetable: %1$s";
    public static final String MESSAGE_ADD_MODULE_ALREADY_EXISTS = "Module is already in timetable: %1$s";

    private final ModuleCode moduleCode;

    public ModuleAddCommand(ModuleCode moduleCode) {
        requireAllNonNull(moduleCode);

        this.moduleCode = moduleCode;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateDuplicateMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_ALREADY_EXISTS, moduleCode.value);
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(ModuleCode moduleCode) {
        return String.format(MESSAGE_ADD_MODULE_SUCCESS, moduleCode.value);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // TODO: add to a `TimeTable` of a `Student` or `User`
        //Student student = model.getActiveStudent();
        if (model.hasEnrollment(moduleCode)) {
            throw new CommandException(generateDuplicateMessage(moduleCode));
        }

        model.addEnrollment(moduleCode);

        /*
        Student editedStudent = new Student(student.getName(), student.getDegrees(), major);
        assert(model instanceof PlannerModelManager);
        model.setActiveStudent(editedStudent);
        */

        //return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
        return new CommandResult(generateSuccessMessage(moduleCode));
    }
}

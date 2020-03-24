package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;
import seedu.address.model.time.StudentSemester;

public class TimeTableListCommand extends TimeTableCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'timetable list' command not implemented yet";

    public static final String MESSAGE_USAGE = "timetable " + COMMAND_WORD
        + ": List semesters with timetables.\n"
        + "Example: " + "timetable " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Listed semesters for the active student (%1$s) :\n%2$s";

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student activeStudent, List<StudentSemester> semesters) {
        return String.format(MESSAGE_SUCCESS, activeStudent, semesters);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        //TODO: check there is an active timetable
        return new CommandResult(generateSuccessMessage(activeStudent, activeStudent.getStudentSemesters()));
    }
}

package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENT_SEM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENT_YEAR;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.student.Student;
import seedu.address.model.time.StudentSemester;

public class TimeTableAddCommand extends TimeTableCommand {
    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'timetable add' command not implemented yet";

    public static final String MESSAGE_USAGE = "timetable " + COMMAND_WORD
        + ": Adds a timetable with the given semester to the active student.\n"
        + "Parameters: "
        + "[" + PREFIX_STUDENT_YEAR + "YEAR] "
        + "[" + PREFIX_STUDENT_SEM + "SEMESTER] \n"
        + "Example: " + "timetable " + COMMAND_WORD + " year/1 sem/ONE";

    public static final String MESSAGE_ADD_TIMETABLE_SUCCESS = "Added timetable to semester: %1$s";
    public static final String MESSAGE_EXISTING_SEMESTER = "Semester already exists in list of timetables: %1$s";

    private final StudentSemester studentSemester;

    public TimeTableAddCommand(StudentSemester studentSemester) {
        requireAllNonNull(studentSemester);
        this.studentSemester = studentSemester;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(StudentSemester semesterYear) {
        return String.format(MESSAGE_ADD_TIMETABLE_SUCCESS, semesterYear);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        //TODO: validate semester

        if (model.getPlanner().hasSemester(studentSemester)) {
            throw new CommandException(String.format(MESSAGE_EXISTING_SEMESTER, studentSemester));
        }

        model.addSemesterTimeTable(studentSemester);

        return new CommandResult(generateSuccessMessage(studentSemester));
    }
}

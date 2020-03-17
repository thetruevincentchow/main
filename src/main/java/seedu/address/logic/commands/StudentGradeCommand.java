package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.grades.CumulativeGrade;
import seedu.address.model.student.Student;

import java.util.OptionalDouble;

import static java.util.Objects.requireNonNull;

public class StudentGradeCommand extends StudentCommand {
    public static final String COMMAND_WORD = "grade";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "'student grade' command not implemented yet";

    public static final String MESSAGE_USAGE = "student " + COMMAND_WORD
            + ": Display average grade of active student.\n"
            + "Example: " + "student " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Grade of active student %1$s: %2$s\n"
            + "Enrolled in %3$d MCs total, %4$d MCs are graded, %5$d MCs are declared S/U.";

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Student activeStudent, CumulativeGrade cumulativeGrade) {
        OptionalDouble gradeValue = cumulativeGrade.getAverage();
        return String.format(MESSAGE_SUCCESS,
                activeStudent,
                gradeValue.isPresent() ? String.format("%.2f/5.00", gradeValue.getAsDouble()) : "-/5.00",
                cumulativeGrade.getTotalCredits(),
                cumulativeGrade.getTotalGradedCredits(),
                cumulativeGrade.getTotalSuCredits());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        // Check if active student and timetable exists
        if (model.getActiveStudent() == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        Student activeStudent = model.getActiveStudent();
        CumulativeGrade cumulativeGrade = activeStudent.getCumulativeGrade();
        return new CommandResult(generateSuccessMessage(activeStudent, cumulativeGrade));
    }
}

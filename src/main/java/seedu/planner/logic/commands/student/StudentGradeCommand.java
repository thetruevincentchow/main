package seedu.planner.logic.commands.student;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.grades.CumulativeGrade;
import seedu.planner.model.grades.Grade;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.time.StudentSemester;


//@@author thetruevincentchow

/**
 * Lists the grade of the currently selected student.
 */
public class StudentGradeCommand extends StudentCommand {
    public static final String COMMAND_WORD = "grade";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
            + ": Display average grade of active student.\n"
            + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Grade of active student %1$s: %2$s\n"
            + "Enrolled in %3$d MCs total, %4$d MCs are graded, %5$d MCs exercise S/U option.\n"
            + "Grade for each module:\n%6$s";

    /**
     * Generates a command execution success message for listing the grades and statistics of the
     * specified {@code activeStudent}.
     */
    private String generateSuccessMessage(Student activeStudent, CumulativeGrade cumulativeGrade) {
        OptionalDouble gradeValue = cumulativeGrade.getAverage();

        StringBuffer buffer = new StringBuffer();

        for (StudentSemester sem : activeStudent.getStudentSemesters()) {
            TimeTable timeTable = activeStudent.getTimeTable(sem);

            buffer.append("\n");
            buffer.append(sem.toString());

            for (Enrollment enrollment : timeTable.getEnrollments()) {
                buffer.append("\n");
                buffer.append(enrollment.getModuleCode().value);
                buffer.append(String.format(" (%d MCs): ", enrollment.getCredit()));

                Optional<Grade> optionalGrade = enrollment.getGrade();
                if (optionalGrade.isPresent()) {
                    buffer.append(optionalGrade.get().toString());
                } else {
                    buffer.append("Pending");
                }
            }

            if (timeTable.isEmpty()) {
                buffer.append("\n");
                buffer.append("[None]");
            }

            buffer.append("\n");
        }

        return String.format(MESSAGE_SUCCESS,
                activeStudent,
                gradeValue.isPresent() ? String.format("%.2f/5.00", gradeValue.getAsDouble()) : "-/5.00",
                cumulativeGrade.getTotalCredits(),
                cumulativeGrade.getTotalGradedCredits(),
                cumulativeGrade.getTotalSuCredits(),
                buffer.toString());
    }

    /**
     * Executes {@code StudentGradeCommand}.
     *
     * @param model {@code Model} which the command should operate on
     * @return {@code CommandResult} produced from executing the command
     * @throws CommandException when an exception occurred while executing the command
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Student activeStudent = model.getActiveStudent();
        if (activeStudent == null) {
            throw new CommandException(Messages.MESSAGE_NO_STUDENT_ACTIVE);
        }

        CumulativeGrade cumulativeGrade = activeStudent.getCumulativeGrade();
        return new CommandResult(generateSuccessMessage(activeStudent, cumulativeGrade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
//@@author

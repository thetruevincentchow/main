package seedu.planner.logic.commands.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_ONE;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_TWO;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_2_SEM_ONE;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.commons.core.Messages;
import seedu.planner.commons.util.StringUtil;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.Planner;
import seedu.planner.model.UserPrefs;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.TimeTableMap;
import seedu.planner.model.time.StudentSemester;
import seedu.planner.testutil.StudentBuilder;
import seedu.planner.testutil.TypicalStudents;
import seedu.planner.testutil.TypicalTimeTables;

//@@author thetruevincentchow
/**
 * Contains integration tests (interaction with the Model) for TimeTableListCommand.
 */
public class TimeTableListCommandTest {
    @Test
    public void execute_showNonEmptyTimeTableList_success() {
        Planner planner = new Planner();

        TimeTableMap validTimeTableMap = TypicalTimeTables.getTypicalTimeTableMap();
        Student validStudent = new StudentBuilder(TypicalStudents.ALICE)
            .withTimeTableMap(validTimeTableMap).build();
        planner.setStudents(Arrays.asList(validStudent));
        planner.activateStudent(validStudent);


        final String expectedFeedback = String.format(TimeTableListCommand.MESSAGE_SUCCESS,
            validStudent, StringUtil.wrapCollection(validStudent.getStudentSemesters()));

        Model model = new ModelManager(planner, new UserPrefs());
        Model expectedModel = new ModelManager(model.getPlanner(), new UserPrefs());

        assertCommandSuccess(new TimeTableListCommand(), model, expectedFeedback, expectedModel);
    }

    @Test
    public void execute_showEmptyTimeTableList_success() {
        Planner planner = new Planner();

        TimeTableMap validTimeTableMap = TypicalTimeTables.getTypicalTimeTableMap();
        Student validStudent = new StudentBuilder(TypicalStudents.ALICE).build();
        planner.setStudents(Arrays.asList(validStudent));
        planner.activateStudent(validStudent);

        final String expectedFeedback = String.format(TimeTableListCommand.MESSAGE_SUCCESS, validStudent, "[None]");

        Model model = new ModelManager(planner, new UserPrefs());
        Model expectedModel = new ModelManager(model.getPlanner(), new UserPrefs());

        assertCommandSuccess(new TimeTableListCommand(), model, expectedFeedback, expectedModel);
    }

    @Test
    public void execute_noActiveStudent_throwsCommandException() {
        Model model = new ModelManager(TypicalStudents.getTypicalPlanner(), new UserPrefs());
        model.activateStudent(null);
        TimeTableListCommand timeTableListCommand = new TimeTableListCommand();

        assertThrows(CommandException.class, () -> timeTableListCommand.execute(model),
            Messages.MESSAGE_NO_STUDENT_ACTIVE);
    }

    /**
     * Returns a {@link TimeTableMap} containing empty timetables for the specified {@code semesters}.
     * @param semesters Any number of {@link StudentSemester}s
     * @return {@link TimeTableMap} with empty timetables for specified semesters
     */
    private TimeTableMap timeTableMapWithSemesters(StudentSemester... semesters) {
        TimeTableMap timeTableMap = new TimeTableMap();
        for (StudentSemester semester : semesters) {
            timeTableMap.put(semester, new TimeTable());
        }
        return timeTableMap;
    }

    /**
     * Returns a Model which stores a single {@link Student} with empty timetables for the specified {@code semesters}.
     * Ensures the student is active.
     * @param semesters Any number of {@link StudentSemester}s
     * @return {@link Model} with empty timetables for specified semesters
     */
    private Model modelWithStudentSemesters(StudentSemester... semesters) {
        TimeTableMap timeTableMap = timeTableMapWithSemesters(semesters);
        Student validStudent = new StudentBuilder(TypicalStudents.ALICE)
            .withTimeTableMap(timeTableMap).build();
        Planner planner = new Planner();
        planner.setStudents(Arrays.asList(validStudent));
        planner.activateStudent(validStudent);

        return new ModelManager(planner, new UserPrefs());
    }

    /**
     * Semesters for the timetables listed should be ordered by the semesters,
     * independent of the insertion order of semesters.
     */
    @Test
    public void execute_uniqueOrder_success() {
        Model model1 = modelWithStudentSemesters(YEAR_1_SEM_ONE, YEAR_1_SEM_TWO, YEAR_2_SEM_ONE);
        Model model2 = modelWithStudentSemesters(YEAR_2_SEM_ONE, YEAR_1_SEM_TWO, YEAR_1_SEM_ONE);

        Model expectedModel1 = new ModelManager(model1.getPlanner(), new UserPrefs());
        Model expectedModel2 = new ModelManager(model2.getPlanner(), new UserPrefs());

        CommandResult commandResult1 = assertCommandSuccess(new TimeTableListCommand(), model1, expectedModel1);
        CommandResult commandResult2 = assertCommandSuccess(new TimeTableListCommand(), model2, expectedModel2);
        assertEquals(commandResult1, commandResult2);
    }
}
//@@author

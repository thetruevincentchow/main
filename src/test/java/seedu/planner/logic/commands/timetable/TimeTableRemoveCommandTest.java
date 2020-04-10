package seedu.planner.logic.commands.timetable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_SEMESTER;
import static seedu.planner.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_ONE;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_TWO;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_2_SEM_ONE;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_6_SEM_ONE;
import static seedu.planner.testutil.TypicalStudents.getTypicalPlannerWithTimeTables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.UserPrefs;
import seedu.planner.model.student.Student;
import seedu.planner.model.time.StudentSemester;
import seedu.planner.testutil.TypicalStudents;

//@@author thetruevincentchow
/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code TimeTableRemoveCommand}.
 */
public class TimeTableRemoveCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalPlannerWithTimeTables(), new UserPrefs());
        expectedModel = new ModelManager(getTypicalPlannerWithTimeTables(), new UserPrefs());

        // failure of this precondition does not indicate test failure
        assert !model.getStudentList().isEmpty();
        assert !expectedModel.getStudentList().isEmpty();

        Student validStudent = model.getStudentList().get(0);

        model.activateStudent(validStudent);
        expectedModel.activateStudent(validStudent);

        // failure of this precondition does not indicate test failure
        assert !model.getStudentSemesters().isEmpty();
        assert !expectedModel.getStudentSemesters().isEmpty();
    }

    @Test
    public void execute_validStudentSemester_success() {
        StudentSemester studentSemesterToRemove = model.getStudentSemesters().get(0);
        TimeTableRemoveCommand timeTableRemoveCommand = new TimeTableRemoveCommand(studentSemesterToRemove);

        String expectedMessage = String.format(TimeTableRemoveCommand.MESSAGE_REMOVE_TIMETABLE_SUCCESS,
            studentSemesterToRemove);

        expectedModel.removeSemesterTimeTable(studentSemesterToRemove);
        assertCommandSuccess(timeTableRemoveCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noActiveStudent_throwsCommandException() {
        Model model = new ModelManager(TypicalStudents.getTypicalPlanner(), new UserPrefs());
        model.activateStudent(null);
        TimeTableRemoveCommand timeTableRemoveCommand = new TimeTableRemoveCommand(YEAR_1_SEM_ONE);

        assertThrows(CommandException.class, () -> timeTableRemoveCommand.execute(model),
            Messages.MESSAGE_NO_STUDENT_ACTIVE);
    }

    @Test
    public void execute_invalidStudentSemester_throwsCommandException() {
        StudentSemester outOfBoundStudentSemester = YEAR_6_SEM_ONE;

        // failure of this precondition does not indicate test failure
        assert !model.getStudentSemesters().contains(outOfBoundStudentSemester);

        TimeTableRemoveCommand timeTableRemoveCommand = new TimeTableRemoveCommand(outOfBoundStudentSemester);
        assertCommandFailure(timeTableRemoveCommand, model, String.format(MESSAGE_INVALID_SEMESTER,
            outOfBoundStudentSemester));
    }

    @Test
    public void equals() {
        TimeTableRemoveCommand timeTableRemoveYear1SemOne = new TimeTableRemoveCommand(YEAR_1_SEM_ONE);
        TimeTableRemoveCommand timeTableRemoveYear1SemTwo = new TimeTableRemoveCommand(YEAR_1_SEM_TWO);
        TimeTableRemoveCommand timeTableRemoveYear2SemOne = new TimeTableRemoveCommand(YEAR_2_SEM_ONE);

        // same object -> returns true
        assertTrue(timeTableRemoveYear1SemOne.equals(timeTableRemoveYear1SemOne));

        // same values -> returns true
        TimeTableRemoveCommand timeTableRemoveYear1SemOneCopy = new TimeTableRemoveCommand(YEAR_1_SEM_ONE);
        assertTrue(timeTableRemoveYear1SemOne.equals(timeTableRemoveYear1SemOneCopy));

        // different types -> returns false
        assertFalse(timeTableRemoveYear1SemOne.equals(1));

        // null -> returns false
        assertFalse(timeTableRemoveYear1SemOne.equals(null));

        // different StudentSemester -> returns false
        assertFalse(timeTableRemoveYear1SemOne.equals(timeTableRemoveYear1SemTwo));
        assertFalse(timeTableRemoveYear1SemOne.equals(timeTableRemoveYear2SemOne));
        assertFalse(timeTableRemoveYear1SemTwo.equals(timeTableRemoveYear2SemOne));
    }
}
//@@author

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
 * {@code TimeTableActiveCommand}.
 */
public class TimeTableActiveCommandTest {
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
        StudentSemester studentSemesterToActive = model.getStudentSemesters().get(0);
        TimeTableActiveCommand timeTableActiveCommand = new TimeTableActiveCommand(studentSemesterToActive);

        String expectedMessage = String.format(TimeTableActiveCommand.MESSAGE_ACTIVE_TIMETABLE_SUCCESS,
                studentSemesterToActive);

        expectedModel.activateSemester(studentSemesterToActive);
        assertCommandSuccess(timeTableActiveCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_noActiveStudent_throwsCommandException() {
        Model model = new ModelManager(TypicalStudents.getTypicalPlanner(), new UserPrefs());
        model.activateStudent(null);
        TimeTableActiveCommand timeTableActiveCommand = new TimeTableActiveCommand(YEAR_1_SEM_ONE);

        assertThrows(CommandException.class, () -> timeTableActiveCommand.execute(model),
                Messages.MESSAGE_NO_STUDENT_ACTIVE);
    }

    @Test
    public void execute_invalidStudentSemester_throwsCommandException() {
        StudentSemester outOfBoundStudentSemester = YEAR_6_SEM_ONE;

        // failure of this precondition does not indicate test failure
        assert !model.getStudentSemesters().contains(outOfBoundStudentSemester);

        TimeTableActiveCommand timeTableActiveCommand = new TimeTableActiveCommand(outOfBoundStudentSemester);
        assertCommandFailure(timeTableActiveCommand, model, String.format(MESSAGE_INVALID_SEMESTER,
                outOfBoundStudentSemester));
    }

    @Test
    public void equals() {
        TimeTableActiveCommand timeTableActiveYear1SemOne = new TimeTableActiveCommand(YEAR_1_SEM_ONE);
        TimeTableActiveCommand timeTableActiveYear1SemTwo = new TimeTableActiveCommand(YEAR_1_SEM_TWO);
        TimeTableActiveCommand timeTableActiveYear2SemOne = new TimeTableActiveCommand(YEAR_2_SEM_ONE);

        // same object -> returns true
        assertTrue(timeTableActiveYear1SemOne.equals(timeTableActiveYear1SemOne));

        // same values -> returns true
        TimeTableActiveCommand timeTableActiveYear1SemOneCopy = new TimeTableActiveCommand(YEAR_1_SEM_ONE);
        assertTrue(timeTableActiveYear1SemOne.equals(timeTableActiveYear1SemOneCopy));

        // different types -> returns false
        assertFalse(timeTableActiveYear1SemOne.equals(1));

        // null -> returns false
        assertFalse(timeTableActiveYear1SemOne.equals(null));

        // different StudentSemester -> returns false
        assertFalse(timeTableActiveYear1SemOne.equals(timeTableActiveYear1SemTwo));
        assertFalse(timeTableActiveYear1SemOne.equals(timeTableActiveYear2SemOne));
        assertFalse(timeTableActiveYear1SemTwo.equals(timeTableActiveYear2SemOne));
    }
}
//@@author


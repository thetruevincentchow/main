package seedu.planner.logic.commands.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.planner.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.planner.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;
import static seedu.planner.testutil.TypicalIndexes.INDEX_SECOND_STUDENT;
import static seedu.planner.testutil.TypicalStudents.getTypicalPlanner;

import org.junit.jupiter.api.Test;

import seedu.planner.commons.core.Messages;
import seedu.planner.commons.core.index.Index;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.UserPrefs;
import seedu.planner.model.student.Student;


//@@author thetruevincentchow
/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code StudentActiveCommand}.
 */
public class StudentActiveCommandTest {
    private Model model = new ModelManager(getTypicalPlanner(), new UserPrefs());

    @Test
    public void execute_validIndex_success() {
        Student studentToActive = model.getStudentList().get(INDEX_FIRST_STUDENT.getZeroBased());
        StudentActiveCommand studentActiveCommand = new StudentActiveCommand(INDEX_FIRST_STUDENT);

        String expectedMessage = String.format(StudentActiveCommand.MESSAGE_ACTIVE_STUDENT_SUCCESS, studentToActive);

        ModelManager expectedModel = new ModelManager(model.getPlanner(), new UserPrefs());
        expectedModel.activateStudent(studentToActive);

        assertCommandSuccess(studentActiveCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getStudentList().size() + 1);
        StudentActiveCommand studentActiveCommand = new StudentActiveCommand(outOfBoundIndex);

        assertCommandFailure(studentActiveCommand, model, Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        StudentActiveCommand activeFirstCommand = new StudentActiveCommand(INDEX_FIRST_STUDENT);
        StudentActiveCommand activeSecondCommand = new StudentActiveCommand(INDEX_SECOND_STUDENT);

        // same object -> returns true
        assertTrue(activeFirstCommand.equals(activeFirstCommand));

        // same values -> returns true
        StudentActiveCommand activeFirstCommandCopy = new StudentActiveCommand(INDEX_FIRST_STUDENT);
        assertTrue(activeFirstCommand.equals(activeFirstCommandCopy));

        // different types -> returns false
        assertFalse(activeFirstCommand.equals(1));

        // null -> returns false
        assertFalse(activeFirstCommand.equals(null));

        // different student -> returns false
        assertFalse(activeFirstCommand.equals(activeSecondCommand));
    }
}
//@@author

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
 * {@code StudentRemoveCommand}.
 */
public class StudentRemoveCommandTest {

    private Model model = new ModelManager(getTypicalPlanner(), new UserPrefs());

    @Test
    public void execute_validIndex_success() {
        Student studentToRemove = model.getStudentList().get(INDEX_FIRST_STUDENT.getZeroBased());
        StudentRemoveCommand studentRemoveCommand = new StudentRemoveCommand(INDEX_FIRST_STUDENT);

        String expectedMessage = String.format(StudentRemoveCommand.MESSAGE_REMOVE_STUDENT_SUCCESS, studentToRemove);

        ModelManager expectedModel = new ModelManager(model.getPlanner(), new UserPrefs());
        expectedModel.removeStudent(studentToRemove);

        assertCommandSuccess(studentRemoveCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getStudentList().size() + 1);
        StudentRemoveCommand studentRemoveCommand = new StudentRemoveCommand(outOfBoundIndex);

        assertCommandFailure(studentRemoveCommand, model, Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        StudentRemoveCommand removeFirstCommand = new StudentRemoveCommand(INDEX_FIRST_STUDENT);
        StudentRemoveCommand removeSecondCommand = new StudentRemoveCommand(INDEX_SECOND_STUDENT);

        // same object -> returns true
        assertTrue(removeFirstCommand.equals(removeFirstCommand));

        // same values -> returns true
        StudentRemoveCommand removeFirstCommandCopy = new StudentRemoveCommand(INDEX_FIRST_STUDENT);
        assertTrue(removeFirstCommand.equals(removeFirstCommandCopy));

        // different types -> returns false
        assertFalse(removeFirstCommand.equals(1));

        // null -> returns false
        assertFalse(removeFirstCommand.equals(null));

        // different student -> returns false
        assertFalse(removeFirstCommand.equals(removeSecondCommand));
    }
}
//@@author

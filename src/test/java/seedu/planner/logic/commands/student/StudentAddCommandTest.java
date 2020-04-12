package seedu.planner.logic.commands.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.ModelStub;
import seedu.planner.model.Planner;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.student.Student;
import seedu.planner.testutil.StudentBuilder;

//@@author thetruevincentchow

/**
 * Contains unit tests for {@code StudentAddCommand}.
 */
class StudentAddCommandTest {
    @Test
    public void constructor_nullStudent_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StudentAddCommand(null));
    }

    @Test
    public void execute_studentAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingStudentAdded modelStub = new ModelStubAcceptingStudentAdded();
        Student validStudent = new StudentBuilder().build();

        CommandResult commandResult = new StudentAddCommand(validStudent).execute(modelStub);

        assertEquals(String.format(StudentAddCommand.MESSAGE_ADD_STUDENT_SUCCESS, validStudent),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validStudent), modelStub.studentsAdded);
    }

    @Test
    public void execute_duplicateStudent_throwsCommandException() {
        Student validStudent = new StudentBuilder().build();
        StudentAddCommand studentAddCommand = new StudentAddCommand(validStudent);
        ModelStub modelStub = new ModelStubWithStudent(validStudent);

        assertThrows(CommandException.class, () -> studentAddCommand.execute(modelStub),
                StudentAddCommand.MESSAGE_DUPLICATE_STUDENT);
    }

    @Test
    public void equals() {
        Student aliceCs = new StudentBuilder().withName("Alice").withMajor("CS").build();
        Student bobCs = new StudentBuilder().withName("Bob").withMajor("CS").build();
        Student aliceIs = new StudentBuilder().withName("Alice").withMajor("IS").build();
        Student bobIs = new StudentBuilder().withName("Bob").withMajor("IS").build();

        StudentAddCommand studentAddAliceCsCommand = new StudentAddCommand(aliceCs);
        StudentAddCommand studentAddBobCsCommand = new StudentAddCommand(bobCs);
        StudentAddCommand studentAddAliceIsCommand = new StudentAddCommand(aliceIs);
        StudentAddCommand studentAddBobIsCommand = new StudentAddCommand(bobIs);

        // same object -> returns true
        assertTrue(studentAddAliceCsCommand.equals(studentAddAliceCsCommand));

        // same values -> returns true
        StudentAddCommand studentAddAliceCsCommandCopy = new StudentAddCommand(aliceCs);
        assertTrue(studentAddAliceCsCommand.equals(studentAddAliceCsCommandCopy));

        // different types -> returns false
        assertFalse(studentAddAliceCsCommand.equals(1));

        // null -> returns false
        assertFalse(studentAddAliceCsCommand.equals(null));

        // different names -> returns false
        assertFalse(studentAddAliceCsCommand.equals(studentAddBobCsCommand));

        // different majors -> return false
        assertFalse(studentAddAliceCsCommand.equals(studentAddAliceIsCommand));

        // different names and majors -> return false
        assertFalse(studentAddAliceCsCommand.equals(studentAddBobIsCommand));
    }

    /**
     * A Model stub that always accept the student being added.
     */
    private class ModelStubAcceptingStudentAdded extends ModelStub {
        final ArrayList<Student> studentsAdded = new ArrayList<>();

        @Override
        public boolean hasStudent(Student student) {
            requireAllNonNull(student);
            return studentsAdded.stream().anyMatch(student::isSameStudent);
        }

        @Override
        public void addStudent(Student student) {
            requireAllNonNull(student);
            studentsAdded.add(student);
        }

        @Override
        public ReadOnlyPlanner getPlanner() {
            return new Planner();
        }
    }

    /**
     * A Model stub that contains a single student.
     */
    private class ModelStubWithStudent extends ModelStub {
        private final Student student;

        ModelStubWithStudent(Student student) {
            requireAllNonNull(student);
            this.student = student;
        }

        @Override
        public boolean hasStudent(Student student) {
            requireAllNonNull(student);
            return this.student.isSameStudent(student);
        }
    }
}
//@@author

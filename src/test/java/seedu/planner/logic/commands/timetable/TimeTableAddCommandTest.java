package seedu.planner.logic.commands.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_ONE;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_1_SEM_TWO;
import static seedu.planner.testutil.TypicalStudentSemesters.YEAR_2_SEM_ONE;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.planner.commons.core.Messages;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.ModelStub;
import seedu.planner.model.Planner;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.time.StudentSemester;

//@@author thetruevincentchow

/**
 * Contains unit tests for {@code TimeTableAddCommand}.
 */
class TimeTableAddCommandTest {

    private static final StudentSemester validStudentSemester = YEAR_1_SEM_ONE;

    @Test
    public void constructor_nullStudentSemester_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeTableAddCommand(null));
    }

    @Test
    public void execute_noActiveStudent_throwsCommandException() {
        ModelStubNoActiveStudent modelStub = new ModelStubNoActiveStudent();
        TimeTableAddCommand timeTableAddCommand = new TimeTableAddCommand(validStudentSemester);

        assertThrows(CommandException.class, () -> timeTableAddCommand.execute(modelStub),
                Messages.MESSAGE_NO_STUDENT_ACTIVE);
    }

    @Test
    public void execute_studentSemesterAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingTimeTableAdded modelStub = new ModelStubAcceptingTimeTableAdded();

        CommandResult commandResult = new TimeTableAddCommand(validStudentSemester).execute(modelStub);

        assertEquals(String.format(TimeTableAddCommand.MESSAGE_ADD_TIMETABLE_SUCCESS, validStudentSemester),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validStudentSemester), modelStub.studentSemestersAdded);
    }

    @Test
    public void execute_duplicateStudentSemester_throwsCommandException() {
        TimeTableAddCommand timeTableAddCommand = new TimeTableAddCommand(validStudentSemester);
        ModelStub modelStub = new ModelStubWithTimeTable(validStudentSemester);

        assertThrows(CommandException.class, () -> timeTableAddCommand.execute(modelStub),
                TimeTableAddCommand.MESSAGE_EXISTING_SEMESTER);
    }

    @Test
    public void equals() {
        TimeTableAddCommand timeTableAddYear1SemOne = new TimeTableAddCommand(YEAR_1_SEM_ONE);
        TimeTableAddCommand timeTableAddYear1SemTwo = new TimeTableAddCommand(YEAR_1_SEM_TWO);
        TimeTableAddCommand timeTableAddYear2SemOne = new TimeTableAddCommand(YEAR_2_SEM_ONE);

        // same object -> returns true
        assertTrue(timeTableAddYear1SemOne.equals(timeTableAddYear1SemOne));

        // same values -> returns true
        TimeTableAddCommand timeTableAddYear1SemOneCopy = new TimeTableAddCommand(YEAR_1_SEM_ONE);
        assertTrue(timeTableAddYear1SemOne.equals(timeTableAddYear1SemOneCopy));

        // different types -> returns false
        assertFalse(timeTableAddYear1SemOne.equals(1));

        // null -> returns false
        assertFalse(timeTableAddYear1SemOne.equals(null));

        // different StudentSemester -> returns false
        assertFalse(timeTableAddYear1SemOne.equals(timeTableAddYear1SemTwo));
        assertFalse(timeTableAddYear1SemOne.equals(timeTableAddYear2SemOne));
        assertFalse(timeTableAddYear1SemTwo.equals(timeTableAddYear2SemOne));
    }

    /**
     * A Model stub that always has an active student and always accept the timetable being added.
     */
    private class ModelStubAcceptingTimeTableAdded extends ModelStub {
        final ArrayList<StudentSemester> studentSemestersAdded = new ArrayList<>();

        @Override
        public boolean hasActiveStudent() {
            return true;
        }

        @Override
        public boolean hasSemester(StudentSemester studentSemester) {
            requireAllNonNull(studentSemester);
            return studentSemestersAdded.stream().anyMatch(studentSemester::equals);
        }

        @Override
        public void addSemesterTimeTable(StudentSemester studentSemester) {
            requireAllNonNull(studentSemester);
            studentSemestersAdded.add(studentSemester);
        }

        @Override
        public ReadOnlyPlanner getPlanner() {
            return new Planner();
        }
    }

    /**
     * A Model stub that always has an active student and contains a single timetable.
     */
    private class ModelStubWithTimeTable extends ModelStub {
        private final StudentSemester studentSemester;

        ModelStubWithTimeTable(StudentSemester studentSemester) {
            requireAllNonNull(studentSemester);
            this.studentSemester = studentSemester;
        }

        @Override
        public boolean hasActiveStudent() {
            return true;
        }

        @Override
        public boolean hasSemester(StudentSemester studentSemester) {
            requireAllNonNull(studentSemester);
            return this.studentSemester.equals(studentSemester);
        }
    }

    /**
     * A Model stub that does not have an active student.
     */
    private class ModelStubNoActiveStudent extends ModelStub {
        @Override
        public boolean hasActiveStudent() {
            return false;
        }
    }
}
//@@author

package seedu.planner.logic.commands.lesson;

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
import seedu.planner.logic.commands.lessons.LessonAddCommand;
import seedu.planner.model.ModelStub;
import seedu.planner.model.Planner;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.module.Lesson;
import seedu.planner.testutil.LessonBuilder;


/**
 * Contains unit tests for {@code LessonAddCommand}.
 */
class LessonAddCommandTest {
    @Test
    public void constructor_nullLesson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new LessonAddCommand(null));
    }

    @Test
    public void execute_lessonAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingLessonAdded modelStub = new ModelStubAcceptingLessonAdded();
        Lesson validLesson = new LessonBuilder().build();

        CommandResult commandResult = new LessonAddCommand(validLesson).execute(modelStub);

        assertEquals(String.format(LessonAddCommand.MESSAGE_ADD_LESSON_SUCCESS, validLesson.getClassNo()),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validLesson), modelStub.lessonsAdded);
    }

    @Test
    public void execute_duplicateStudent_throwsCommandException() {
        Lesson validLesson = new LessonBuilder().build();
        LessonAddCommand lessonAddCommand = new LessonAddCommand(validLesson);
        ModelStub modelStub = new ModelStubWithLesson(validLesson);

        assertThrows(CommandException.class, () -> lessonAddCommand.execute(modelStub),
                LessonAddCommand.MESSAGE_ADD_LESSON_ALREADY_EXISTS);
    }

    @Test
    public void equals() {
        Object week = new Object();
        Lesson cs1231 = new LessonBuilder().withClassNo("10").withWeek(week).build();
        Lesson cs2030 = new LessonBuilder().withClassNo("20").withWeek(week).build();

        LessonAddCommand lessonAddCS1231Command = new LessonAddCommand(cs1231);
        LessonAddCommand lessonAddCS2030Command = new LessonAddCommand(cs2030);

        // same object -> returns true
        assertTrue(lessonAddCS1231Command.equals(lessonAddCS1231Command));

        // different types -> returns false
        assertFalse(lessonAddCS1231Command.equals(1));

        // null -> returns false
        assertFalse(lessonAddCS1231Command.equals(null));

        // different lessons -> returns false
        assertFalse(lessonAddCS1231Command.equals(lessonAddCS2030Command));
    }

    /**
     * A Model stub that always accept the lesson being added.
     */
    private class ModelStubAcceptingLessonAdded extends ModelStub {
        final ArrayList<Lesson> lessonsAdded = new ArrayList<>();

        @Override
        public boolean hasLesson(Lesson lesson) {
            requireAllNonNull(lesson);
            return lessonsAdded.stream().anyMatch(lesson::isSameLesson);
        }

        @Override
        public void addLesson(Lesson lesson) {
            requireAllNonNull(lesson);
            lessonsAdded.add(lesson);
        }

        @Override
        public ReadOnlyPlanner getPlanner() {
            return new Planner();
        }
    }

    /**
     * A Model stub that contains a single lesson.
     */
    private class ModelStubWithLesson extends ModelStub {
        private final Lesson lesson;

        ModelStubWithLesson(Lesson lesson) {
            requireAllNonNull(lesson);
            this.lesson = lesson;
        }

        @Override
        public boolean hasLesson(Lesson lesson) {
            requireAllNonNull(lesson);
            return this.lesson.isSameLesson(lesson);
        }
    }
}

package seedu.planner.logic.commands.lesson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;
import static seedu.planner.testutil.TypicalIndexes.INDEX_SECOND_STUDENT;
import static seedu.planner.testutil.TypicalStudents.getTypicalPlanner;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.lessons.LessonRemoveCommand;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.ModelStub;
import seedu.planner.model.UserPrefs;
import seedu.planner.model.module.Lesson;
import seedu.planner.testutil.LessonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code StudentRemoveCommand}.
 */
public class LessonRemoveCommandTest {

    private Model model = new ModelManager(getTypicalPlanner(), new UserPrefs());

    @Test
    public void execute_validIndex_success() throws Exception {
        Lesson validLesson = new LessonBuilder().build();
        ModelStub modelStub = new ModelStubWithLesson(validLesson);
        CommandResult commandResult = new LessonRemoveCommand(INDEX_FIRST_STUDENT).execute(modelStub);
        assertEquals(String.format(LessonRemoveCommand.MESSAGE_REMOVE_LESSON_SUCCESS, validLesson.getClassNo()),
                commandResult.getFeedbackToUser());
    }

    @Test
    public void equals() {
        LessonRemoveCommand removeFirstCommand = new LessonRemoveCommand(INDEX_FIRST_STUDENT);
        LessonRemoveCommand removeSecondCommand = new LessonRemoveCommand(INDEX_SECOND_STUDENT);

        // same object -> returns true
        assertTrue(removeFirstCommand.equals(removeFirstCommand));

        // different types -> returns false
        assertFalse(removeFirstCommand.equals(1));

        // null -> returns false
        assertFalse(removeFirstCommand.equals(null));

        // different student -> returns false
        assertFalse(removeFirstCommand.equals(removeSecondCommand));
    }

    /**
     * A Model stub that contains a single lesson.
     */
    private class ModelStubWithLesson extends ModelStub {
        private final Lesson lesson;
        private List<Lesson> lessons = new ArrayList<>();

        ModelStubWithLesson(Lesson lesson) {
            requireAllNonNull(lesson);
            this.lesson = lesson;
            lessons.add(lesson);
        }

        public List<Lesson> getLessons() {
            return lessons;
        }

        public void removeLesson(Lesson lesson) {
            lessons.remove(lesson);
        }

        @Override
        public boolean hasLesson(Lesson lesson) {
            requireAllNonNull(lesson);
            return this.lesson.isSameLesson(lesson);
        }
    }
}

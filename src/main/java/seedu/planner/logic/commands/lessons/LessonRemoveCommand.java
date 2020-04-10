package seedu.planner.logic.commands.lessons;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import seedu.planner.commons.core.Messages;
import seedu.planner.commons.core.index.Index;
import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.Lesson;

public class LessonRemoveCommand extends LessonCommand {

    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
            + ": Removes the lessons from list of lessons enrolled in.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + getQualifiedCommand(COMMAND_WORD) + " 1";

    public static final String MESSAGE_REMOVE_LESSON_SUCCESS = "Removed lesson: %1$s";

    private final Index index;

    public LessonRemoveCommand(Index index) {
        requireAllNonNull(index);
        this.index = index;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Lesson removedLesson) {
        return String.format(MESSAGE_REMOVE_LESSON_SUCCESS, removedLesson.getClassNo());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Lesson> lastShownList = model.getLessons();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        }

        Lesson removedLesson = lastShownList.get(index.getZeroBased());
        model.removeLesson(removedLesson);

        return new CommandResult(generateSuccessMessage(removedLesson));
    }
}

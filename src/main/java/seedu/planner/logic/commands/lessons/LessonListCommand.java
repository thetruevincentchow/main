package seedu.planner.logic.commands.lessons;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.Lesson;

public class LessonListCommand extends LessonCommand {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = getQualifiedCommand(COMMAND_WORD)
            + ": List Lesson in the lessons list.\n"
            + "Example: " + getQualifiedCommand(COMMAND_WORD);

    public static final String MESSAGE_SUCCESS = "Listed Lesson in Lesson list:\n%1$s";

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(List<Lesson> lessons) {
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for (int i = 0; i < lessons.size(); ++i) {
            Lesson lesson = lessons.get(i);
            if (!isFirst) {
                sb.append("\n");
            }
            sb.append(i + 1);
            sb.append(": ");
            sb.append(lesson.getClassNo() + " " + lesson.getLessonType());
            isFirst = false;
        }

        return String.format(MESSAGE_SUCCESS, sb.length() == 0 ? "[None]" : sb.toString());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Lesson> lastShownList = model.getLessons();

        return new CommandResult(generateSuccessMessage(lastShownList));
    }
}

package seedu.planner.logic.commands.lessons;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_LESSON;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MODULE;

import seedu.planner.logic.commands.CommandResult;
import seedu.planner.logic.commands.exceptions.CommandException;
import seedu.planner.model.Model;
import seedu.planner.model.module.Lesson;

public class LessonAddCommand extends LessonCommand {

    public static final String COMMAND_WORD = "add";

    public static final String EXAMPLE_COMMAND =
            getQualifiedCommand(COMMAND_WORD) + " " + PREFIX_MODULE + "CS2030 " + PREFIX_LESSON + "10";

    public static final String MESSAGE_ADD_LESSON_SUCCESS = "Added lessons to timetable: %1$s";
    public static final String MESSAGE_ADD_LESSON_ALREADY_EXISTS = "Lesson is already in timetable: %1$s";
    public static final String MESSAGE_ADD_LESSON_INVALID = "Lesson code does not exist: %1$s";

    private final Lesson lesson;

    public LessonAddCommand(Lesson lesson) {
        requireAllNonNull(lesson);
        this.lesson = lesson;
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateModuleDoesNotExists(Lesson lesson) {
        return String.format(MESSAGE_ADD_LESSON_INVALID, lesson.getClassNo());
    }


    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateDuplicateMessage(Lesson lesson) {
        return String.format(MESSAGE_ADD_LESSON_ALREADY_EXISTS, lesson.getClassNo());
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Lesson lesson) {
        return String.format(MESSAGE_ADD_LESSON_SUCCESS, lesson.getClassNo());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasLesson(lesson)) {
            throw new CommandException(MESSAGE_ADD_LESSON_ALREADY_EXISTS);
        }
        if (lesson.getClassNo() == null) {
            throw new CommandException(generateDuplicateMessage(lesson));
        }
        model.addLesson(lesson);
        return new CommandResult(generateSuccessMessage(lesson));
    }
}

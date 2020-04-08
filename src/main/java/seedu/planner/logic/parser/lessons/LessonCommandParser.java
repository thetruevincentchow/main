package seedu.planner.logic.parser.lessons;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.planner.logic.commands.lessons.LessonAddCommand;
import seedu.planner.logic.commands.lessons.LessonCommand;
import seedu.planner.logic.commands.lessons.LessonListCommand;
import seedu.planner.logic.commands.lessons.LessonRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.exceptions.ParseException;

public class LessonCommandParser implements Parser<LessonCommand> {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+) ?(?<arguments>.*)");

    /**
     * Parses user subcommand input into command for execution.
     *
     * @param userInput user subcommand input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public LessonCommand parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, LessonCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {
        case LessonAddCommand.COMMAND_WORD:
            return new LessonAddCommandParser().parse(arguments);

        case LessonRemoveCommand.COMMAND_WORD:
            return new LessonRemoveCommandParser().parse(arguments);

        case LessonListCommand.COMMAND_WORD:
            return new LessonListCommand();

        default:
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, LessonCommand.MESSAGE_USAGE));
        }
    }
}

package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.StudentRemoveCommand;
import seedu.address.logic.commands.TimeTableActiveCommand;
import seedu.address.logic.commands.TimeTableAddCommand;
import seedu.address.logic.commands.TimeTableCommand;
import seedu.address.logic.commands.TimeTableListCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class TimeTableCommandParser implements Parser<TimeTableCommand> {
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
    public TimeTableCommand parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {
        case StudentRemoveCommand.COMMAND_WORD:
            return new TimeTableRemoveCommandParser().parse(arguments);

        case TimeTableAddCommand.COMMAND_WORD:
            return new TimeTableAddCommandParser().parse(arguments);

        case TimeTableActiveCommand.COMMAND_WORD:
            return new TimeTableActiveCommandParser().parse(arguments);

        case TimeTableListCommand.COMMAND_WORD:
            return new TimeTableListCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}

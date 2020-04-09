package seedu.planner.logic.parser.exemptions;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.planner.logic.commands.exemptions.ExemptAddCommand;
import seedu.planner.logic.commands.exemptions.ExemptCommand;
import seedu.planner.logic.commands.exemptions.ExemptListCommand;
import seedu.planner.logic.commands.exemptions.ExemptRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.exceptions.ParseException;

//@@author thetruevincentchow

/**
 * Parses sub-commands of the "exempt" command and creates a new ExemptCommand object
 */
public class ExemptCommandParser implements Parser<ExemptCommand> {
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
    public ExemptCommand parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, ExemptCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {
        case ExemptAddCommand.COMMAND_WORD:
            return new ExemptAddCommandParser().parse(arguments);

        case ExemptRemoveCommand.COMMAND_WORD:
            return new ExemptRemoveCommandParser().parse(arguments);

        case ExemptListCommand.COMMAND_WORD:
            return new ExemptListCommand();

        default:
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, ExemptCommand.MESSAGE_USAGE));
        }
    }
}
//@@author

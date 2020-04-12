package seedu.planner.logic.parser.exemptions;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;

import seedu.planner.logic.commands.exemptions.ExemptAddCommand;
import seedu.planner.logic.commands.exemptions.ExemptCommand;
import seedu.planner.logic.commands.exemptions.ExemptListCommand;
import seedu.planner.logic.commands.exemptions.ExemptRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.SubCommandSplitter;
import seedu.planner.logic.parser.exceptions.ParseException;

//@@author thetruevincentchow

/**
 * Parses sub-commands of the "exempt" command and creates a new ExemptCommand object.
 */
public class ExemptCommandParser implements Parser<ExemptCommand> {

    /**
     * Parses user subcommand input into command for execution.
     *
     * @param userInput user subcommand input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ExemptCommand parse(String userInput) throws ParseException {
        SubCommandSplitter subCommandSplitter = new SubCommandSplitter(userInput, ExemptCommand.MESSAGE_USAGE);

        final String commandWord = subCommandSplitter.getCommand();
        final String arguments = subCommandSplitter.getSubCommand();

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

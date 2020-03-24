package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.StudentActiveCommand;
import seedu.address.logic.commands.StudentRemoveCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class StudentActiveCommandParser implements Parser<StudentActiveCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public StudentActiveCommand parse(String args) throws ParseException {
        requireNonNull(args);
        Index index;

        try {
            index = ParserUtil.parseIndex(args);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, StudentActiveCommand.MESSAGE_USAGE), pe);
        }

        return new StudentActiveCommand(index);
    }
}

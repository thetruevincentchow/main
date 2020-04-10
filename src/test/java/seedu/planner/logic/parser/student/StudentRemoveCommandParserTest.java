package seedu.planner.logic.parser.student;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.planner.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.student.StudentRemoveCommand;

//@@author thetruevincentchow
class StudentRemoveCommandParserTest {
    private StudentRemoveCommandParser parser = new StudentRemoveCommandParser();

    @Test
    public void parse_validArgs_returnsRemoveCommand() {
        assertParseSuccess(parser, "1", new StudentRemoveCommand(INDEX_FIRST_STUDENT));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentRemoveCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentRemoveCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentRemoveCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "0", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentRemoveCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "-1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentRemoveCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "+1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentRemoveCommand.MESSAGE_USAGE));
    }
}
//@@author

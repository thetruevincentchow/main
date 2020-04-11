package seedu.planner.logic.parser.exemptions;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.exemptions.ExemptRemoveCommand;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow
class ExemptRemoveCommandParserTest {
    private ExemptRemoveCommandParser parser = new ExemptRemoveCommandParser();

    @Test
    public void parse_validArgs_returnsRemoveCommand() {
        assertParseSuccess(parser, "CS2040", new ExemptRemoveCommand(new ModuleCode("CS2040")));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // empty
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ExemptRemoveCommand.MESSAGE_USAGE));

        // whitespace only
        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ExemptRemoveCommand.MESSAGE_USAGE));

        // invalid exempt code format
        /* Temporarily omitting due to discussion on allowing multiple module codes to be entered
        assertParseFailure(parser, "a  b", ModuleCode.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "a\tb", ModuleCode.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "-4asdf++!", ModuleCode.MESSAGE_CONSTRAINTS);
         */
    }
}
//@@author

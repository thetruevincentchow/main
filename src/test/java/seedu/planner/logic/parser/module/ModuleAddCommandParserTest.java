package seedu.planner.logic.parser.module;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.module.ModuleAddCommand;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow
class ModuleAddCommandParserTest {
    private ModuleAddCommandParser parser = new ModuleAddCommandParser();

    @Test
    public void parse_validArgs_returnsAddCommand() {
        List<ModuleCode> moduleCodes = new ArrayList<>();
        moduleCodes.add(new ModuleCode("CS2040"));
        assertParseSuccess(parser, "CS2040", new ModuleAddCommand(moduleCodes));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // empty
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ModuleAddCommand.MESSAGE_USAGE));

        // whitespace only
        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ModuleAddCommand.MESSAGE_USAGE));

        // invalid module code format
        assertParseFailure(parser, "a  b", ModuleCode.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "a\tb", ModuleCode.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "-4asdf++!", ModuleCode.MESSAGE_CONSTRAINTS);
    }
}
//@@author

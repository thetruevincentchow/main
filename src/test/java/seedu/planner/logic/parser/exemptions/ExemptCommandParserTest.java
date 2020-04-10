package seedu.planner.logic.parser.exemptions;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;
import static seedu.planner.logic.commands.CommandTestUtil.INVALID_SUBCOMMAND;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.exemptions.ExemptAddCommand;
import seedu.planner.logic.commands.exemptions.ExemptCommand;
import seedu.planner.logic.commands.exemptions.ExemptRemoveCommand;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow
class ExemptCommandParserTest {
    private ExemptCommandParser parser = new ExemptCommandParser();

    @Test
    public void parse_validArgs_success() {
        assertParseSuccess(parser, "add CS2040", new ExemptAddCommand(new ModuleCode("CS2040")));

        assertParseSuccess(parser, "remove  CS2040", new ExemptRemoveCommand(new ModuleCode("CS2040")));
    }

    @Test
    public void parse_subCommandMissing_failure() {
        assertParseFailure(parser, "", String.format(MESSAGE_UNKNOWN_SUBCOMMAND, ExemptCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            ExemptCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_subCommandInvalid_failure() {
        assertParseFailure(parser, INVALID_SUBCOMMAND, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            ExemptCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE + INVALID_SUBCOMMAND, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            ExemptCommand.MESSAGE_USAGE));
    }
}
//@@author

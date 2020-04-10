package seedu.planner.logic.parser.module;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;
import static seedu.planner.logic.commands.CommandTestUtil.INVALID_SUBCOMMAND;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.module.ModuleAddCommand;
import seedu.planner.logic.commands.module.ModuleCommand;
import seedu.planner.logic.commands.module.ModuleGradeSetCommand;
import seedu.planner.logic.commands.module.ModuleGradeViewCommand;
import seedu.planner.logic.commands.module.ModuleRemoveCommand;
import seedu.planner.model.grades.LetterGrade;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow
class ModuleCommandParserTest {
    private ModuleCommandParser parser = new ModuleCommandParser();

    @Test
    public void parse_validArgs_success() {
        assertParseSuccess(parser, "add CS2040", new ModuleAddCommand(new ModuleCode("CS2040")));

        assertParseSuccess(parser, "remove  CS2040", new ModuleRemoveCommand(new ModuleCode("CS2040")));

        assertParseSuccess(parser, "grade  CS2040", new ModuleGradeViewCommand(new ModuleCode("CS2040")));
        assertParseSuccess(parser, "grade  CS2040  grade/A-", new ModuleGradeSetCommand(new ModuleCode("CS2040"),
            LetterGrade.A_MINUS));
    }

    @Test
    public void parse_subCommandMissing_failure() {
        assertParseFailure(parser, "", String.format(MESSAGE_UNKNOWN_SUBCOMMAND, ModuleCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            ModuleCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_subCommandInvalid_failure() {
        assertParseFailure(parser, INVALID_SUBCOMMAND, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            ModuleCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE + INVALID_SUBCOMMAND, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            ModuleCommand.MESSAGE_USAGE));
    }
}
//@@author

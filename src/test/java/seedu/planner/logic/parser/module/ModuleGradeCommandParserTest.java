package seedu.planner.logic.parser.module;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.module.ModuleGradeCommand;
import seedu.planner.logic.commands.module.ModuleGradeSetCommand;
import seedu.planner.logic.commands.module.ModuleGradeViewCommand;
import seedu.planner.model.grades.LetterGrade;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow
class ModuleGradeCommandParserTest {
    private ModuleGradeCommandParser parser = new ModuleGradeCommandParser();

    @Test
    public void parse_validArgs_returnsAddCommand() {
        assertParseSuccess(parser, "CS2040", new ModuleGradeViewCommand(new ModuleCode("CS2040")));

        assertParseSuccess(parser, "CS2040     grade/A+",
            new ModuleGradeSetCommand(new ModuleCode("CS2040"), LetterGrade.A_PLUS));
        assertParseSuccess(parser, "CS2040    grade/EXE",
            new ModuleGradeSetCommand(new ModuleCode("CS2040"), LetterGrade.EXE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // empty
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ModuleGradeCommand.MESSAGE_USAGE));

        // whitespace only
        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ModuleGradeCommand.MESSAGE_USAGE));

        // invalid module code format
        assertParseFailure(parser, "a  b", ModuleCode.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "a\tb", ModuleCode.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "-4asdf++!", ModuleCode.MESSAGE_CONSTRAINTS);

        // grade prefix present but argument empty
        assertParseFailure(parser, "CS2040 grade/", LetterGrade.MESSAGE_CONSTRAINTS);

        // grade invalid
        assertParseFailure(parser, "CS2040 grade/EE EE", LetterGrade.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, "CS2040 grade/F+", LetterGrade.MESSAGE_CONSTRAINTS);

        // grade parameter occurs before module code
        assertParseFailure(parser, "grade/A  CS2040", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            ModuleGradeCommand.MESSAGE_USAGE));
    }
}
//@@author

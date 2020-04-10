package seedu.planner.logic.parser.student;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.commands.CommandTestUtil.INVALID_MAJOR_DESC;
import static seedu.planner.logic.commands.CommandTestUtil.MAJOR_DESC_CS;
import static seedu.planner.logic.commands.CommandTestUtil.MAJOR_DESC_CS_LOWER;
import static seedu.planner.logic.commands.CommandTestUtil.MAJOR_DESC_IS;
import static seedu.planner.logic.commands.CommandTestUtil.NAME_DESC_ALICE;
import static seedu.planner.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.commands.CommandTestUtil.VALID_MAJOR_CS;
import static seedu.planner.logic.commands.CommandTestUtil.VALID_NAME_ALICE;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.student.StudentAddCommand;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;
import seedu.planner.model.util.SampleDataUtil;
import seedu.planner.testutil.StudentBuilder;

//@@author thetruevincentchow
class StudentAddCommandParserTest {
    private StudentAddCommandParser parser = new StudentAddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Student expectedStudent = new StudentBuilder()
            .withName(VALID_NAME_ALICE).withMajor(VALID_MAJOR_CS)
            .withTimeTableMap(SampleDataUtil.getSampleTimeTableMap()).build();

        // whitespace in preamble, all fields present
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_ALICE + MAJOR_DESC_CS,
            new StudentAddCommand(expectedStudent));

        // lowercase major
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_ALICE + MAJOR_DESC_CS_LOWER,
            new StudentAddCommand(expectedStudent));

        // multiple name prefixes
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + NAME_DESC_ALICE
            + MAJOR_DESC_CS_LOWER, new StudentAddCommand(expectedStudent));

        // multiple major prefixes
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + NAME_DESC_ALICE
            + MAJOR_DESC_IS + MAJOR_DESC_CS_LOWER, new StudentAddCommand(expectedStudent));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        // empty arguments
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT, StudentAddCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentAddCommand.MESSAGE_USAGE));

        // name not present
        assertParseFailure(parser, MAJOR_DESC_CS_LOWER, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentAddCommand.MESSAGE_USAGE));

        // major not present
        assertParseFailure(parser, NAME_DESC_ALICE, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            StudentAddCommand.MESSAGE_USAGE));

        // name prefix present but empty argument
        assertParseFailure(parser, PREFIX_NAME + " " + MAJOR_DESC_IS, Name.MESSAGE_CONSTRAINTS);

        // major prefix present but empty argument
        assertParseFailure(parser, NAME_DESC_ALICE + " " + PREFIX_MAJOR + PREAMBLE_WHITESPACE,
            Major.MESSAGE_CONSTRAINTS);

        // name and major prefixes present but both have empty arguments
        assertParseFailure(parser, PREFIX_NAME + " " + PREFIX_MAJOR, Name.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_compulsoryFieldInvalid_failure() {
        // major invalid
        assertParseFailure(parser, PREAMBLE_WHITESPACE + NAME_DESC_ALICE + INVALID_MAJOR_DESC,
            Major.MESSAGE_CONSTRAINTS);
    }
}
//@@author

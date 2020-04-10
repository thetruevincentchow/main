package seedu.planner.logic.parser.student;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;
import static seedu.planner.logic.commands.CommandTestUtil.INVALID_SUBCOMMAND;
import static seedu.planner.logic.commands.CommandTestUtil.MAJOR_DESC_CS;
import static seedu.planner.logic.commands.CommandTestUtil.NAME_DESC_ALICE;
import static seedu.planner.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.planner.logic.commands.CommandTestUtil.VALID_MAJOR_CS;
import static seedu.planner.logic.commands.CommandTestUtil.VALID_NAME_ALICE;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.planner.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.planner.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.student.StudentActiveCommand;
import seedu.planner.logic.commands.student.StudentAddCommand;
import seedu.planner.logic.commands.student.StudentCommand;
import seedu.planner.logic.commands.student.StudentGradeCommand;
import seedu.planner.logic.commands.student.StudentListCommand;
import seedu.planner.logic.commands.student.StudentRemoveCommand;
import seedu.planner.model.student.Student;
import seedu.planner.model.util.SampleDataUtil;
import seedu.planner.testutil.StudentBuilder;

//@@author thetruevincentchow
class StudentCommandParserTest {
    private StudentCommandParser parser = new StudentCommandParser();

    @Test
    public void parse_validAddCommand_success() {
        Student expectedStudent = new StudentBuilder()
            .withName(VALID_NAME_ALICE).withMajor(VALID_MAJOR_CS)
            .withTimeTableMap(SampleDataUtil.getSampleTimeTableMap()).build();

        // whitespace in preamble, all fields present
        assertParseSuccess(parser, "add " + PREAMBLE_WHITESPACE + NAME_DESC_ALICE + MAJOR_DESC_CS,
            new StudentAddCommand(expectedStudent));
    }

    @Test
    public void parse_validRemoveCommand_success() {
        assertParseSuccess(parser, "remove 1", new StudentRemoveCommand(INDEX_FIRST_STUDENT));
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + "remove 1", new StudentRemoveCommand(INDEX_FIRST_STUDENT));
    }

    @Test
    public void parse_validActiveCommand_success() {
        assertParseSuccess(parser, "active 1", new StudentActiveCommand(INDEX_FIRST_STUDENT));
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + "active 1", new StudentActiveCommand(INDEX_FIRST_STUDENT));
    }

    @Test
    public void parse_validListCommand_success() {
        assertParseSuccess(parser, "list", new StudentListCommand());

        // any text is allowed after "list "
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + "list" + " fajslkfjalk",
            new StudentListCommand());
    }

    @Test
    public void parse_validGradeCommand_success() {
        assertParseSuccess(parser, "grade", new StudentGradeCommand());

        // any text is allowed after "grade "
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + "grade" + " fajslkfjalk",
            new StudentGradeCommand());
    }

    @Test
    public void parse_subCommandMissing_failure() {
        assertParseFailure(parser, "", String.format(MESSAGE_UNKNOWN_SUBCOMMAND, StudentCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            StudentCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_subCommandInvalid_failure() {
        assertParseFailure(parser, INVALID_SUBCOMMAND, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            StudentCommand.MESSAGE_USAGE));

        assertParseFailure(parser, PREAMBLE_WHITESPACE + INVALID_SUBCOMMAND, String.format(MESSAGE_UNKNOWN_SUBCOMMAND,
            StudentCommand.MESSAGE_USAGE));
    }
}
//@@author

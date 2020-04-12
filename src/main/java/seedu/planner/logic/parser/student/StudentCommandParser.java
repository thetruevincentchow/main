package seedu.planner.logic.parser.student;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;

import seedu.planner.logic.commands.student.StudentActiveCommand;
import seedu.planner.logic.commands.student.StudentAddCommand;
import seedu.planner.logic.commands.student.StudentCommand;
import seedu.planner.logic.commands.student.StudentGradeCommand;
import seedu.planner.logic.commands.student.StudentListCommand;
import seedu.planner.logic.commands.student.StudentRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.SubCommandSplitter;
import seedu.planner.logic.parser.exceptions.ParseException;

//@@author thetruevincentchow

/**
 * Parses sub-commands of the "student" command and creates a new StudentCommand object.
 */
public class StudentCommandParser implements Parser<StudentCommand> {
    /**
     * Parses user subcommand input into command for execution.
     *
     * @param userInput user subcommand input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public StudentCommand parse(String userInput) throws ParseException {
        SubCommandSplitter subCommandSplitter = new SubCommandSplitter(userInput, StudentCommand.MESSAGE_USAGE);

        final String commandWord = subCommandSplitter.getCommand();
        final String arguments = subCommandSplitter.getSubCommand();

        switch (commandWord) {
        case StudentRemoveCommand.COMMAND_WORD:
            return new StudentRemoveCommandParser().parse(arguments);

        case StudentAddCommand.COMMAND_WORD:
            return new StudentAddCommandParser().parse(arguments);

        case StudentActiveCommand.COMMAND_WORD:
            return new StudentActiveCommandParser().parse(arguments);

        case StudentListCommand.COMMAND_WORD:
            return new StudentListCommand();

        case StudentGradeCommand.COMMAND_WORD:
            return new StudentGradeCommand();

        default:
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, StudentCommand.MESSAGE_USAGE));
        }
    }
}
//@@author

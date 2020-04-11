package seedu.planner.logic.parser;

import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.planner.logic.commands.ClearCommand;
import seedu.planner.logic.commands.Command;
import seedu.planner.logic.commands.ExitCommand;
import seedu.planner.logic.commands.HelpCommand;
import seedu.planner.logic.commands.StatusCommand;
import seedu.planner.logic.commands.exemptions.ExemptCommand;
import seedu.planner.logic.commands.lessons.LessonCommand;
import seedu.planner.logic.commands.major.MajorCommand;
import seedu.planner.logic.commands.module.ModuleCommand;
import seedu.planner.logic.commands.specialisation.SpecialisationCommand;
import seedu.planner.logic.commands.student.StudentCommand;
import seedu.planner.logic.commands.timetable.TimeTableCommand;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.logic.parser.exemptions.ExemptCommandParser;
import seedu.planner.logic.parser.lessons.LessonCommandParser;
import seedu.planner.logic.parser.module.ModuleCommandParser;
import seedu.planner.logic.parser.specialisation.SpecialisationCommandParser;
import seedu.planner.logic.parser.student.StudentCommandParser;
import seedu.planner.logic.parser.timetable.TimeTableCommandParser;

/**
 * Parses user input.
 */
public class PlannerParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case StatusCommand.COMMAND_WORD:
            return new StatusCommand();

        case StudentCommand.COMMAND_WORD:
            return new StudentCommandParser().parse(arguments);

        case ModuleCommand.COMMAND_WORD:
            return new ModuleCommandParser().parse(arguments);

        case MajorCommand.COMMAND_WORD:
            return new MajorCommandParser().parse(arguments);

        case TimeTableCommand.COMMAND_WORD:
            return new TimeTableCommandParser().parse(arguments);

        case SpecialisationCommand.COMMAND_WORD:
            return new SpecialisationCommandParser().parse(arguments);

        case ExemptCommand.COMMAND_WORD:
            return new ExemptCommandParser().parse(arguments);

        case LessonCommand.COMMAND_WORD:
            return new LessonCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}

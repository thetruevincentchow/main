package seedu.planner.logic.parser.timetable;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_STUDENT_SEM;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_STUDENT_YEAR;
import static seedu.planner.logic.parser.ParserUtil.arePrefixesPresent;

import seedu.planner.logic.commands.timetable.TimeTableRemoveCommand;
import seedu.planner.logic.parser.ArgumentMultimap;
import seedu.planner.logic.parser.ArgumentTokenizer;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.ParserUtil;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.time.DegreeYear;
import seedu.planner.model.time.Semester;
import seedu.planner.model.time.SemesterYear;
import seedu.planner.model.time.StudentSemester;

//@@author thetruevincentchow
/**
 * Parses input arguments and creates a new TimeTableRemoveCommand object
 */
public class TimeTableRemoveCommandParser implements Parser<TimeTableRemoveCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the TimeTableRemoveCommand
     * and returns an TimeTableRemoveCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public TimeTableRemoveCommand parse(String args) throws ParseException {
        requireNonNull(args);

        // NOTE: the concatenation " " is a workaround for `ArgumentTokenizer` treating the first argument as the
        // preamble
        // TODO: use ArgumentTokenizer for all subcommands
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(" " + args, PREFIX_STUDENT_SEM,
            PREFIX_STUDENT_YEAR);

        if (!arePrefixesPresent(argMultimap, PREFIX_STUDENT_SEM, PREFIX_STUDENT_YEAR)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                TimeTableRemoveCommand.MESSAGE_USAGE));
        }

        final DegreeYear year = ParserUtil.parseYear(argMultimap.getValue(PREFIX_STUDENT_YEAR).get());
        final Semester sem = ParserUtil.parseSemester(argMultimap.getValue(PREFIX_STUDENT_SEM).get());

        SemesterYear semesterYear = new SemesterYear(sem, 0); // TODO: input academic year
        StudentSemester studentSemester = new StudentSemester(semesterYear, year.getYear());
        return new TimeTableRemoveCommand(studentSemester);
    }
}
//@@author

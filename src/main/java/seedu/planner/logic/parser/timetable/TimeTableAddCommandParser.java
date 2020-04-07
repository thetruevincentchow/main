package seedu.planner.logic.parser.timetable;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_STUDENT_SEM;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_STUDENT_YEAR;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import seedu.planner.logic.commands.timetable.TimeTableAddCommand;
import seedu.planner.logic.parser.ArgumentMultimap;
import seedu.planner.logic.parser.ArgumentTokenizer;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.ParserUtil;
import seedu.planner.logic.parser.Prefix;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.time.DegreeYear;
import seedu.planner.model.time.Semester;
import seedu.planner.model.time.SemesterYear;
import seedu.planner.model.time.StudentSemester;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class TimeTableAddCommandParser implements Parser<TimeTableAddCommand> {

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public TimeTableAddCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(" " + args, PREFIX_STUDENT_SEM,
            PREFIX_STUDENT_YEAR);

        if (!arePrefixesPresent(argMultimap, PREFIX_STUDENT_SEM, PREFIX_STUDENT_YEAR)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, TimeTableAddCommand.MESSAGE_USAGE));
        }
        try {
            final DegreeYear year = ParserUtil.parseYear(argMultimap.getValue(PREFIX_STUDENT_YEAR).get());
            final Semester sem = ParserUtil.parseSemester(argMultimap.getValue(PREFIX_STUDENT_SEM).get());
            SemesterYear semesterYear = new SemesterYear(sem, 0); // TODO: input academic year
            StudentSemester studentSemester = new StudentSemester(semesterYear, year.getYear());
            return new TimeTableAddCommand(studentSemester);
        } catch (NoSuchElementException ex) {
            throw new ParseException("Invalid Semester.");
        }
    }
}

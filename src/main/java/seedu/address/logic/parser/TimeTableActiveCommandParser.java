package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.StudentActiveCommand;
import seedu.address.logic.commands.TimeTableActiveCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.time.Semester;
import seedu.address.model.time.SemesterYear;
import seedu.address.model.time.StudentSemester;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENT_SEM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENT_YEAR;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class TimeTableActiveCommandParser implements Parser<TimeTableActiveCommand> {

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
    public TimeTableActiveCommand parse(String args) throws ParseException {
        requireNonNull(args);

        //NOTE: the concatenation " " is a workaround for `ArgumentTokenizer` treating the first argument as the
        // preamble
        // TODO: use ArgumentTokenizer for all subcommands
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(" " + args, PREFIX_STUDENT_SEM,
            PREFIX_STUDENT_YEAR);

        if (!arePrefixesPresent(argMultimap, PREFIX_STUDENT_SEM, PREFIX_STUDENT_YEAR)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                TimeTableActiveCommand.MESSAGE_USAGE));
        }

        Index index;
        Semester sem;

        try {
            index = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_STUDENT_YEAR).get());
            sem = ParserUtil.parseSemester(argMultimap.getValue(PREFIX_STUDENT_SEM).get());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                TimeTableActiveCommand.MESSAGE_USAGE), pe);
        }

        SemesterYear semesterYear = new SemesterYear(sem, 0); // TODO: input academic year
        StudentSemester studentSemester = new StudentSemester(semesterYear, index.getOneBased());
        return new TimeTableActiveCommand(studentSemester);
    }
}

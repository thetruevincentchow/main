package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.StudentAddCommand;
import seedu.address.logic.commands.StudentRemoveCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.Name;
import seedu.address.model.student.Major;
import seedu.address.model.student.Student;
import seedu.address.model.student.TimeTableMap;
import seedu.address.model.tag.Tag;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class StudentAddCommandParser implements Parser<StudentAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public StudentAddCommand parse(String args) throws ParseException {
        requireNonNull(args);

        //NOTE: the concatenation " " is a workaround for `ArgumentTokenizer` treating the first argument as the preamble
        //TODO: use ArgumentTokenizer for all subcommands
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(" " + args, PREFIX_NAME, PREFIX_MAJOR);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_MAJOR)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, StudentAddCommand.MESSAGE_USAGE));
        }

        //TODO: remove references to AddressBook's `person.Name` class so we can use our own `student.Name`
        /*
        seedu.address.model.person.Name abName = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Name name = new Name(abName.fullName);
        Major major  = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        */

        Name name = new Name(argMultimap.getValue(PREFIX_NAME).get());
        Major major  = new Major(argMultimap.getValue(PREFIX_MAJOR).get());
        TimeTableMap timeTableMap = TimeTableMap.sampleTimeTableMap();

        Student student = new Student(name, major, timeTableMap);

        return new StudentAddCommand(student);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

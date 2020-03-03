package seedu.address.logic.parser;

import seedu.address.logic.commands.StudentAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.Major;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new RemarkCommand object
 */
public class StudentAddCommandParser implements Parser<StudentAddCommand> {
    private static final Prefix PREFIX_MAJOR = new Prefix("major/");
    private static final Prefix PREFIX_NAME = new Prefix("n/");

    /**
     * Parses the given {@code String} of arguments in the context of the RemarkCommand
     * and returns a RemarkCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public StudentAddCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_MAJOR);

        try {
            Name name = new Name(argMultimap.getValue(PREFIX_NAME).orElse(""));
            Major major = new Major(argMultimap.getValue(PREFIX_MAJOR).orElse(""));
            return new StudentAddCommand(new Student(name, major));
        } catch (Exception ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                StudentAddCommand.MESSAGE_USAGE), ive);
        }
    }
}

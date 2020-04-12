package seedu.planner.logic.parser.specialisation;

import static java.util.Objects.requireNonNull;

import seedu.planner.logic.commands.specialisation.SpecialisationSetCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.exceptions.ParseException;

/**
 * Class to parse input for {@code SpecialisationSetCommand}.
 */
public class SpecialisationSetCommandParser implements Parser<SpecialisationSetCommand> {

    public static final String INVALID_SPECIALISATION = "Invalid Specialisation";

    /**
     * Parses the given {@code String} of arguments in the context of the DeclareMajorCommand
     * and returns a SpecialisationSetCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public SpecialisationSetCommand parse(String args) throws ParseException {
        try {
            requireNonNull(args);
            return new SpecialisationSetCommand(args);
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage());
        }
    }
}

package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.SpecialisationSetCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.programmes.specialisations.cs.AlgorithmsAndTheorySpecialisation;

public class SpecialisationSetCommandParser implements Parser<SpecialisationSetCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeclareMajorCommand
     * and returns a DeclareMajorCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public SpecialisationSetCommand parse(String args) throws ParseException {
        requireNonNull(args);

        try {
            switch (args) {
            case "algo":
                return new SpecialisationSetCommand(new AlgorithmsAndTheorySpecialisation());
            default:
                return null;
            }
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage());
        }
    }
}

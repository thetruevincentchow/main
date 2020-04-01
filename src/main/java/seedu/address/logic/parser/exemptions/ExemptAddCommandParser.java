package seedu.address.logic.parser.exemptions;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exemptions.ExemptAddCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.module.ModuleCode;

public class ExemptAddCommandParser implements Parser<ExemptAddCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ModuleAddCommand
     * and returns a ModuleAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ExemptAddCommand parse(String args) throws ParseException {
        requireNonNull(args);

        try {
            ModuleCode moduleCode = new ModuleCode(args);
            return new ExemptAddCommand(moduleCode);
        } catch (IllegalArgumentException e) {
            throw new ParseException(e.getMessage());
        }
    }
}

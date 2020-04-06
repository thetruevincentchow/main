package seedu.planner.logic.parser.exemptions;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.planner.logic.commands.exemptions.ExemptRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.ParserUtil;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.module.ModuleCode;

public class ExemptRemoveCommandParser implements Parser<ExemptRemoveCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ModuleRemoveCommand
     * and returns a ModuleRemoveCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ExemptRemoveCommand parse(String args) throws ParseException {
        requireNonNull(args);

        if (args.trim().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ExemptRemoveCommand.MESSAGE_USAGE));
        }

        ModuleCode moduleCode = ParserUtil.parseModuleCode(args);
        return new ExemptRemoveCommand(moduleCode);
    }
}

package seedu.planner.logic.parser.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;

import seedu.planner.logic.commands.module.ModuleAddCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.ParserUtil;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow

/**
 * Parses input arguments and creates a new ModuleAddCommand object.
 */
public class ModuleAddCommandParser implements Parser<ModuleAddCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ModuleAddCommand
     * and returns a ModuleAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ModuleAddCommand parse(String args) throws ParseException {
        requireNonNull(args);

        if (args.trim().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ModuleAddCommand.MESSAGE_USAGE));
        }

        List<ModuleCode> moduleCodes = ParserUtil.parseModuleCodes(args);
        return new ModuleAddCommand(moduleCodes);
    }
}
//@@author

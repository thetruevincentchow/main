package seedu.planner.logic.parser.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;

import seedu.planner.logic.commands.module.ModuleRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.ParserUtil;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow
/**
 * Parses input arguments and creates a new ModuleRemoveCommand object
 */
public class ModuleRemoveCommandParser implements Parser<ModuleRemoveCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ModuleRemoveCommand
     * and returns a ModuleRemoveCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ModuleRemoveCommand parse(String args) throws ParseException {
        requireNonNull(args);

        if (args.trim().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ModuleRemoveCommand.MESSAGE_USAGE));
        }

        List<ModuleCode> moduleCodes = ParserUtil.parseModuleCodes(args);
        return new ModuleRemoveCommand(moduleCodes);
    }
}
//@@author

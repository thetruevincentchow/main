package seedu.planner.logic.parser.module;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;

import seedu.planner.logic.commands.module.ModuleAddCommand;
import seedu.planner.logic.commands.module.ModuleCommand;
import seedu.planner.logic.commands.module.ModuleGradeCommand;
import seedu.planner.logic.commands.module.ModuleListCommand;
import seedu.planner.logic.commands.module.ModuleRemoveCommand;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.SubCommandSplitter;
import seedu.planner.logic.parser.exceptions.ParseException;

//@@author thetruevincentchow

/**
 * Parses sub-commands of the "module" command and creates a new ModuleCommand object.
 */
public class ModuleCommandParser implements Parser<ModuleCommand> {
    /**
     * Parses user subcommand input into command for execution.
     *
     * @param userInput user subcommand input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ModuleCommand parse(String userInput) throws ParseException {
        SubCommandSplitter subCommandSplitter = new SubCommandSplitter(userInput, ModuleCommand.MESSAGE_USAGE);

        final String commandWord = subCommandSplitter.getCommand();
        final String arguments = subCommandSplitter.getSubCommand();

        switch (commandWord) {
        case ModuleAddCommand.COMMAND_WORD:
            return new ModuleAddCommandParser().parse(arguments);

        case ModuleRemoveCommand.COMMAND_WORD:
            return new ModuleRemoveCommandParser().parse(arguments);

        case ModuleListCommand.COMMAND_WORD:
            return new ModuleListCommand();

        case ModuleGradeCommand.COMMAND_WORD:
            return new ModuleGradeCommandParser().parse(arguments);

        default:
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, ModuleCommand.MESSAGE_USAGE));
        }
    }
}
//@@author

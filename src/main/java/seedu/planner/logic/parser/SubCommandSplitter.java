package seedu.planner.logic.parser;

import static seedu.planner.commons.core.Messages.MESSAGE_UNKNOWN_SUBCOMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.planner.logic.parser.exceptions.ParseException;

//@@author thetruevincentchow

/**
 * Splits a command string into a command word and the remaining sub-command string, separated by whitespace.
 */
public class SubCommandSplitter {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<subCommand>.*)",
            Pattern.DOTALL);

    private final String command;
    private final String subcommand;

    /**
     * Splits user command input into a command and subcommand string.
     * The subcommand can be empty or contain newlines and other whitespace.
     *
     * @param userInput user sub-command input string
     * @throws ParseException if the user input does not conform the expected format
     */
    public SubCommandSplitter(String userInput, String failureMessage) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_UNKNOWN_SUBCOMMAND, failureMessage));
        }

        command = matcher.group("commandWord");
        subcommand = matcher.group("subCommand");
    }

    public String getCommand() {
        return command;
    }

    public String getSubCommand() {
        return subcommand;
    }
}
//@@author

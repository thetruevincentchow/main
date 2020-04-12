package seedu.planner.logic.parser.module;

import static java.util.Objects.requireNonNull;
import static seedu.planner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_GRADE;
import static seedu.planner.logic.parser.CliSyntax.PREFIX_SU;
import static seedu.planner.logic.parser.ParserUtil.arePrefixesPresent;

import seedu.planner.logic.commands.module.ModuleGradeCommand;
import seedu.planner.logic.commands.module.ModuleGradeResetCommand;
import seedu.planner.logic.commands.module.ModuleGradeSetCommand;
import seedu.planner.logic.commands.module.ModuleGradeViewCommand;
import seedu.planner.logic.parser.ArgumentMultimap;
import seedu.planner.logic.parser.ArgumentTokenizer;
import seedu.planner.logic.parser.Parser;
import seedu.planner.logic.parser.ParserUtil;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.grades.LetterGrade;
import seedu.planner.model.module.ModuleCode;

//@@author thetruevincentchow

/**
 * Parses input arguments and creates a new ModuleGradeCommand object
 */
public class ModuleGradeCommandParser implements Parser<ModuleGradeCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ModuleGradeCommand
     * and returns a ModuleGradeCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public ModuleGradeCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(" " + args, PREFIX_GRADE, PREFIX_SU);

        if (argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ModuleGradeCommand.MESSAGE_USAGE));
        }

        ModuleCode moduleCode = ParserUtil.parseModuleCode(argMultimap.getPreamble());

        final boolean isGradePresent = arePrefixesPresent(argMultimap, PREFIX_GRADE);
        final boolean isSuPresent = arePrefixesPresent(argMultimap, PREFIX_SU);

        if (isGradePresent && isSuPresent) {
            throw new ParseException(ModuleGradeCommand.MESSAGE_BOTH_GRADE_AND_SU);
        }

        if (isGradePresent) {
            String letterGradeString = argMultimap.getValue(PREFIX_GRADE).get();
            if (letterGradeString.trim().isEmpty()) {
                return new ModuleGradeResetCommand(moduleCode);
            } else {
                LetterGrade letterGrade = ParserUtil.parseLetterGrade(letterGradeString);
                return new ModuleGradeSetCommand(moduleCode, letterGrade, false);
            }
        } else if (isSuPresent) {
            String letterGradeString = argMultimap.getValue(PREFIX_SU).get();
            LetterGrade letterGrade = ParserUtil.parseLetterGrade(letterGradeString);
            return new ModuleGradeSetCommand(moduleCode, letterGrade, true);
        } else {
            return new ModuleGradeViewCommand(moduleCode);
        }
    }
}
//@@author

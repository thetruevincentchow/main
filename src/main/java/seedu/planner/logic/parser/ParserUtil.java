package seedu.planner.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.planner.commons.core.index.Index;
import seedu.planner.commons.util.StringUtil;
import seedu.planner.logic.parser.exceptions.ParseException;
import seedu.planner.model.grades.LetterGrade;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.time.Semester;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String moduleCode} into a {@code ModuleCode}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code ModuleCode} is invalid.
     */
    public static ModuleCode parseModuleCode(String moduleCode) throws ParseException {
        requireNonNull(moduleCode);
        String trimmedName = moduleCode.trim();
        if (!ModuleCode.isValidModuleCode(trimmedName)) {
            throw new ParseException(ModuleCode.MESSAGE_CONSTRAINTS);
        }
        return new ModuleCode(trimmedName);
    }

    public static Semester parseSemester(String semester) throws ParseException {
        requireNonNull(semester);
        try {
            final Semester semesterEnum = Semester.valueOf(semester);
            return semesterEnum;
        } catch (IllegalArgumentException e) {
            throw new ParseException(Semester.MESSAGE_CONSTRAINTS);
        }
    }

    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        try {
            final Name modelName = new Name(name);
            return modelName;
        } catch (IllegalArgumentException e) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
    }

    public static Major parseMajor(String major) throws ParseException {
        requireNonNull(major);
        try {
            final Major modelMajor = new Major(major);
            return modelMajor;
        } catch (IllegalArgumentException e) {
            throw new ParseException(Major.MESSAGE_CONSTRAINTS);
        }
    }

    public static LetterGrade parseLetterGrade(String letterGrade) throws ParseException {
        requireNonNull(letterGrade);
        try {
            final LetterGrade modelLetterGrade = LetterGrade.valueOf(letterGrade);
            return modelLetterGrade;
        } catch (IllegalArgumentException e) {
            throw new ParseException(LetterGrade.MESSAGE_CONSTRAINTS);
        }
    }
}

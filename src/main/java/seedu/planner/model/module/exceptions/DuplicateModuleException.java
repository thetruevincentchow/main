package seedu.planner.model.module.exceptions;

/**
 * Signals that the operation will result in repeated ModuleCodes or Enrollments
 * (ModuleCode and Enrollment are considered repeated if they have the same module code).
 */
public class DuplicateModuleException extends RuntimeException {
    public DuplicateModuleException() {
        super("Operation would result in duplicate module");
    }
}

package seedu.address.model.module;

import static java.util.Objects.requireNonNull;

public class ModuleCode {
    public static final String MESSAGE_CONSTRAINS = "Module code cannot be null";

    public final String value;

    public ModuleCode(String code) {
        requireNonNull(code);
        value = code;
    }

    @Override
    public String toString() {
        return value;
    }
}

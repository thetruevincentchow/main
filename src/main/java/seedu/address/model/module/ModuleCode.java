package seedu.address.model.module;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ModuleCode)) {
            return false;
        } else {
            return value.equals(((ModuleCode)other).value);
        }
    }
}

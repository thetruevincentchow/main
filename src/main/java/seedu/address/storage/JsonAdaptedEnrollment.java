package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.grades.Grade;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Enrollment;
import seedu.address.model.student.TimeTableMap;

import java.util.Optional;

//TODO: add other fields (currently only stores ModuleCode)
public class JsonAdaptedEnrollment {
    private final JsonAdaptedModuleCode code;
    /**
     * Represents the student's grade. Can be null.
     */
    public Grade grade;
    public int credit;

    @JsonCreator
    public JsonAdaptedEnrollment(@JsonProperty("code") JsonAdaptedModuleCode code, @JsonProperty("grade") Grade grade,
                                 @JsonProperty("credit") int credit) {
        this.code = code;
        this.grade = grade;
        this.credit = credit;
    }

    public JsonAdaptedEnrollment(Enrollment source) {
        this.code = new JsonAdaptedModuleCode(source.getModuleCode());
        this.grade = source.getGrade().orElse(null);
        this.credit = source.credit;
    }

    public Enrollment toModelType() throws IllegalValueException  {
        return new Enrollment(code.toModelType(), Optional.ofNullable(grade), credit);
    }
}

package seedu.address.storage;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.grades.Grade;
import seedu.address.model.student.Enrollment;

//TODO: add other fields (currently only stores ModuleCode)
public class JsonAdaptedEnrollment {
    private final JsonAdaptedModuleCode code;
    /**
     * Represents the student's grade. Can be null.
     */
    public JsonAdaptedGrade grade;
    public int credit;

    @JsonCreator
    public JsonAdaptedEnrollment(@JsonProperty("code") JsonAdaptedModuleCode code,
                                 @JsonProperty("grade") JsonAdaptedGrade grade,
                                 @JsonProperty("credit") int credit) {
        this.code = code;
        this.grade = grade;
        this.credit = credit;
    }

    public JsonAdaptedEnrollment(Enrollment source) {
        this.code = new JsonAdaptedModuleCode(source.getModuleCode());
        Optional<Grade> optionalGrade = source.getGrade();
        if (optionalGrade.isPresent()) {
            this.grade = new JsonAdaptedGrade(optionalGrade.get());
        } else {
            this.grade = null;
        }
        this.credit = source.credit;
    }

    public Enrollment toModelType() throws IllegalValueException {
        return new Enrollment(code.toModelType(), grade == null ?
            Optional.empty() : Optional.of(grade.toModelType()), credit);
    }
}

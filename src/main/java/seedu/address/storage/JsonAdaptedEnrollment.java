package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.module.Module;
import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Enrollment;
import seedu.address.model.student.TimeTableMap;

//TODO: add other fields (currently only stores ModuleCode)
public class JsonAdaptedEnrollment {
    private final JsonAdaptedModuleCode code;

    @JsonCreator
    public JsonAdaptedEnrollment(@JsonProperty("code") JsonAdaptedModuleCode code) {
        this.code = code;
    }

    public JsonAdaptedEnrollment(Enrollment source) {
        this.code = new JsonAdaptedModuleCode(source.getModuleCode());
    }

    public Enrollment toModelType() throws IllegalValueException  {
        return new Enrollment(code.toModelType());
    }
}

package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.grades.Grade;
import seedu.address.model.grades.LetterGrade;

//TODO: add other fields (currently only stores ModuleCode)
public class JsonAdaptedGrade {
    protected final String letterGrade;
    protected final boolean isSu;

    @JsonCreator
    public JsonAdaptedGrade(@JsonProperty("letterGrade") String letterGrade, @JsonProperty("isSu") boolean isSu) {
        this.letterGrade = letterGrade;
        this.isSu = isSu;
    }

    public JsonAdaptedGrade(Grade source) {
        this.letterGrade = source.letterGrade.toString();
        this.isSu = source.isSu;
    }

    public Grade toModelType() throws IllegalValueException {
        return new Grade(LetterGrade.valueOf(letterGrade), isSu);
    }
}

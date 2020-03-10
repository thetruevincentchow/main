package seedu.address.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.time.StudentSemester;

import java.io.IOException;

public class JsonStudentSemesterDeserializer extends KeyDeserializer {
    @Override
    public StudentSemester deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return new JsonAdaptedStudentSemester(JsonUtil.fromJsonString(key, StudentSemester.class)).toModelType();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
        return null;
    }
}

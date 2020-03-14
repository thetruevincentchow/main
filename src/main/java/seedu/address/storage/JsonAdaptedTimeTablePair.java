package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import javafx.util.Pair;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.student.Enrollment;
import seedu.address.model.student.TimeTable;
import seedu.address.model.time.SemesterYear;
import seedu.address.model.time.StudentSemester;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is used since Pair\<JsonAdaptedStudentSemester, JsonAdaptedTimeTable\> doesn't seem to be read correctly by Jackson.
 */

public class JsonAdaptedTimeTablePair {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "StudentSemester's %s field is missing!";

    private final JsonAdaptedStudentSemester sem;
    private final JsonAdaptedTimeTable timeTable;

    @JsonCreator
    public JsonAdaptedTimeTablePair(@JsonProperty("sem") JsonAdaptedStudentSemester sem, @JsonProperty("timeTable") JsonAdaptedTimeTable timeTable) {
        this.sem = sem;
        this.timeTable = timeTable;
    }

    public JsonAdaptedTimeTablePair(Map.Entry<StudentSemester, TimeTable> source) {
        this.sem = new JsonAdaptedStudentSemester(source.getKey());
        this.timeTable = new JsonAdaptedTimeTable(source.getValue());
    }

    public Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable> toModelType() throws IllegalValueException {
        if (sem == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, StudentSemester.class.getSimpleName()));
        }

        if (timeTable == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, TimeTable.class.getSimpleName()));
        }

        return new Pair<>(sem, timeTable);
    }
}

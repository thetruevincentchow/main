package seedu.planner.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javafx.util.Pair;
import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.TimeTableMap;
import seedu.planner.model.time.StudentSemester;

/**
 * Jackson-friendly version of {@link TimeTableMap}.
 */
public class JsonAdaptedTimeTableMap {
    public final List<JsonAdaptedTimeTablePair> timeTables;

    @JsonCreator
    public JsonAdaptedTimeTableMap(List<JsonAdaptedTimeTablePair> timeTables) {
        this.timeTables = timeTables;
    }

    /**
     * Converts a given {@code TimeTableMap} into this class for Jackson use.
     */
    public JsonAdaptedTimeTableMap(TimeTableMap source) {
        timeTables = new ArrayList<>();
        for (Map.Entry<StudentSemester, TimeTable> entry : source.entrySet()) {
            timeTables.add(new JsonAdaptedTimeTablePair(entry));
        }
    }

    @JsonValue
    public List<JsonAdaptedTimeTablePair> getTimeTables() {
        return timeTables;
    }

    /**
     * Converts this Jackson-friendly adapted timetable map into the model's {@code TimeTableMap} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted timetable map.
     */
    public TimeTableMap toModelType() throws IllegalValueException {
        TimeTableMap map = new TimeTableMap();
        for (JsonAdaptedTimeTablePair timeTable : timeTables) {
            Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable> modelPair = timeTable.toModelType();
            if (map.put(modelPair.getKey().toModelType(), modelPair.getValue().toModelType()) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        return map;
    }
}

package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import javafx.util.Pair;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.student.TimeTable;
import seedu.address.model.student.TimeTableMap;
import seedu.address.model.tag.Tag;
import seedu.address.model.time.StudentSemester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonAdaptedTimeTableMap {
    public final List<Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable>> timeTables;

    @JsonCreator
    public JsonAdaptedTimeTableMap(List<Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable>> timeTables) {
        this.timeTables = timeTables;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedTimeTableMap(TimeTableMap source) {
        timeTables = new ArrayList<>();
        /*
        this.timeTables = source.entrySet().stream().map(entry -> {
            return new Pair(new JsonAdaptedStudentSemester(entry.getKey()), new JsonAdaptedTimeTable(entry.getValue()));
        }).collect(Collectors.toCollection(ArrayList<Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable>>::new));
         */
        for (Map.Entry<StudentSemester, TimeTable> entry : source.entrySet()) {
            timeTables.add(new Pair<>(new JsonAdaptedStudentSemester(entry.getKey()), new JsonAdaptedTimeTable(entry.getValue())));
        }
    }

    @JsonValue
    public List<Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable>> getTimeTables() {
        return timeTables;
    }

    public TimeTableMap toModelType() throws IllegalValueException {
        TimeTableMap map  = new TimeTableMap();
        for (Pair<JsonAdaptedStudentSemester, JsonAdaptedTimeTable> timeTable : timeTables) {
            if (map.put(timeTable.getKey().toModelType(), timeTable.getValue().toModelType()) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        return map;
    }
}

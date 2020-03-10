package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.student.Enrollment;
import seedu.address.model.student.TimeTable;
import seedu.address.model.student.TimeTableMap;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonAdaptedTimeTable {
    private final List<JsonAdaptedEnrollment> enrollments = new ArrayList<>();

    @JsonCreator
    public JsonAdaptedTimeTable(List<JsonAdaptedEnrollment> enrollments) {
        this.enrollments.addAll(enrollments);
    }

    @JsonValue
    public List<JsonAdaptedEnrollment> getEnrollments() {
        return enrollments;
    }

    public JsonAdaptedTimeTable(TimeTable source) {
        enrollments.addAll(source.getEnrollments().stream()
                .map(JsonAdaptedEnrollment::new)
                .collect(Collectors.toList()));
    }

    public TimeTable toModelType() throws IllegalValueException {
        final List<Enrollment> modelEnrollments = new ArrayList<>();
        for (JsonAdaptedEnrollment enrollment : enrollments) {
            modelEnrollments.add(enrollment.toModelType());
        }
        return new TimeTable(modelEnrollments);
    }
}

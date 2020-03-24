package seedu.address.model.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Jackson-friendly version of {@link Lesson}.
 */
class JsonAdaptedLesson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Lesson's %s field is missing!";

    public final String classNo;
    public final String startTime;
    public final String endTime;
    public final Object weeks;
    public final String venue;
    public final String day;
    public final String lessonType;
    public final int size;

    /**
     * Constructs a {@code JsonAdaptedLesson} with the given Lesson details.
     */
    @JsonCreator
    public JsonAdaptedLesson(
        @JsonProperty("classNo") String classNo,
        @JsonProperty("startTime") String startTime,
        @JsonProperty("endTime") String endTime,
        @JsonProperty("weeks") String weeks,
        @JsonProperty("venue") String venue,
        @JsonProperty("day") String day,
        @JsonProperty("lessonType") String lessonType,
        @JsonProperty("size") int size
    ) {
        this.classNo = classNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weeks = weeks;
        this.venue = venue;
        this.day = day;
        this.lessonType = lessonType;
        this.size = size;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedLesson(Lesson lesson) {
        this.classNo = lesson.classNo;
        this.startTime = lesson.startTime;
        this.endTime = lesson.endTime;
        this.weeks = lesson.weeks;
        this.venue = lesson.venue;
        this.day = lesson.day;
        this.lessonType = lesson.lessonType;
        this.size = lesson.size;
    }

    /**
     * Converts this Jackson-friendly adapted Module object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Lesson toModelType() {
        return new Lesson(
            classNo,
            startTime,
            endTime,
            weeks,
            venue,
            day,
            lessonType,
            size
        );
    }
}

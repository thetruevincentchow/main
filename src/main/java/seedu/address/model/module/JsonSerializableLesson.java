package seedu.address.model.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An Immutable ModuleList that is serializable to JSON format.
 */
public class JsonSerializableLesson {

    public static final String MESSAGE_DUPLICATE_MODULE = "Module list contains duplicate module(s).";

    private final String classNo;
    private final String startTime;
    private final String endTime;
    private final Object weeks;
    private final String venue;
    private final String day;
    private final String lessonType;
    private final int size;


    /**
     * Constructs a {@code JsonSerializableLesson} with the given lessons.
     */
    @JsonCreator
    public JsonSerializableLesson(
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
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    /*public JsonSerializableLesson(ReadOnlyPlanner source) {
        // TODO: Don't think we will need to use this. KIV
        // modules.addAll(source.getModuleList().stream().map(JsonAdaptedModule::new).collect(Collectors.toList()));
    }*/

    /**
     * Converts this address book into the model's {@code AddressBook} object.
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

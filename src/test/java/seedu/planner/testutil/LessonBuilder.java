package seedu.planner.testutil;

import seedu.planner.model.module.Lesson;

/**
 * A utility class to help with building Lesson objects.
 */
public class LessonBuilder {

    private static final String CLASSNO = "10";
    private static final String STARTTIME = "1200";
    private static final String ENDTIME = "1200";
    private static final Object WEEKS = new Object();
    private static final String VENUE = "AS6-0211";
    private static final String DAY = "Wednesday";
    private static final String LESSONTYPE = "Tutorial";
    private static final int SIZE = 25;

    private String classNo;
    private String startTime;
    private String endTime;
    private Object weeks;
    private String venue;
    private String day;
    private String lessonType;
    private int size;

    public LessonBuilder() {
        this.classNo = CLASSNO;
        this.startTime = STARTTIME;
        this.endTime = ENDTIME;
        this.weeks = WEEKS;
        this.venue = VENUE;
        this.day = DAY;
        this.lessonType = LESSONTYPE;
        this.size = SIZE;
    }

    public LessonBuilder(Lesson lesson) {
        this.classNo = lesson.getClassNo();
        this.startTime = lesson.getStartTime();
        this.endTime = lesson.getEndTime();
        this.weeks = lesson.getWeeks();
        this.venue = lesson.getVenue();
        this.day = lesson.getDay();
        this.lessonType = lesson.getLessonType();
        this.size = lesson.getSize();
    }

    /**
     * Sets the {@code classNo} of the {@code Lesson} that we are building.
     */
    public LessonBuilder withClassNo(String classNo) {
        this.classNo = classNo;
        return this;
    }

    /**
     * Sets the {@code weeks} of the {@code Lesson} that we are building.
     */
    public LessonBuilder withWeek(Object weeks) {
        this.weeks = weeks;
        return this;
    }

    public Lesson build() {
        return new Lesson(classNo, startTime, endTime, weeks, venue, day, lessonType, size);
    }
}

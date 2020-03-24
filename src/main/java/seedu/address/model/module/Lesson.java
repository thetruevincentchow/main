package seedu.address.model.module;

public class Lesson {
    public final String classNo;
    public final String startTime;
    public final String endTime;
    public final Object weeks;
    public final String venue;
    public final String day;
    public final String lessonType;
    public final int size;
    protected ModuleTime time;

    public Lesson(String classNo, String startTime, String endTime, Object weeks, String venue, String day,
                  String lessonType, int size) {
        this.classNo = classNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weeks = weeks;
        this.venue = venue;
        this.day = day;
        this.lessonType = lessonType;
        this.size = size;
    }


    public ModuleTime getTime() {
        return null;
    }
}

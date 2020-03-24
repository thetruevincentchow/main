package seedu.address.model.module;

public class Lesson {
    public String classNo;
    public String startTime;
    public String endTime;
    public Object weeks;
    public String venue;
    public String day;
    public String lessonType;
    public int size;
    protected ModuleTime time;

    public Lesson() {

    }

    public Lesson(String classNo, String startTime, String endTime, Object weeks, String venue, String day, String lessonType, int size) {
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

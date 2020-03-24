package seedu.address.model.module;

public class Sectional extends Lesson {
    public Sectional(String classNo, String startTime, String endTime, Object weeks, String venue, String day,
                     String lessonType, int size) {
        super(classNo, startTime, endTime, weeks, venue, day, lessonType, size);
    }

    public ModuleTime getTime() {
        return null;
    }
}

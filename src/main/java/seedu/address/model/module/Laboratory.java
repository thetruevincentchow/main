package seedu.address.model.module;

public class Laboratory extends Lesson {

    public Laboratory(String classNo, String startTime, String endTime, Object weeks, String venue, String day,
                      String lessonType, int size) {
        super(classNo, startTime, endTime, weeks, venue, day, lessonType, size);
    }

    public ModuleTime getTime() {
        return null;
    }
}

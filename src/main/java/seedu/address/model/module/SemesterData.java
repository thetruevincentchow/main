package seedu.address.model.module;

import java.util.List;

public class SemesterData {

    public final int semester;
    public final String examDate;
    public final int examDuration;
    public final List<Lesson> timetable;


    public SemesterData(int semester, String examDate, int examDuration, List<Lesson> timetable) {
        this.semester = semester;
        this.examDate = examDate;
        this.examDuration = examDuration;
        this.timetable = timetable;
    }

    /*public SemesterData(JsonSerializableSemesterData jsonSerializableModule, String semesterData) {

    }*/
}

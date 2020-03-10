package seedu.address.model.student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TimeTable {
    public List<Enrollment> enrollments;

    public TimeTable() {
        enrollments = new ArrayList<>();
    }

    public TimeTable(List<Enrollment> enrollments) {
        this.enrollments = new ArrayList<>(enrollments);
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}

package seedu.address.model.student;

import seedu.address.model.module.ModuleCode;
import seedu.address.model.module.UniqueEnrollmentList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TimeTable {
    public UniqueEnrollmentList enrollments = new UniqueEnrollmentList();

    public TimeTable() {
    }

    public TimeTable(List<Enrollment> enrollments) {
        enrollments.forEach(this.enrollments::add);
    }

    public static TimeTable sampleTimeTable() {
        TimeTable timeTable = new TimeTable();
        timeTable.addEnrollment(new Enrollment(new ModuleCode("CS2040")));
        return timeTable;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public boolean hasEnrollment(Enrollment enrollment) {
        return enrollments.contains(enrollment);
    }

    public UniqueEnrollmentList getEnrollments() {
        return enrollments;
        //return enrollments.asUnmodifiableObservableList(); //TODO: replace with ObservableList<Enrollment>
    }
}

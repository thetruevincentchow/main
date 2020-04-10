package seedu.planner.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.planner.model.Planner;
import seedu.planner.model.module.Module;
import seedu.planner.model.module.ModuleCode;
import seedu.planner.model.student.Enrollment;
import seedu.planner.model.student.Major;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;
import seedu.planner.model.student.TimeTable;
import seedu.planner.model.student.TimeTableMap;
import seedu.planner.model.tag.Tag;
import seedu.planner.model.time.Semester;
import seedu.planner.model.time.SemesterYear;
import seedu.planner.model.time.StudentSemester;

/**
 * Contains utility methods for populating {@link Planner} with sample data.
 */
public class SampleDataUtil {
    public static Module[] getSampleModules() {
        return new Module[]{
            new Module(new ModuleCode("CS2040")),
            new Module(new ModuleCode("CS2103T"))
        };
    }

    public static Planner getSamplePlanner() {
        Planner samplePlanner = new Planner();
        Student student = SampleDataUtil.getSampleStudent();
        samplePlanner.addStudent(student);
        samplePlanner.activateStudent(student);
        return samplePlanner;
    }

    public static Student getSampleStudent() {
        Student sampleStudent = new Student(new Name("Mark"), new Major("CS"),
            SampleDataUtil.getSampleTimeTableMap(), SampleDataUtil.getSampleExemptedModules());
        return sampleStudent;
    }

    public static List<ModuleCode> getSampleExemptedModules() {
        List<ModuleCode> sampleExemptedModules = new ArrayList<>();
        return sampleExemptedModules;
    }

    public static TimeTableMap getSampleTimeTableMap() {
        TimeTableMap timeTableMap = new TimeTableMap();
        timeTableMap.put(new StudentSemester(new SemesterYear(Semester.ONE, 2019), 1),
            new TimeTable());
        return timeTableMap;
    }

    /**
     * Returns a non-empty {@link TimeTable}.
     * @return Non-empty {@link TimeTable}.
     */
    public static TimeTable getSampleTimeTable() {
        TimeTable timeTable = new TimeTable();
        timeTable.addEnrollment(new Enrollment(new ModuleCode("CS2040"), Optional.empty(), 4));
        return timeTable;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
            .map(Tag::new)
            .collect(Collectors.toSet());
    }

}

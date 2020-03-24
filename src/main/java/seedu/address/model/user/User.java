package seedu.address.model.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import seedu.address.model.module.ModuleCode;
import seedu.address.model.student.Student;
import seedu.address.model.student.TimeTable;
import seedu.address.model.time.StudentSemester;

public class User {
    Student student;
    Map<StudentSemester, TimeTable> timeTables;
    Set<ModuleCode> exemptedModules;

    public User(Student student) {
        this.student = student;
        timeTables = new HashMap<>();
        exemptedModules = new HashSet<>();
    }

}

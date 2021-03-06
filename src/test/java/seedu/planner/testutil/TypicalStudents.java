package seedu.planner.testutil;

import static seedu.planner.testutil.TypicalTimeTables.getTypicalTimeTableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.planner.model.Planner;
import seedu.planner.model.student.Name;
import seedu.planner.model.student.Student;

/**
 * A utility class containing a list of {@code Student} objects to be used in tests.
 */
public class TypicalStudents {

    public static final Student ALICE = new StudentBuilder().withName(new Name("Alice")).withMajor("CS").build();
    public static final Student BOB = new StudentBuilder().withName(new Name("Bob")).withMajor("IS").build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalStudents() {
    } // prevents instantiation

    /**
     * Returns an {@code Planner} with all the typical students.
     */
    public static Planner getTypicalPlanner() {
        Planner planner = new Planner();
        for (Student student : getTypicalStudents()) {
            planner.addStudent(student);
        }
        return planner;
    }

    /**
     * Returns an {@code Planner} with all the typical students.
     */
    public static Planner getTypicalPlannerWithTimeTables() {
        Planner planner = new Planner();
        for (Student student : getTypicalStudents()) {
            planner.addStudent(new StudentBuilder(student)
                    .withTimeTableMap(getTypicalTimeTableMap())
                    .build());
        }
        return planner;
    }

    public static List<Student> getTypicalStudents() {
        return new ArrayList<>(Arrays.asList(ALICE, BOB));
    }
}

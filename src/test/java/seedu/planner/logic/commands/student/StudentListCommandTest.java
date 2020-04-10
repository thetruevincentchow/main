package seedu.planner.logic.commands.student;

import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.Planner;
import seedu.planner.model.UserPrefs;
import seedu.planner.testutil.TypicalStudents;

//@@author thetruevincentchow
/**
 * Contains integration tests (interaction with the Model) for StudentListCommand.
 */
public class StudentListCommandTest {

    private static final String nonEmptyExpectedFeedback = "Listed students in student list:\n"
        + "1: n/Alice major/CS\n"
        + "2: n/Bob major/IS";

    private static final String emptyExpectedFeedback = "Listed students in student list:\n"
        + "[None]";

    @Test
    public void execute_showNonEmptyStudentList() {
        // NOTE: Construct new Planner here instead of using TypicalStudents.getTypicalPlanner()
        //       for stability to changes in other code.
        Planner planner = new Planner();
        planner.addStudent(TypicalStudents.ALICE);
        planner.addStudent(TypicalStudents.BOB);

        Model model = new ModelManager(planner, new UserPrefs());
        Model expectedModel = new ModelManager(model.getPlanner(), new UserPrefs());

        assertCommandSuccess(new StudentListCommand(), model, nonEmptyExpectedFeedback, expectedModel);
    }

    @Test
    public void execute_showEmptyStudentList() {
        Model model = new ModelManager(new Planner(), new UserPrefs());
        Model expectedModel = new ModelManager(model.getPlanner(), new UserPrefs());

        assertCommandSuccess(new StudentListCommand(), model, emptyExpectedFeedback, expectedModel);
    }
}
//@@author

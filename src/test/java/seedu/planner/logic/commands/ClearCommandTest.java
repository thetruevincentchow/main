package seedu.planner.logic.commands;

import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;

public class ClearCommandTest {

    @Test
    public void execute_emptyPlanner_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}

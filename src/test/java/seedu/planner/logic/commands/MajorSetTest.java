package seedu.planner.logic.commands;

import static seedu.planner.model.util.SampleDataUtil.getSamplePlanner;

import org.junit.jupiter.api.Test;

import seedu.planner.logic.commands.major.MajorSetCommand;
import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for EditCommand.
 */
public class MajorSetTest {

    private Model model = new ModelManager(getSamplePlanner(), new UserPrefs());

    @Test
    public void execute_setMajor_success() {
        String major = "CS";
        MajorSetCommand majorSetCommand = new MajorSetCommand(major);
        String expectedMessage = String.format(MajorSetCommand.MESSAGE_SUCCESS, major);
    }

    @Test
    public void equals() {

    }

}

package seedu.planner.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.planner.testutil.TypicalModules.getTypicalPlanner;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.planner.commons.core.GuiSettings;
import seedu.planner.model.Planner;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.UserPrefs;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonPlannerStorage plannerStorage = new JsonPlannerStorage(getTempFilePath("ab"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(plannerStorage, userPrefsStorage); // TODO
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void plannerReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonPlannerStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonPlannerStorageTest} class.
         */
        Planner original = getTypicalPlanner();
        storageManager.savePlanner(original);
        ReadOnlyPlanner retrieved = storageManager.readPlanner().get();
        assertEquals(original, new Planner(retrieved));
    }

    @Test
    public void getPlannerFilePath() {
        assertNotNull(storageManager.getPlannerFilePath());
    }

}

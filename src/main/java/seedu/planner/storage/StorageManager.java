package seedu.planner.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.planner.commons.core.LogsCenter;
import seedu.planner.commons.exceptions.DataConversionException;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.ReadOnlyUserPrefs;
import seedu.planner.model.UserPrefs;

/**
 * Manages storage of Planner data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private PlannerStorage plannerStorage;
    private UserPrefsStorage userPrefsStorage;


    public StorageManager(PlannerStorage plannerStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.userPrefsStorage = userPrefsStorage;
        this.plannerStorage = plannerStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }

    // ================ Planner methods ==============================

    public Path getPlannerFilePath() {
        return plannerStorage.getPlannerFilePath();
    }

    public Optional<ReadOnlyPlanner> readPlanner() throws DataConversionException, IOException {
        return readPlanner(plannerStorage.getPlannerFilePath());
    }

    /**
     * Reads a {@code Planner} object from {@code Storage}
     * @param filePath Location of where the planner is stored
     * @return {@code Optional<ReadOnlyPlanner>} object
     * @throws DataConversionException when there is an issue converting the serialised form the {@code Planner} object
     * @throws IOException when there is an issue with reading contents from the file
     */
    public Optional<ReadOnlyPlanner> readPlanner(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return plannerStorage.readPlanner(filePath);
    }

    public void savePlanner(ReadOnlyPlanner planner) throws IOException {
        savePlanner(planner, plannerStorage.getPlannerFilePath());
    }

    /**
     * Saves a given {@code ReadOnlyPlanner} into a {@code Storage}
     * @param planner Planner to be saved
     * @param filePath Location of where the planner is to be saved
     * @throws IOException when there is an issue with writing changes into the file
     */
    public void savePlanner(ReadOnlyPlanner planner, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        plannerStorage.savePlanner(planner, filePath);
    }

}

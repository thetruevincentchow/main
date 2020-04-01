package seedu.planner.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.planner.commons.exceptions.DataConversionException;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.ReadOnlyUserPrefs;
import seedu.planner.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends UserPrefsStorage, PlannerStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getPlannerFilePath();

    @Override
    Optional<ReadOnlyPlanner> readPlanner() throws DataConversionException, IOException;

    @Override
    void savePlanner(ReadOnlyPlanner planner) throws IOException;

}

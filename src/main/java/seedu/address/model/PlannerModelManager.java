package seedu.address.model;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.student.Student;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents the in-memory model of the address book data.
 */
public class PlannerModelManager extends ModelManager {
    private static final Logger logger = LogsCenter.getLogger(PlannerModelManager.class);

    private final Planner planner;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public PlannerModelManager(Planner planner) {
        super();
        requireAllNonNull(planner);

        // logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.planner = planner;
        // this.userPrefs = new UserPrefs(userPrefs);
    }

    public PlannerModelManager() {
        this(new Planner());
    }


    //=========== Planner ================================================================================

    public void setPlanner(Planner planner) {
        this.planner.resetData(planner);
    }

    public Planner getPlanner() {
        return planner;
    }

    public void addStudent(Student student) {
        requireAllNonNull(student);
        planner.addStudent(student);
    }


    @Override
    public Student getActiveStudent() {
        return planner.getActiveStudent();
    }

    @Override
    public void setActiveStudent(Student editedStudent) {
        planner.setActiveStudent(editedStudent);
    }
}

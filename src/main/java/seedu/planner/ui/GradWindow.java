package seedu.planner.ui;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.graduation.GraduationRequirement;
import seedu.planner.model.student.Student;



public class GradWindow extends UiPart<Region> {

    private static final String FXML = "GradView.fxml";

    @FXML
    private HBox gradPane;

    @FXML
    private Label graduationStatus;

    @FXML
    private Label info;

    public GradWindow(ReadOnlyPlanner planner) {
        super(FXML);
        setGrad(planner);
    }

    public void setGrad(ReadOnlyPlanner planner) {
        if (planner.getStudentList().size() == 0) {
            graduationStatus.setText("No Active Student Detected");
        } else {
            Student activeStudent = planner.getActiveStudent();
            graduationStatus.setStyle("-fx-font: 24 arial; -fx-text-fill: white;");
            graduationStatus.setText("Graduation Requirement for " + activeStudent.getName());
            List<GraduationRequirement> gradRequire = activeStudent.getMajor().getGraduationRequirements();
            StringBuffer sb = new StringBuffer();
            boolean isFirst = true;
            for (GraduationRequirement graduationRequirement : gradRequire) {
                if (!isFirst) {
                    sb.append("\n");
                }
                sb.append(graduationRequirement.getString(activeStudent.getAllEnrolledModules()));
            }
            info.setStyle("-fx-font: 16 arial; -fx-text-fill: white;");
            info.setText(sb.toString());

        }
    }

    /**
     * Overrides Equal function to compare objects
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GradWindow)) {
            return false;
        }
        return false;
    }
}

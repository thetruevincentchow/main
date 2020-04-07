package seedu.planner.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import seedu.planner.model.module.Lesson;
import seedu.planner.model.module.LessonDataImporter;
import seedu.planner.model.module.Module;



/**
 * An UI component that displays information of a {@code Module}.
 */
public class ModuleCard extends UiPart<Region> {

    private static final String FXML = "ModuleListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     */

    public final Module module;
    private List<Lesson> lessons = new ArrayList<>();

    @FXML
    private HBox cardPane;
    @FXML
    private Label code;
    @FXML
    private Label id;
    @FXML
    private Label title;
    @FXML
    private Label semester;
    @FXML
    private FlowPane tags;

    /**
     * Constructor for ModuleCard Class
     * @param module
     * @param displayedIndex
     */
    public ModuleCard(Module module, int displayedIndex) {
        super(FXML);
        this.module = module;
        id.setText(displayedIndex + ". ");
        code.setText(module.getModuleCode().value);
        title.setText(module.getModuleTitle());
        String builder = "Semesters: ";
        for (int i = 0; i < module.getSemesterName().size(); i++) {
            builder += module.getSemesterName().get(i).getSemester() + " ";
        }
        semester.setText(builder);
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
        if (!(other instanceof ModuleCard)) {
            return false;
        }

        // state check
        ModuleCard card = (ModuleCard) other;
        return id.getText().equals(card.id.getText())
            && module.equals(card.module);
    }

    @FXML
    public void showDetails() {
        VBox order = new VBox();
        String moduleBuilder = "Module: " + module.getTitle() + "  " + module.getModuleTitle()
                + "\n\n" + "Department: " + module.getDepartment() + "\n\n" + "Description: " + module.getDescription()
                + "\n\n" + "Pre Req: " + module.getPrerequisite();

        Label moduleDetails = new Label(moduleBuilder);
        Button sem1 = new Button();
        sem1.setText("Lessons for Semester 1");
        sem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CalendarBox sem1Lesson = new CalendarBox();
                setLessonDetails(1);
                sem1Lesson.setCalendar(lessons);
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(sem1Lesson.getRoot());
                Scene secondScene = new Scene(secondaryLayout, 1360, 300);
                secondScene.getStylesheets().add(getClass().getResource("/view/DarkTheme.css").toExternalForm());
                Stage newWindow = new Stage();
                newWindow.setTitle("Semester 1");
                newWindow.setScene(secondScene);
                newWindow.show();
            }
        });
        Button sem2 = new Button();
        sem2.setText("Lessons for Semester 2");
        sem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CalendarBox sem2Lesson = new CalendarBox();
                setLessonDetails(2);
                sem2Lesson.setCalendar(lessons);
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(sem2Lesson.getRoot());
                Scene secondScene = new Scene(secondaryLayout, 1360, 300);
                secondScene.getStylesheets().add(getClass().getResource("/view/DarkTheme.css").toExternalForm());
                Stage newWindow = new Stage();
                newWindow.setTitle("Semester 2");
                newWindow.setScene(secondScene);
                newWindow.show();
            }
        });
        moduleDetails.setTextFill(Color.rgb(255, 255, 255));
        moduleDetails.setWrapText(true);
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(order);
        order.getChildren().add(moduleDetails);
        if (module.getSemesterName().size() == 0) {
            //Do nothing
        } else if (module.getSemesterName().size() == 1) {
            if (module.getSemesterName().get(0).getSemester() == 1) {
                order.getChildren().add(sem1);
            } else if (module.getSemesterName().get(0).getSemester() == 2) {
                order.getChildren().add(sem2);
            }
        } else {
            order.getChildren().add(sem1);
            order.getChildren().add(sem2);
        }
        secondaryLayout.setBackground(new Background(new BackgroundFill(Color.rgb(60, 62, 63), CornerRadii.EMPTY,
                Insets.EMPTY)));
        Scene secondScene = new Scene(secondaryLayout, 500, 500);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle(code.getText());
        newWindow.setScene(secondScene);
        newWindow.show();
    }

    private void setLessonDetails(int sem) {
        LessonDataImporter imp = new LessonDataImporter();
        lessons = imp.run(module.getModuleCode().toString(), sem);
    }
}


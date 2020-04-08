package seedu.planner.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import seedu.planner.commons.core.LogsCenter;
import seedu.planner.model.ReadOnlyPlanner;
import seedu.planner.model.module.Lesson;
import seedu.planner.model.module.LessonDataImporter;

/**
 * An UI component that displays information of a {@code Timetable}.
 */
public class CalendarBox extends UiPart<Region> {
    private static final String FXML = "calendarBox.fxml";
    private final Logger logger = LogsCenter.getLogger(CalendarBox.class);
    private ReadOnlyPlanner planner;
    private LessonDataImporter lessonDataImporter = new LessonDataImporter();

    @FXML
    private Label semester;

    @FXML
    private Label dayTime;

    @FXML
    private AnchorPane lessonPanel;

    @FXML
    private AnchorPane am1;
    @FXML
    private AnchorPane am2;
    @FXML
    private AnchorPane am3;
    @FXML
    private AnchorPane am4;
    @FXML
    private AnchorPane am5;
    @FXML
    private AnchorPane am6;
    @FXML
    private AnchorPane am7;
    @FXML
    private AnchorPane am8;
    @FXML
    private AnchorPane am9;
    @FXML
    private AnchorPane am10;
    @FXML
    private AnchorPane am11;
    @FXML
    private AnchorPane am12;
    @FXML
    private AnchorPane at1;
    @FXML
    private AnchorPane at2;
    @FXML
    private AnchorPane at3;
    @FXML
    private AnchorPane at4;
    @FXML
    private AnchorPane at5;
    @FXML
    private AnchorPane at6;
    @FXML
    private AnchorPane at7;
    @FXML
    private AnchorPane at8;
    @FXML
    private AnchorPane at9;
    @FXML
    private AnchorPane at10;
    @FXML
    private AnchorPane at11;
    @FXML
    private AnchorPane at12;
    @FXML
    private AnchorPane aw1;
    @FXML
    private AnchorPane aw2;
    @FXML
    private AnchorPane aw3;
    @FXML
    private AnchorPane aw4;
    @FXML
    private AnchorPane aw5;
    @FXML
    private AnchorPane aw6;
    @FXML
    private AnchorPane aw7;
    @FXML
    private AnchorPane aw8;
    @FXML
    private AnchorPane aw9;
    @FXML
    private AnchorPane aw10;
    @FXML
    private AnchorPane aw11;
    @FXML
    private AnchorPane aw12;
    @FXML
    private AnchorPane ath1;
    @FXML
    private AnchorPane ath2;
    @FXML
    private AnchorPane ath3;
    @FXML
    private AnchorPane ath4;
    @FXML
    private AnchorPane ath5;
    @FXML
    private AnchorPane ath6;
    @FXML
    private AnchorPane ath7;
    @FXML
    private AnchorPane ath8;
    @FXML
    private AnchorPane ath9;
    @FXML
    private AnchorPane ath10;
    @FXML
    private AnchorPane ath11;
    @FXML
    private AnchorPane ath12;
    @FXML
    private AnchorPane af1;
    @FXML
    private AnchorPane af2;
    @FXML
    private AnchorPane af3;
    @FXML
    private AnchorPane af4;
    @FXML
    private AnchorPane af5;
    @FXML
    private AnchorPane af6;
    @FXML
    private AnchorPane af7;
    @FXML
    private AnchorPane af8;
    @FXML
    private AnchorPane af9;
    @FXML
    private AnchorPane af10;
    @FXML
    private AnchorPane af11;
    @FXML
    private AnchorPane af12;

    @FXML
    private Label t89;
    @FXML
    private Label t910;
    @FXML
    private Label t1011;
    @FXML
    private Label t1112;
    @FXML
    private Label t1213;
    @FXML
    private Label t1314;
    @FXML
    private Label t1415;
    @FXML
    private Label t1516;
    @FXML
    private Label t1617;
    @FXML
    private Label t1718;
    @FXML
    private Label t1819;
    @FXML
    private Label t1920;

    @FXML
    private Label m1;
    @FXML
    private Label m2;
    @FXML
    private Label m3;
    @FXML
    private Label m4;
    @FXML
    private Label m5;
    @FXML
    private Label m6;
    @FXML
    private Label m7;
    @FXML
    private Label m8;
    @FXML
    private Label m9;
    @FXML
    private Label m10;
    @FXML
    private Label m11;
    @FXML
    private Label m12;

    @FXML
    private Label t1;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label t4;
    @FXML
    private Label t5;
    @FXML
    private Label t6;
    @FXML
    private Label t7;
    @FXML
    private Label t8;
    @FXML
    private Label t9;
    @FXML
    private Label t10;
    @FXML
    private Label t11;
    @FXML
    private Label t12;

    @FXML
    private Label w1;
    @FXML
    private Label w2;
    @FXML
    private Label w3;
    @FXML
    private Label w4;
    @FXML
    private Label w5;
    @FXML
    private Label w6;
    @FXML
    private Label w7;
    @FXML
    private Label w8;
    @FXML
    private Label w9;
    @FXML
    private Label w10;
    @FXML
    private Label w11;
    @FXML
    private Label w12;

    @FXML
    private Label th1;
    @FXML
    private Label th2;
    @FXML
    private Label th3;
    @FXML
    private Label th4;
    @FXML
    private Label th5;
    @FXML
    private Label th6;
    @FXML
    private Label th7;
    @FXML
    private Label th8;
    @FXML
    private Label th9;
    @FXML
    private Label th10;
    @FXML
    private Label th11;
    @FXML
    private Label th12;

    @FXML
    private Label f1;
    @FXML
    private Label f2;
    @FXML
    private Label f3;
    @FXML
    private Label f4;
    @FXML
    private Label f5;
    @FXML
    private Label f6;
    @FXML
    private Label f7;
    @FXML
    private Label f8;
    @FXML
    private Label f9;
    @FXML
    private Label f10;
    @FXML
    private Label f11;
    @FXML
    private Label f12;


    /**
     * Constructor for CalendarBox class
     */
    public CalendarBox(ReadOnlyPlanner planner) {
        super(FXML);
        this.planner = planner;
        dayTime.setText("Day / Time");
        m1.setText("");
        m2.setText("");
        m3.setText("");
        m4.setText("");
        m5.setText("");
        m6.setText("");
        m7.setText("");
        m8.setText("");
        m9.setText("");
        m10.setText("");
        m11.setText("");
        m12.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        w1.setText("");
        w2.setText("");
        w3.setText("");
        w4.setText("");
        w5.setText("");
        w6.setText("");
        w7.setText("");
        w8.setText("");
        w9.setText("");
        w10.setText("");
        w11.setText("");
        w12.setText("");
        th1.setText("");
        th2.setText("");
        th3.setText("");
        th4.setText("");
        th5.setText("");
        th6.setText("");
        th7.setText("");
        th8.setText("");
        th9.setText("");
        th10.setText("");
        th11.setText("");
        th12.setText("");
        f1.setText("");
        f2.setText("");
        f3.setText("");
        f4.setText("");
        f5.setText("");
        f6.setText("");
        f7.setText("");
        f8.setText("");
        f9.setText("");
        f10.setText("");
        f11.setText("");
        f12.setText("");
        setCalendar(planner.getLessons());
    }

    /**
     * Constructor for CalendarBox class
     */
    public CalendarBox() {
        super(FXML);
        dayTime.setText("Day / Time");
        m1.setText("");
        m2.setText("");
        m3.setText("");
        m4.setText("");
        m5.setText("");
        m6.setText("");
        m7.setText("");
        m8.setText("");
        m9.setText("");
        m10.setText("");
        m11.setText("");
        m12.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        w1.setText("");
        w2.setText("");
        w3.setText("");
        w4.setText("");
        w5.setText("");
        w6.setText("");
        w7.setText("");
        w8.setText("");
        w9.setText("");
        w10.setText("");
        w11.setText("");
        w12.setText("");
        th1.setText("");
        th2.setText("");
        th3.setText("");
        th4.setText("");
        th5.setText("");
        th6.setText("");
        th7.setText("");
        th8.setText("");
        th9.setText("");
        th10.setText("");
        th11.setText("");
        th12.setText("");
        f1.setText("");
        f2.setText("");
        f3.setText("");
        f4.setText("");
        f5.setText("");
        f6.setText("");
        f7.setText("");
        f8.setText("");
        f9.setText("");
        f10.setText("");
        f11.setText("");
        f12.setText("");
    }

    /**
     * Fills up the timetable
     */
    public void setCalendar(List<Lesson> lessons) {
        for (int i = 0; i < lessons.size(); i++) {
            String type = "";
            type = lessons.get(i).getLessonType().substring(0, 3);
            String startTime = lessons.get(i).getStartTime();
            String endTime = lessons.get(i).getEndTime();
            String day = lessons.get(i).getDay();
            if (day.contains("Monday")) {
                if (startTime.startsWith("08")) {
                    am1.setStyle("-fx-background-color: #f5a7a2;");
                    m1.setText(type);
                } else if (startTime.startsWith("09")) {
                    am2.setStyle("-fx-background-color: #f5a7a2;");
                    m2.setText(type);
                } else if (startTime.startsWith("10")) {
                    am3.setStyle("-fx-background-color: #f5a7a2;");
                    m3.setText(type);
                } else if (startTime.startsWith("11")) {
                    am4.setStyle("-fx-background-color: #f5a7a2;");
                    m4.setText(type);
                } else if (startTime.startsWith("12")) {
                    am5.setStyle("-fx-background-color: #f5a7a2;");
                    m5.setText(type);
                } else if (startTime.startsWith("13")) {
                    am6.setStyle("-fx-background-color: #f5a7a2;");
                    m6.setText(type);
                } else if (startTime.startsWith("14")) {
                    am7.setStyle("-fx-background-color: #f5a7a2;");
                    m7.setText(type);
                } else if (startTime.startsWith("15")) {
                    am8.setStyle("-fx-background-color: #f5a7a2;");
                    m8.setText(type);
                } else if (startTime.startsWith("16")) {
                    am9.setStyle("-fx-background-color: #f5a7a2;");
                    m9.setText(type);
                } else if (startTime.startsWith("17")) {
                    am10.setStyle("-fx-background-color: #f5a7a2;");
                    m10.setText(type);
                } else if (startTime.startsWith("18")) {
                    am11.setStyle("-fx-background-color: #f5a7a2;");
                    m11.setText(type);
                } else if (startTime.startsWith("09")) {
                    am12.setStyle("-fx-background-color: #f5a7a2;");
                    m12.setText(type);
                }
            } else if (day.contains("Tuesday")) {
                if (startTime.startsWith("08")) {
                    at1.setStyle("-fx-background-color: #f5a7a2;");
                    t1.setText(type);
                } else if (startTime.startsWith("09")) {
                    at2.setStyle("-fx-background-color: #f5a7a2;");
                    t2.setText(type);
                } else if (startTime.startsWith("10")) {
                    at3.setStyle("-fx-background-color: #f5a7a2;");
                    t3.setText(type);
                } else if (startTime.startsWith("11")) {
                    at4.setStyle("-fx-background-color: #f5a7a2;");
                    t4.setText(type);
                } else if (startTime.startsWith("12")) {
                    at5.setStyle("-fx-background-color: #f5a7a2;");
                    t5.setText(type);
                } else if (startTime.startsWith("13")) {
                    at6.setStyle("-fx-background-color: #f5a7a2;");
                    t6.setText(type);
                } else if (startTime.startsWith("14")) {
                    at7.setStyle("-fx-background-color: #f5a7a2;");
                    t7.setText(type);
                } else if (startTime.startsWith("15")) {
                    at8.setStyle("-fx-background-color: #f5a7a2;");
                    t8.setText(type);
                } else if (startTime.startsWith("16")) {
                    at9.setStyle("-fx-background-color: #f5a7a2;");
                    t9.setText(type);
                } else if (startTime.startsWith("17")) {
                    at10.setStyle("-fx-background-color: #f5a7a2;");
                    t10.setText(type);
                } else if (startTime.startsWith("18")) {
                    at11.setStyle("-fx-background-color: #f5a7a2;");
                    t11.setText(type);
                } else if (startTime.startsWith("09")) {
                    at12.setStyle("-fx-background-color: #f5a7a2;");
                    t12.setText(type);
                }
            } else if (day.contains("Wednesday")) {
                if (startTime.startsWith("08")) {
                    aw1.setStyle("-fx-background-color: #f5a7a2;");
                    w1.setText(type);
                } else if (startTime.startsWith("09")) {
                    aw2.setStyle("-fx-background-color: #f5a7a2;");
                    w2.setText(type);
                } else if (startTime.startsWith("10")) {
                    aw3.setStyle("-fx-background-color: #f5a7a2;");
                    w3.setText(type);
                } else if (startTime.startsWith("11")) {
                    aw4.setStyle("-fx-background-color: #f5a7a2;");
                    w4.setText(type);
                } else if (startTime.startsWith("12")) {
                    aw5.setStyle("-fx-background-color: #f5a7a2;");
                    w5.setText(type);
                } else if (startTime.startsWith("13")) {
                    aw6.setStyle("-fx-background-color: #f5a7a2;");
                    w6.setText(type);
                } else if (startTime.startsWith("14")) {
                    aw7.setStyle("-fx-background-color: #f5a7a2;");
                    w7.setText(type);
                } else if (startTime.startsWith("15")) {
                    aw8.setStyle("-fx-background-color: #f5a7a2;");
                    w8.setText(type);
                } else if (startTime.startsWith("16")) {
                    aw9.setStyle("-fx-background-color: #f5a7a2;");
                    w9.setText(type);
                } else if (startTime.startsWith("17")) {
                    aw10.setStyle("-fx-background-color: #f5a7a2;");
                    w10.setText(type);
                } else if (startTime.startsWith("18")) {
                    aw11.setStyle("-fx-background-color: #f5a7a2;");
                    w11.setText(type);
                } else if (startTime.startsWith("09")) {
                    aw12.setStyle("-fx-background-color: #f5a7a2;");
                    w12.setText(type);
                }
            } else if (day.contains("Thursday")) {
                if (startTime.startsWith("08")) {
                    ath1.setStyle("-fx-background-color: #f5a7a2;");
                    th1.setText(type);
                } else if (startTime.startsWith("09")) {
                    ath2.setStyle("-fx-background-color: #f5a7a2;");
                    th2.setText(type);
                } else if (startTime.startsWith("10")) {
                    ath3.setStyle("-fx-background-color: #f5a7a2;");
                    th3.setText(type);
                } else if (startTime.startsWith("11")) {
                    ath4.setStyle("-fx-background-color: #f5a7a2;");
                    th4.setText(type);
                } else if (startTime.startsWith("12")) {
                    ath5.setStyle("-fx-background-color: #f5a7a2;");
                    th5.setText(type);
                } else if (startTime.startsWith("13")) {
                    ath6.setStyle("-fx-background-color: #f5a7a2;");
                    th6.setText(type);
                } else if (startTime.startsWith("14")) {
                    ath7.setStyle("-fx-background-color: #f5a7a2;");
                    th7.setText(type);
                } else if (startTime.startsWith("15")) {
                    ath8.setStyle("-fx-background-color: #f5a7a2;");
                    th8.setText(type);
                } else if (startTime.startsWith("16")) {
                    ath9.setStyle("-fx-background-color: #f5a7a2;");
                    th9.setText(type);
                } else if (startTime.startsWith("17")) {
                    ath10.setStyle("-fx-background-color: #f5a7a2;");
                    th10.setText(type);
                } else if (startTime.startsWith("18")) {
                    ath11.setStyle("-fx-background-color: #f5a7a2;");
                    th11.setText(type);
                } else if (startTime.startsWith("09")) {
                    ath12.setStyle("-fx-background-color: #f5a7a2;");
                    th12.setText(type);
                }
            } else if (day.contains("Friday")) {
                if (startTime.startsWith("08")) {
                    af1.setStyle("-fx-background-color: #f5a7a2;");
                    f1.setText(type);
                } else if (startTime.startsWith("09")) {
                    af2.setStyle("-fx-background-color: #f5a7a2;");
                    f2.setText(type);
                } else if (startTime.startsWith("10")) {
                    af3.setStyle("-fx-background-color: #f5a7a2;");
                    f3.setText(type);
                } else if (startTime.startsWith("11")) {
                    af4.setStyle("-fx-background-color: #f5a7a2;");
                    f4.setText(type);
                } else if (startTime.startsWith("12")) {
                    af5.setStyle("-fx-background-color: #f5a7a2;");
                    f5.setText(type);
                } else if (startTime.startsWith("13")) {
                    af6.setStyle("-fx-background-color: #f5a7a2;");
                    f6.setText(type);
                } else if (startTime.startsWith("14")) {
                    af7.setStyle("-fx-background-color: #f5a7a2;");
                    f7.setText(type);
                } else if (startTime.startsWith("15")) {
                    af8.setStyle("-fx-background-color: #f5a7a2;");
                    f8.setText(type);
                } else if (startTime.startsWith("16")) {
                    af9.setStyle("-fx-background-color: #f5a7a2;");
                    f9.setText(type);
                } else if (startTime.startsWith("17")) {
                    af10.setStyle("-fx-background-color: #f5a7a2;");
                    f10.setText(type);
                } else if (startTime.startsWith("18")) {
                    af11.setStyle("-fx-background-color: #f5a7a2;");
                    f11.setText(type);
                } else if (startTime.startsWith("09")) {
                    af12.setStyle("-fx-background-color: #f5a7a2;");
                    f12.setText(type);
                }
            }
        }
        Label lessonsDetails = new Label();
        String lessonList = "";
        for (int j = 0; j < lessons.size(); j++) {
            lessonList = lessonList + (j + 1) + ". " + lessons.get(j).getClassNo() + " "
                    + lessons.get(j).getLessonType() + "\n";
        }
        lessonsDetails.setText(lessonList);
        lessonPanel.getChildren().add(lessonsDetails);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CalendarBox)) {
            return false;
        }
        return false;
    }

}

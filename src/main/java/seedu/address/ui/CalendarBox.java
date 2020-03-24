package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;

/**
 * An UI component that displays information of a {@code Timetable}.
 */
public class CalendarBox extends UiPart<Region> {
    private static final String FXML = "calendarBox.fxml";
    private final Logger logger = LogsCenter.getLogger(CalendarBox.class);

    @FXML
    private Label semester;

    @FXML
    private Label dayTime;

    @FXML
    private Label t89, t910, t1011, t1112, t1213, t1314, t1516, t1617, t1718, t1819, t1920;

    @FXML
    private Label m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12;

    @FXML
    private Label t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;

    @FXML
    private Label w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12;

    @FXML
    private Label th1, th2, th3, th4, th5, th6, th7, th8, th9, th10, th11, th12;

    @FXML
    private Label f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12;


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
     * Todo once timetable can be seen
     */
    public void setCalendar() {

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

package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.module.Module;

public class CalendarBox extends UiPart<Region> {
    private static final String FXML = "calendarBox.fxml";
    private final Logger logger = LogsCenter.getLogger(CalendarBox.class);

    @FXML
    private Label semester;

    @FXML
    private Label day_time;



    public CalendarBox(){
        super(FXML);
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

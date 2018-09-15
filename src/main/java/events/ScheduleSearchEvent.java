package events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.Apprantice;
import models.reference.ScheduleReference;
import parsers.ScheduleParser;
import tables.TableCreator;
import tables.forms.MyTable;

public class ScheduleSearchEvent implements EventHandler<ActionEvent>
{
    private ComboBox facultyComboBox;
    private TextField groupNumberTextField;
    private ScheduleReference scheduleReference;
    private MyTable schedule;
    private ScheduleParser scheduleParser;
    private TableCreator tableCreator;

    public ScheduleSearchEvent(ComboBox facultyComboBox, TextField groupNumber, MyTable schedule)
    {
        this.facultyComboBox = facultyComboBox;
        this.groupNumberTextField = groupNumber;
        this.schedule = schedule;
    }

    @Override
    public void handle(ActionEvent event)
    {

//        Apprantice apprantice = new Apprantice(this.facultyComboBox.getValue().toString()
//                , this.groupNumberTextField.getText());
//        this.scheduleReference = new ScheduleReference(apprantice);
//        this.scheduleParser = new ScheduleParser(this.scheduleReference);
//        this.scheduleParser.parse();
//        this.schedule.getChildren().add(this.scheduleParser.getParseTable());

        Apprantice apprantice = new Apprantice(this.facultyComboBox.getValue().toString()
                , this.groupNumberTextField.getText());
        this.scheduleReference = new ScheduleReference(apprantice);
        this.tableCreator = new TableCreator(this.schedule, this.scheduleReference);
        this.tableCreator.createTable();


    }
}

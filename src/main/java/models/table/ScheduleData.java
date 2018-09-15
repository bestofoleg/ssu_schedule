package models.table;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ScheduleData extends HBox
{
    private List<ScheduleColumnData> daysColums;

    public ScheduleData()
    {
        this.daysColums = new ArrayList<>();

    }

    public void addCoulumn(ScheduleColumnData data)
    {
        this.daysColums.add(data);
        this.getChildren().add(data);
    }

    public List<ScheduleColumnData> getDaysColums() {
        return daysColums;
    }
}

package models.table;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ScheduleColumnData extends VBox
{
    private List<ScheduleCellData> subjectsCells;

    public List<ScheduleCellData> getSubjectsCells() {
        return subjectsCells;
    }

    public ScheduleColumnData()
    {
        this.subjectsCells = new ArrayList<>();
    }

    public void addCell(ScheduleCellData data)
    {
        this.subjectsCells.add(data);
        this.getChildren().add(data);
    }

}

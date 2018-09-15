package tables.forms;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MyColumn extends VBox
{
    private String columnName;
    private int columnSize;
    private ObservableList<Node> children;

    public MyColumn(String columnName) {
        this.columnName = columnName;
        this.columnSize = 0;
        this.children = this.getChildren();
        MyCell c = new MyCell(columnName);
        c.setStyle("-fx-border-color: green ; -fx-border-width: 2px ;");
        this.children.add(c);
    }

    public void addCell(MyCell cell)
    {
        this.children.add(cell);
        this.columnSize ++;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }
}

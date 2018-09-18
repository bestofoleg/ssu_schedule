package tables.forms;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import javax.swing.table.TableColumn;

public class MyTable extends HBox
{
    private int columnsCount;
    private float maxCellSize;
    private ObservableList<Node> children;

    public MyTable()
    {
        super();
        this.columnsCount = 0;
        this.maxCellSize = 0;
        this.children = this.getChildren();
    }

    public void clear()
    {
        this.children.clear();
    }

    public void addColumn(MyColumn column)
    {
        this.children.add(column);
        this.columnsCount ++;
    }

    public MyColumn getColumn(int index)
    {
        return (MyColumn) this.children.get(index);
    }

    public int getColumnsCount() {
        return columnsCount;
    }
}

package tables.forms;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyCell extends VBox
{

    private Text infoText;

    public MyCell(String info)
    {
        this.infoText = new Text(info);
        this.infoText.setWrappingWidth(100);
        this.getChildren().add(this.infoText);
    }

    public Text getInfoText() {
        return infoText;
    }
}

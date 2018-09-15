package models.table;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ScheduleCellData extends VBox
{
    private Text subjectNameText;
    private Text teacherNameText;
    private Text placeText;
    private Text parityText;
    private Text subjectTypeText;

    public ScheduleCellData() {

        this.subjectNameText = new Text();
        this.teacherNameText = new Text();
        this.placeText = new Text();
        this.parityText = new Text();
        this.subjectTypeText = new Text();

        this.getChildren().addAll(

                this.subjectNameText,
                this.teacherNameText,
                this.placeText

        );

    }

    public void setSubjectType(String type)
    {
        this.subjectTypeText.setText(type);
    }

    public void setParityText(String text)
    {
        this.parityText.setText(text);
    }

    public void setSubjectName(String name)
    {
        this.subjectNameText.setText(name);
    }

    public void setTeacherName(String name)
    {
        this.teacherNameText.setText(name);
    }

    public void setPlaceName(String name)
    {
        this.placeText.setText(name);
    }

    public String getSubjectType()
    {
        return this.subjectTypeText.getText();
    }

    public String getParityText()
    {
        return this.parityText.getText();
    }

    public String getSubjectName()
    {
        return this.subjectNameText.getText();
    }

    public String getTeacherName()
    {
        return this.teacherNameText.getText();
    }

    public String getPlaceName()
    {
        return this.placeText.getText();
    }


}

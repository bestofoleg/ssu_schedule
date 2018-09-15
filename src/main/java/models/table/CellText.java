package models.table;

public class CellText
{

    private StringBuffer text;

    public CellText(ScheduleCellData scheduleCellData)
    {

        this.text.append(scheduleCellData.getSubjectType());
        this.text.append("       ");
        this.text.append(scheduleCellData.getParityText());
        this.text.append("\n");
        this.text.append(scheduleCellData.getSubjectName());
        this.text.append("\n");
        this.text.append(scheduleCellData.getPlaceName());
        this.text.append("\n");
        this.text.append(scheduleCellData.getTeacherName());

    }

    public String getText() {
        return text.toString();
    }

    public void setText(String text) {
        this.text.delete(0, this.text.length()-1);
        this.text.append(text);
    }
}

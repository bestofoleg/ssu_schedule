package tables;

import javafx.scene.text.Text;
import models.reference.ScheduleReference;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tables.forms.MyCell;
import tables.forms.MyColumn;
import tables.forms.MyTable;

import java.io.IOException;

public class TableCreator
{

    private MyTable emptyTable;
    private ScheduleReference scheduleReference;

    public TableCreator(MyTable emptyTable, ScheduleReference scheduleReference) {
        this.emptyTable = emptyTable;
        this.scheduleReference = scheduleReference;
    }

    public void createTable()
    {
        this.emptyTable.clear();
        try{

            Document document = Jsoup.connect(this.scheduleReference.getReference()).get();
            Element table = document.getElementById("schedule");
            Elements tableRows = table.getElementsByTag("tr");
            tableRows.remove(0);

            MyCell cell = null;
            MyColumn column = null;
            StringBuffer info = new StringBuffer();

            this.emptyTable.addColumn(new MyColumn("ПН"));
            this.emptyTable.addColumn(new MyColumn("ВТ"));
            this.emptyTable.addColumn(new MyColumn("СР"));
            this.emptyTable.addColumn(new MyColumn("ЧТ"));
            this.emptyTable.addColumn(new MyColumn("ПТ"));
            this.emptyTable.addColumn(new MyColumn("СБ"));

            int columnsCounter = 0;

            for(Element i : tableRows) {


                Elements tableCells = i.getElementsByTag("td");

                for (Element j : tableCells) {
                    Elements div1 = j.getElementsByTag("div");
                    Elements div2 = null;
                    if(div1.size() != 0)
                    {
                        div2 = div1.get(0).getElementsByClass("l-dn");

                        info.append(div2.get(0).ownText());
                    }
                    else
                    {
                        info.append("окно");
                    }
                    cell = new MyCell(info.toString());
                    cell.setStyle("-fx-border-color: yellow ; -fx-border-width: 2px ;");
                    cell.setPrefHeight(100);
                    this.emptyTable.getColumn(columnsCounter).addCell(cell);
                    info.setLength(0);
                    columnsCounter ++;

                }
                columnsCounter = 0;


                //this.emptyTable.addColumn(column);
            }


        } catch (Exception e) {

            this.emptyTable.getChildren().add(new Text("Неизвестное расписание!"));

        }

    }
}

package parsers;

import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.reference.IReference;
import models.table.ScheduleCellData;
import models.table.ScheduleColumnData;
import models.table.ScheduleData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tables.TableCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ScheduleParser
{
    private String reference;
    private ScheduleData scheduleData;
    //private TableCreator tableCreator;
    //Here must be Some Data

    public ScheduleParser(IReference reference)
    {
        this.reference = reference.getReference();
        this.scheduleData = new ScheduleData();
        //this.tableCreator = new TableCreator(this.scheduleData);
    }

    public void parse()
    {
        try {
            Document document = Jsoup.connect(this.reference).get();


            Element schedule = document.getElementById("schedule");

            Element tbody = schedule.getElementsByTag("tbody").get(0);
            Elements trs = tbody.getElementsByTag("tr");
            trs.remove(0);

            Elements tds = null;


            for (Element tr : trs)
            {
                ScheduleColumnData columnData = new ScheduleColumnData();

                tds = tr.getElementsByTag("td");

                for (Element td : tds)
                {
                    String parity, subjectName,subjectType,teacherName,place;
                    //System.out.println(td);
                    if(false) {
                        Element onePr = td.getElementsByClass("1-pr").get(0);
                        parity = onePr.getElementsByClass("1-pr-r").get(0).data();
                        subjectType = onePr.getElementsByClass("1-pr-t").get(0).data();
                        Element oneDn = td.getElementsByClass("1-dn").get(0);
                        subjectName = oneDn.data();
                        teacherName = td.getElementsByClass("1-tn").get(0)
                                .getElementsByTag("href").get(0).data();
                        place = td.getElementsByClass("1-p").get(0).data();

                        System.out.println("!!!");
                    }
                    else
                    {
                        parity = place = subjectName = subjectType = teacherName = "! ";
                    }
                    ScheduleCellData cellData = new ScheduleCellData();
                    cellData.setParityText(parity);
                    cellData.setPlaceName(place);
                    cellData.setSubjectName(subjectName);
                    cellData.setTeacherName(teacherName);
                    cellData.setSubjectType(subjectType);

                    columnData.addCell(cellData);


                }

                this.scheduleData.addCoulumn(columnData);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Pane getParseTable()
    {
        return this.scheduleData;
    }



}

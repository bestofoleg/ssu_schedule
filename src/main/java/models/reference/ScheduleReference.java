package models.reference;

import models.Apprantice;

import java.util.HashMap;

public class ScheduleReference implements IReference
{
    private HashMap<String, String> nameToRefMap;//faculty - ref_faculty
    private StringBuffer reference;
    private Apprantice apprantice;

    public ScheduleReference(Apprantice apprantice)
    {
        this.nameToRefMap = new HashMap<>();

        this.nameToRefMap.put("КНиИТ", "knt");
        this.nameToRefMap.put("Мех-мат", "mm");
        this.nameToRefMap.put("ФНБМТ","fn");

        this.reference = new StringBuffer(45);
        this.reference.append("https://www.sgu.ru/schedule/");
        this.apprantice = apprantice;
    }

    @Override
    public String getReference() {

        this.reference.append(nameToRefMap.get(this.apprantice.getFaculty()));
        this.reference.append("/do/");//the custom part of reference
        this.reference.append(this.apprantice.getGroupNumber());

        return this.reference.toString();
    }
}

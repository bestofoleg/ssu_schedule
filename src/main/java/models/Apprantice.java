package models;

public class Apprantice
{
    private String faculty;
    private String groupNumber;

    public Apprantice(String faculty, String groupNumber) {
        this.faculty = faculty;
        this.groupNumber = groupNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}

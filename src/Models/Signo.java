
package Models;

import java.util.Date;

public class Signo {
    
    private int Id;
    private String Description;
    private Date DateStart;
    private Date DateEnd;

    public Signo(int Id, String Description, Date DateStart, Date DateEnd) {
        this.Id = Id;
        this.Description = Description;
        this.DateStart = DateStart;
        this.DateEnd = DateEnd;
    }

    public Signo() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date DateEnd) {
        this.DateEnd = DateEnd;
    }
}

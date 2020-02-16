import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.*;

//TITLE, NAME, SURNAME,DOB,GOVID,CARDID
@Entity
@Table(name = "CARDHOLDER")
public class CARDHOLDER implements Comparator<CARDHOLDER> {


    @Id
    private String CARDID;
    private String GOVID;
    private String TITLE;
    private String NAME;
    private String SURNAME;
    private Date DOB;

CARDHOLDER(){}

    public CARDHOLDER(String GOVID, String TITLE, String NAME, String SURNAME, Date DOB, String CARDID) {
        this.GOVID = GOVID;
        this.TITLE = TITLE;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.DOB = DOB;
        this.CARDID = CARDID;
    }

    public String getGOVID() {
        return GOVID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getCARDID() {
        return CARDID;
    }

    public void setGOVID(String GOVID) {
        this.GOVID = GOVID;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setCARDID(String CARDID) {
        this.CARDID = CARDID;
    }
    public int compare(CARDHOLDER m1, CARDHOLDER m2)
    {
         int i = m1.getSURNAME().compareTo(m2.getSURNAME());
        return i;
    }
    public String toString()
    {
        return this.getGOVID() + " " + this.getCARDID() + " " + this.getTITLE() + " " +
                this.getDOB() + " " + this.getNAME()    ;
    }
}

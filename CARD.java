import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.*;

@Entity
@Table(name = "CARD")
public class CARD {
    //CARDID, CARDNUM, STATUS,DATECREATED,DATEACTIVATED,PRISECIND,DATEEXPIRY,AVLBALANCE,ACTUALBAL



    private String CARDID;


    @Id
    private String CARDNUMBER;
    private Date DATECREATED;
    private Date ACTIVEDATE;
    private String PRISECIND;
    private Date DATEEXPIRY;
    private double AVAILABLEBALANCE;
    private double ACTUALBAL;
    private CARD_STATUS STATUS = CARD_STATUS.INACTIVE;
    CARD(){}


    public enum CARD_STATUS {
        ACTIVE,INACTIVE,LOST,STOLEN,CLOSED;

    }

    public String getCARDID() {
        return CARDID;
    }

    public String getCARDNUMBER() {
        return CARDNUMBER;
    }

    public Date getDATECREATED() {
        return DATECREATED;
    }

    public Date getACTIVEDATE() {
        return ACTIVEDATE;
    }

    public String getPRISECIND() {
        return PRISECIND;
    }

    public Date getDATEEXPIRY() {
        return DATEEXPIRY;
    }

    public double getAVAILABLEBALANCE() {
        return AVAILABLEBALANCE;
    }

    public double getACTUALBAL() {
        return ACTUALBAL;
    }

    public CARD_STATUS getSTATUS() {
        return STATUS;
    }

    public void setCARDID(String CARDID) {
        this.CARDID = CARDID;
    }

    public void setCARDNUMBER(String CARDNUMBER) {
        this.CARDNUMBER = CARDNUMBER;
    }

    public void setDATECREATED(Date DATECREATED) {
        this.DATECREATED = DATECREATED;
    }

    public void setACTIVEDATE(Date ACTIVEDATE) {
        this.ACTIVEDATE = ACTIVEDATE;
    }

    public void setPRISECIND(String PRISECIND) {
        this.PRISECIND = PRISECIND;
    }

    public void setDATEEXPIRY(Date DATEEXPIRY) {
        this.DATEEXPIRY = DATEEXPIRY;
    }

    public void setAVAILABLEBALANCE(double AVAILABLEBALANCE) {
        this.AVAILABLEBALANCE = AVAILABLEBALANCE;
    }

    public void setACTUALBAL(double ACTUALBAL) {
        this.ACTUALBAL = ACTUALBAL;
    }

    public void setSTATUS(CARD_STATUS STATUS) {
        this.STATUS = STATUS;
    }

    public String toString()
    {
        return this.getCARDID() + "" +this.getCARDNUMBER()+" "+this.getPRISECIND()+" "+this.getACTIVEDATE()+" "+this.getDATECREATED()
                +" "+this.getDATEEXPIRY();
    }

}

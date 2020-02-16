import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARDMGMT")
public class CARDMGMT {
    @Id
    private String CARDID;
    private String CARDNUMBER;
    private int count;

    public CARDMGMT(){}
    public CARDMGMT(String CARDID, String CARDNUMBER, int count) {
        this.CARDID = CARDID;
        this.CARDNUMBER = CARDNUMBER;
        this.count = count;
    }

    public String getCARDID() {
        return CARDID;
    }

    public String getCARDNUMBER() {
        return CARDNUMBER;
    }

    public int getCount() {
        return count;
    }

    public void setCARDID(String CARDID) {
        this.CARDID = CARDID;
    }

    public void setCARDNUMBER(String CARDNUMBER) {
        this.CARDNUMBER = CARDNUMBER;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CARDMGMT{" +
                "CARDID='" + CARDID + '\'' +
                ", CARDNUMBER='" + CARDNUMBER + '\'' +
                ", count=" + count +
                '}';
    }
}

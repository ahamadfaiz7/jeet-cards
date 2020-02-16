import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class DRIVERCLASS {

    public static void main(String[] args) throws Exception {
        double actualbal = 0;
        double availablebalance = 0;
        int cardcount = 0;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager em = emf.createEntityManager();


  /*      Map<String, String> cardMap = new HashMap();
        Map<String, String> cardHolderMap = new HashMap(); */

            System.out.println("Enter CardNumber :");

            String CardNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();

            System.out.println("Enter Status :");

            String CardStatus = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if (CardStatus.equals("ACTIVE") || CardStatus.equals("CLOSED"))
            {
                System.out.println("Card can't be ACTIVE / CLOSED ");
                return ;
            }

            System.out.println("Enter Primary / Secondary /PRIMARY / SECONDARY :");

            String PrimaryOrSecondary = new BufferedReader(new InputStreamReader(System.in)).readLine();
            String PrimarySecInd = null;

            if (PrimaryOrSecondary.equalsIgnoreCase("PRIMARY")) {
                PrimarySecInd = "P";
            } else if (PrimaryOrSecondary.equalsIgnoreCase("SECONDARY")) {
                PrimarySecInd = "S";
            } else if (PrimaryOrSecondary.equalsIgnoreCase("primary")) {
                PrimarySecInd = "P";
            } else if (PrimaryOrSecondary.equalsIgnoreCase("secondary")) {
                PrimarySecInd = "S";
            } else {

                while (PrimarySecInd.equalsIgnoreCase("PRIMARY") || PrimarySecInd.equalsIgnoreCase("PRIMARY")) {
                    System.out.println(" Invalid Indicator . please use PRIMARY / SECONDARY /primary / secondary .");

                    String NewPrimaryOrSecondary = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    PrimarySecInd = NewPrimaryOrSecondary;
                }

            }

            System.out.println("Enter ActiveDate :");

            String CardActDate = new BufferedReader(new InputStreamReader(System.in)).readLine();
            SimpleDateFormat sdf = new SimpleDateFormat(CardActDate);
            Date ActDate = new SimpleDateFormat("yyyy-MM-dd").parse(CardActDate);


        System.out.println("Enter Creation Date :");

        String CardCRDate = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Date CRDate = new SimpleDateFormat("yyyy-MM-dd").parse(CardActDate);

        System.out.println("Enter ExpiryDate :");

            String CardExpDate = new BufferedReader(new InputStreamReader(System.in)).readLine();
            Date ExpDate = new SimpleDateFormat("yyyy-MM-dd").parse(CardExpDate);

            System.out.println("Enter CARDID :");

            String CardId = new BufferedReader(new InputStreamReader(System.in)).readLine();
            boolean isCardValid =  VerifyCardNumber (CardNumber,em,cardcount);
            System.out.println(isCardValid);
            if (isCardValid == true)
            {
              //  Session session =
                em.getTransaction().begin();
                CARD newcard = new CARD();
                CARDMGMT newcardmgmt = new CARDMGMT();

                newcard.setCARDID(CardId);
                newcardmgmt.setCARDID(CardId);

                newcard.setCARDNUMBER(CardNumber);
                newcardmgmt.setCARDID(CardNumber);

                newcard.setSTATUS(CARD.CARD_STATUS.INACTIVE);
                newcard.setPRISECIND(PrimaryOrSecondary);
                newcard.setDATECREATED(CRDate);

                newcard.setACTIVEDATE(ActDate);

                newcard.setDATEEXPIRY(ExpDate);

                newcard.setACTUALBAL(actualbal);

                newcard.setAVAILABLEBALANCE(availablebalance);

                System.out.println(newcard.toString());
                em.persist(newcard);
                em.persist(newcardmgmt);
                em.getTransaction().commit();
                em.close();
            }
        }

    public static boolean VerifyCardNumber(String Cardno, EntityManager em, int cardcount)
    /*
       logic to increase count if CardId is found in the MAP .
       All Values under the Map which has same CardId should increase the count.
       Meaning all count values to a cardId must be same .
       Value = CardId-CardStatus-CardIndicator-Cardcounts
     */
    {

        if(Cardno.length() != 16)
        {
            System.out.println("Card not added to System due to invalid Length");
            return false;
        }


        //System.out.println(CardId);
        CARD cardHolder = em.find(CARD.class,Cardno);


        if (cardHolder != null && cardHolder.getCARDNUMBER() == Cardno)
        {
            System.out.println("Card Already Present");
            return false;
        }

        if (cardHolder!= null)
        {
            CARDMGMT clientCardCount = em.find(CARDMGMT.class,cardHolder.getCARDID());

            if (clientCardCount != null && clientCardCount.getCount() >= 7)

            {
                System.out.println("Client has exceeded the number of Cards to Own .");
                return false;
            }
        }

        return true;
    }
}

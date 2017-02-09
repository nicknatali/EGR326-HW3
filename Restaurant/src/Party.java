import java.util.Queue;

/**
 * Created by NickNatali on 2/7/17.
 * A group of customers that can eat at the restaurant
 */
public class Party {

    /**
     * Variables
     */
    private int partySize;
    private String partyName;


    /**
     * Constructor
     */
    public Party(int partySize, String partyName) {
        this.partySize = partySize;
        this.partyName = partyName;
    }


    /**
     * Set the party's name
     * @param partyName: name of the party.
     */
    public void setPartyName(String partyName){
        //Set the party's name
    }

    /**
     * Set the party's size
     * @param partySize: size of the party.
     */
    public void setPartySize(int partySize) {

    }

    /**
     * Get party size
     */
    public int getPartySize() {

        return 0;
    }

    /**
     * Get the party's name
     */
    public String getPartyName() {
        //return the party's name
        return null;
    }

    /**
     * Let the party pay for a meal to the cash register
     * @Param: total:
     */
    public double payForMeal(double total) {
            //Let someone enter a number amount for how much to pay.
        return 0;
    }

    /**
     * Let the party give the server a tip
     * @param tip:
     */
    public double tipServer(double tip){
        //Let someone enter a number for how much they want to tip.
        return 0;
    }
}

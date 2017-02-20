import java.util.ArrayList;


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
        if(partyName == "" || partySize < 0)
            throw new IllegalArgumentException();
        this.partySize = partySize;
        this.partyName = partyName;
    }


    /**
     * Set the party's name
     * @param partyName: name of the party.
     */
    public void setPartyName(String partyName){
        this.partyName = partyName;
    }

    /**
     * Set the party's size
     * @param partySize: size of the party.
     */
    public void setPartySize(int partySize) {
                this.partySize = partySize;
    }

    /**
     * Get party size
     */
    public int getPartySize() {
        return partySize;
    }

    /**
     * Get the party's name
     */
    public String getPartyName() {
        return partyName;
    }


    /**
     * Checks to see if party has unique name when comparing
     * to table names and names within the waitinglist
     *
     */
    public static boolean partyHasUniqueName(ArrayList<Party> waitlist, String namePossibility){
        //if the party has the same name as another party.
        for(int i = 0; i < waitlist.size(); i++){
            if(waitlist.get(i).getPartyName().equals(namePossibility)) {
                return false;
            }
        }
        return true;
    }

    /**
     * To string method
     * @return
     */
    @Override
    public String toString() {
        return "Party " + partyName + " : size=" + partySize;
    }

}

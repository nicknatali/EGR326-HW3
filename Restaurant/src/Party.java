import java.util.ArrayList;


/**
 * Created by NickNatali on 2/7/17.
 * A group of customers that can eat at the restaurant
 */
public class Party implements Comparable<Party>{

    /**
     * Variables
     */
    private int partySize;
    private String partyName;

    /**
     * Constructor
     *  @param partyName the name of the party
     * @param partySize the size of the party
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
     * @return Get party size
     */
    public int getPartySize() {
        return partySize;
    }

    /**
     * @return Get the party's name
     */
    public String getPartyName() {
        return partyName;
    }


    /**
     * Checks to see if party has unique name when comparing
     * to table names and names within the waitinglist
     *
     */
    public static boolean partyHasUniqueName(ArrayList<Party> waitingList, ArrayList<Table> tableList, String possibleName){
        for(Party party : waitingList){
            if(party.getPartyName() == possibleName)
                return false;
        }
        for (Table each : tableList){
            if(!each.isOccupied() && each.getPartySeated().getPartyName().equals(possibleName))
                return false;
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

    /**
     * Method to compare two party objects
     * @param o object to be compared
     * @return whether the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if(o.getClass() == this.getClass()) {
            Party other = (Party) o;
            return this.partyName.equals(other.partyName) && this.partySize == other.partySize;
        }
        return false;
    }

    /**
     * Method to return the hashcode of the party object
     * @return integer of the hashcode
     */
    @Override
    public int hashCode() {
        return 31 * partySize * partyName.length();
    }

    /**
     * Method to clone a party object
     * @return a clone of the original party object
     * @throws CloneNotSupportedException
     */
    @Override
    public Party clone() throws CloneNotSupportedException {
        return (Party)super.clone();
    }

    /**
     * Method to compare two party objects
     * @return the result of the subtraction of their sizes
     */
    @Override
    public int compareTo(Party o) {
        return partySize - o.partySize;
    }
}




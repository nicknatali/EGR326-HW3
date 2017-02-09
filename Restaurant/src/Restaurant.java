import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by NickNatali on 2/7/17.
 * The overall restaurant and its associated data
 */
public class Restaurant {

    /**
     * Variables
     */
    private ArrayList<Table> tables;
    private ArrayList<Server> servers;
    private Queue<Party> waitlist;
    private String restaurantName;
    private double cashRegister;

    /**
     * @param restaurantName: The name of the restaurant
     * @param cashRegister: Where all the money from parties will go.
     * @param waitlist: Who is waiting to be seated.
     */
    public Restaurant(String restaurantName, double cashRegister, Queue<Party> waitlist){
        //Queue<Party> waitList = new Queue <Party>();
        this.restaurantName = restaurantName;
        this.cashRegister = cashRegister;
    }

    /**
     * Displays the total amount of cash in the register
     */
    public void displaycashRegister(){

    }

    /**
     * Display the total amount of tips for a server
     */
    public void displayTips(Server server) {

    }

    /**
     * Set the restaurant's name
     */
    public void setRestaurantName() {}

    /**
     * Get the restaurant's name
     */
    public void getRestaurantName() {}

    /**
     * Checks to see if party has unique name when comparing to table names and names within the waitinglist
     */
    public boolean partyHasUniqueName(){
        return true;
    }

    /**
     * Gets the party's name
     */
    public String getPartyName() {
        return "";
    }


    public boolean addServer(Server server){
        return true;
    }

    public boolean addTable(Table table){
        return true;
    }

    public void addToCashRegister(double total){


    }

    public void addToWaitingList(Party party){

    }

    public boolean addParty(Party party) {
        return true;
    }

    public boolean removeTable(Table table) {
     return true;
    }

    public boolean removeServer(Server server) {
        return true;
    }

    public boolean removeParty(Party party) {
        return true;
    }

    public boolean removeFromWaitList(Party party){
        return true;
    }





}

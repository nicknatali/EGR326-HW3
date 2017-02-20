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
    private ArrayList<Table> tablesList = new ArrayList<Table>();
    private ArrayList<Server> serversList = new ArrayList<Server>();
    private ArrayList<Party> waitlist = new ArrayList<Party>();
    private String restaurantName;
    private double cashRegister;

    /**
     * @param restaurantName: The name of the restaurant
     */
    public Restaurant( String restaurantName, ArrayList<Server> serversList, ArrayList<Table> tablesList){
        if(restaurantName == "" || serversList == null || tablesList == null)
            throw new IllegalArgumentException();
        this.restaurantName = restaurantName;
        this.serversList = serversList;
        this.tablesList = tablesList;
        this.waitlist = new ArrayList<>();
    }

    /**
     * Setter methods
     */


    /**
     * Set the restaurant's name
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Set list of servers
     */
    public void setServersList(ArrayList<Server> serversList) {
        this.serversList = serversList;
    }

    /**
     * Get list of servers
     */
    public ArrayList<Server> getServersList() {
        return serversList;
    }

    /**
     * Getter methods
     */

    /**
     * Get the restaurant's name
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Displays the total amount of cash in the register
     */
    public double getCashRegister() {
        return cashRegister;
    }

    /**
     * Gets the tables
     * @return
     */
    public ArrayList<Table> getTables() { return tablesList; }


    /**
     * Adder methods
     */


    /**
     * Add a server to the server array list
     * @param server
     * @return
     */
    public boolean addServer(Server server){
        return serversList.add(server);
    }

    /**
     * Add a table to the table array list
     * @param table
     * @return
     */
    public boolean addTable(Table table){
        return tablesList.add(table);
    }

    /**
     * Add a party to the waitlist array list
     * @param party
     */
    public void addToWaitingList(Party party){
            waitlist.add(party);
    }

    /**
     * Add cash to the cash register
     * @param total
     */
    public void addToCashRegister(double total){
        cashRegister += total;
    }


    /**
     * Remover methods
     */

    //Remove table from list
    public boolean removeTable(Table table) {
     return tablesList.remove(table);
    }

    //Remove server from list
    public boolean removeServer(Server server) {
      return serversList.remove(server);
    }

    //Remove from waiting list
    public boolean removeFromWaitList(Party party){
        return waitlist.remove(party);
    }

    /**
     * Get waiting list
     * @return
     */
    public ArrayList<Party> getWaitingList() { return waitlist; }


}

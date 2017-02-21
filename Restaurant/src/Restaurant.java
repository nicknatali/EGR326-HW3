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
    private double cashRegister = 0.0;

    /**
     * Constructor
     * @param restaurantName: The name of the restaurant
     */
    public Restaurant(String restaurantName){
        if(restaurantName == "")
            throw new IllegalArgumentException();
        this.restaurantName = restaurantName;
    }

    //******** Setter methods *******

    /**
     * Function to set the list of tables
     * @param tablesList an array list of tables
     */
    public void setTables(ArrayList<Table> tablesList){ this.tablesList = tablesList; }


    /**
     * Function to set a party at the best possible table.
     * It will pick the table with the closest amount of
     * seats to the party
     *
     * @param party the party that is to be removed
     * @return void
     */
    public void setPartyAtTable(Party party){
        int partySize = party.getPartySize();
        //Pick the table with the closest amount of seats to the party
        Integer currentClosest = Integer.MAX_VALUE;
        Integer currentClosestTableIndex = null;
        //Loop through to get table sizes and compare them
        for(int i = 0; i < this.getTables().size(); i++) {
            if(tablesList.get(i).isOccupied()) {
                //Get difference between party size and largest table
                int diffBetweenPartyAndTable = tablesList.get(i).getTableSize() - partySize;
                //If the difference is 0, seat the party at that table
                if (diffBetweenPartyAndTable == 0) {
                    currentClosestTableIndex = i;
                    break;
                } else if (diffBetweenPartyAndTable > 0 && diffBetweenPartyAndTable < currentClosest) {
                    currentClosest = diffBetweenPartyAndTable;
                    currentClosestTableIndex = i;
                }
            }
        }
        //Find table with the closest amount of seats to party size
        if(currentClosestTableIndex != null && getServerAvailability()) {
            //Place server at the table with the closest table size
            tablesList.get(currentClosestTableIndex).setPartySeated(party);
            System.out.println("Party " + party.getPartyName() + " is seated at table " +
                    tablesList.get(currentClosestTableIndex).getTableId() + ".");
        } else if(!getServerAvailability()){
            System.out.println("There is not a server available to seat this party.");
        } else{
            System.out.println("Party was unable to be seated at this time.");
            return;
        }
        //Add a server to that table
        for(Server server : serversList){
            if(server.isServerOnDuty() && server.getServersTable().size() < 2) {
                tablesList.get(currentClosestTableIndex).setServer(server);
                break;
            }
        }
    }


    //*******Getter methods**********

    /**
     * Get list of servers
     */
    public ArrayList<Server> getServersList() {
        return serversList;
    }


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
     * Get waiting list
     * @return
     */
    public ArrayList<Party> getWaitingList() { return waitlist; }

    /**
     * Function to get the number of vacant tables in the restaurant
     *
     * @return the number of vacant tables
     */
    public int getVacantTables(){
        int vacantTableCount = 0;
        //Get total amount of servers on duty
        for(Table each: tablesList){
            if(each.isOccupied())
                vacantTableCount++;
        }
        return vacantTableCount;
    }

    /**
     * Function to get the number of servers available
     *
     * @return the number of servers who have less than 2 tables and are on duty
     */
    public boolean getServerAvailability(){
        //Check if there is a server available
        boolean isServerAvaiable = false;
        for(Server server: serversList){
            isServerAvaiable |= (server.isServerOnDuty() && server.getServersTable().size() < 2);
        }
        return isServerAvaiable;
    }

    /**
     * Function to the how many servers are currently on
     * duty at a given time
     *
     * @return the number of servers on duty
     */
    public int getServersOnDuty(){
        int serversOnDutyCount = 0;
        //Get total amount of servers on duty
        for(Server each: serversList){
            if(each.isServerOnDuty())
                serversOnDutyCount++;
        }
        return serversOnDutyCount;
    }

    /**
     * Function to get the largest table in the restaurant
     *
     * @return the number of seats of the largest table
     */
    public int getLargestTableSize(){
        int largestTable = 0;
        for (Table each : tablesList){
            if (each.getTableSize() > largestTable)
                largestTable = each.getTableSize();
        }
        return largestTable;
    }

    /**
     * Function to get the largest table the is not occupied
     *
     * @return the number of seats of the largest table not occupied
     */
    public int getLargestTableAvailable(){
        int largestTableAvailable = 0;
        for (Table each : tablesList){
            if(each.getTableSize() > largestTableAvailable && each.isOccupied())
                largestTableAvailable = each.getTableSize();
        }
        return largestTableAvailable;
    }

     // ******* Adder methods ***********

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



    //********* Remover Methods *********

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

}

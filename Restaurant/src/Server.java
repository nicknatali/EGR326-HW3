import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by NickNatali on 2/9/17.
 */
public class Server implements Comparable<Server>{

    /**
     * Variables
     */
    private ArrayList<Table> tableList;
    private boolean serverIsOnDuty;
    public static int serverIndex = 0;
    private int serverId;
    public double tips = 0.0;

    /**
     * Constructor
     * @param serverId how to identify the servers and know amount
     * @param serverIsOnDuty whether the server is on duty
     */
    public Server(int serverId, boolean serverIsOnDuty){
        if(serverId < 0)
            throw new IllegalArgumentException();
        this.serverId = serverId;
        this.serverIsOnDuty = serverIsOnDuty;
        this.tableList = new ArrayList<>();
    }

    //***** Setter methods ****

    /**
     * Set the serverList's Id to be recognized by.
     * @param serverId sets the servers id
     */
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    /*
     * the Table being served by a specific serverList
     * @param tableList sets the servers tables they are serving
     */
    public void setServersTable(ArrayList<Table> tableList) {
        this.tableList = tableList;
    }

    /**
     * Checks whether the server is on duty or not
     * @param onDuty returns true if server is on duty
     */
    public void setServerIsOnDuty(boolean onDuty) {
        serverIsOnDuty = onDuty;
    }

    /**
     * Set the tips of the server
     * @param tips sets the servers tables they are serving
     */
    public void setTips(double tips) {
        this.tips = tips;
    }

    /**
     * Gets and returns the serverList's id that correlates to its index in the array.
     * @return the serverList's id
     */
    public int getServerId() {
        return serverId;
    }

    /**
     * Set the serverList's Id to be recognized by.
     *
     * @return list of tables the server is serving
     */
    public ArrayList<Table> getServersTable() {
        return tableList;
    }


    /**
     * Add to server's list of tables to serve
     * @param table the table added to ther server's tables
     */
   public boolean addToServersTables(Table table) {
        return tableList.add(table);
   }

    /**
     * Remove a server's table
     * @return boolean as to whether the table was removed
     */
    public boolean removeFromServersTables(Table table){ return tableList.remove(table); }


    /**
     * See if the server is on duty
     * @return whether the server is on duty.
     */
    public boolean isServerOnDuty() {

        return serverIsOnDuty;
    }

    /**
     * Add valulue to the tip
     * @param value the amount of tips they are given.
     */
    public void addToTip(double value) {
        this.tips += value;
    }


    /**
     * Returns the tip
     * @ return double sets the servers number
     */
    public double getTips() {
        return tips;
    }

    /**
     * Create a string version of the server object
     * @return the string representation of the server object
     */
    @Override
    public String toString() {
        String returnString = "[Server #" + serverId + " On Duty: " + serverIsOnDuty + "  Tips: " + tips;
        for(Table each : tableList)
            returnString += each.getTableId() + " ";
        return returnString + "]";
    }

    /**
     * Function to compare two server objects
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == this.getClass()) {
            Server other = (Server) obj;
            return this.serverId == other.serverId;
        }
        return false;
    }

    /**
     * Function to create a hashcode of the server object
     * @return the new hashcode
     */
    @Override
    public int hashCode() {
        return 31 * serverId;
    }

    /**
     * Function to clone this server object
     * @return a clone of the server
     */
    @Override
    public Server clone() throws CloneNotSupportedException {
        Server clone = new Server(serverId, isServerOnDuty());
        clone.setServersTable((ArrayList<Table>) tableList.clone());
        clone.setTips(tips);
        return clone;
    }

    /**
     * Function to compare two server objects
     * @return which server id number is greater
     */
    @Override
    public int compareTo(Server o) {
        return this.serverId - o.serverId;
    }

}

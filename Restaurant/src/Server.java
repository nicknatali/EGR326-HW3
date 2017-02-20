import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by NickNatali on 2/9/17.
 */
public class Server {

    /**
     * Variables
     */
    private ArrayList<Table> tableList;
    private boolean serverIsOnDuty;
    public static int serverIndex = 0;
    private int serverId;
    private double tips;

    /**
     * Constructor
     */
    public Server(int serverId, boolean serverIsOnDuty){
        if(serverId < 0)
            throw new IllegalArgumentException();
        this.serverId = serverId;
        this.serverIsOnDuty = serverIsOnDuty;
        this.tableList = new ArrayList<>();
    }


    /**
     * Set the serverList's Id to be recognized by.
     * @param serverId
     */
    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    /*
     * the Table being served by a specific serverList
     */
    public void setServersTable(ArrayList<Table> tableList) {
        this.tableList = tableList;
    }

    public void setServerIsOnDuty(boolean onDuty) {
        serverIsOnDuty = onDuty;
    }

    /**
     * Gets and returns the serverList's id that correlates to its index in the array.
     * @return the serverList's id
     */
    public int getServerId() {
        return serverId;
    }


    public ArrayList<Table> getServersTable() {
        return tableList;
    }


    /**
     * Add to server's list of tables to serve
     * @param table
     */
   public void addToServersTables(Table table) {
        tableList.add(table);
   }

    /**
     * Remove a server's table
     */
    public boolean removeFromServersTables(Table table){ return tableList.remove(table); }


    /**
     * See if the server is on duty
     */
    public boolean isServerOnDuty() {

        return serverIsOnDuty;
    }

    /**
     * Add value to tip
     */
    public void addToTip(double value) {
        this.tips += value;
    }


    /**
     * Returns the tip
     */
    public double getTips() {
        return tips;
    }

    /**
     * @return the string representation of the serverList's id
     */
    @Override
    public String toString() {
        String returnString = "[Server #" + serverId + " On Duty: " + serverIsOnDuty + "  Tips: " + tips;
        for(Table each : tableList)
            returnString += each.getTableId() + " ";
        return returnString + "]";
    }


}

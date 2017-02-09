import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by NickNatali on 2/9/17.
 */
public class Server {

    /**
     * Variables
     */
    private Queue<Integer> serverList;
    private ArrayList<Table> tableList;
    private Queue<Double> tipList;
    private boolean serverIsOnDuty;
    private int serverId;

    /**
     * Constructor
     */
    public Server(int serverId, boolean serverIsOnDuty){
        this.serverId = serverId;
        this.serverIsOnDuty = serverIsOnDuty;
        this.tableList = new ArrayList<>();
    }


    /**
     * See if the server is on duty
     */
    public boolean isServerIsOnDuty() {
        return serverIsOnDuty;
    }

    /**
     * Gets and returns the serverList's id that correlates to its index in the array.
     * @return the serverList's id
     */
    public int getServerId() {
        return serverId;
    }


    public ArrayList<Table> getTableList() {
        return tableList;
    }

    /*
     * the Table being served by a specific serverList
     */
    public void setServersTable(ArrayList<Table> tableList) {
        this.tableList = tableList;
    }

    /**
     * Add to server's list of tables to serve
     * @param table
     */
   public void addToServersTables(Table table) {
        tableList.add(table);
   }

    /**
     * Set the serverList's Id to be recognized by.
     * @param serverId
     */
    public void setServerId(int serverId) {
            this.serverId = serverId;
    }

    /**
     * @return the string representation of the serverList's id
     */
    public String toString() {
        return "";
    }




}

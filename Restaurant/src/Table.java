import java.util.Queue;

/**
 * Created by NickNatali on 2/7/17.
 * A table at which parties of customers may sit to eat.
 */
public class Table {

    /**
     * Variables
     */
    private int tableId;
    private int tableSize;
    private Server server;
    private Party seatedParty;
    public static int tableIndex = 0;

    /**
     * Constructor
     * @param tableId
     * @param tableSize
     */
    public Table(int tableId, int tableSize) {
            this.tableId = tableId;
            this.tableSize = tableSize;
    }

    /**
     * Checks to see whether the table is Occupied or not.
     * @returns true if the table is occupied, false if not
     */
    public boolean isOccupied() {
        return seatedParty == null;
    }

    /**
     * Returns the tableId
     * @return
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * Returns the size of the table
     * @return
     */
    public int getTableSize() { return tableSize; }

    /**
     * Returns the server
     * @return
     */
    public Server getServer() {
        return server;
    }

    /**
     * Returns the party that was seated
     * @return
     */
    public Party getPartySeated() {
        return seatedParty;
    }

    /**
     * Set the tableId
     * @param tableId: Identification number for the table
     */
    public void setTableId(int tableId) {
            this.tableId = tableId;
    }

    /**
     * Set the table Size
     * @param tableSize: size of the table.
     * @return
     */
    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    /**
     * Set the server
     * @param server
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * Seats the party.
     * @param seatedParty
     */
    public void setPartySeated(Party seatedParty) {
        this.seatedParty = seatedParty;
    }

    /**
     * Reset the table
     */
    public void resetTable(){
        this.seatedParty = null;
        this.server = null;
    }
    /**
     * Converts table name's number into a strong.
     * @return a string representation of tableName including it's number.
     */
    @Override
    public String toString() {
        return "Table " + tableId + " : seats=" + tableSize + " vacant=" + isOccupied() + " server=" + server;
    }

}

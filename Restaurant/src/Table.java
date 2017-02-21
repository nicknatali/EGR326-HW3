import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        if(tableId < 0 || tableSize < 0)
            throw new IllegalArgumentException();
        this.tableId = tableId;
        this.tableSize = tableSize;
        this.seatedParty = null;
        this.server = null;
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
     * @return an integer representing the tables id
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
     * @return the server
     */
    public Server getServer() {
        return server;
    }

    /**
     * Returns the party that was seated
     * @return the party that was seated
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
     * @param server the server for a given table
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * Seats the party.
     * @param seatedParty the party to be seated
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
     * Function to get the list of tables from the text file
     * @param fileName the name of the text file
     * @return an array list of tables
     */
    public static ArrayList<Table> producer(String fileName) throws java.io.IOException{
        ArrayList<Table> tables = new ArrayList<>();
        for (String line : Files.readAllLines(Paths.get(fileName)))
            tables.add(new Table(++Table.tableIndex, Integer.parseInt(line)));
        return tables;
    }


    /**
     * Converts table name's number into a strong.
     * @return a string representation of tableName including it's number.
     */
    @Override
    public String toString() {
        return "Table " + tableId + " : seats=" + tableSize + " vacant=" + isOccupied() + " server=" + server + (seatedParty == null ? "null":seatedParty.getPartyName());
    }

}

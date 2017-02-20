import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by NickNatali on 2/19/17.
 */
public class TableTest {

    @Test
    public void constructorTest(){

        //Arrange
        int tableSize = 1;
        int tableId = 1;

        //Act
        Table table = new Table(tableId, tableSize);

        //Assert
        Assert.assertEquals("Incorrect tableId", tableId, table.getTableId());
        Assert.assertEquals("Incorrect tableSize", tableSize,table.getTableSize());

        //Assert Not
        Assert.assertNotEquals("Correct table Id!", 1, table.getTableId());
        Assert.assertEquals("Correct table Size", 1, table.getTableSize());

    }

    @Test
    public void isOccupiedTest() {
        //Arrange
        int tableSize = 1;
        int tableId = 1;

        //Act
        Table table = new Table(tableId, tableSize);
        Party party = new Party(1, "Nick");
        table.setPartySeated(party);
        boolean check = table.isOccupied();

        //Assert
        Assert.assertEquals("The expected expression is true", true, check);
        Assert.assertNotEquals("The expected expression is true", false, check);
    }

    @Test
    public void getterTest() {
        //Arrange
        int tableSize = 1;
        int tableId = 1;
        int serverId = 1;
        boolean onDuty = true;
        int partySize = 2;
        String partyName = "James";
        Table table = new Table(tableId, tableSize);
        Server server = new Server(serverId, onDuty);
        Party party = new Party(partySize, partyName);

        //Act
        int getTableId = table.getTableId();
        int getTableSize = table.getTableSize();

        //Assert
        Assert.assertEquals("Incorrect Table Id!", tableId, getTableId);
        Assert.assertEquals("Incorrect Table Size", tableSize, getTableSize);
        Assert.assertEquals("Incorrect server value", server, table.getServer());
        Assert.assertEquals("Incorrect party", party, table.getPartySeated());

        //!Assert
        Assert.assertNotEquals("Correct Table Id!", tableId, getTableId);
        Assert.assertNotEquals("Correct Table size", tableSize, getTableSize);
        Assert.assertNotEquals("Correct server value", server, table.getServer());
        Assert.assertNotEquals("Correct Party seated", party, table.getPartySeated());
    }

    @Test
    public void resetTableTest() {

        //Arrange
        int serverId = 1;
        boolean isOnDuty = true;

        //Act
        Server server = new Server(serverId, isOnDuty);
        Table table = new Table(1, 3);
        Party party = new Party(1, "Savage");

        table.setServer(server);
        table.setPartySeated(party);

        //Assert
        Assert.assertEquals("Incorrect party value", party, table.getPartySeated());
        table.setPartySeated(null);
        Assert.assertNotEquals("Correct party value", null, table.getPartySeated());
        Assert.assertEquals("Incorrect server value", server, table.getServer());
        table.setServer(null);
        Assert.assertNotEquals("Correct server value", null, table.getServer());
    }





}

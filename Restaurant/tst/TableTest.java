import org.junit.Assert;
import org.junit.Test;

public class TableTest {

    //Test constructor
    @Test
    public void constructorTest(){

        //Arrange
        int tableSize = 1;
        int tableId = 1;

        //Act
        Table table = new Table(tableId, tableSize);

        //Assert
        Assert.assertEquals("Incorrect tableId", tableId, table.getTableSize());
        Assert.assertEquals("Incorrect tableSize", tableSize,table.getTableSize());

        table.setTableSize(tableId+1);
        //Assert Not
        Assert.assertNotEquals("Correct table Id!", 1, table.getTableId());
        Assert.assertNotEquals("Correct table Size", 5, table.getTableSize());

    }

    //Test is occupied method
    @Test
    public void isOccupiedTest() {
        //Arrange
        int tableSize = 1;
        int tableId = 1;

        //Act
        Table table = new Table(tableId, tableSize);
        Party party = new Party(1, "Nick");
        boolean check = table.isOccupied();

        //Assert
        Assert.assertEquals("The expected expression is true", true, check);

        table.setPartySeated(party);

        //Assert Not
        Assert.assertNotEquals("The expected expression is true", false, check);
    }

    //Test getter methods
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
        table.setServer(server);
        table.setPartySeated(party);

        //Assert
        Assert.assertEquals("Incorrect Table Id!", tableId, table.getTableId());
        Assert.assertEquals("Incorrect Table Size", tableSize, table.getTableSize());
        Assert.assertEquals("Incorrect server value", server, table.getServer());
        Assert.assertEquals("Incorrect party", party, table.getPartySeated());

        table.setTableId(5);
        table.setServer(new Server(2, true));
        table.setPartySeated(new Party(4, "jake"));

        //!Assert
        Assert.assertNotEquals("Correct Table Id!", tableId, table.getTableId());
        Assert.assertNotEquals("Correct server value", server, table.getServer());
        Assert.assertNotEquals("Correct Party seated", party, table.getPartySeated());
    }

    //Test reset method
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
        Assert.assertEquals("Incorrect server value", server, table.getServer());
        table.resetTable();
        Assert.assertEquals("Correct party value", null, table.getPartySeated());
        Assert.assertEquals("Correct server value", null, table.getServer());
    }
}

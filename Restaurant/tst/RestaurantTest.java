import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class RestaurantTest {


    //Test the constructor
    @Test
    public void constructorAndGetterTest(){
        //Arrange
        String restaurantName = "Pablo's";

        //Act
        Restaurant restaurant = new Restaurant(restaurantName);

        //Arrange
        Assert.assertEquals("Incorrect restaurant Name", restaurantName, restaurant.getRestaurantName());
        Assert.assertNotEquals("Correct restaurant Name", "Joe's", restaurant.getRestaurantName());
    }

    //Test the set party at table method
    @Test
    public void setPartyAtTableTest() {
        //Arrange
        String restaurantName = "Pablo's";
        int partySize = 2;
        String partyName = "Jed";

        //Act
        Restaurant restaurant = new Restaurant(restaurantName);
        Table table = new Table(1, 3);
        restaurant.addTable(table);
        restaurant.addServer(new Server(2, true));
        Party party = new Party(partySize, partyName);
        restaurant.setPartyAtTable(party);

        //Assert
        Assert.assertEquals("Incorrect party seated", party, table.getPartySeated());

        //!Assert
        Assert.assertNotEquals("Correct party seated", "Jeff", table.getPartySeated());
    }

    //Test getters
    @Test
    public void gettersTest() {
        //Arrange
        String restaurantName = "Pablo's";
        ArrayList<Table> tablesList = new ArrayList<Table>();
        ArrayList<Party> waitlist = new ArrayList<Party>();
        ArrayList<Server> serverList = new ArrayList<Server>();

        //Act
        Restaurant restaurant = new Restaurant(restaurantName);
        Server server = new Server(1, true);
        Table table = new Table(1,2);
        Party party = new Party(1, "James");

        restaurant.addServer(server);
        restaurant.addTable(table);
        restaurant.addToWaitingList(party);
        restaurant.addToCashRegister(50);

        serverList.add(server);
        waitlist.add(party);
        tablesList.add(table);

        //Assert
        Assert.assertEquals("Incorrect servers list", serverList, restaurant.getServersList());

        Assert.assertEquals("Incorrect restaurant name", restaurantName, restaurant.getRestaurantName());
        Assert.assertNotEquals("Correct restaurant name", "Jeff", restaurant.getRestaurantName());

        Assert.assertEquals("Correct cash amount", 50.0, restaurant.getCashRegister(), 0.0);

        Assert.assertEquals("Incorrect table in list", tablesList, restaurant.getTables());

        Assert.assertEquals("Incorrect waiting list", waitlist, restaurant.getWaitingList());

        Assert.assertEquals("Incorrect vacant table amount", 1, restaurant.getVacantTables());

        Assert.assertEquals("Incorrect server on duty count", 1, restaurant.getServersOnDuty());

        Assert.assertEquals("Incorrect largest Table available", 2, restaurant.getLargestTableAvailable());
    }


    //Test adder methods
    @Test
    public void testAdderMethods() {
        //Arrange
        String restaurantName = "Pablo's";
        double cashRegister = 0.0;

        //Act
        Restaurant restaurant = new Restaurant(restaurantName);
        Server server = new Server(1, true);
        Table table = new Table(1,2);
        Party party = new Party(1, "James");
        restaurant.addServer(server);
        restaurant.addServer(new Server(4,true));
        restaurant.addTable(table);
        restaurant.addTable(new Table(5,3));
        restaurant.addToCashRegister(cashRegister);
        restaurant.addToWaitingList(party);
        restaurant.addToWaitingList(new Party(4, "keldo"));

        //Assert
        Assert.assertEquals("Incorrect server", server, restaurant.getServersList().get(0));
        Assert.assertNotEquals("Correct server", server, restaurant.getServersList().get(1));

        Assert.assertEquals("Incorrect table", table, restaurant.getTables().get(0));
        Assert.assertNotEquals("Correct table", table, restaurant.getTables().get(1));

        Assert.assertEquals("Incorrect party on waiting list", party , restaurant.getWaitingList().get(0));
        Assert.assertNotEquals("Correct party on waiting list", server, restaurant.getWaitingList().get(0));

        Assert.assertEquals("Correct cash register amount", cashRegister, restaurant.getCashRegister(), 0.0);
    }

    //Test remove methods
    @Test
    public void testRemoveMethods() {
        //Arrange
        String restaurantName = "Pablo's";

        //Act
        Restaurant restaurant = new Restaurant(restaurantName);
        Server server = new Server(1, true);
        Table table = new Table(1,2);
        Party party = new Party(1, "James");
        restaurant.addTable(table);
        restaurant.addServer(server);
        restaurant.addToWaitingList(party);

        //Assert
        Assert.assertEquals("Correct removal of table", true, restaurant.removeTable(table));
        Assert.assertEquals("Incorrect removal of table", false, restaurant.removeTable(table));

        Assert.assertEquals("Correct removal of server", true, restaurant.removeServer(server));
        Assert.assertEquals("Incorrect removal of server", false, restaurant.removeServer(server));

        Assert.assertEquals("Correct removal from waitlist", true, restaurant.removeFromWaitList(party));
        Assert.assertEquals("Incorrect removal from waitlist", false, restaurant.removeFromWaitList(party));

    }
}

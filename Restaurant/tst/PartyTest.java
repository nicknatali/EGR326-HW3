import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class PartyTest {

    //Test the constructor and getter methods
    @Test
    public void constructorAndGetterTest() {
        //Arrange
        int partySize = 1;
        String partyName = "James";

        //Act
        Party party = new Party(partySize, partyName);
        party.setPartyName(partyName);
        party.setPartySize(partySize);

        //Assert
        Assert.assertEquals("Incorrect party size.", partySize, party.getPartySize());
        Assert.assertEquals("Incorrect party name", partyName, party.getPartySize());

        //!Assert
        Assert.assertNotEquals("Incorrect Party size!", 2, party.getPartySize());
        Assert.assertNotEquals("Incorrect party name", "Jeff", party.getPartyName());
        party.setPartyName(null);
        Assert.assertNull("Incorrect party", party.getPartyName());
    }

    //Test setter methods
    @Test
    public void setterTest() {
        //Arrange
        int partySize = 1;
        String partyName = "James";

        //Act
        Party party = new Party(partySize, partyName);
        party.setPartyName("John");
        party.setPartySize(3);

        //Assert
        Assert.assertEquals("Incorrect party size.", 3, party.getPartySize());
        Assert.assertEquals("Incorrect party name", "John", party.getPartyName());

        //!Assert
        Assert.assertNotEquals("Incorrect Party size!", 2, party.getPartySize());
        Assert.assertNotEquals("Incorrect party name", partyName, party.getPartyName());
        party.setPartyName(null);
        Assert.assertNull("Incorrect party", party.getPartyName());
    }

    //Test party has unique name method
    @Test
    public void partyHasUniqueNameTest() {
        //Arrange
        int partySize = 1;
        String partyName = "James";
        int tableId = 2;
        int tableSize = 3;
        ArrayList<Table> tablesList = new ArrayList<Table>();
        ArrayList<Party> waitlist = new ArrayList<Party>();
        boolean hasUniqueName = true;

        //Act
        Party party = new Party(partySize, partyName);
        Table table = new Table(tableId, tableSize);
        boolean value = Party.partyHasUniqueName(waitlist, tablesList, partyName);

        //Assert
        Assert.assertEquals("Does have unique name", hasUniqueName, value);
        Assert.assertNotEquals("Does not have unique name", !hasUniqueName, value);
    }

    //Test equals and hashcode test
    @Test
    public void equalsAndHashCodeTest() {
        //Arrange
        int partySize = 1;
        String partyName = "James";
        boolean isEqual = true;

        //Act
        Party party = new Party(partySize, partyName);
        Party party2 = new Party(1, "James");

        //Assert
        Assert.assertEquals("The two objects are equal", isEqual, party.equals(party2));
        Assert.assertEquals("The two objects are equal", isEqual, party2.equals(party));
        Assert.assertTrue(party.hashCode() == party2.hashCode());
        Assert.assertTrue(party.equals(party2) && party2.equals(party));

        //!Assert
        Assert.assertNotEquals("The two objects are not equal", !isEqual, party.equals(party2));
        Assert.assertNotEquals("The two objects are not equal", !isEqual, party2.equals(party));
    }

    //Test clone method
    @Test
    public void cloneTest() throws CloneNotSupportedException  {
        //Arrange
        int partySize = 1;
        String partyName = "James";
        boolean isEqual = true;

        //Act
        Party party = new Party(partySize, partyName);
        Party party2 = party.clone();

        //Assert
        Assert.assertEquals(party, party2);
        Assert.assertNotSame(party, party2);
    }

    //Test the compare to method
    @Test
    public void compareToTest() {
        //Arrange
        int partySize = 1;
        String partyName = "James";
        boolean isEqual = true;

        //Act
        Party party = new Party(partySize, partyName);
        Party party2 = new Party(2,"Nick");

        //Assert
        Assert.assertEquals("Party is bigger but returned otherwise", -1, party.compareTo(party2));

        //!Assert
        Assert.assertNotEquals("Objects are comparable", 1, party.compareTo(party2));
    }

}
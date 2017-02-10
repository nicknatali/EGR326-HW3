import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by NickNatali on 2/9/17.
 * Testing the server class
 */
public class ServerTest {


        @Test
        public void constructorAndGetterTest(){
            //Arrange
            int serverNum = 1;
            boolean isOnDuty = true;
            //Act
            Server server = new Server(serverNum, isOnDuty);
            Table table = new Table(1, 3);
            server.addToServersTables(table);
            //Assert
            Assert.assertEquals("Incorrect Server Id!", serverNum, server.getServerId());
            Assert.assertEquals("Incorrect On Duty Value!", isOnDuty, server.isServerOnDuty());
            Assert.assertEquals("Incorrect Table!", table, server.getServersTable().get(0));
            //!Assert
            Assert.assertNotEquals("Incorrect Server Id!", 23, server.getServerId());
            Assert.assertNotEquals("Incorrect is On Duty Value!", !isOnDuty, server.isServerOnDuty());
            server.removeServer(table);
            server.addToServersTables(null);
            Assert.assertNull("Incorrect Table!", server.getServersTable().get(0));
        }

        @Test
        public void setterTest(){
            //Arrange
            int serverNum = 1;
            boolean isOnDuty = true;
            Server server = new Server(serverNum, isOnDuty);
            Table table = new Table(1, 3);
            server.addToServersTables(table);
            //Act
            server.isServerOnDuty(false);
            server.isServerOnDuty(3);


            //Assert
            Assert.assertEquals("Incorrect Server Id!", 3, server.getServerId());
            Assert.assertEquals("Incorrect On Duty Value!", false, server.isServerOnDuty());
            //!Assert
            Assert.assertNotEquals("Incorrect Server Id!", 23, server.getServerId());
            Assert.assertNotEquals("Incorrect On Duty Value!", isOnDuty, server.isServerOnDuty());
        }

    }




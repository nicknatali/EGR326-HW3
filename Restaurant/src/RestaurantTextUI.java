// Restaurant Homework 
// Instructor-provided code.
// You SHOULD heavily modify this file to make it interface with your own classes.

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
// import java.util.*;

/**
 * This class represents the text user interface (UI) for the restaurant
 * program, allowing the user to view and manage the restaurant and its objects.
 * @author Your name
 * @version Put version
 */
public class RestaurantTextUI {
	// file name from which to read the restaurant data
	// file name from which to read the restaurant data
	private static final String DEFAULT_TABLES_FILENAME = "./tables.txt";
	private static final String DEFAULT_SERVERS_FILENAME = "./servers.txt";
	private Restaurant restaurant = new Restaurant("Taco Bell");

	/**
	 * Constructs a new text user interface for managing a restaurant.
	 */
	public RestaurantTextUI() {
		System.out.println("Restaurant Simulator");
	}

	/**
	 * Reads the information about the restaurant from the default restaurant
	 * file.
	 *
	 * @return true if the data was read successfully; false if there were any errors
	 */
	public boolean readRestaurantData() {
		//Try to read through the file
		try {
			for (String line : Files.readAllLines(Paths.get(DEFAULT_TABLES_FILENAME)))
				restaurant.addTable(new Table(++Table.tableIndex, Integer.parseInt(line)));

			for (String line : Files.readAllLines(Paths.get(DEFAULT_SERVERS_FILENAME)))
				restaurant.addServer(new Server(++Server.serverIndex, Boolean.parseBoolean(line)));

			return true;
			//Catch it if unable to read the data in the file.
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * Displays the main menu of choices and prompts the user to enter a choice.
	 * Once a valid choice is made, initiates other code to handle that choice.
	 */
	public void mainMenu() {
		// main menu
		displayOptions();
		while (true) {
			String choice = ValidInputReader.getValidString(
					"Main menu, enter your choice:",
					"^[sSaAdDrRpPtTcCwWqQ!?]$").toUpperCase();
			if (choice.equals("S")) {
				serversOnDuty();
			} else if (choice.equals("A")) {
				addServer();
			} else if (choice.equals("D")) {
				dismissServer();
			} else if (choice.equals("R")) {
				cashRegister();
			} else if (choice.equals("P")) {
				partyToBeSeated();
			} else if (choice.equals("T")) {
				tableStatus();
			} else if (choice.equals("C")) {
				checkPlease();
			} else if (choice.equals("W")) {
				waitingList();
			} else if (choice.equals("Q")) {
				break;
			} else if (choice.equals("?")) {
				displayOptions();
			} else if (choice.equals("!")) {
				rickRoll();
			}
			System.out.println();
		}
	}

	// Displays the list of key commands the user can use.
	private void displayOptions() {
		System.out.println();
		System.out.println("Main System Menu");
		System.out.println("----------------");
		System.out.println("S)ervers on duty");
		System.out.println("A)dd server");
		System.out.println("D)ismiss server");
		System.out.println("R)egister");
		System.out.println("P)arty has arrived");
		System.out.println("T)ables status");
		System.out.println("C)heck, please");
		System.out.println("W)aiting list");
		System.out.println("?) display this menu of choices again");
		System.out.println("Q)uit");
	}

	// Called when S key is pressed from main menu.
	// Displays all servers who are currently working.
	private void serversOnDuty() {
		System.out.println("Servers currently on duty:");
		//Loop through servers
		for (Server server : restaurant.getServersList()) {
			if (server.isServerOnDuty()) {
				System.out.println(server.toString() + "( $" + server.getTips() + " in total tips)");
			}
		}
	}

	// Called when A key is pressed from main menu.
	// Adds one more server to the system.
	private void addServer() {
		System.out.println("Adding a new server to our workforce:");

		//display current count of servers
		restaurant.addServer(new Server(++Server.serverIndex, true));
		serversOnDuty();
	}

	// Called when D key is pressed from main menu.
	// Sends one server home for the night (if possible).
	private void dismissServer() {

		//When there are no servers in the servers list
		if (restaurant.getServersList().size() == 0 || restaurant.getServersList() == null) {
			System.out.println("There aren't any servers to dismiss!");
		}

		int serversOnDutyCount = 0;
		//Gather the total amount of servers on duty.
		for (Server server : restaurant.getServersList()) {
			if (server.isServerOnDuty())
				serversOnDutyCount++;
		}

		//If there is only one server left on duty.
		if (serversOnDutyCount == 1) {
			System.out.println("There is only 1 server left, none can cash out!");
		}

		//Cash out a server
		for (Server server : restaurant.getServersList()) {
			if (server.isServerOnDuty() && server.getServersTable().size() == 0) {
				server.setServerIsOnDuty(false);
				// when the server is able to be dismissed,
				System.out.println("Dismissing server #" + server.getServerId()+" with $" + server.getTips() + " in tips.");

				return;
			}

		}
		//If there is only one server with tables remaining
		System.out.println("Sorry, no servers can cash out now;");
	}


	// Called when R key is pressed from main menu.
	// Displays how much money is in the restaurant's cash register.
	private void cashRegister() {

		System.out.println("Money in the cash register: " + restaurant.getCashRegister());
	}

	// Called when T key is pressed from main menu.
	// Displays the current status of all tables.
	private void tableStatus() {
		System.out.println("Tables status:");

		//show restaurant's table statuses, e.g.:
		// Table 5 (2-top): Jones party of 2 - Server #2
		// Table 6 (4-top): empty

		System.out.println("-----------------------");
		System.out.println("         Tables        ");
		for (Table tables : restaurant.getTables()) {
			System.out.println(tables.toString());
		}
	}

	// Called when C key is pressed from main menu.
	// Helps process a party's check to leave the restaurant.
	private void checkPlease() {
		//Let the user input values
		System.out.println("Send the check to a party that has finished eating:");
		String partyName = ValidInputReader.getValidString("Party's name?", "^[a-zA-Z '-]+$");

		//Declare variables in order to store the selected Server & table
		Server serverSelected = null;
		Table tableSelected = null;

		//Loop through tables
		for (Table tables : restaurant.getTables()) {
			System.out.println(tables);

			//If the table is not occupied and the correct party is seated
			if (!tables.isOccupied() && tables.getPartySeated().getPartyName().equals(partyName)) {
				serverSelected = tables.getServer();
				tableSelected = tables;
				break;
			}
		}

		//If the table cannot be found
		if (tableSelected == null) {
			System.out.println("There is no party by that name :(");
			return;
		}


		// when such a party is sitting at a table in the restaurant,
		double subtotal = ValidInputReader.getValidDouble("Bill subtotal?", 0.0, 9999.99);
		double tip = ValidInputReader.getValidDouble("Tip?", 0.0, 9999.99);

		//Add cash to the cashregister
		restaurant.addToCashRegister(subtotal);
		//Give tip to server.
		serverSelected.addToTip(tip);


		//Remove table values
		tableSelected.resetTable();
		//Remove table from server
		serverSelected.removeFromServersTables(tableSelected);

		//Set party from waiting list and remove it from the waiting list
		int previousVacantTables = restaurant.getVacantTables();
		for(Party party : restaurant.getWaitingList()) {
			restaurant.setPartyAtTable(party);
			if(restaurant.getVacantTables() > previousVacantTables) {
				System.out.println(party.getPartyName() + " has been seated from the waiting list.");
				return;
			}
		}
	}

	// Called when W key is pressed from main menu.
	// Displays the current waiting list, if any.
	private void waitingList() {
		//Print Waiting List
		System.out.println("--------------------------------------------");
		System.out.println("              Waiting List                  ");
		System.out.println("--------------------------------------------");

		//Loop through waitingList and print the parties.
		for (Party party : restaurant.getWaitingList()) {
			System.out.println(party.toString());
		}
	}

	// Called when P key is pressed from main menu.
	// Helps seat a newly arriving party at a table in the restaurant.
	private void partyToBeSeated() {
		//When there are no servers,
		if (restaurant.getServersOnDuty() == 0) {
			System.out.println("Sorry, there are no servers here yet to seat this party");
			System.out.println("and take their orders.  Add servers and try again.");
			return;
		}
		//When there is at least one server,
		String partyName = ValidInputReader.getValidString("Party's name?", "^[a-zA-Z '-]+$");
		//Check to make sure name is unique
		while(!Party.partyHasUniqueName(restaurant.getWaitingList(), restaurant.getTables(), partyName)){
			// when a duplicate party name is found,
			System.out.println("We already have a party with that name in the restaurant.");
			System.out.println("Please try again with a unique party name.");
			partyName = ValidInputReader.getValidString("Party's name?", "^[a-zA-Z '-]+$");
		}
		//Get Party size
		int partySize = ValidInputReader.getValidInt("How many people in the party?", 1, 99999);
		//Create new party
		Party party = new Party(partySize, partyName);
		//Variable to store the largest table size and largest available
		int largestTable = restaurant.getLargestTableSize();
		int largestTableAvailable = restaurant.getLargestTableAvailable();
		//Decide what happens with the party
		if(partySize > largestTable) {
			//when the restaurant doesn't have any tables big enough to ever seat this party,
			System.out.println("Sorry, the restaurant is unable to seat a party of this size.");
			return;
		} else if (partySize > largestTableAvailable){
			// when all tables large enough to accommodate this party are taken,
			System.out.println("Sorry, there is no open table that can seat this party now.");
			boolean wait = ValidInputReader.getYesNo("Place this party onto the waiting list? (y/n)");
			if(wait)
				restaurant.addToWaitingList(party);
			return;
		} else{
			restaurant.setPartyAtTable(party);
		}
	}


	// You know what this method does. :/
	private void rickRoll() {
		// tell you how I'm feeling; make you understand
		System.out.println("We're no strangers to love");
		System.out.println("You know the rules and so do I");
		System.out.println("A full commitment's what I'm thinking of");
		System.out.println("You wouldn't get this from any other guy");
		System.out.println("I just wanna tell you how I'm feeling");
		System.out.println("Gotta make you understand");
		System.out.println();
		System.out.println("Never gonna give you up");
		System.out.println("Never gonna let you down");
		System.out.println("Never gonna run around and desert you");
		System.out.println("Never gonna make you cry");
		System.out.println("Never gonna say goodbye");
		System.out.println("Never gonna tell a lie and hurt you");
	}

	// This helper is just put into the text UI code to mark places where you
	// will need to add or modify this file.  Crashes with a runtime exception.
	private void crash(String message) {
		// Math.random() < 10 will always be true;  so why is it there?
		// I can't just throw because Eclipse will then warn about dead code
		// for any code that occurs after a call to crash().
		// So I wrap the exception throw in an "opaque predicate" to fool it.
		if (Math.random() < 10) {
			throw new RuntimeException("Not yet implemented: " + message);
		}
	}


}

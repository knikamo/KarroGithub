import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class World extends BuildWorld {
	ArrayList<Room> allRooms;
	Room currentRoom;
	int numberOfRooms;
	Avatar player;

	public World () {
		numberOfRooms = 0;
	}

	public Avatar getAvatar() {
		return this.player;
	}

	public int getNumberOfRooms() {
		return this.numberOfRooms;
	}

	public ArrayList<Room> getAllRooms() {
		return this.allRooms;
	}

	public void setNumberOfRooms(int n) {
		this.numberOfRooms = n;
	}

	public void setAllRooms(ArrayList<Room> rooms) {
		this.allRooms = rooms;
	}

	public void testWorld() {
		createWorld();
		
		Avatar a = new Avatar(this, "Whatever", "Karro");
		player = a;
		(allRooms.get(0)).addToRoom(a);
		printAllRooms();
		currentRoom = allRooms.get(0);
		runGame();
/*
	Creature s = new Student("hej hej", "Karro");
	ArrayList<Creature> creatures = new ArrayList<Creature>();
	creatures.add(s);
	items.add(i);

*/
	}

	public void createWorld() {
		createRooms(this);
		createKeys(this);
	}

	public void runGame() {
		Scanner reader = new Scanner(System.in);
		Boolean continueGame = true;
		
		while (continueGame) {
			System.out.println("What's next? (type 'help' for help)");
			String input = reader.nextLine();
			String[] splitInput = input.split(" ");
			switch (splitInput[0]) {
				case "help": printHelp(); break;
				case "inventory": System.out.println(player.backpackToString()); break;
				case "go":	go(splitInput[1]); break;	
				
				case "talk": System.out.println("talk woho"); break;
				case "exit": continueGame = false; break;
				default: 
					System.out.println("Unvalid input");
					printHelp(); 
					break;
			}
			reader.reset();
		}
		

		reader.close();
	}

	private void printHelp() {
		String help = "--------------------------------------------\n";
		help += "COMMANDS\t\tEXPLANATION\n";
		help += "help\t\t\tshows this help menu\n";
		help += "inventory\t\tshows items in your backpack\n";
		help += "go [d]\t\t\tgoes to the room in direction [d]\n";
		help += "talk [n]\t\ttalk to the student with name [n]\n";
		help += "exit\t\t\texit game\n";
		help += "use key with [d]\tunlock the door in direction [d]\n";
		help += "";
		help += "";
		help += "";
		help += "";
		help += "";
		help += "--------------------------------------------\n";

		System.out.println(help);
	}
	private void go(String direction) {
		switch (direction) {
			case "north": 
				System.out.println("North.");
				break;
			
			case "east": 
				System.out.println("East");
				break;

			case "south": 
				System.out.println("South");
				break;

			case "west": 
				System.out.println("West");
				break;
			
			default: System.out.println("Not a direction.");
		}
	}
	public Room findRoom(String roomName) {
		for (int i = 0; i < numberOfRooms; i++) {
		Room crnt = allRooms.get(i);
		
		if ((crnt.getName()).equals(roomName)) return crnt;
	}
	return null;
	}

	public void printAllRooms() {
		for (int i = 0; i < numberOfRooms; i++) {
		Room crnt = allRooms.get(i);
		System.out.println(crnt);
	}
}
}
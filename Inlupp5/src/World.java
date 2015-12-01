import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class World extends RoomReader{
	ArrayList<Room> allRooms;
	int numberOfRooms;
	Avatar player;

	public World () {
		numberOfRooms = 0;
		//this.allRooms = createRooms();
		//this.player = player;
		//create random keys. 
		//create random stuff.
	}
	public void testWorld() {
		createRooms();
		printAllRooms();
/*
	Creature s = new Student("hej hej", "Karro");
	Item i = new Key(0.3);
	
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Creature> creatures = new ArrayList<Creature>();
	creatures.add(s);
	items.add(i);

*/
	}

	/*	
	public static String arrListToString(ArrayList arrList) {
	String s;
	Object current = arrList.get(0);
		
		s = current.toString();	

		for (int i = 1; i < arrList.size(); i++) {
			s += ", ";
			current = arrList.get(i);
			s += current.toString(); 
		}
		return s;
	}*/

	private static ArrayList<String[]> convertToStringArr(ArrayList<String> allRoomsLine) {
	ArrayList<String[]> allRoomsInfo = new ArrayList<String[]>();
		for (int i = 0; i < allRoomsLine.size(); i++) {
		String roomLine = allRoomsLine.get(i);
		String[] roomInfoStringList = new String[9];
		
		int roomLineLength = roomLine.length();
		int k = 0;
		for (int j = 0; j < 9; j++) {
			String currentWord = "";
		
				while ((roomLine.charAt(k) !=';') && (roomLine.charAt(k) != '\n')) {
					char c = roomLine.charAt(k);
					currentWord += c;
					k++;
					if (k >= roomLineLength) break;
				}
				k += 2; //eftersom den är mellanslag efter varje kolon

			//System.out.println("currentWord: " + currentWord);
			roomInfoStringList[j] = currentWord;

		}
		allRoomsInfo.add(i, roomInfoStringList); 	
	}
	return allRoomsInfo;
	}
	private Room findRoom(String roomName) {
		for (int i = 0; i < numberOfRooms; i++) {
		Room crnt = allRooms.get(i);
		
		if ((crnt.getName()).equals(roomName)) return crnt;
	}
	return null;
	}

	private void connectRooms(ArrayList<String[]> allRoomsInfo) {
		for (int i = 0; i < numberOfRooms; i++) {
			String[] crntInfo = allRoomsInfo.get(i);
			String crntName = crntInfo[0];
			Room crntRoom = findRoom(crntName);
			
			Room[] rooms = new Room[4];

			for (int j = 1; j < 5; j++) {
				String connectedName = crntInfo[j];
				
				Room connectedRoom = findRoom(connectedName); 
				
				if (connectedName.equals("X")) {
				 	rooms[j-1] = null; 
				}
				else {
					rooms[j-1] = connectedRoom;
				}
			}
			crntRoom.setRooms(rooms);
		}
	}

	private Boolean[] convertToBoolean(String[] roomArray) {
		Boolean[] openDoors = new Boolean[4];

		for (int i = 5; i < 9; i++) {
			
			String door = roomArray[i];
			if (door.equals("X") || door.equals("False") || door.equals("false")) {
				openDoors[i-5] = false;
			}
			else {
				openDoors[i-5] = true;
		}
		
	}
	return openDoors;
}

	public void createRooms() {
	
	ArrayList<String> roomLines = new ArrayList<String>(); //= readRoom();
		try {
		roomLines = readRoom();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found....  " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Caught IOException...." + e.getMessage());
		} 
	ArrayList<Room> gameMap = new ArrayList<Room>();
	ArrayList<String[]> allRoomsInfo = convertToStringArr(roomLines);

	this.numberOfRooms = allRoomsInfo.size();

	for (int i = 0; i < numberOfRooms; i++) {
		String currentName = (allRoomsInfo.get(i))[0];
		Boolean[] currentOpenDoors = convertToBoolean(allRoomsInfo.get(i));
		Room currentRoom = new Room(currentName, currentOpenDoors);
		gameMap.add(currentRoom);
	}

	this.allRooms = gameMap;
	connectRooms(allRoomsInfo);

}

	public void printAllRooms() {
		for (int i = 0; i < numberOfRooms; i++) {
		Room crnt = allRooms.get(i);
		System.out.println(crnt);
	}
}
}
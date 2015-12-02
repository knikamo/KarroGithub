import java.util.ArrayList;
import java.util.Random;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class BuildWorld {
	
	public static ArrayList<String> readTextFile(String fileName) throws FileNotFoundException, IOException {
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	ArrayList<String> allLines = new ArrayList<String>();
	String line;
	
	while ((line = br.readLine()) != null) {
		allLines.add(line);
		
	}

	return allLines;

}


	public static void createRooms(World w) {
	
	ArrayList<String> roomLines = new ArrayList<String>();
		try {
		roomLines = readTextFile("rooms.txt");
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found....  " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Caught IOException...." + e.getMessage());
		} 
	ArrayList<Room> gameMap = new ArrayList<Room>();
	ArrayList<String[]> allRoomsInfo = convertToStringArr(roomLines);

	w.setNumberOfRooms(allRoomsInfo.size());

	for (int i = 0; i < w.getNumberOfRooms(); i++) {
		String currentName = (allRoomsInfo.get(i))[0];
		Boolean[] currentOpenDoors = convertToBoolean(allRoomsInfo.get(i));
		Room currentRoom = new Room(currentName, currentOpenDoors);
		gameMap.add(currentRoom);
	}

	w.setAllRooms(gameMap);
	connectRooms(w, allRoomsInfo);

}

	public static void createKeys(World w) {
		int numberOfRooms = w.getNumberOfRooms();
		double numberOfKeys =  numberOfRooms * 1.5;
		Random random = new Random();
		
		for (int i = 0; i < numberOfKeys; i++) {
			Key newKey = new Key();
			int randomIndex = random.nextInt(numberOfRooms);
			Room randomRoom = (w.getAllRooms()).get(randomIndex);
			randomRoom.addToRoom(newKey);

		}
 }
	public static ArrayList<String[]> convertToStringArr(ArrayList<String> lines) {
	ArrayList<String[]> convertedLines = new ArrayList<String[]>();
		
		for (int i = 0; i < lines.size(); i++) {
		String singleLine = lines.get(i);
		//String[] roomInfoStringList = new String[9];
		String[] splittedLine;
		splittedLine = singleLine.split(";");
		/*
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
				k += 2; //eftersom dent är mellanslag efter varje kolon

			roomInfoStringList[j] = currentWord;

		}*/
		convertedLines.add(i, splittedLine);
		//allRoomsInfo.add(i, roomInfoStringList); 	
	}
	return convertedLines;
	}

	private static void connectRooms(World w, ArrayList<String[]> allRoomsInfo) {
		for (int i = 0; i < w.getNumberOfRooms(); i++) {
			String[] crntInfo = allRoomsInfo.get(i);
			String crntName = crntInfo[0];
			Room crntRoom = w.findRoom(crntName);
			
			Room[] rooms = new Room[4];

			for (int j = 1; j < 5; j++) {
				String connectedName = crntInfo[j];
				
				Room connectedRoom = w.findRoom(connectedName); 
				
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

	private static Boolean[] convertToBoolean(String[] roomArray) {
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

}
import java.util.ArrayList;
import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;

public class Room implements ListToString {
	private String name;
	private Room[] rooms;
	private Boolean[] openDoors;
	private ArrayList<Item> items;
	private ArrayList<Creature> creatures;

	public Room(String name, Boolean[] od, ArrayList<Item> i, ArrayList<Creature> c) {
		this.name = name;
		this.openDoors = od;
		this.items = i;
		this.creatures = c;
	}
	public Room(String name, Boolean[] od) {
		this.name = name;
		this.openDoors = od;
		this.items = new ArrayList<Item>();
		this.creatures = new ArrayList<Creature>();
	}

	public String getName() throws NullPointerException {
		return this.name;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public String toString() {
		String creatureString = "";
		String itemString = "";
		try {
			itemString = arrListToString(items); } 
		catch (IndexOutOfBoundsException e) {
			itemString = "(nothing)";
		}
		try {
			creatureString = arrListToString(creatures); } 
		catch (IndexOutOfBoundsException e) {
			creatureString = "(nothing)";
		}

		String s = "============================================\n";
		s += "Room: " + name + "\n";
		s += "Items: " + itemString + "\n";
		s += "Creatures: " + creatureString + "\n";
		s += "Doors from this room: \n" + roomsToString();
		s += "============================================";
		return s;
	}
	private String openToString(int index) {
		if (openDoors[index]) return "(open)";
		else return "(locked)";
	}
	private String roomsToString() {
		String s;
		String[] neighbourNames = new String[4];
		
		for (int i = 0; i < 4; i++) {
		try {
			neighbourNames[i] = rooms[i].getName(); 
			neighbourNames[i] += " " + openToString(i);
		}
		catch (NullPointerException e) {
				neighbourNames[i] = "(Wall)";
			}
		}

		s = " * North: " + neighbourNames[0] + "\n";
		s += " * East: " + neighbourNames[1] + "\n";
		s += " * South: " + neighbourNames[2] + "\n";
		s += " * West: " + neighbourNames[3] + "\n";

		return s;
	}

	public String arrListToString(ArrayList arrList) throws IndexOutOfBoundsException {
		String s;

		Object current = arrList.get(0);
		
		s = current.toString();	

		for (int i = 1; i < arrList.size(); i++) {
			s += ", ";
			current = arrList.get(i);
			s += current.toString(); 
		}
		return s;
	}

}
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

	public void addToRoom(Object o) {
		if (o instanceof Item) {
			Item i = (Item) o;
			items.add(i);
		}
		else if (o instanceof Creature) {
			Creature c = (Creature) o;
			creatures.add(c);
		}
		else {
			System.out.println("Not a valid object to put in room");
		}
	}

	public Avatar avatarInRoom() {
		for (int i = 0; i < creatures.size(); i ++) {
			Creature crnt = creatures.get(i);
			if (crnt instanceof Avatar) {
				Avatar a = (Avatar) crnt;
				return a;
		}
	}
		return null;
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
		Avatar a = avatarInRoom();
		if (a != null) {
			s += "--------------------------------------------\n";
			s+= a.backpackToString() + "\n";
		}
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
				neighbourNames[i] = "-----";
			}
		}

		s = " * N: " + neighbourNames[0] + "\n";
		s += " * E: " + neighbourNames[1] + "\n";
		s += " * S: " + neighbourNames[2] + "\n";
		s += " * W: " + neighbourNames[3] + "\n";

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
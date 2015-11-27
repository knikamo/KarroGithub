import java.util.ArrayList;
import java.lang.NullPointerException;

public class Room extends ListToString {
	private String name;
	private Room[] rooms;
	private Boolean[] openDoors;
	private ArrayList<Item> items;
	private ArrayList<Creature> creatures;

	public Room(String name, Room[] r, Boolean[] od, ArrayList<Item> i, ArrayList<Creature> c) {
		this.name = name;
		this.rooms = r;
		this.openDoors = od;
		this.items = i;
		this.creatures = c;
	}

	public String getName() {
		try  {
		
		return this.name; } 

		catch (NullPointerException n) {
			return "Wall";
		}
	}
	public String toString() {
		String s = "Room:" + name + "\n";
		s += "Items: " + arrListToString(items) + "\n";
		s += "Creatures: " + arrListToString(creatures) + "\n";
		s += "Doors from this room: " + roomsToString() + "\n";
		return s;
	}
	private String openToString(int index) {
		if (openDoors[index]) return "(open)";
		else return "(locked)";
	}
	private String roomsToString() {
		String s;
		s = "North: " + rooms[0].getName() + rooms[0].openToString(0);
		s += "East: " + rooms[1].getName() + rooms[1].openToString(1);
		s += "South: " + rooms[2].getName() + rooms[2].openToString(2);
		s += "West: " + rooms[3].getName() + rooms[3].openToString(3);

		return s;
	}
	/*
	private String arrListToString(ArrayList arrList) {
		String s;
		Object current = arrList.get(0);
		
		s = current.toString();	

		for (int i = 1; i < arrList.size(); i++) {
			s += ", ";
			current = arrList.get(i);
			s += current.toString(); 
		}
		return s;
	} */
}
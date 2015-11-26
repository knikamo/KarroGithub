import java.util.ArrayList;

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
		return this.name;
	}
	public String toString() {
		String s = "Room:" + name + "\n";
		s += "Items: " + arrListToString(items) + "\n";
		s += "Creatures: " + arrListToString(creatures) + "\n";
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
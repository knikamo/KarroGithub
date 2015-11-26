import java.util.ArrayList;

public class Room {
	private String name;
	private Room[] rooms;
	private Bool[] openDoors;

	private ArrayList<Item> items;
	private ArrayList<Creature> people;

	public Room(String name, Room[] r, Bool[] od, ArrayList<Item> i, ArrayList<Creature> p) {
		this.name = name;
		this.rooms = r;
		this.openDoors = od;
		this.items = i;
		this.people = p;
	}
}
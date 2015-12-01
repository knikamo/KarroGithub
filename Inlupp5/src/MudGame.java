import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MudGame extends World {
	public static void main(String[] args) throws InterruptedException {
	System.out.println("test");
	World w = new World();
	w.testWorld();

	/*
	try {
		testRR(); } 

		catch (FileNotFoundException e) {
			System.out.println("File not found....  " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Caught IOException...." + e.getMessage());
		} 

	Creature s = new Student("hej hej", "Karro");
	Item i = new Key(0.3);
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Creature> creatures = new ArrayList<Creature>();
	creatures.add(s);
	items.add(i);

	String[] strings = {"Norrrrr", "Östtttt", "Syddd", "Väääääst"};
	Boolean[] openDoors = {true, false, true, false};

	Room testRoom = new Room("Sovrum", strings, openDoors, items, creatures);
	System.out.println(testRoom);
	*/
	}
}
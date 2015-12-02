import java.util.ArrayList;
import java.util.Scanner;

public class Avatar extends Creature {
	private Backpack backpack;
	private int hp;
	private ArrayList<Course> ongoingCourses;
	private ArrayList<Course> completedCourses;

	public Avatar(World w, String roomName, String name) {
		super(w, roomName, name);
		this.backpack = new Backpack();
		this.hp = 60;		
	}

	public String toString() {
		return (getName() + " (you)");
	}

	public String backpackToString() {
		return backpack.toString();
	}

	public String talk() {
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		reader.close();

		return input;
		//read input from user
	}

	public void pickUp(Item i) {
		backpack.addToBackpack(i);
	}

	public void drop(Item i) {
		backpack.dropFromBackpack(i);
	}
	public Boolean readyForExam() {
		return (hp >= 180 && ongoingCourses.isEmpty());
	}
}
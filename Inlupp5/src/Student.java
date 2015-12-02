import java.util.ArrayList;
public class Student extends Creature {
	private String ongoingCourse;
	private String completedCourse;
	private ArrayList<Book> books;

	public Student(World w, String room, String name) {//, Course ongoingCourse, Course completedCourse, ArrayList<Book> books) {
		super(w, room, name);
		//this.ongoingCourse = ongoingCourse;
		//this.completedCourse = completedCourse;
		//this.books = books;
	}

	public String toString() {
		return getName() + "(student)";
	}

	public String talk() {
		String studentInfo = "Hello, I'm " + getName();
		studentInfo += "and I study " + ongoingCourse + ".";
		return studentInfo;
		//System.out.println("Hello, I'm a student");
	}
}
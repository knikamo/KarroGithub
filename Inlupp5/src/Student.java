import java.util.ArrayList;
public class Student extends Creature {
	private Course ongoingCourse;
	private Course completedCourse;
	private ArrayList<Book> books;

	public Student(String room, String name) {//, Course ongoingCourse, Course completedCourse, ArrayList<Book> books) {
		super(room, name);
		//this.ongoingCourse = ongoingCourse;
		//this.completedCourse = completedCourse;
		//this.books = books;
	}

	public String toString() {
		return getName() + "(student)";
	}
}
import java.util.ArrayList;
public class Student extends Creature {
	private String name;
	private Course ongoingCourse;
	private Course completedCourse;
	private ArrayList<Book> books;

	public Student(Room r, Course ongoingCourse, Course completedCourse, Book[] books) {
		super(r);
		this.ongoingCourse = ongoingCourse;
		this.completedCourse = completedcCourse;
		this.books = books;
	}

	public String toString() {
		return "S";
	}
}
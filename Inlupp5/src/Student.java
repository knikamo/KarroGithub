import java.util.ArrayList;
public class Student extends Creature {
	private String name;
	private Course ongoingCourse;
	private Course completedCourse;
	private ArrayList<Book> books;

	public Student(String r, Course ongoingCourse, Course completedCourse, ArrayList<Book> books) {
		super(r);
		this.ongoingCourse = ongoingCourse;
		this.completedCourse = completedCourse;
		this.books = books;
	}

	public String toString() {
		return "S: " + this.name;
	}
}
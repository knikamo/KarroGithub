public class Teacher extends Creature {
	private Course course;
	
	public Teacher (Room r, Course c) {
		super(r);
		this.course = c;
	}

	public String toString() {
	return "T";
	}
}
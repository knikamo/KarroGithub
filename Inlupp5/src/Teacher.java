public class Teacher extends Creature {
	private Course course;
	
	public Teacher (String r, Course c) {
		super(r);
		this.course = c;
	}

	public String toString() {
	return "T";
	}
}
public class Teacher extends Creature {
	private Course course;
	
	public Teacher (String room, String name, Course c) {
		super(room, name);
		this.course = c;
	}

	public String toString() {
	return getName() + "(teacher)";
	}
}
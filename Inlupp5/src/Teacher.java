import java.util.Random;

public class Teacher extends Creature {
	private Course course;
	
	public Teacher (World w, String room, String name, Course c) {
		super(w, room, name);
		this.course = c;
	}

	public String toString() {
		return getName() + "(teacher)";
	}

	public String talk() {
		return "Hello, I'm a teacher";
		//System.out.println("Hello, I'm a teacher");
	}

	public Boolean askQuestion(Boolean avatarCompleted, Boolean avatarOngoing) {
		Random r = new Random();
		int randomIndex = r.nextInt(100);
		Boolean correct;
		if (avatarCompleted && randomIndex < 50) {
				correct = course.courseQuestion();
		}
		else if (avatarOngoing && randomIndex < 75) {
			correct = course.courseQuestion();
		}
		else {
			System.out.println("You are not enrolled on this course.");
			correct = true;
		}
		return correct;
	}
}
import java.util.Scanner;

public class Course {
	private String name;
	private Book book; 
	private int hp;
	private String question;
	private String[] answers;
	private String correctAlt;

	public Course(String n, Book b, int hp, String q, String[] a) {
		this.name = n;
		this.book = b;
		this.hp = hp;
		this.question = q;
		this.answers = a;
	}

	public Boolean courseQuestion() {
		System.out.println(question);
		System.out.println("Alternatives: \n a) " + answers[0] + "\n b) " + answers[1] + "\n c) " + answers[2] + "\n");

		Scanner reader = new Scanner(System.in);
	
		String input = reader.nextLine();

		while (input != "a" || input != "b" || input != "c") {
			System.out.println("Not a valid answer, try again with 'a', 'b' or 'c' ");
			input = reader.nextLine();
		}
		
		reader.close();
		if (correctAlt.equals(input)) {
			System.out.println("Correct answer! You just got " + hp + "hp!");
			return true; 
		}
		else return false;
	}
}

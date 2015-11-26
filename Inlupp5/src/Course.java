public class Course {
	private String name;
	private Book book; 
	private int hp;
	private String question;
	private String[] answers;

	public Course(String n, Book b, int hp, String q, String[] a) {
		this.name = n;
		this.book = b;
		this.hp = hp;
		this.question = q;
		this.answers = a;
	}
}

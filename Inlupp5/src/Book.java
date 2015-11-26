public class Book extends Item {
	private String name;
	private String courseName;

	public Book(double volume, String name, String courseName) {
		super(volume);
		this.name = name;
		this.courseName = courseName;
	}
}
abstract class Creature {
	private String room;
	private String name;

	public Creature(String room, String name)  {
		this.room = room;
		this.name = name;
	}
	
	public String getRoom() {
		return this.room;
	}

	public String getName() {
		return this.name;
	}
}
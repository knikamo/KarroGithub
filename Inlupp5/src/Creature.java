abstract class Creature {
	private World world;
	private String room;
	private String name;

	public Creature(World w, String room, String name)  {
		this.world = w;
		this.room = room;
		this.name = name;
	}
	
	public World getWorld() {
		return this.world;
	}
	
	public String getRoomName() {
		return this.room;
	}

	public String getName() {
		return this.name;
	}

	public String talk() {
		return ("This creature can't talk");
		//System.out.print("This creature can't talk");
	}
}
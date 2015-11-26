public class Backpack {
	private double maxvolume;
	private double currentvolume;
	private ArrayList<Item> items;

	// set maxvolume to 10
	public Backpack () { 
		maxvolume = 10.0

	} 

	// set currentvolume to 0
	public Backpack() {
		currentvolume = 0.0

	}

	// Add and checks if valid add
	public void addtobackpack (double amountofitems){
		int checkSpace = currentvolume+amountofitems;
		if(checkSpace<=maxvolume)
			currentvolume += amountofitems;

	}

	// Drop and checks if valid drop
	public void dropfrombackpack (double amountofitems){
		if(amountofitems<=currentvolume)
		currentvolume -= amountofitems;
	}
	 

	
	

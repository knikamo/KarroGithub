import java.util.ArrayList;

public class Backpack {
	private double maxvolume;
	private double currentvolume;
	private ArrayList<Item> items;

	// set maxvolume to 10
	// set currentvolume to 0
	public Backpack () { 
		maxvolume = 10.0;
		currentvolume = 0.0;

	} 


	// Add and checks if valid add
	public void addtobackpack (Item addItem) {
		double itemVolume = addItem.getVolume();

		double checkSpace = currentvolume+itemVolume;
		if(checkSpace<=maxvolume)
			{
				currentvolume += itemVolume;
				(this.items).add(addItem);
			}


	}

	// Drop and checks if valid drop
	public void dropfrombackpack (Item dropItem) {
		double itemVolume = dropItem.getVolume();
		Boolean hasDropped = (this.items).remove(dropItem);
		if (hasDropped)
			{
			currentvolume -= itemVolume;
			}
	}

	public String toString() {
		String s = "Backpack: ";
		s += arrListToString(items);
		/*
		Item currentItem = items.get(0);
		s += currentItem.toString();	

		for (int i = 1; i < items.size(); i++) {
			s += ", ";
			currentItem = items.get(i);
			s += currentItem.toString(); 
		} */

		return s;

	}	 
}
	
	

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Backpack implements ListToString {
	private double maxVolume;
	private double currentVolume;
	private ArrayList<Item> items;

	// set maxvolume to 10
	// set currentvolume to 0
	public Backpack () { 
		maxVolume = 10.0;
		currentVolume = 0.0;

	} 


	// Add and checks if valid add
	public void addtobackpack (Item addItem) {
		double itemVolume = addItem.getVolume();

		double checkSpace = currentVolume+itemVolume;
		if(checkSpace<=maxVolume)
			{
				currentVolume += itemVolume;
				(this.items).add(addItem);
			}
		else {
			System.out.print("Backpack is not big enough for that item. Current empty space in backpack: " + currentVolume);
		}


	}

	// Drop and checks if valid drop
	public void dropfrombackpack (Item dropItem) {
		double itemVolume = dropItem.getVolume();
		Boolean hasDropped = (this.items).remove(dropItem);
		if (hasDropped)
			{
			currentVolume -= itemVolume;
			}
	}

	public String toString() {
		String s = "Backpack: ";
		try {
		s += arrListToString(items); } catch (IndexOutOfBoundsException e) {
			s += "(empty)";
		}
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

	public String arrListToString(ArrayList arrList) throws IndexOutOfBoundsException {
		String s;
		Object current = arrList.get(0);
		
		s = current.toString();	

		for (int i = 1; i < arrList.size(); i++) {
			s += ", ";
			current = arrList.get(i);
			s += current.toString(); 
		}
		return s;
	}	 
}
	
	

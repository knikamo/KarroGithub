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
		items = new ArrayList<Item>();

	} 


	// Add and checks if valid add
	public void addToBackpack (Item addItem) {
		double itemVolume = addItem.getVolume();

		double checkSpace = currentVolume+itemVolume;
		if(checkSpace<=maxVolume)
			{
				currentVolume += itemVolume;
				(this.items).add(addItem);
			}
		else {
			System.out.println("Backpack is not big enough for that item. Current empty space in backpack: " + currentVolume);
		}


	}

	// Drop and checks if valid drop
	public void dropFromBackpack (Item dropItem) {
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
			s += "-----";
		}
		s += "\n Volume: " + currentVolume + " litres   (Empty space: " + (maxVolume-currentVolume) + " litres)";
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
	
	

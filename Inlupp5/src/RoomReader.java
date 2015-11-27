import java.util.ArrayList;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class RoomReader {
	
	public static void testRR() throws FileNotFoundException, IOException {
	BufferedReader br = new BufferedReader(new FileReader("rooms.txt"));
	ArrayList<String> allRooms = new ArrayList<String>();
	String line;
	
	while ((line = br.readLine()) != null) {
		System.out.println(line);
		allRooms.add(line);
		
	}
/*
	for (int i = 0; i < allRooms.size(); i++) {
		System.out.print(i);
	} */
}

}
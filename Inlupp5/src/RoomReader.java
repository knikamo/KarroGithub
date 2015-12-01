import java.util.ArrayList;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class RoomReader {
	
	public static ArrayList<String> readRoom() throws FileNotFoundException, IOException {
	BufferedReader br = new BufferedReader(new FileReader("rooms.txt"));
	ArrayList<String> allLines = new ArrayList<String>();
	String line;
	
	while ((line = br.readLine()) != null) {
		//System.out.println(line + "old version");
		allLines.add(line);
		
	}

	return allLines;

}

}
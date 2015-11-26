abstract class RoomReader {
	StringReader s = new StringReader(new BufferInputStream (new File("rooms.txt")).getInputStream);
	ArrayList<String> allRooms = new ArrayList<String>();
	
	while () {
		String roomString = s.readString();
		allRooms.add(roomString);
	}
}
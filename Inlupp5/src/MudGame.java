import java.io.FileNotFoundException;
import java.io.IOException;

public class MudGame extends RoomReader {
	public static void main(String[] args) throws InterruptedException {
	System.out.println("test");
	try {
		testRR(); } 

		catch (FileNotFoundException e) {
			System.out.println("File not found....  " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Caught IOException...." + e.getMessage());
		} 

	}
}
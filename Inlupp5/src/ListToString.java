import java.util.ArrayList;

abstract class ListToString {
		
		public static String arrListToString(ArrayList arrList) {
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
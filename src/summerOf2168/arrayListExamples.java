package summerOf2168;

import java.util.ArrayList;

// using java ArrayLists not the one that we made

public class arrayListExamples {
	
	public static int sum(ArrayList<Integer> list) {
		int sum = 0;
		
		for (int i = 0; i < list.size(); i++) {
			sum += (int) list.get(i); // if this was a list we would use sum += list[i]
		}
		return sum;
	}
	
	public static <T> boolean contains(ArrayList<T> list, T item) { // this method contains an arraylist of type T's looking for a T item... only need this if you do not know what type of thing that is going to be passed into the method
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}
}

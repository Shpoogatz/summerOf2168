// https://www.youtube.com/watch?v=rX6xOj78kpE&t=2085s&ab_channel=ProfessorRosen

package summerOf2168;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// showing some different examples of time complexity

public class bigOExamples {
	
	// linear, increasing the size of the list  by a factor of 10 will increase the time it takes to to run by 10 and same for removing in a factor of 10 or 100 etc.
	// if it is of size n it will take n time ( or some version of that... could be .04n or something like that ) 
	public static void createArrayList1() {
	ArrayList<Integer> list = new ArrayList<Integer>();
	long start = System.currentTimeMillis();
	
	for (int i = 0; i < 100000; i++) {
		list.add(i);
	}
	
	long end = System.currentTimeMillis();
	System.out.println(end - start);
	
	}
	
	// quadratic
	// adding anywhere except the end of the list requires the shifting of other elements in a list causing this to take a considerable amount of time more 
	public static void createArrayList2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		long start = System.currentTimeMillis();
		
		// notice that we have the same for loop with a different override of the add() function
		for (int i = 0; i < 100000; i++) {
			list.add(0,i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	
	// showing the power of a LinkedList on the same for loop 
	public static void createArrayList3() {
		List<Integer> list = new LinkedList<Integer>();
		long start = System.currentTimeMillis();
		
		// notice that we have the same for loop with a different override of the add() function
		for (int i = 0; i < 100000; i++) {
			list.add(0,i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	
	
	
	public static void main(String[] args) {
		createArrayList1(); // O(n) example 
		createArrayList2(); // O(n^2) example
		createArrayList3(); // same as example 2 but with a LinkedList (which is actually linear time complexity... Rosen says we will learn when we get to LinkedLists how this works).
	}
}

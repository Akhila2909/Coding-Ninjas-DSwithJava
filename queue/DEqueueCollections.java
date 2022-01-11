package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DEqueueCollections {
public static void main(String args[]) {
		
		Deque<String> dq=new ArrayDeque<>();
		
		dq.addFirst("First"); //adds at front end
		dq.addLast("Last");   //adds at rear end
		dq.add("IDK");		  //adds at rear end
		
		System.out.println(dq.contains("First")); //check element present
		
		System.out.println(dq.peekFirst());// returns null if empty
		System.out.println(dq.peekLast()); // returns null if empty
				
		for (Iterator itr = dq.iterator(); //forward iterator
	             itr.hasNext();) {
	            System.out.print(itr.next() + " ");
	        }
	  
	        System.out.println();
	  
	        for (Iterator itr = dq.descendingIterator(); //backward iterator
	             itr.hasNext();) {
	            System.out.print(itr.next() + " ");

	        }
		
	    System.out.println(dq.pollLast());  //deletes & returns rear element ;empty array if empty
		System.out.println(dq.removeLast()); //deletes & returns rear element ;throws exception if empty
	
		
	
		System.out.println(dq.poll());//return front & null if empty
		System.out.println(dq.pop()); //returns front & exception if empty
		System.out.println(dq.removeFirst());//deletes & returns front element
		
		
	
 
}
}

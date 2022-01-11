package priorityQueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static int kthLargest(int n, int[] input, int k) {
	    
        //Method 1 -Max Heap Adding all-removing till kth -N* O(log N)
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++)
            p.add(input[i]);  //N*O(log N)
        while(k!=1)
        {
            p.remove();       //K*O(log K)
            k--;
        }
        return p.remove();
        
	}
        //Method 2-Min Heap to store k largest elements so kth largest will be root(directly) - N*O(log k)
	public static int kthLargestBetter(int n, int[] input, int k) {
	       
        PriorityQueue<Integer> p=new PriorityQueue<>();
        int i=0;
        for(;i<k;i++)
            p.add(input[i]);				//k* O(log k)
        for(;i<input.length;i++){
			if(input[i]>p.element())		
            {
				p.remove();
                p.add(input[i]);           //(N-k)* O(log K)
            }
        }
        return p.element();
            
	}
   public static void main(String[] args) {
		int[] a= {2,7,1,5,9,3};
		System.out.println(kthLargestBetter(5,a,3));

	}
}

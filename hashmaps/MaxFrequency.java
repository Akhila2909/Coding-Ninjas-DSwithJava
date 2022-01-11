package hashmaps;
import java.util.ArrayList;
import java.util.HashMap;


public class MaxFrequency {

public static int maxFrequencyNumber(int[] arr){ 

	   HashMap<Integer,Integer> store=new HashMap<>();
	        for(int a:arr)
	        {
	            if(!store.containsKey(a))
	                store.put(a,1);
	            else
	                store.put(a,store.get(a)+1);
	        }
	        
	  int maxFreq=Integer.MIN_VALUE ,max=0;
	        for(int a:arr)
	            if(store.get(a)>maxFreq)
	            {
	                maxFreq=store.get(a);
	                max=a;
	            }
	         return max;       	
	    }




}
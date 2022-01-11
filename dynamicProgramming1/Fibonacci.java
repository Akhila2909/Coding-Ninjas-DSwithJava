package dynamicProgramming1;

public class Fibonacci {

	public static int fib(int n) { 						// O(2^n) 
		if(n==0||n==1)
			return n;
		return fib(n-1)+fib(n-2);
	}
	
	public static int fibM(int n) {  					//O(N) as 2N-1  calls
		int[] storage=new int[n+1];
		for(int i=0;i<n+1;i++)
			storage[i]=-1;	   							//-1 implies ans not calculated already
		
		return fibM(n,storage);
	}
	
	public static int fibM(int n,int[] storage) {
		if(n==0||n==1) {        						//storing ans we know
			storage[n]=n;
			return storage[n];
		}
		
		if(storage[n]!=-1)     							//checking if ans is already calculated
			return storage[n]; 							//if yes then return it
		
		storage[n]=fibM(n-1,storage)+fibM(n-2,storage); //if not then calculate it & store
		return storage[n]; 								//then return it
		
	}
	
	public static int fibDP(int n) {
		int[] storage=new int[n+1];
		storage[0]=0;                                  //storing ans we know
		storage[1]=1;
		
		for(int i=2;i<=n;i++) 
			storage[i]=storage[i-1]+storage[i-2];      //moving in bottom up fashion
		
	  return storage[n];                               //ans is stored at nth index
	}
	

	public static void main(String[] args) {
		int n = 4;
		System.out.println(fibM(n));
		System.out.println(fib(n));
		System.out.println(fibDP(n));
	}

}

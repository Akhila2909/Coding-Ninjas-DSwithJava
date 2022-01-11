package dynamicProgramming1;

public class Staircase {

	public static long staircase(int n) {
		if(n==0)
            return 1;
        if(n<0)
            return 0;
        long option1=staircase(n-1);
        long option2=staircase(n-2);
        long option3=staircase(n-3);
        return option1+option2+option3;
	}
	
	public static long staircaseM(int n) {
		long[] storage=new long[n+1];
        for(int i=0;i<n+1;i++)
            storage[i]=-1;
        return staircaseM(n,storage);
	}
  
  public static long staircaseM(int n,long[] storage){
       if(n==0){
           storage[n]=1;
           return storage[n];
      }
      if(n<0)
          return 0;
      
      if(storage[n]!=-1)
          return storage[n];
      
      storage[n]=staircaseM(n-1,storage)+staircaseM(n-2,storage)+staircaseM(n-3,storage);
      return storage[n];    
      
  }
  
  public static long staircaseDP(int n) {
      if(n==0)
          return 0;
      if(n==1)
          return 1;
      long[] storage=new long[n+1];
      storage[0]=1;
      storage[1]=1;
      storage[2]=2;
      for(int i=3;i<n+1;i++)
      {
          storage[i]=storage[i-3]+storage[i-2]+storage[i-1];
      }
      
      return storage[n];  
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

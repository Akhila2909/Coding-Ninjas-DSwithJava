package dynamicProgramming1;

public class MinStepsTo1 {
   
	public static int countMinStepsToOne(int n) {
		if(n<=1)
			return 0;
		int option1=countMinStepsToOne(n-1),option2=Integer.MAX_VALUE,option3=Integer.MAX_VALUE;;
		
		if(n%2==0)
			option2=countMinStepsToOne(n/2);
		if(n%3==0)
			option3=countMinStepsToOne(n/3);
		
		return 1+Math.min(option1,Math.min(option2,option3));
	}
	
	public static int countMinStepsToOneM(int n) {
		int[] storage=new int[n+1];
		for(int i=0;i<n+1;i++)
			storage[i]=-1;
		return countMinStepsToOneM(n,storage);
	}
	
	public static int countMinStepsToOneM(int n,int[] storage) {
		if(n<=1) {
			storage[n]=0;
			return storage[n];
		}
		
		if(storage[n]!=-1)
			return storage[n];
		
		int option1=countMinStepsToOneM(n-1,storage),option2=Integer.MAX_VALUE,option3=Integer.MAX_VALUE;;
		
		if(n%2==0)
			option2=countMinStepsToOneM(n/2,storage);
		if(n%3==0)
			option3=countMinStepsToOneM(n/3,storage);
		
		storage[n]= 1+Math.min(option1,Math.min(option2,option3));
		return storage[n];
	}
	
	
	
	public static int countMinStepsToOneDP(int n) {
		int[] storage=new int[n+1];
		storage[0]=0;
		storage[1]=0;
		
		for(int i=2;i<n+1;i++) {
			int option1=storage[i-1],option2=Integer.MAX_VALUE,option3=Integer.MAX_VALUE;;
			if(i%2==0)
				option2=storage[i/2];
			if(i%3==0)
				option3=storage[i/3];
			storage[i]=Math.min(option2, Math.min(option1, option3))+1;
		}
		return storage[n];
	}
	
	
	
	public static void main(String[] args) {
		int n = 1000;
		System.out.println(countMinStepsToOneDP(n));
		System.out.println(countMinStepsToOneM(n));
		System.out.println(countMinStepsToOne(n));
		
	}

}

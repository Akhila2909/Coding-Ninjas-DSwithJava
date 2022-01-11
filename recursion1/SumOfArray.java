package recursion1;

public class SumOfArray {

	public static int sum(int input[]) {
        return sum(input,0);
	}
    
    public static int sum(int input[],int start) {
        if(start==input.length)
            return 0;
        int smallAns=sum(input,start+1);
        return smallAns+input[start];
		
	}
    
    public static void main(String args[]) {
        System.out.println(sum(new int[] {2,3,4,5}));
    }
    
    
}
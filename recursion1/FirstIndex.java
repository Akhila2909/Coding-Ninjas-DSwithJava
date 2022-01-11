package recursion1;

public class FirstIndex { //1st index of a number in an array

	public static int firstIndex(int input[], int x) {
		return firstIndex(input,x,0);
        
	}
    
    public static int firstIndex(int input[], int x,int index) {
        if(index==input.length)
            return -1;
		if(input[index]==x)
            return index;
        else
            return firstIndex(input,x,index+1);
        
	}
    
    public static void main(String args[]) {
        System.out.println(firstIndex(new int[] {2,3,4,3,3},3));
    }
}

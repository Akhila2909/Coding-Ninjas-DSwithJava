package recursion1;

public class CheckNumberInArray {

	public static boolean checkNumber(int input[], int x) {
		return checkNumber(input,x,0);
	}
    
    public static boolean checkNumber(int input[], int x,int index) {
		if(index==input.length)
            return false;
        if(input[index]==x)
            return true;
        return checkNumber(input,x,index+1);
		
	}
    
    public static void main(String args[]) {
        System.out.println(checkNumber(new int[] {2,3,4,5},3));
    }
    
}
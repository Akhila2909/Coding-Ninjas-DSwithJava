package recursion1;

public class LastIndex {

	public static int lastIndex(int input[], int x) {
		return lastIndex(input,x,0);
	}
    
    public static int lastIndex(int input[], int x,int index) {
		if(index==input.length)
            return -1;

        int smallAns=lastIndex(input,x,index+1);
        
        if(smallAns!=-1)
            return smallAns;
        else if(input[index]==x)
            return index;
        else
            return -1;
	}
	public static void main(String[] args) {
		System.out.println(lastIndex(new int[] {2,3,4,5,5},5));

	}

}

package recursion1;

public class AllIndices {
	
	public static int[] allIndexes(int input[], int x) {
		
		return allIndexes(input,x,0);
	}
	
	public static int[] allIndexes(int input[], int x,int index) {
		if(index==input.length)
            return new int[0];
    
        int[] smallAns=allIndexes(input,x,index+1);
    
        if(input[index]==x){
        int[] ans=new int[smallAns.length+1];
        ans[0]=index;
        for(int i=1;i<ans.length;i++)
            ans[i]=smallAns[i-1];
        return ans;
        }
        else
        return smallAns;
            
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

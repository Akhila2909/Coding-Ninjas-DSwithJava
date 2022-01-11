package recursion1;

public class CheckSorted {
	
	
	public static boolean checkSorted(int[] a) {
		return checkSorted(a,0);
	}

	public static boolean checkSorted(int[] a,int start) {
		if(start==a.length-1)
			return true;
		else {
		if(a[start]>a[start+1])
			return false;
		else
			return checkSorted(a,start+1);	
	}
	}
	
	

	public static void main(String[] args) {	
		int a[]= {2,3,0,5};
		System.out.println(checkSorted(a));
	}

}

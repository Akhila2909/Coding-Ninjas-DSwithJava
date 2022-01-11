package recursion1;

public class Multiply2Integers {

	public static int multiplyTwoIntegers(int m, int n){
		if(n==0)
            return 0;
        else if(n==1)
            return m;
        else
            return m+multiplyTwoIntegers(m,n-1);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

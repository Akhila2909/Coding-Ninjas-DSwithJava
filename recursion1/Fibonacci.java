package recursion1;

public class Fibonacci {

	//nth fibo number
	public static int nthFib(int n) {
		if(n==0 ||n==1)
			return n;
		else
			return nthFib(n-1)+nthFib(n-2);
		
	}
	
	public static void main(String[] args) {
		System.out.println(nthFib(3));

	}

}

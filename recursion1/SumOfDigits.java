package recursion1;

public class SumOfDigits {

	public static int sumOfDigits(int input){
		if(input/10==0)
            return input;
        return sumOfDigits(input/10)+(input%10);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package recursion1;

public class CountZeros {

	public static int countZerosRec(int input){
		if(input/10==0)
            if(input%10==0)
                return 1;
            else
              return 0;
        
        if(input%10==0)
            return countZerosRec(input/10)+1;
        else
            return countZerosRec(input/10);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

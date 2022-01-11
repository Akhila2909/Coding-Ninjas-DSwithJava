package assignmentRecursion1;

public class RemoveX {

	public static String removeX(String input){
		if(input.equals(""))
            return input;
        String smallAns=removeX(input.substring(1));
        if(input.charAt(0)=='x')
            return smallAns;
        else
            return input.charAt(0)+smallAns;
        

	}
}

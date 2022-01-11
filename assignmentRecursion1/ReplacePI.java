package assignmentRecursion1;

public class ReplacePI {

	public String replace(String input) {
		if(input.length()<=1)
			return input;
		String smallAns=replace(input.substring(1));
		if(input.charAt(0)=='p' && smallAns.charAt(0)=='i')
			return "3.14"+smallAns.substring(1);
		else
			return input.charAt(0)+smallAns;
	}
	
	
}

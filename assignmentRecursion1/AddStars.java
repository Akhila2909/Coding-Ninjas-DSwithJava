package assignmentRecursion1;

public class AddStars {

	// Return the updated string
		public static String addStars(String s) {
			if(s.length()<=1)
	            return s;
	        String smallAns=addStars(s.substring(1));
	        if(smallAns.charAt(0)==s.charAt(0))
	            return s.charAt(0)+"*"+smallAns;
	        else
	            return s.charAt(0)+smallAns;

		}
}

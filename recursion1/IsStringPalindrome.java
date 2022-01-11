package recursion1;

public class IsStringPalindrome {

	public static boolean isStringPalindrome(String input) {
        if(input.length()<=1)
            return true;
        boolean cornerCheck=(input.charAt(0)==input.charAt(input.length()-1));
        if(cornerCheck==false)
            return false;
        else
            return isStringPalindrome(input.substring(1,input.length()-1));

	}
}

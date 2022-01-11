package assignmentRecursion1;

public class ConvertStringToInteger {

	public static int convertStringToInt(String input){
		  if(input.length()==1)
		           return Integer.parseInt(input);
		        int smallAns=convertStringToInt(input.substring(1));
		        int length=input.length();
		        int digit=Integer.parseInt(input.substring(0,1));
		        int ans=digit*(int)Math.pow(10,length-1)+smallAns;
		        return ans;
		}
	}
		



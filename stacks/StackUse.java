package stacks;
import java.util.*;
public class StackUse {
	
	
	public static boolean checkRedundantBrackets(String expression) {//CHECK REDUNDANT BRACKETS
		Stack<Character> s=new Stack<>();
       for(int i=0;i<expression.length();i++)
       {
            char c=expression.charAt(i);
            if(c==')'){
                int k=0;
                while(s.peek()!='('){
                    s.pop();
                    k++;
                }
                s.pop();
                if(k==0||k==1)
                    return true;
            }
            else
                s.push(c);
        }
        return false;
	}
	
    static boolean ispar(String x)  //BALANCED PARENTHESIS
    {
        if(x.length()==0)
            return true;
            
        int l=x.length();
        Stack<Character> s=new Stack<>();
        
        for(int i=0;i<x.length();i++){
            char c=x.charAt(i);
            if(c==')'||c=='}'||c==']'){
                if(s.isEmpty())
                    return false;
                else
                {
                    char top=s.pop();
                    if((top=='(' && c==')')||(top=='{' && c=='}')||(top=='[' && c==']'))
                        continue;
                    else
                        return false;
                }
            }
            else 
                s.push(c);
                
            }
            if(!s.isEmpty())
                return false;
            else
                return true;
        }
        
	public static int countBracketReversals(String input) { //MINIMUM BRACKET REVERSAL
		if(input.length()%2!=0)
            return -1;
        Stack<Character> s=new Stack<>();
       	for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='{')
                s.push(ch);
            else
            {
                if(s.isEmpty())
                    s.push(ch);
                else {
					if(s.peek()=='}')
                        s.push(ch);
                    else
                        s.pop();
                }
            }
        }
        int count=0;
        while(!s.isEmpty()){
            char c1=s.pop();
            char c2=s.pop();
            if(c1==c2)
                count++;
            else
                count+=2;
        }
     return count;   
	}

	
	public static void main(String args[])throws StackEmptyException,StackFullException {
//	StackUsingArray s=new StackUsingArray();

	StackUsingLinkedList s=new StackUsingLinkedList();
	
	for(int i=0;i<20;i++)
		s.push(i);
	

	
	for(int j=0;j<20;j++)
		System.out.println(s.pop());
	
	System.out.println(s.top());

	System.out.println(s.size());
	
	System.out.println(s.isEmpty());
	
	
	
	
	
	
	
	}
}

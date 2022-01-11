package stacks;

public class StackUsingArray {

	private int data[];
    private int top;
	
	public StackUsingArray(){
		data=new int[10];
		top=-1;
	}
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty()
	{
		return(top==-1);
	}
	
	public int size() {//no of elements present
		return top+1;
	}
	
	public int top() throws StackEmptyException {
		if(top==-1) {
			StackEmptyException e=new StackEmptyException();
		    throw e;
	}
	return data[top];
		
	}
	
	public void push(int e) {
		if(size()==data.length) {
			doubleCapacity();
		}
			
		top++;
		data[top]=e;
	
	}
	
	public int pop() throws StackEmptyException {
		if(size()==0)
			throw new StackEmptyException();
		int temp=data[top];
		top--;
		return temp;
	}
	
	public void doubleCapacity() {
		
		int[] a=data;
		data=new int[size()*2];
		
		int i;
		for( i=0;i<a.length;i++) {
			data[i]=a[i];
		}
		
	}
	
	
	
	
	
	
}

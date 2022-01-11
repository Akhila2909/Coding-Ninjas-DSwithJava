package stacks;

class Node<T>{
	
	T data;
	Node<T> next;
	
	Node(T data){
		this.data=data;
		next=null;
	}
}


public class StackUsingLinkedList {

    
	private int size;          //size variable so that we don't have to traverse the whole LL to find length
	private Node<Integer> top; //head of the linked list
	
	StackUsingLinkedList(){
		size=0;
		top=null;
	}
	
	public boolean isEmpty() {
		return (top==null);
	}
	
	public int size() {
		return size;
	}
	
	public int top() throws StackEmptyException {
		if(top==null)
			throw new StackEmptyException();
		return top.data;
	}
	
	public void push(int e) {
		Node<Integer> n=new Node<>(e);
		n.next=top;
		top=n;
		size++;
	}
	
	public int pop() throws StackEmptyException {
		if(size==0)
			throw new StackEmptyException();
		int temp=top.data;
		top=top.next;
		size--;
		return temp;
	}

}

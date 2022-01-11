package stacks;


class doubleNode{
	int data;
	doubleNode next;
	doubleNode prev;
	doubleNode(int data){
		this.data=data;
		next=null;
		prev=null;
	}
}
public class StackforMiddleElementOperations {
	
	private int size;        //size variable so that we don't have to traverse the whole LL to find length
	private doubleNode top; //head of the linked list
	private doubleNode mid;
	
	StackforMiddleElementOperations(){
		size=0;
		top=null;
		mid=null;
	}
	
	
	
	public void push(int x) {
		doubleNode n=new doubleNode(x);
		size++;
		if(top==null) {
			mid=n;
			top=n;
		}
		else {
		n.next=top;
		top.prev=n;
		top=n;
		if(size%2!=0) 
			mid=mid.prev;
		}
		return;
	}
	
	public int pop() {
		if(top==null)
			return -1;
		if(top.next==null) {
			int temp=top.data;
			top=null;
			mid=null;
			return temp;
		}
		int temp=top.data;
		top=top.next;
		top.prev=null;
		if(size%2==0) 
			mid=mid.next;
		size--;
		return temp;
		}
		
	public int middle() {
		if(size%2==0)
			return mid.prev.data;
		else
			return mid.data;
	}
	
	public int peek() {
		return top.data;
	}
	public void deleteMiddle() {
		
		doubleNode prev=mid.prev;
		doubleNode next=mid.next;
		prev.next=next;
		next.prev=prev;
		
	}
	

public static void main(String args[]) {
	StackforMiddleElementOperations s=new StackforMiddleElementOperations();
	
	for(int i=0;i<10;i++) {
		s.push(i);
//		System.out.println(s.peek());
	}
	
    System.out.println(s.middle());
	
	s.deleteMiddle();
//	
//	for(int j=0;j<5;j++)
//		System.out.println(s.p());
	

	
	for(int j=0;j<10;j++)
		System.out.println(s.pop());
	
	
	
	
}


}

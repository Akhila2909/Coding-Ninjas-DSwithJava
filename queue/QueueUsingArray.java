package queue;

public class QueueUsingArray{
	private int data[];
	private int front;//points to 1st element in queue
	private int rear; //points to last element in queue
	private int size; //size of queue
	
	QueueUsingArray(){
	 data=new int[10];
	 front=-1;
	 rear=-1;
	 size=0;
	 
	}
	
	QueueUsingArray(int capacity){
	     data=new int[capacity];
		 front=-1;
		 rear=-1;
		 size=0;
		 
	}
	
	int front() throws QueueEmptyException { //returns front element 
		if(size == 0){
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	
	boolean isEmpty() {
		return size==0;
	}
	
	int size() {
		return size;
	}
	
	void enqueue(int element) {
		if(size()==data.length) {
			doubleCapacity();
		}
		
		if(size()==0) { //set front to 0 for 1st element
			front=0;
		}
		
		rear=(rear+1)%data.length; //if rear<length then ++ else starts from front
		
		data[rear]=element;
		
		size++;
		
	}
	
	int dequeue() throws QueueEmptyException {
		if(size()==0) {
			throw new QueueEmptyException();
		}
		
		int temp=data[front];
		
		front=(front+1)%data.length; //front++ or reset front to front of Q if capacity left
		
		size--;
		

		if(size()==0) { //the only element in Q was removed so reset pointers
			front=-1;
			rear=-1;
		}
		
		return temp;
		
		
	}
	
	void doubleCapacity(){
		int n=data.length;
		int[] temp=data;
		data=new int[n*2];
		int k=0;
		for(int i=front;i<n;i++) {
			data[k++]=temp[i];
		}
		for(int i=0;i<front;i++)
			data[k++]=temp[i];
		front=0;
		rear=n-1;	
	}
	
	
	

}

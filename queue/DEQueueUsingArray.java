package queue;

public class DEQueueUsingArray {
	
	private int[] data;
	private int front;
	private int rear;
	private int size;
	
	DEQueueUsingArray(){
		data=new int[10];
	    front=-1;
	    rear=-1;
	}
	
	DEQueueUsingArray(int capacity){
		data=new int[capacity];
	    front=-1;
	    rear=-1;
	}

	boolean isEmpty(){
		return rear==-1;
	}
	
	int size(){
		return size;
	}
	
//	void doubleCapacity() {
//		int[] temp=data;
//		data=new int[temp.length];
//		for(int i=0;i<temp.length;i++) {
//			
//		}
//	}
	
	void enqueueF(int element) throws QueueFullException{
		if(size()==data.length||(front==-1 && rear!=-1))
			throw new QueueFullException();
		size++;
		data[front]=element;
		front--;
	}
	
	void enqueueR(int element) throws QueueFullException{
		if(rear==size()-1)
			throw new QueueFullException();
		data[rear]=element;
		rear++;
		size++;
	}
	
	
	int dequeueF() throws QueueEmptyException{
		if(size()==0)
			throw new QueueEmptyException();
		int temp=data[front];
		front++;
		size--;
		if(size()==0) {
			front=-1;
			rear=-1;
		}
		
		return temp;
	}
	
	int dequeueR() throws QueueEmptyException{
		if(size()==0)
			throw new QueueEmptyException();
		int temp=data[rear];
		rear--;
		size--;
		if(size()==0) {
			front=-1;
			rear=-1;
		}
		
		return temp;
	}
	
	

}

z1q+package queue;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class QueueUsingLinkedList { //dynamic itself

private Node front;
private Node rear;
private int size;


public QueueUsingLinkedList() {
	front=null;
    rear=null;
    size=0;
}


public int getSize() { 
	return size;
}


public boolean isEmpty() { 
	return getSize()==0;
}


public void enqueue(int data) {
     Node temp=new Node(data);
	if(getSize()!=0){ 		//not empty 
        rear.next=temp;		//attach at rear 
        rear=rear.next;		//update rear
    }
    else{					//empty so front & rear point to this
        front=temp;
        rear=temp;
    }
    size++;
}


public int dequeue() {
	if(front!=null){          //not empty
        int temp=front.data;
        front=front.next;     //remove from front 
          size--;
        if(getSize()==0)      //if last node was removed reset pointers(front did due to .next step)
            rear=null;
        
        return temp;
    }
    else
        return -1;
}


public int front() {
	if(front!=null)
        return front.data;
    else
        return -1;
}
}

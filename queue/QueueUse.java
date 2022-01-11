package queue;

public class QueueUse {

	public static void main(String[] args) throws QueueFullException,QueueEmptyException {
		DEQueueUsingArray q=new DEQueueUsingArray();
		
		q.enqueueF(23);
		q.enqueueR(34);
		
		System.out.println(q.dequeueF());
		System.out.println(q.dequeueR());
		

	}

}

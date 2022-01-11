package linkedList;

import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> takeInput(){			// LL INPUT
		Scanner sc=new Scanner(System.in);
		Node<Integer> head=null,tail=null;
		int data=sc.nextInt();
		while(data!=-1) {								//-1 means user finished his LL
			Node<Integer> newNode=new Node<>(data);
			if(head==null) {
				head=newNode;
				tail=newNode;
			}
			else {
				tail.next=newNode;
				tail=newNode;
			}
		 data=sc.nextInt();
		}
		return head;
		
	}
	
	public static int lengthOfLL(Node<Integer> head) { 	// LENGTH OF LL
		int l=0;
		while(head!=null) {
			head=head.next;
			l++;
		}
		return l;
	}
	
	public static void printIthNode(Node<Integer> head,int i) { //PRINT Ith NODE
		
		
		while(i>0 && head!=null)
		{
			head=head.next;
			i--;
		}
		
		//if i out of LL indexes or empty list
		if(head==null) 
			return;
		
		System.out.println(head.data);
	}
	
	public static void printLinkedList(Node<Integer> head) { // PRINT LL
		//head here is just a local pointer where 1st node's address will be passed & it will point to it
		
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
		
	}
	
	public static Node<Integer> insert(Node<Integer> head,int data,int position){// INSERT AT Ith POSITION
		Node<Integer> newNode=new Node<>(data);
		Node<Integer> temp=head;

		if(position==0) {
			newNode.next=head;
			head=newNode;
		}
		else {
			while(position!=1 && temp!=null) {
				temp=temp.next;
				position--;
			}
			//temp is on previous node of where new node has to be inserted now
			
			if(temp==null)
				return head;
			//if prev node is null (out of LL) then return head as can't insert node after this
			
			newNode.next=temp.next;
			temp.next=newNode;
		}
		return head;
	}
	public static Node<Integer> deleteNode(Node<Integer> head,int pos){ //DELETE NODE
		Node<Integer> temp=head;
		if(head==null)
			return head;
		if(pos==0) {
			return(head.next);
		}
		else
		{
			while(pos!=1 && temp!=null) {
				temp=temp.next;
				pos--;
			}
			//temp is on the prev node of node which has to be deleted
			
			if(temp==null||temp.next==null)
				return head;
			//if prev node is last node or null (out of LL) then return head as can't delete next node
			
			temp.next=temp.next.next;
		
		}
		return head;
	}
	
	public static int indexOfNode(Node<Integer> head,int n) { //INDEX OF NODE
		int c=0;
		while(head!=null) {
			if(head.data==n)
				return c;
			c++;
			head=head.next;
		}
		return -1;
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> head){ // REMOVE DUPLICATES
		
		if(head==null||head.next==null)// 0 or 1 node means no duplicates
			return head;
		Node<Integer> temp=head;
		while(temp.next!=null) {
			if(temp.data==temp.next.data) 
				temp.next=temp.next.next;
			temp=temp.next;
		}
		return head;
	}
	
	public static void printReverse(Node<Integer> root) { //PRINT LL IN REVERSE
		 if(root==null)
           return;
		printReverse(root.next);
       System.out.print(root.data+" ");
	}
	public static Node<Integer> Reverse(Node<Integer> root) { //REVERSE LL
        
        if(root==null ||root.next==null)
            return root;
        
        Node<Integer> curr=root;
        Node<Integer> prev=null;
        Node<Integer> next=null;
        
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
	}
public static Node<Integer> Reverse2(Node<Integer> head) { //REVERSE LL (2)
        
        if(head==null ||head.next==null)
            return head;
        
        Node<Integer> rev=Reverse2(head.next);
        
        head.next.next=head;
        
        head.next=null;
        
        return rev;
        
	}

public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) { //APPEND LAST N NODES TO FIRST
	
    if(n==0 ||head==null||head.next==null)
        return head;
    
    Node<Integer> slow=head,fast=head;
    
    for(int i=0;i<n;i++)
        fast=fast.next;
    
    //fast is n nodes ahead of slow
    
    while(fast.next!=null){
        fast=fast.next;
        slow=slow.next;
    }
    
    //fast is at last node
    //slow is at last (n-1)th node
    //now change links
    
    fast.next=head;
    head=slow.next;
    slow.next=null;
    return head;
}

public static boolean isPalindrome(Node<Integer> head) {// CHECK PALINDROME LL
    
    if(head==null||head.next==null)
        return true;
    
	Node<Integer> slow=head,fast=head;
	
    while(fast.next!=null&& fast.next.next!=null){
        fast=fast.next.next;
    	slow=slow.next;
    }
    
    Node<Integer> newhead=Reverse2(slow.next);
    
    while(newhead!=null && head!=null){
        if(!head.data.equals(newhead.data))
            return false;
		head=head.next;
        newhead=newhead.next;
    }
    
    return true;
}
	
public static Node<Integer> midPoint(Node<Integer> head) { //MIDPOINT OF LL
    
    if(head==null ||head.next==null)
        return head;
   
    Node<Integer> fast=head,slow=head;
    while(fast.next!=null && fast.next.next!=null){
        fast=fast.next.next;
    	slow=slow.next;
    }
    return slow;
}

public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {// MERGE 2 SORTED LL
	Node<Integer> h3=null,t3=null; //point to H & T of new List
	Node<Integer> t1=head1, t2=head2; //pointers to travel the lists
    
    if(head1==null)
        return head2;
    if(head2==null)
        return head1;
    if(t1.data<=t2.data){
        h3=t1;
        t3=t1;
        t1=t1.next;
    }
    else{
        h3=t2;
        t3=t2;
        t2=t2.next;
    }
    
    while(t1!=null && t2!= null){
        if(t1.data<=t2.data){
        t3.next=t1;
        t3=t3.next;
        t1=t1.next;
   		}
   		else{
        t3.next=t2;
        t3=t3.next;
        t2=t2.next;
    	}
    }
    if(t1!=null)
        t3.next=t1;
    else
        t3.next=t2;
    
    return h3;
}


public static Node<Integer> mergeSort(Node<Integer> head) { //MERGE SORT 2 LL
    if(head==null||head.next==null)
        return head;
    Node<Integer> mid=midPoint(head);
    Node<Integer>head2=mid.next;
    mid.next=null;
    Node<Integer> first=mergeSort(head);
    Node<Integer> second=mergeSort(head2);
    Node<Integer> merged=mergeTwoSortedLinkedLists(first,second);
    return merged;
}

public static Node<Integer> insertRecursively(Node<Integer> head,int pos,int number){// INSERT RECURSIVELY
	if(pos==0) {
		Node<Integer> n=new Node<>(number);
		n.next=head;
		head=n;
		return head;
	}
	if(head==null) {
		return head;
	}
	Node<Integer> inserted=insertRecursively(head.next,pos-1,number);
	head.next=inserted;
	return head;
	
}
public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {// DELETE NODE REC
	if(head==null)
        return head;
    if(pos==0){
        return head.next;
    }
    Node<Integer> deleted=deleteNodeRec(head.next,pos-1);
    head.next=deleted;
    return head;
}
public static int findNodeRec(Node<Integer> head, int n) {  //FIND NODE REC
    return findNodeRec(head,n,0); 
    
}
public static int findNodeRec(Node<Integer> head, int n,int index) {
	if(head==null) //list empty or not present in whole list
        return -1;
    if(head.data==n) //base case
    	return index;
    return findNodeRec(head.next,n,index+1); //search in remaining list
    
}

public static Node<Integer> evenAfterOdd(Node<Integer> head) { //EVEN NODES AFTER ODD
	Node<Integer> curr=head,eh=null,et=null,oh=null,ot=null;
    
    if(head==null||head.next==null)
        return head;
    
    while(curr!=null){
		if(curr.data%2==0){//even
            if(eh==null){
                eh=curr;
                et=curr;
            }
            else
            {
                et.next=curr;
                et=et.next;
            }
    	}
        else
        {
             if(oh==null){
                oh=curr;
                ot=curr;
            }
            else
            {
                ot.next=curr;
                ot=ot.next;
            }
        }
        curr=curr.next;
}
   if(oh==null) {
		return eh;
	}
	if(eh==null) {
		return oh;
	}
	ot.next=eh;
	et.next=null;//the last even node next has to be made null
	return oh;
  
}
public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) { //SKIP M DELETE N
    
	if(N==0)
        return head;
	if(M==0)
        return null;
	Node<Integer> curr=head,temp=null;
   while(curr!=null)
   {
	   //traverse node which are to be kept
       for(int i=1;i<M;i++) 
       {
           curr=curr.next;
           //LL over so no nodes left to delete so return head
           if(curr==null)    
               return head;	
           
       }
       
       //curr at mth node so deleting from next node
       temp=curr.next;      
       
       //traverse nodes which have to be deleted
       for(int i=0;i<N;i++) 
       {
           temp=temp.next;
           //no more left to delete
           if(temp==null)
               break;      
       }
       
       //temp at n+1 th node so curr has to point to this now
       //curr has to move to next set
       curr.next=temp;     
       curr=temp;          
   }
    
return head;
}


public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) { // SWAP 2 NODES
	Node<Integer> p1=null,p2=null,c1=null,c2=null,temp=head;int pos=0;
    
    if(head==null||i==j) 
        return head;
    
    // find the nodes at positions and their previos nodes
    while(temp!=null) 
    {
        if(pos==i-1)
        {
            p1=temp;
            c1=temp.next;
        }
         if(pos==j-1)
        {
            p2=temp;
            c2=temp.next;
        }
        pos++;
        temp=temp.next;
    }
    
    //if prev is null it means the node is head so other node becomes head due to swap
    //else change the links of prev nodes as curr node is stored in c1,c2 so the link can be broken
    if(p1!=null)   
        p1.next=c2;
    else
        head=c2;
    
    if(p2!=null)
        p2.next=c1;
    else
        head=c1;
    
    //change the links of curr nodes 
    //store one of their nexts because that is not stored
    temp=c2.next;
    c2.next=c1.next;
    c1.next=temp;
    
        
    return head;
}

public static Node<Integer> kReverse(Node<Integer> head, int k) { // KReverse
	if(k==0||k==1||head==null)
        return head;
    
	Node<Integer> curr=head,prev=null,next=null,revk=null;
    
    int count=0;
    
    //Reverse the first k nodes
    while(count!=k && curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        count++;
    }
    
    //let recursion K reverse the rest
    if(next!=null)
       revk= kReverse(next,k);
    
    head.next=revk;
    
    return prev;
}
	public static void main(String[] args) {
		
		Node<Integer> head=takeInput();
//		printLinkedList(head);
//		System.out.println(lengthOfLL(head));
//		printIthNode(head,2);
//		Node<Integer> head1=insert(head,100,3);
//		printLinkedList(head1);
//		Node<Integer> head2=deleteNode(head,3);
//		printLinkedList(head2);
//		System.out.println(indexOfNode(head2,100));
//		Node<Integer> head3=removeDuplicates(head);
//		printLinkedList(head3);
//		Node<Integer> head4=Reverse2(head);
//		printLinkedList(head4);
		Node<Integer> head4=insertRecursively(head,5,100);
		printLinkedList(head4);		
		
	}

}

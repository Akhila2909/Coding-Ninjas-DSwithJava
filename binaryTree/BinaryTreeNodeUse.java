package binaryTree;
import java.util.*;
public class BinaryTreeNodeUse {
	
	
	public static BinaryTreeNode<Integer> takeInput(Scanner sc){
		int rootData;
		System.out.println("Enter next node");
		rootData=sc.nextInt();
		if(rootData==-1)
			return null;
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		root.left=takeInput(sc);
		root.right=takeInput(sc);
        return root;
	}
	
	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.print(root.data+": ");
		
		if(root.left!=null) {
			System.out.print("L:"+root.left.data);
		}
		
		if(root.right!=null) {
			System.out.print(" R:"+root.right.data);
		}
		
		System.out.println();
		print(root.left);
		print(root.right);
	}
	
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter root data");
		n=sc.nextInt();
		if(n==-1)
			return null;
		
		Queue<BinaryTreeNode<Integer>>q=new LinkedList<>();
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(n);
		
		q.add(root);
		
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> front=q.poll();
			System.out.println("Enter left child of "+front.data);
			int left=sc.nextInt();
			if(left!=-1) {
				BinaryTreeNode<Integer> l=new BinaryTreeNode<>(left);
				front.left=l;
				q.add(l);
			}
			System.out.println("Enter right child of "+front.data);
			int right=sc.nextInt();
			if(right!=-1) {
				BinaryTreeNode<Integer> r=new BinaryTreeNode<>(right);
				front.right=r;
				q.add(r);
			}	
		}
		return root;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root==null)
            return;
        Queue<BinaryTreeNode<Integer>> remainingNodes=new LinkedList<>();
        remainingNodes.add(root);
        while(!remainingNodes.isEmpty())
        {
            BinaryTreeNode<Integer> front=remainingNodes.poll();
        
            int leftdata=-1,rightdata=-1;
            if(front.left!=null)
            {
                leftdata=front.left.data;
                remainingNodes.add(front.left);
            }
            if(front.right!=null)
            {
                rightdata=front.right.data;
                remainingNodes.add(front.right);
            }
            String s=front.data+":L:"+leftdata+",R:"+rightdata;
        System.out.println(s);
	}
	}
	
	
	public static int noOfNodes(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		return (noOfNodes(root.left)+noOfNodes(root.right)+1);
	}
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    if(root==null)
            return false;
        if(root.data.equals(x))
            return true;
        if(isNodePresent(root.left,x)||isNodePresent(root.right,x))
            return true;
        else
            return false;
            
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
	}
	
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null)
            return;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        BinaryTreeNode<Integer> temp=root.left;
        root.left=root.right;
        root.right=temp;
        return ;
       
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		int option1=diameter(root.left);
		int option2=diameter(root.right);
		int option3=height(root.left)+height(root.right);
		return Math.max(Math.max(option1, option2),option3);
		
	}

	
	public static Pair<Integer,Integer> diameterBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			Pair<Integer,Integer> d=new  Pair<>();
			d.first=0;
			d.second=0;
			return d;
		}
		Pair<Integer,Integer>  left=diameterBetter(root.left);
		Pair<Integer,Integer>  right=diameterBetter(root.right);
		int option1=left.first+right.first;
		int option2=left.second;
		int option3=right.second;
		int diameter=Math.max(option1, Math.max(option2, option3));
        int height=Math.max(left.first,right.first)+1;
        
		Pair<Integer,Integer>  output=new Pair<>();
		output.first=height;
		output.second=diameter;
		
		return output;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static ArrayList<Integer> leftView(BinaryTreeNode<Integer> root) //using Level Order T
    {
      Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
      ArrayList<Integer> ans=new ArrayList<>();
      
      if(root==null)
        return ans;
        
      q.add(root);
      
      while(!q.isEmpty()){
          int size=q.size();
    	  for(int i=1;i<=size;i++)
    	  {
    		  BinaryTreeNode<Integer> front=q.poll();
    	      if(i==1)
    	        ans.add(front.data);
    	      if(front.left!=null)
    	        q.add(front.left);
    	       if(front.right!=null)
                 q.add(front.right);
    	  }
    	  
      }
     return ans; 
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BinaryTreeNode<Integer> root=takeInputLevelWise();
//		

		ArrayList<Integer> a=leftView(root);
		for(int x:a)
			System.out.print(x+" ");
		

	}

}

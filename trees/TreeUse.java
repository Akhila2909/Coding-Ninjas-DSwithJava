package trees;

import java.util.*;

public class TreeUse {
	
	public static TreeNode<Integer> takeInput(Scanner sc){
		
		System.out.println("Enter next Node");
		int data=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<>(data);
		System.out.println("Enter no of children of "+data);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc=new Scanner(System.in);
		Queue<TreeNode<Integer>> q=new LinkedList<>();
		System.out.println("Enter root Node");
		int data=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<>(data);	
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> frontNode=q.poll();
			System.out.println("Enter no of children of "+frontNode.data);
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("Enter "+(i+1)+"th child of "+frontNode.data);
				TreeNode<Integer> child=new TreeNode<>(sc.nextInt());
				frontNode.children.add(child);
				q.add(child);
			}
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		System.out.print(root.data+":");   //printing root
		
		for(int i=0;i<root.children.size();i++)
			System.out.print(root.children.get(i).data+","); //printing roots children
		System.out.println();
		
		for(int i=0;i<root.children.size();i++)
			print(root.children.get(i));  //printing it's children  by calling the function recursively
		
		
	}
	public static void printLevelWise(TreeNode<Integer> root){
		if(root==null)
			return;
		Queue<TreeNode<Integer>> q=new LinkedList<>();
	    q.add(root);
	    q.add(null);
	    while(q.size()>1){
	        if(q.peek()!=null){
	        TreeNode<Integer> front=q.poll();
	        System.out.print(front.data+" ");
	        for(int i=0;i<front.children.size();i++)
	        {
	            q.add(front.children.get(i));
	        }
	        }
	        else{
	            q.poll();
	            q.add(null);
	            System.out.println();
	        }
	    }
	        
		}
	
	
	public static int noOfChildren(TreeNode<Integer> root) {
		if(root==null)
			return 0;
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			count+=noOfChildren(root.children.get(i));
		}
		return count;
		
	}
	public static int sumOfAllNode(TreeNode<Integer> root){
		 if(root==null)
	         return 0;
	     int sum=root.data;
	     for(int i=0;i<root.children.size();i++){
	      sum+=sumOfAllNode(root.children.get(i)); 
	     }
	        return sum;
	    }
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){
	      if(root==null)
	          return Integer.MIN_VALUE;
	      int subtreecount=0;
	      for(int i=0;i<root.children.size();i++) {
			subtreecount+=numNodeGreater(root.children.get(i),x);
	      }
	      if(root.data>x)
	          return subtreecount+1;
	      else
	          return subtreecount;
	}
	
	public static int getHeight(TreeNode<Integer> root){ //height:no of levels in a tree
		if(root==null)
            return 0;
        int height=0;
        for(int i=0;i<root.children.size();i++){
            height=Math.max(getHeight(root.children.get(i)),height);
        }
        return height+1;
	}
	
	public static int findDepthofNode(TreeNode<Integer> root ,int node) { //depth:distance from root
		if(root==null)
			return -1;
		if(root.data==node)
			return 0;
		int smallAns=0;
		for(int i=0;i<root.children.size();i++) {
		    smallAns=findDepthofNode(root.children.get(i), node);
			if(smallAns!=-1)
				return 1+smallAns;
		}	
		return smallAns;
	}
	
	public static void printNodesatDepthK(TreeNode<Integer> root ,int depth) { //depth:distance from root
		if(root==null)
			return;
		
		if(depth==0) {
			System.out.print(root.data);
		     return ;
		}
		
		for(int i=0;i<root.children.size();i++) {
		     printNodesatDepthK(root.children.get(i),depth-1);
		}	
	}
	
	
	public static int noOfLeafNodes(TreeNode<Integer> root) {
		if(root==null)
			return 0;
		if(root.children.size()==0)
			return 1;
		int count=0;
		for(int i=0;i<root.children.size();i++) 
			count+=noOfLeafNodes(root.children.get(i));
		return count;
	}
	
	public static void preOrderTraversal(TreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.println(root.data);
		for(int i=0;i<root.children.size();i++)
			preOrderTraversal(root.children.get(i));
	}
	
	
	public static void postOrderTraversal(TreeNode<Integer> root) {
		if(root==null)
			return;
		for(int i=0;i<root.children.size();i++)
			postOrderTraversal(root.children.get(i));
		System.out.println(root.data);
		
	}
	
	public static boolean containsNode(TreeNode<Integer> root,int node) {
		if(root==null)
			return false;
		if(root.data==node) 
			return true;
		
		for(int i=0;i<root.children.size();i++) {
			if(containsNode(root.children.get(i),node)) //if child subtrees return T then only return true
					return true;			
		}
		return false; //comes here only if not found in any of the subtrees so return false
	}
	
	
	//sum=sum of node data & node's children's data
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){ 
		if(root==null)
            return root;
        
        TreeNode<Integer> ans=root;
        int sum=root.data;
        for(int i=0;i<root.children.size();i++)
           sum+=root.children.get(i).data;
        
        for(int i=0;i<root.children.size();i++){
           TreeNode<Integer> smallAns=maxSumNode(root.children.get(i));
           int smallSum=smallAns.data;
              for(int j=0;j<smallAns.children.size();j++)
                  smallSum+=smallAns.children.get(j).data;
            if(smallSum>sum)
            {
                sum=smallSum;
                ans=smallAns;
            }
	    }
	
		 return ans;
   }
	
	
		
		public static TreeNode<Integer> maxSumNode2(TreeNode<Integer> root){ //better
			return (maxSumNode2Helper(root).node);
		}
		
		public static class Pair{
		       TreeNode<Integer> node;
		       int sum;
		        
		    }
		
	    public static Pair maxSumNode2Helper(TreeNode<Integer> root){
			if(root==null)
	        {
	            Pair p=new Pair();
	            return p;
	        }
	        
	        
	        int sum=root.data;
	         for(int i=0;i<root.children.size();i++)
	             sum+=root.children.get(i).data;
	        
	        Pair ans=new Pair();
	        ans.node=root;
	        ans.sum=sum;
	        
	        for(int i=0;i<root.children.size();i++){
	            Pair temp=maxSumNode2Helper(root.children.get(i));
	            if(temp.sum>ans.sum){
	                ans=temp;
	            }
	        }
	            
	      return ans; 
	        
		}
	    
		public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

			if(root1==null && root2==null)
	            return true;
	        if(root1==null||root2==null||(root1.children.size()!=root2.children.size())||(!root1.data.equals(root2.data)))
	            return false;
	        if(root1.data.equals(root2.data))
	        {
	            for(int i=0;i<root1.children.size();i++){
	                boolean smallAns=checkIdentical(root1.children.get(i),root2.children.get(i));
	                if(!smallAns)
	                    return false;
	            }
	 
	        }
	           return true;
		}
		
		
		public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
			
	        if(root==null)
	            return null;
	        
	        TreeNode<Integer> ans=null;
	        
	        if(root.data>n)
	            ans=root;
	        
	        for(int i=0;i<root.children.size();i++){
	        TreeNode<Integer> temp=findNextLargerNode(root.children.get(i),n);
	            if(temp!=null){
	            if(ans==null||temp.data<ans.data && temp.data>n)
	                ans=temp;
	            }
	        }
	        return ans;
	    
		}
		
		
		public static void replaceWithDepthValue(TreeNode<Integer> root){

	        if(root==null)
	            return;
			replaceWithDepthValue(root,0);
			
		}
	    public static void replaceWithDepthValue(TreeNode<Integer> root,int level){
	        root.data=level;
	        for(TreeNode<Integer> child:root.children)
	          replaceWithDepthValue(child,level+1);
		}
	    
	    // Pointers to store the largest and second largest node
	    public static TreeNode<Integer> largest;
	    public static TreeNode<Integer> secondLargest;
	    
		
		public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
	        largest = new TreeNode<Integer>(Integer.MIN_VALUE); //both initialized with -infinity
	        secondLargest = largest;
	        
	        findSecondLargestHelper(root);
	        return secondLargest;
		}
		

		public static void findSecondLargestHelper(TreeNode<Integer> root)
	    {
	        
	        if (root == null) {
	            return;
	        }
	        
	         if (root.data > largest.data) {
	            secondLargest = largest;
	            largest = root;
	        } else if (root.data > secondLargest.data && root.data != largest.data)
	            secondLargest = root; 
	        // recursively find second largest in children
	        for (TreeNode<Integer> child: root.children)
	            findSecondLargestHelper(child);         
	          }    


	public static void main(String[] args) {	
		Scanner sc=new Scanner(System.in);
//		TreeNode<Integer> rootNode=takeInput(sc);
		TreeNode<Integer> rootNode=takeInputLevelWise();
//        print(rootNode);
//        System.out.println();
//        System.out.println(findDepthofNode(rootNode,5));
//        printNodesatDepthK(rootNode,1);
		  postOrderTraversal(rootNode);
       
	}
}

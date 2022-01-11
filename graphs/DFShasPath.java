package graphs;

import java.util.Scanner;

public class DFShasPath {
	
	//if all adjacent vertices of start vertice does not have a path to the target vertice it means start vertice does not have a path to it

	 public static void hasPathDFS(int[][] edges,int x,int y){
		  if(x>=edges.length||y>=edges.length||x<0||y<0){
              System.out.println(false);
              return;
           }
	        boolean[] visited=new boolean[edges.length]; 
	        System.out.println(hasPathDFS(edges,x,y,visited));
	     }
	     
	      public static boolean hasPathDFS(int[][] edges,int x,int y,boolean[] visited){
	     
	         if(edges[x][y]==1)  							    //if target is adjacent automatically the edge is the  path
	             return true;
	          
	         visited[x]=true;
	     
	         for(int i=0;i<edges.length;i++)                   //cheking all adj vertices for a path 
	         {
	             if(edges[x][i]==1 && !visited[i]) 
	                 if(hasPathDFS(edges,i,y,visited)==true)   //if any adj vertice has a path means it also has a path
	                 	return true;
	         }
	         return false;
	      }

	      
	      
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();                        	//no of vertices
		int[][] edges=new int[n][n];              	//adjacency matrix
		int e=sc.nextInt();						  	//no of edges
		for(int i=0;i<e;i++)
		{
			int fv=sc.nextInt(); 					//1st vertex of the edge
			int sv=sc.nextInt(); 					//2nd vertex of the edge
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		}
		int x=sc.nextInt(); 					    
	    int y=sc.nextInt(); 		
		hasPathDFS(edges,x,y);

	}

}

package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFShasPath {
	
	
	  public static void hasPathBFS(int[][] edges,int x,int y){
          if(x>=edges.length||y>=edges.length||x<0||y<0){
               System.out.println(false);
               return;
         }
          boolean[] visited=new boolean[edges.length]; 
          System.out.println(hasPathBFS(edges,x,y,visited));
       }
      
      public static boolean hasPathBFS(int[][] edges,int x,int y,boolean[] visited){
    	  
    	  //every vertice we add in queue has a path to starting vertice 
    	  //we check if any of these is adjacent to the target vertice

          Queue<Integer> q=new LinkedList<>();
          q.add(x);
          visited[x]=true;
          while(!q.isEmpty()){
              int front=q.poll();
              if(edges[front][y]==1)
                  return true;
              for(int i=0;i<edges.length;i++)
              {
                  if(edges[front][i]==1 && !visited[i]){
                      q.add(i);
                      visited[i]=true;
                   }
              }
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
		hasPathBFS(edges,x,y);
	}

}

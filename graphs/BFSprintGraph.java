package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSprintGraph {

	 public static void bfs(int[][] edges){
	        boolean[] visited=new boolean[edges.length];
	        for(int i=0;i<edges.length;i++)
	            if(!visited[i])
	                bfsHelper(edges,visited,i);
	    }
	    
	    public static void bfsHelper(int[][] edges,boolean[] visited,int sv){
	        Queue<Integer> q=new LinkedList<>();
	        q.add(sv);
	        visited[sv]=true;
	        while(!q.isEmpty()){
	            int front=q.poll();
	            System.out.print(front+" ");
	            for(int i=0;i<edges.length;i++){
	                if(edges[front][i]==1 && (!visited[i])){
	                    q.add(i);
	                    visited[i]=true;
	                }
	        } 
	    }
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
			bfs(edges);
		}

	}

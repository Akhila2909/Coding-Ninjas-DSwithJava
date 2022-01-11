package graphs;
import java.util.*;
public class DFSprintGraph {
	
	
	public static void print(int[][] edges) {
		int n=edges.length;
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++) {                       //so that all connected componenets are visited
			if(!visited[i])     
				printHelper(edges,i,visited);
		}
	}
	
	public static void printHelper(int[][] edges,int sv,boolean[] visited) {
		System.out.println(sv);
		visited[sv]=true;
		int n=edges.length;
		for(int i=0;i<n;i++)
		{
			if(edges[sv][i]==1 && !visited[i])
				printHelper(edges,i,visited);
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
		print(edges);
	}

}

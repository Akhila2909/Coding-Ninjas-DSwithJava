package graphs;

import java.util.Scanner;

public class IsConnected {
	
	//Check if a graph is connected or not

    public static boolean isConnected(int[][] edges){
        if(edges.length==0)
            return true;
        boolean[] visited=new boolean[edges.length];
        DFS(edges,0,visited);
        for(int i=0;i<edges.length;i++)
            if(visited[i]==false)
                return false;  
        return true;
    }
    
    
    public static void DFS(int[][] edges,int sv,boolean[] visited){
        
        visited[sv]=true;
        
        for(int i=0;i<edges.length;i++){
         if(edges[sv][i]==1 && !visited[i]) 
            DFS(edges,i,visited);
        }
        
    }
    

	public static void main(String[] args) throws NumberFormatException{
                Scanner sc=new Scanner(System.in);
				int n=sc.nextInt();                        	
				int[][] edges=new int[n][n];              	
				int e=sc.nextInt();						  	
				for(int i=0;i<e;i++)
				{
					int fv=sc.nextInt(); 					//1st vertex of the edge
					int sv=sc.nextInt(); 					//2nd vertex of the edge
					edges[fv][sv]=1;
					edges[sv][fv]=1;
				}		
				System.out.println(isConnected(edges));
	}

}

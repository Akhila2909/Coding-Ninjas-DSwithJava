package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSgetPath {
	
	
	public static void getPathDFS(int[][] edges,int x,int y){
	       if(x>=edges.length||y>=edges.length||x<0||y<0)  
	           return;
	       boolean visited[]=new boolean[edges.length];
	       ArrayList<Integer> ans=getPathDFS(edges,x,y,visited);
	       if(ans!=null){
	       for(int a:ans)
	           System.out.print(a+" ");
	       }
	        
	    }
	    
	     public static ArrayList<Integer> getPathDFS(int[][] edges,int sv,int ev,boolean[] visited){
	         if(sv==ev) //reached the end 
	         {
	             ArrayList<Integer> a=new ArrayList<>();
	             a.add(ev);
	             return a;
	         }
	         
	         visited[sv]=true;
	         
	         for(int i=0;i<edges.length;i++){
	                   if(edges[sv][i]==1 && !visited[i]){
	                   		ArrayList<Integer> smallAns=getPathDFS(edges,i,ev,visited);
	                   if(smallAns!=null){
	                       smallAns.add(sv);
	                       return smallAns;
	                   }
	                }  
	             }  
	         
	         return null;
	    }
	      
	    
	    
		public static void main(String[] args){
	        
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
			getPathDFS(edges,x,y);

		}
	}

package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReturnAllConnectedComponents {

	 private static ArrayList<ArrayList<Integer>>  connectedComp(int[][] edges) {	
	        
			ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
			
			boolean[] visited=new boolean[edges.length];
	        
			for(int i=0;i<edges.length;i++) {
	            if(!visited[i]){
	            ArrayList<Integer> smallAns=new ArrayList<>();
				DFS(edges,i,visited,smallAns);
				ans.add(smallAns);
	            }
			}
			
	        return ans;
		}
	    
		private static void DFS(int[][] edges, int sv, boolean[] visited,ArrayList<Integer> smallAns) {
			visited[sv]=true;
	        smallAns.add(sv);
	        
			for(int i=0;i<edges.length;i++) {
				if(edges[sv][i]==1 && !visited[i])
					DFS(edges,i,visited,smallAns);
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
	        if(edges.length==0)
	            return ;
	        
	        ArrayList<ArrayList<Integer>> ans=connectedComp(edges);
	           for(ArrayList<Integer> a:ans){
	               Collections.sort(a);
	            for(int i:a)
	                System.out.print(i+" ");
	            System.out.println();
	        }
		}

	}
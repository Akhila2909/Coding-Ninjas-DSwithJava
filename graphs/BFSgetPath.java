package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSgetPath {
	 public static void getPathBFS(int[][] edges,int sv,int ev){
	        boolean[] visited=new boolean[edges.length];
	        getPathBFS(edges,sv,ev,visited);
	    }
	    
	     public static void getPathBFS(int[][] edges,int sv,int ev,boolean[] visited){
	         
	         Queue<Integer> q=new LinkedList<>();
	         
	         HashMap<Integer,Integer> h=new HashMap<>();
	         
	         q.add(sv);
	         h.put(sv,-1);
	         visited[sv]=true;
	         
	         while(!q.isEmpty()){
	             
	             int front=q.poll();
	             
	             for(int i=0;i<edges.length;i++)
	             {
	                 if(edges[front][i]==1 &&!visited[i])
	                 {
	                     q.add(i);
	                     visited[i]=true;
	                     h.put(i,front);
	                     
	                     if(i==ev){
	                         while(ev!=-1){
	            				 System.out.print(ev+" ");
	             				 ev=h.get(ev);   
	            			}
	                    return;   
	                     }
	                 }
	              }
	          }
	         
	     }
	 
		
		public static void main(String[] args)  throws NumberFormatException{
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
				int x=sc.nextInt(); 					    
			    int y=sc.nextInt(); 		
				getPathBFS(edges,x,y);
		}
	}


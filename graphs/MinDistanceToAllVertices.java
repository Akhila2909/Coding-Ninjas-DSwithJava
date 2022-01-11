package graphs;

import java.util.Scanner;

public class MinDistanceToAllVertices {

	public static int findMinVertex(int[] distance,boolean[] visited){
        
        int minVertex=-1;
      
        for(int i=0;i<distance.length;i++){
				if(!visited[i]&& (minVertex==-1 || distance[i]<distance[minVertex]))
                  minVertex=i;
        }
      
      return minVertex;
  }
  
  
  public static int[] Dijkstra(int[][] edge,int V){
      
      int[] distance=new int[V];
      boolean[] visited=new boolean[V];
      distance[0]=0;
      
      for(int i=1;i<V;i++)
       distance[i]=Integer.MAX_VALUE;
      
      for(int j=0;j<V;j++){
          
          int minVertex=findMinVertex(distance,visited);
          visited[minVertex]=true;
          
          for(int i=0;i<V;i++){
              
              if(edge[minVertex][i]>0 && !visited[i] && edge[minVertex][i]<Integer.MAX_VALUE){ //if vertex is a neighbour & unvisited
                  int distViaMin=distance[minVertex]+edge[minVertex][i];
                  if(distViaMin<distance[i])
                      distance[i]=distViaMin;
              }
                  
          }
          
      }
      
      return distance;
  }
  
  

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

      int[][] edge=new int[V][V];
      for(int i=0;i<E;i++){
          int fv=s.nextInt();
          int sv=s.nextInt();
          int w=s.nextInt();
          edge[fv][sv]=w;
          edge[sv][fv]=w;
      }
      
      int[] distance=Dijkstra(edge,V);
      for(int i=0;i<V;i++)
          System.out.println(i+" "+distance[i]);
      
	}
                               }
                               
                               
  

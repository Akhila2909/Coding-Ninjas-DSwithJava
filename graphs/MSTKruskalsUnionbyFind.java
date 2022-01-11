package graphs;
import java.util.*;

class Edge implements Comparable<Edge>{
    
    int v1;
    int v2;
    int weight;
    
    Edge(int v1,int v2,int weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }
    
    public int compareTo(Edge e){
        return this.weight-e.weight;
    }
 
}

public class MSTKruskalsUnionbyFind {
	    
	    
	    public static int findParent(int v,int[] parent){
	        
	        if(parent[v]==v)//topmmost parent
	            return v;
	        return findParent(parent[v],parent); //find parent's parent & so on
	    
	    }
	    
	    
	    public static Edge[] kruskals(Edge[] edges,int V){
	        
	            Arrays.sort(edges);
	        
	            Edge MST[]=new Edge[V-1];
	        
	            int[] parent=new int[V];
	            for(int i=0;i<V;i++)
	                parent[i]=i;
	        
	    
	            int i=0,count=0;
	            while(count!=V-1){
	        		Edge currEdge=edges[i++];
	            	int v1Parent=findParent(currEdge.v1,parent);
	            	int v2Parent=findParent(currEdge.v2,parent);
	            	if(v1Parent!=v2Parent){
	                	MST[count]=currEdge;
	                	parent[v1Parent]=v2Parent;
	                	count++;
	            }
	         }
	        return MST;
	    }

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int V = sc.nextInt();
			int E = sc.nextInt();
	        Edge edges[]=new Edge[E];
	        
	        for(int i=0;i<E;i++){
	            int s=sc.nextInt();
	            int d=sc.nextInt();
	            int w=sc.nextInt();
	            Edge e=new Edge(s,d,w);
	            edges[i]=e; 
	        }

	        Edge[] MST=kruskals(edges,V);
	        
	        for(int i=0;i<V-1;i++){
	            if(MST[i].v1<=MST[i].v2)
	            	System.out.print(MST[i].v1+" "+MST[i].v2+" "+MST[i].weight);
	            else
	                System.out.print(MST[i].v2+" "+MST[i].v1+" "+MST[i].weight);
	            
	        System.out.println();
	        }
	        
		}
	}

package graphs;

import java.util.ArrayList;

public class DetectCycle {

	public static int topParent(int v,int[] parent){
        if(parent[v]!=v)
          parent[v]=topParent(parent[v],parent);
        return parent[v];
    }
    
    
    public static boolean cycleDetect(ArrayList<ArrayList<Integer>> adj,int V){
        int parent[]=new int[V];
        int rank[]=new int[V];
        
        
        for(int i=0;i<V;i++)
           parent[i]=i;
           
    
        for(int i=0;i<adj.size();i++){
            ArrayList<Integer> a=adj.get(i);
            int v1=a.get(0);
            int v2=a.get(1);
            int v1Parent=topParent(v1,parent);
            int v2Parent=topParent(v2,parent);
            if(v1Parent==v2Parent)
               return true;
            if(rank[v1Parent]>rank[v2Parent]){
                parent[v2Parent]=v1Parent;
                rank[v1Parent]+=rank[v2Parent];
            }
                else 
            {
                parent[v1Parent]=v2Parent;
                rank[v2Parent]+=rank[v1Parent];
            }
        }
      return false;
    }
    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        return cycleDetect(adj,V);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

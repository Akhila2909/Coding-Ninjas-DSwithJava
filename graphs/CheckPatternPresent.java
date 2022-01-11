package graphs;

public class CheckPatternPresent {
    
    static int[][] steps={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    
    static String t="CODINGNINJAS";
	
    static public boolean valid(int i,int j,boolean[][] visited,int n,int m){
        if(i<0||j<0||i>=n||j>=m||visited[i][j]==true)
            return false;
        return true;
    }
    
    
    
    static public boolean DFS(String[] Graph,int i,int j,int index ,boolean[][] visited,int n,int m)
    {
        if(index==t.length()-1)
            return true;
        visited[i][j]=true;
        for(int k=0;k<steps.length;k++){
            int newi=i+steps[k][0];
            int newj=j+steps[k][1];
            if(valid(newi,newj,visited,n,m) && t.charAt(index)==Graph[newi].charAt(newj))
                if(DFS(Graph,newi,newj,index+1,visited,n,m))
                    return true;
        }
        visited[i][j]=false;
        return false;
    }
    
    
	static int solve(String[] Graph , int N, int M)
	{
        boolean[][] visited=new boolean[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Graph[i].charAt(j)=='C')
                    if(DFS(Graph,i,j,1,visited,N,M))
                        return 1;
            }
        }
        return 0;
	}
	
	public static void main(String[] args) {
		String Graph[]= {"AJNINGNIDOC"};
		System.out.println(solve(Graph,1,11));
	}
}
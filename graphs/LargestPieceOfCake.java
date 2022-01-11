package graphs;

public class LargestPieceOfCake {


    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static boolean valid(int i,int j,int n){
        if(i<0||j<0||i>=n||j>=n)
            return false;
        return true;
    }
    
    public static int piece(String[] edge,boolean[][] visited,int i,int j){
        visited[i][j]=true;
        int c=1;
        for(int k=0;k<4;k++)
        {
            int newi=i+dir[k][0];
            int newj=j+dir[k][1];
            if(valid(newi,newj,edge.length) && !visited[newi][newj] && edge[newi].charAt(newj)=='1')
                c+=piece(edge,visited,newi,newj);
        }
        return c;
    }
    
    
	public static int dfs(String[] edge, int n) {
        int largestPiece=0;
		boolean [][] visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edge[i].charAt(j)=='1')
                    largestPiece=Math.max(largestPiece,piece(edge,visited,i,j));
            }
        }
        return largestPiece;      
	}


}
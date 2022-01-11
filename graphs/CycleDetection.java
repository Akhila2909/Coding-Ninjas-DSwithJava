package graphs;
import java.util.*;
public class CycleDetection {
 
	   int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
	    
	    int si,sj;
	    
	    boolean valid(int i,int j,int n,int m){
	        if(i<0 || j<0 || i>=n|| j>=m)
	            return false;
	        return true;
	    }
	    
	    
	   boolean dfs(String[] board,int i,int j,char letter,boolean[][] visited,int count,int n,int m){
	      if(count>4 && si==i && sj==j)
	           return true;
	       if(valid(i,j,n,m) && !visited[i][j] && board[i].charAt(j)==letter){ 
	            visited[i][j]=true;
	       for(int k=0;k<4;k++){
	           int newi=i+dir[k][0];
	           int newj=j+dir[k][1];
	           if(dfs(board,newi,newj,letter,visited,count+1,n,m))
	               return true;
	          }
	        visited[i][j]=false;
	       }
	   
	       return false;
	   }


	    int solve(String[] board , int n, int m)
		{
		  boolean[][] visited=new boolean[n][m];
	      for(int i=0;i<n;i++)
	          for(int j=0;j<m;j++)
	              if(!visited[i][j]){
	                  si=i;sj=j;
	                  if(dfs(board,i,j,board[i].charAt(j),visited,1,n,m))
	                      return 1;
	              }
	        return 0;
		}
		
		
	}

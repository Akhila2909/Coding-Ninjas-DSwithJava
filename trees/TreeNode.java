package trees;

import java.util.ArrayList;

public class TreeNode<T> {
	
	T data;
	ArrayList<TreeNode<T>> children;//null 
	
	TreeNode(T data){
		this.data=data;
		children=new ArrayList<>();
	}
	

}

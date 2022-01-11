package hashmaps;
import java.util.ArrayList;
import java.util.HashMap;


public class RemoveDuplicates {

	public static ArrayList<Integer> removeDuplicates(int a[]) {
		ArrayList<Integer> result =new ArrayList<>();
		HashMap<Integer,Boolean> unique=new HashMap<>();
		for(int i:a) {
			if(!unique.containsKey(i))
				result.add(i);
			unique.put(i,true);
		}
	 return result;
		
		
	}
	
	public static void main(String[] args) {
		int a[] = {1,3,2,4,1,2,2,2,10000,3,2};
		ArrayList<Integer> output = removeDuplicates(a);
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
	}

}
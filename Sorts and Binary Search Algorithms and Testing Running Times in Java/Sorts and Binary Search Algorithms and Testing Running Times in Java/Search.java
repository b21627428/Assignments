import java.util.ArrayList;

public abstract class Search {
	
	public static int binarySearch(ArrayList<Integer> list  , int searchingNumber) {
		
		int left = 0 , right = list.size()-1;
		
		while(left<=right) {
			
			int middle = (left+right)/2;
			
			if(list.get(middle) < searchingNumber) {
				
				left = middle+1;
			}
			else if(list.get(middle) > searchingNumber){
				
				right = middle-1;
			}
			else {
				
				return middle;
			}

		}
		
		return -1;
	}
	
}

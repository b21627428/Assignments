import java.util.ArrayList;

public abstract class Sort {
	
	private static long startTime,endTime,totalTime;
	

	
	
	//SELECTION SORT
	private static double selectionSort(ArrayList<Integer> tempArrayList) {

		startTime = System.nanoTime();   
		int i, j, minimumIndex,temp; 
		for (i = 0; i < tempArrayList.size()-1; i++) { 
			
			minimumIndex = i; 
		    for (j = i+1; j < tempArrayList.size(); j++) {
		    	
		    	if (tempArrayList.get(j) < tempArrayList.get(minimumIndex)) {
		    		
		    		minimumIndex = j;
		    	}
		    }
		    temp = tempArrayList.get(i);
		    tempArrayList.set(i, tempArrayList.get(minimumIndex));
		    tempArrayList.set(minimumIndex, temp);
		}
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		return totalTime/10e5;
	}
	
	
	
	//INSERTION SORT
	private static double insertionSort(ArrayList<Integer> tempArrayList) {
		
		startTime = System.nanoTime();
	    int i, j,temp; 
	    for (i=1; i<tempArrayList.size(); i++) { 
	        temp = tempArrayList.get(i); 
	        j = i-1; 
	        for( ; j>=0 ; j--) {
	        	
	        	if(tempArrayList.get(j) <= temp ) break; 
	        	tempArrayList.set(j+1, tempArrayList.get(j));	
	        }
	        tempArrayList.set(j+1, temp); 
	    } 
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		return totalTime/10e5;
	}
	
	//MERGESORT
	private static void mergeSort(ArrayList<Integer> tempArrayList) {

		if(tempArrayList.size() < 2) {
			return;
		}
		int mid = tempArrayList.size()/2;
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for(int i=0 ; i<mid ; i++) {
			left.add(tempArrayList.get(i));
		}
		for(int i=0 ; i<tempArrayList.size()-mid ; i++) {
			right.add(tempArrayList.get(mid+i));
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(tempArrayList,left,right, mid, tempArrayList.size()-mid);
	}
	private static void merge(ArrayList<Integer> tempArrayList , 
					          ArrayList<Integer> left , 
					          ArrayList<Integer> right, 
					          int leftIndex ,int rightIndex) {
		
		int i=0,j=0,r=0;
		while(i<leftIndex && j<rightIndex) {
			
			if(left.get(i) < right.get(j)) {
				tempArrayList.set(r++, left.get(i++));
			}
			else {
				tempArrayList.set(r++, right.get(j++));
			}
		}
		while(j<rightIndex) {
			tempArrayList.set(r++, right.get(j++));
		}
		while(i<leftIndex) {
			tempArrayList.set(r++, left.get(i++));
		}
	}
	
	
	//RADIXSORT
	private static double radixSort(ArrayList<Integer> tempArrayList) {
		
		startTime = System.nanoTime();
		for(int exp=1 ; (tempArrayList.size()-1)/exp>0 ; exp*=10) {

			ArrayList<Integer> newArray = new ArrayList<Integer>();
			for(int i=0 ; i<tempArrayList.size() ; i++) {
				newArray.add(0);			
			}
			ArrayList<Integer> counter = new ArrayList<Integer>();
			for(int i=0 ; i<10 ; i++) {
				counter.add(0);			
			}
			//***************
			for(int i=0 ; i<tempArrayList.size() ; i++ ) {
				counter.set( (tempArrayList.get(i)/exp)%10, (counter.get( (tempArrayList.get(i)/exp) %10) )+1 );
			}
			for(int i=1 ; i<10 ; i++) {
				counter.set(i, counter.get(i)+counter.get(i-1));
			}
			//**************
			for(int i=tempArrayList.size()-1 ; i>=0 ; i--) {
				
				newArray.set( (counter.get( (tempArrayList.get(i)/exp) %10) )-1 , tempArrayList.get(i) );
				
				counter.set( (tempArrayList.get(i)/exp)%10, (counter.get( (tempArrayList.get(i)/exp) %10) )-1 );
			}
			for(int i=0 ; i<tempArrayList.size() ; i++) {
				tempArrayList.set(i, newArray.get(i));
			}
		}
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		return totalTime/10e5;
	}
	//HELPSORT
	public static double HelpSort(String kindOf ,ArrayList<Integer> tempArrayList){
		
		try {
			
			switch(kindOf) {
			
				case "mergeSort":
					long startTime = System.nanoTime();        mergeSort(tempArrayList);
					long endTime   = System.nanoTime();        long totalTime = endTime - startTime;
					return totalTime/10e5;
				case "insertionSort": return insertionSort(tempArrayList);
				case "selectionSort": return selectionSort(tempArrayList);
				case "radixSort":     return radixSort(tempArrayList);
				default: 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}

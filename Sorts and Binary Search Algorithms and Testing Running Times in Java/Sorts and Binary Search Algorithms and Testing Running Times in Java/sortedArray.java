public class sortedArray extends Array {
	
	//Constructor
	public sortedArray(int numberOfElements) {
			
		create(numberOfElements);
	}
	@Override
	public void create(int numberOfElements) {
		
		for(int i=0 ; i<numberOfElements ; i++) {
			getArray().add(i);
		}
	}
}

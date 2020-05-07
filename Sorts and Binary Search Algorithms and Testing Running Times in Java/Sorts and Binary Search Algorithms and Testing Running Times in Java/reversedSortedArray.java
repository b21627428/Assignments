public class reversedSortedArray extends Array{
	
	//Constructor
	public reversedSortedArray(int numberOfElements) {
		
		create(numberOfElements);
	}
	@Override
	public void create(int numberOfElements) {
		
		for(int i=numberOfElements-1 ; i>=0 ; i--) {
			getArray().add(i);
		}
	}
}

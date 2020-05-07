import java.util.Random;

public class mixedArray extends Array{
	
	//Constructor
	public mixedArray(int numberOfElements) {
		
		create(numberOfElements);
	}
	@Override
	public void create(int numberOfElements) {
		
		Random rand = new Random(); 

		for(int i=numberOfElements-1 ; i>=0 ; i--) {
			getArray().add( rand.nextInt( numberOfElements+ 1  ) );
		}
	}
}

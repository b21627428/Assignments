
public abstract class function {

	public static void findTheRootsOfEquation›nSecondOrder(int a,int b,int c) {
		
		int delta =  ((int)Math.pow(b,2)-4*a*c);
		
		
		
		if ( delta < 0 ) System.out.println( "The solution is not real but complex" );
		
		else if ( delta == 0) {
			
			System.out.println("There is one solution");
			
			float route = (float) ((-b - Math.sqrt(delta) ) / 2 *a);
			
			System.out.println("Solution: "+route);
		}
		
		else {
			
			System.out.println("There are two solutions");
			
			float firstRoute = (float) ((-b -  Math.sqrt(delta) ) / 2 *a) , secondRoute = (float) ((-b +  Math.sqrt(delta) ) / 2 *a);

			System.out.printf("Solutions: %.2f %.2f ",firstRoute,secondRoute);
		}
		
		
		
		
		
		
		
	}
}

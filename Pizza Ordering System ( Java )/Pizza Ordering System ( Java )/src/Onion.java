public class Onion extends PizzaDecorator {

	
	public Onion(Material pizza) {
		super(pizza);
		
	}
	@Override
	public int getCost() {
		
		return super.getCost()+2;
	}

	@Override
	public String getName() {
		
		return super.getName()+" Onion";
	}
	

}

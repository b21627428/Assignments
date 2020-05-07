public class Salami extends PizzaDecorator {
	
	
	
	public Salami(Material pizza) {
		super(pizza);
		
	}
	
	@Override
	public int getCost() {
		
		return super.getCost()+3;
	}

	@Override
	public String getName() {
		
		return super.getName()+" Salami";
	}


		
}

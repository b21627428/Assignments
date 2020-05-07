public class Soudjouk extends PizzaDecorator {

	
	
	public Soudjouk(Material pizza) {
		super(pizza);
		
	}
	
	@Override
	public int getCost() {
		
		return super.getCost()+3;
	}

	@Override
	public String getName() {
		
		return super.getName()+" Soudjouk";
	}



}

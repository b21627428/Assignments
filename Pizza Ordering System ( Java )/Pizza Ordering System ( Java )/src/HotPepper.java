public class HotPepper extends PizzaDecorator {

	public HotPepper(Material pizza) {
		super(pizza);
		
	}
	
	@Override
	public int getCost() {
		
		return super.getCost()+1;
	}

	@Override
	public String getName() {
		
		return super.getName()+" HotPepper";
	}


}

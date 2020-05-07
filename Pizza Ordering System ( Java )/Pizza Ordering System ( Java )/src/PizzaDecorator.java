public abstract class PizzaDecorator implements Material {
	
	private Material pizza;

	public PizzaDecorator(Material pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public int getCost() {
		
		return this.pizza.getCost();
	}

	@Override
	public String getName() {
		
		return this.pizza.getName();
	}
	
	

}

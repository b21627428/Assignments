import static java.lang.Class.forName;
import java.lang.reflect.Constructor;
import java.util.ArrayList;


public class Order { 
	
	private int orderID;
	private Customer customer;
	
	private ArrayList<Material> Basket = new ArrayList<Material>() ;              // Bu arraylist sepet amaçlı yapılmıştır.Ordera eklenen malzemleri eklemek için.
	
	private Material pizza;
	private Material drink;
        
    private static Constructor constructor;
    private static Class<?> class1;
	
	private int orderPrice;
	
	public Order(int id, Customer customer) {
		setOrderID(id);
		setCustomer(customer);
		setOrderPrice(0);
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public void setBasket(ArrayList<Material> basket) {
		Basket = basket;
	}
	public ArrayList<Material> getBasket(){
		
		return Basket;
	}
	
	// YAPILAN ISLEMLER 

	public Material addPizza(String []array){                      // Bir Stringlerden oluşan array gelir ve kıyaslamalara göre bu ordera pizza eklenir.En son bu orderin basketine ekleme yapılır.
		
		
            for(int i=2; i<array.length ; i++){
			
                        
                try{
                    
                    class1 = Class.forName(array[i]);
                    
                    if(i==2){
                                
                        pizza = (Material)class1.newInstance();
                                
                    }else{
                                
                        constructor = class1.getConstructor(new Class[]{Material.class});
                                
                        pizza = (Material) constructor.newInstance(pizza);
                           
                    }
                }catch( Throwable e){
                            
                    System.out.println("Hata: " + e.getMessage() );
                }
                        
            }
		
		
		
            Basket.add(pizza);
		
            setOrderPrice( getOrderPrice() + pizza.getCost() );
		
            return pizza;
            
	}
	
	
	
	public void addDrink(){          // Drink oluşturur.
		
		drink = new Drink();
		Basket.add(drink);
		
		setOrderPrice( getOrderPrice() + drink.getCost() );
		
		
		
	}
	
    @Override
    public String toString(){
            
        return String.format("%d %d", getOrderID() , getCustomer().getId() );
    }   



	
}



	







	




	

	
	



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CustomerDAO implements IDataAccessObject  {

	private ArrayList<Object> customers = new ArrayList<Object>();
	

	
	@Override
	public Object getByID(int ID) {    // ID ye göre customerların durduğu arraylist den o customeri çeker.
		
		
		for(int i=0; i< getCustomers().size() ; i++){
			
			if( ( (Customer)getCustomers().get(i) ).getId() == ID){
				
				return getCustomers().get(i);
			}
		}
		return null;
		
	}
	
	@Override
	public String deleteByID(int ID) { // ID ye göre customerların durduğu arraylist den o customeri siler.
		
		String temp;
		
		for(int i=0; i< getCustomers().size() ; i++){
			
			if( ( (Customer)getCustomers().get(i) ).getId() == ID){
				
				temp = ( (Customer)getCustomers().get(i) ).getName();
				
				getCustomers().remove(i);
				
				return temp;
			}
		}
		return null;
		
	}

	@Override
	public boolean add(Object object) { // Gelen objeyi arrayliste ekler.
		
		boolean test = true;
		          
		for(int i=0 ; i< getCustomers().size() ; i++){
		
			if ( ( (Customer)getCustomers().get(i) ).getId() == ( (Customer)object ).getId() ){
				
				
				test = false;
				
			}
		}
		
		if(test){
			
			getCustomers().add( (Customer) object);
			
		}
		return test;
		
		
	}


	@Override   
	public ArrayList<Object> getAll() {  // customer database ini return eder.
		
		return getCustomers();
	}


	@Override 
	public void update(){  // customer database i sort eder ( Name e göre output.txt için )
        	
		Collections.sort( getCustomers() , new Comparator<Object>() {

			@Override
			public int compare ( Object customer1 , Object customer2){

				return ((Customer)customer1).getName().compareTo(((Customer)customer2).getName());
                                
                                
			}
		});

	}

	public void update(int a){  // customer database i sort eder ( ID ye göre  customer.txt için )
        	
		Collections.sort( getCustomers() , new Comparator<Object>() {

			@Override
			public int compare ( Object customer1 , Object customer2){

				int customer1id = ((Customer) customer1).getId();
                                int customer2id = ((Customer) customer2).getId();
                                
                                if( customer1id> customer2id){
                                    
                                    return 1;
                                }
                                else if ( customer2id > customer1id){
                                    return -1;
                                }
                            
                                return 0;
                                
                                
			}
		});


	}
        
    public ArrayList<Object> getCustomers() {   // customer database ini return eder.
		
        return customers;
	}
	public void setCustomers( ArrayList<Object> customerArray){   // customer database ini günceller.
		
        this.customers = customerArray;
		
	}

 
	
	
	
	
	


	





}

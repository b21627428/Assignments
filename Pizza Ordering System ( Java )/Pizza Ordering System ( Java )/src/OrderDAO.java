import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderDAO  implements IDataAccessObject  {

    private ArrayList<Object> orderArray = new ArrayList<Object>();
        
    @Override
	public Object getByID(int ID) {  // ID ye göre orderların durduğu arraylist den o orderi çeker.
		
		for(int i=0; i< getOrderArray().size() ; i++){
			
			if( ( (Order)getOrderArray().get(i) ).getOrderID() == ID){
				
				return getOrderArray().get(i);
			}
		}
		return null;
		
	}
	
	@Override
	public String deleteByID(int ID) { // ID ye göre orderların durduğu arraylist den o orderı siler.
	
		
		
		for(int i=0; i< getOrderArray().size() ; i++){
			
			if( ( (Order)getOrderArray().get(i) ).getOrderID() == ID){
				
				
				getOrderArray().remove(i);

				return null;
			}
		}
		
		
		
		return "";
		
	}

	@Override
	public boolean add(Object object) { // Gelen objeyi arrayliste ekler.

		boolean test = true;;
		
		for(int i=0 ; i< getOrderArray().size() ; i++){
		
			if ( ( (Order)getOrderArray().get(i) ).getOrderID() == ( (Order)object ).getOrderID() ){
				
				
				
				test = false;
				
			}
		}
                
		
		if(test){
			
			getOrderArray().add((Order)object);

		}
		return test;
		
		
		
	}
	

	@Override   // order database ini return eder.
	public ArrayList<Object> getAll() {
		
		return getOrderArray();
	}

	@Override // order database i sort eder.
	public void update(){
        	
		Collections.sort( getOrderArray() , new Comparator<Object>() {

			@Override
			public int compare ( Object order1 , Object order2){

				int order1id = ((Order) order1).getOrderID();
                                int order2id = ((Order) order2).getOrderID();
                                
                                if( order1id > order2id){
                                    
                                    return 1;
                                }
                                else if ( order2id > order1id){
                                    return -1;
                                }
                            
                                return 0;
                                
                                
			}
		});

	}
        
    public ArrayList<Object> getOrderArray() { // order database ini return eder.
            
           return orderArray;
	}

	public void setOrderArray(ArrayList<Object> orderArray) {  // order database ini günceller.
		
            this.orderArray = orderArray;
	}


	

}

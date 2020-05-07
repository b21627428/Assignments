import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadWrite {

	private static IDataAccessObject customers = new CustomerDAO();
	private static IDataAccessObject orders = new OrderDAO();
	private static ArrayList<String> outputArray = new ArrayList<String>();
	
        

	public static void inputTxt(String filename){  // Gelen filename argümanına göre dosya açılır ve while döngüsü içinde kıyaslamalar yapılır.Bu kıyaslamalara göre arraylistler içindeki customerlar ve orderlarda değişiklikler gerçekleşir ve outputArray e bu değişikliklerin özeti eklenir.
		
                
		String information;
		String[]temp;
		String temp2;
		
		int orderID;
		int customerID;
		
		Customer customer;
		Customer customerTest;
		
		Material temp1;
		
		boolean test ;
		
		ArrayList<Material> Basket;
		
		try{
    		
			FileInputStream fStream  =    new FileInputStream(filename);            
    		DataInputStream dStream =     new DataInputStream(fStream);				
    		BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
            while( (information = bReader.readLine() )  != null){        
                    
                    temp = information.split(" ");
                    
                    if( temp[0].equals("AddCustomer") ){                                                // Customer ekleme kısmı
                    	
                        customer = new Customer( temp );
                        
                        test = customers.add( customer );
                        customers.update();
                    	
                    	if(test==false){
								
								outputArray.add("Customer " +temp[2]+" "+ temp[3]  +" has already on the system");
                    	}
                    	else{
								
								outputArray.add("Customer " +customer.getId()+" "+ customer.getName() +" added" );
                    	}
                    }
                    else if( temp[0].equals("RemoveCustomer") ){                                        // Customer remove kısmı
                    	
                        customerID = Integer.valueOf(temp[1]);
                    	
                    	temp2 = customers.deleteByID( customerID);
                        customers.update();
                    	
                    	if(temp2 == null){
								
								outputArray.add("There is no such person " + customerID+" on the system" );
                    	}
                    	else{
                                
								outputArray.add(  "Customer " + customerID+" "+temp2+" removed");
                        }
                    }
                    else if( temp[0].equals("CreateOrder") ){                                                // CreateOrder kısmı
                    	
                        orderID = Integer.valueOf(temp[1]);
                    	customerID = Integer.valueOf(temp[2]);
                    	
                        customerTest = (Customer)customers.getByID(customerID);
                             
                        if(customerTest == null){
                                 
                            outputArray.add("There is no such person " + customerID+" on the system" );
                             
                        }
                        else {
                            
                            test = orders.add( new Order (orderID , (Customer)customers.getByID(customerID))  );
                            orders.update();
                            
                            if(test==false){
                                    
                                    outputArray.add("Order " +orderID+" has already on the system");
                            }
                            else{
                                    outputArray.add("Order "+orderID+" created");
                            }
                        }
                    }
                    else if ( temp[0].equals("RemoveOrder") ){                                                // RemoveOrder kısmı
                    	
                    	orderID = Integer.valueOf(temp[1]);
                    	
                    	temp2 = orders.deleteByID(orderID);
                        orders.update();
                    	
                    	if(temp2 != null ){
								
								outputArray.add("There is no such order "+orderID+" on the system");
                    	}
                    	else{
								
								outputArray.add("Order "+orderID+" removed");
                    	}
                    	
                    }
                    else if ( temp[0].equals("AddPizza") ){                                                   // AddPizza kısmı
                    	
                    	orderID = Integer.valueOf(temp[1]);
                        
                    	
                        try{
                            
							( (Order)orders.getByID(orderID) ).addPizza(temp);

                            outputArray.add( temp[2]+" pizza added to order "+orderID );
                        }
                        catch(Exception e){
                            
                            outputArray.add("There is no such order "+orderID+" on the system");
                        }
                    }
                    else if ( temp[0].equals("AddDrink") ){                                                    // AddDrink kısmı
                    	
                    	orderID = Integer.valueOf(temp[1]);
                    	
                        try{
                            ( (Order)orders.getByID(orderID) ).addDrink();

                            outputArray.add( "Drink added to order "+orderID );
                        }
                        catch(Exception e){
                            
                            outputArray.add("There is no such order "+orderID+" on the system");
                        }
                    }
                    else if ( temp[0].equals("PayCheck") ){                                                   // PayCheck kısmı
                    	
                    	orderID = Integer.valueOf(temp[1]);
                        
                    	try{
                            
							Basket =  ( (Order)orders.getByID(orderID)).getBasket();

                            outputArray.add("PayCheck for order  "+orderID);

                            for(int i = 0; i < Basket.size() ; i++){

								temp1 = ( Basket.get(i) );
                                
								outputArray.add( "\t"+ temp1.getName() +"  "+temp1.getCost()+"$" );
                                
                            }
							outputArray.add("\tTotal: "+( (Order)orders.getByID(orderID) ).getOrderPrice() +"$" );
                        }
						catch(Exception e){
                            
							outputArray.add("There is no such order "+orderID+" on the system");
                        }
                    }
                    else if ( temp[0].equals("List") && temp[1].equals("Customers")){                         // ListCustomers kısmı
                    	
						outputArray.add("Customer List:");
                		
						for(int i=0 ; i< customers.getAll().size() ; i++){
                			
							outputArray.add( "\t"+ ((Customer) customers.getAll().get(i)).toString() );
                			
                		}
                    }
                    
                     
            }
          
          
          
          
          dStream.close();
            
		} catch(Exception e){
            
			System.out.println("input.txt hatasi");
		}
	}
	public static void outputTxt( String filename  ){  // inputTxt() fonksiyonunun çalışması sonucunda bir outputArray oluştu.Bu fonksiyon bu array deki bilgileri output.txt ye basar.
		
		 FileWriter fWriter = null;
	     BufferedWriter writer = null;
		
		try{
			 fWriter = new FileWriter(filename);    //output dosyasi acilir
             writer =  new BufferedWriter(fWriter);
            
             for(String name : outputArray){
            	 
				 writer.write(name);
            	 writer.newLine();
             }
          
          
          
          writer.close();
            
		} catch(Exception e){
            
			System.out.println("output.txt hatasi");
		}
		
	}
	public static void customerTxtUpdate( String filename ){ // inputTxt() fonksiyonunun çalışması sonucunda databaselerde değişiklikler gerçekleşti .Bu fonksiyon bu customer database indekileri customer.txt ye basar.
		
        ((CustomerDAO)customers).update(1);
		
        ArrayList<Object> arrayList = customers.getAll();
		
		FileWriter fWriter = null;
	    BufferedWriter writer = null;
		
		try{
			 
			fWriter = new FileWriter(filename);    //customer dosyasi acilir
            writer =  new BufferedWriter(fWriter);
           
            
            for(int i=0; i< arrayList.size() ; i++ ){
           	 	
				writer.write( ((Customer)arrayList.get(i)).toString() );
           	 	writer.newLine();
            }
         
         
         
            writer.close();
           
		} catch(Exception e){
           
			System.out.println("Customer.txt hatasi");
		
		}
		
	}
	public static void orderTxtUpdate ( String filename ){ // inputTxt() fonksiyonunun çalışması sonucunda databaselerde değişiklikler gerçekleşti .Bu fonksiyon bu order database indekileri order.txt ye basar.
		
		ArrayList<Object> arrayList = orders.getAll();
		
		FileWriter fWriter = null;
	    BufferedWriter writer = null;
		
		try{
		   
			fWriter = new FileWriter(filename);    //order dosyasi acilir
			writer =  new BufferedWriter(fWriter);
                    
			for(int i=0; i< arrayList.size() ; i++ ){
          	 	
				writer.write( "Order: "+((Order)arrayList.get(i)).toString()   );
           		writer.newLine();
                        
           		for(int j=0 ; j< ((Order)arrayList.get(i)).getBasket().size() ; j++){
           		
           		
           			writer.write( ((Order)arrayList.get(i)).getBasket().get(j).getName()       );
           			writer.newLine();
           		
           			
           		
           		}
           }
           
           writer.close();
          
		} catch(Exception e){
          
		  System.out.println("Order.txt hatasi");
		}
	}
}

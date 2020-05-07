public class Customer  { 
	private int id;
	private String name;
	private String surname;
	private String phone;
	private String address;
	
	public Customer(String[] array) {                // Bu constructor inputTxt() gerçekleşirken yani değişiklikler yapılırken eklenen customerler için vardır.
		
		this.id = Integer.valueOf( array[1] );
		this.name = array[2];
		this.surname = array[3];
		this.phone = array[4];
		
		String temp = "Address:";
		for(int i=5 ; i<array.length ; i++){
			
			temp = temp  +" "+ array[i];
		}
		
		this.address = temp;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
       
	@Override
    public String toString(){
            
            return String.format("%d %s %s %s %s", getId() , getName() , getSurname() , getPhone() , getAddress() );
    
	}

	

}

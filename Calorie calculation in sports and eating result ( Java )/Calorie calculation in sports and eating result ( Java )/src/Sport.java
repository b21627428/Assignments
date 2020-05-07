

public class Sport {
    
    
    private int ID; 
    private String Name;
    private int BurnsCalorie;
    
    
    /*Constructor kısmı */
    public Sport(){
        
        
    }
    
    public Sport(int ID ,  String Name ,  int Calorie){
        setID(ID);
        setName(Name);
        setBurnsCalorie(Calorie);
    }
    
    
    /* Set ve get methodları aşağıda yer alır */
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public int getBurnsCalorie(){
        return BurnsCalorie;
    }
    public void setBurnsCalorie(int Calorie){
        this.BurnsCalorie = Calorie;
    }
    
    
    
   
    
}

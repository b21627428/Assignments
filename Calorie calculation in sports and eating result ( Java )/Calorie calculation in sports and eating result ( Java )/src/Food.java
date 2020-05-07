



public class Food {
    
    
    private int ID; 
    private String Name;
    private int GivesCalorie;
    
    /*Constructor kısmı */
    public Food(){
        
        
    }
    
    public Food(int ID ,  String Name ,  int Calorie){
        setID(ID);
        setName(Name);
        setGivesCalorie(Calorie);
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
    public int getGivesCalorie(){
        return GivesCalorie;
    }
    public void setGivesCalorie(int Calorie){
        this.GivesCalorie = Calorie;
    }
    
    
    
   
    
}

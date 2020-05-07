



public class Human {
    
    
    private int ID; 
    private String Name;
    private String Sex;
    private int Height;
    private int Weight;
    private int Age;
    private int DailyNeedsCalorie;
    private int TakesCalorie;
    private int BurnsCalorie;
    private int TotalCalorie;
   
    /*Constructor kısmı */
    public Human(){
        setTakesCalorie(0);
        setBurnsCalorie(0);
        
        
    }
    
    public Human(int ID ,  String Name , String Sex , int Height , int Weight , int Age){
        setID(ID);
        setName(Name);
        setSex(Sex);
        setHeight(Height);
        setWeight(Weight);
        setAge(Age);
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
    public String getSex(){
        return Sex;
    }
    public void setSex(String Sex){
        this.Sex = Sex;
    }
    public int getHeight(){
        return Height;
    }
    public void setHeight(int Height){
        this.Height = Height;
    }
    public int getWeight(){
        return Weight;
    }
    public void setWeight(int Weight){
        this.Weight = Weight;
    }
    public int getAge(){
        return Age;
    }
    public void setAge(int Age){
        this.Age = Age;
    }
    public int getDailyNeedsCalorie(){
        return DailyNeedsCalorie;
    }
    public void setDailyNeedsCalorie(int Calorie){
        this.DailyNeedsCalorie = Calorie;
    }
    public int getTakesCalorie(){
        return TakesCalorie;
    }
    public void setTakesCalorie( int Calorie){
        this.TakesCalorie =  Calorie; 
    }
    public int getBurnsCalorie(){
        return BurnsCalorie;
    }
    public void setBurnsCalorie( int Calorie){
        this.BurnsCalorie = Calorie;
    }
    public int getTotalCalorie(){
        return  (TakesCalorie - BurnsCalorie)-DailyNeedsCalorie;
    }
  
    
    
    
   
    
}

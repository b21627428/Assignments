
public abstract class MathSymbol implements Jewel {      
 
    private String name , type = "MathSymbol";
    private int point;

    public MathSymbol( String name){
        
       setName(name);
       setPoint(20);
        
    }
    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        
        this.name = name;
    }

    public int getPoint() {
        
        return point;
    }

  
    public void setPoint(int point) {
        
        this.point = point;
    }
    
    public String getType(){
        
        return type;
    }
    

}

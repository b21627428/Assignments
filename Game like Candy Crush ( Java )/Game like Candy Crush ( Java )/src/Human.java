
public class Human {           // Bu class leaderboard.txt açılıp kıyaslama yapılırken kullanmak amaçlı yazılmıştır.
    
    private String name;
    private int point;

    public Human(){
       setPoint(0);
    }
    
    public Human(String name , int point){
        setName(name);
        setPoint(point);
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
}

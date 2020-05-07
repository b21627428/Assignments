
public class Triangle implements Jewel {


    private String name ,type="Triangle";
    private int point;

    public Triangle(){
        
       setName("T");
       setPoint(15);
        
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
    

    @Override
    public boolean compare(int rowCoordinate , int columnCoordinate , int row , int column , Jewel[][] array) { // Koordinata göre mapimiz ve koordinatlarımız belirli fonksiyonlara gönderilir.
        
        boolean test = true;
        //Kıyaslama kısmı
        if (            (rowCoordinate ==  (row-1) && columnCoordinate == (column-1) ) ||        // Eğer koordinat mapin köşelerinde ise bu koşul gerçekleştirlir.
                        (rowCoordinate ==  (row-1) && columnCoordinate ==     0      ) ||
                        (rowCoordinate ==     0    && columnCoordinate ==     0      ) ||
                         (rowCoordinate ==     0    && columnCoordinate == (column-1) )     ){
                        
            test = rightLeftEdge(row, column, rowCoordinate, columnCoordinate, array);
        }
        else if (        (0 < rowCoordinate        && rowCoordinate    <    (row-1)   )&& 
                                     (0 < columnCoordinate     && columnCoordinate <   (column-1) )    ){     // Eğer koordinat mapin ortasında ise bu koşul gerçekleştirlir.

            test = middle(row, column, rowCoordinate, columnCoordinate, array);            
        }
        else{   // Eğer koordinat mapin herhangi bir kenarında ise bu koşul gerçekleştirlir. 
                        
            if (        (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == 0           ){
                             
                test = rightLeftEdge(row , column , rowCoordinate , columnCoordinate , array );
            }
            else if (   (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == (column-1)  ){
       
                test = rightLeftEdge(row , column , rowCoordinate , columnCoordinate , array );
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == 0        ){
                             
                test = upEdge(row , column, rowCoordinate, columnCoordinate, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == (row-1)  ){
                            
                test = downEdge(row , column, rowCoordinate, columnCoordinate, array);
            }
        }
        
        //Shifting kısmı
        for ( int i=(row-1) ; i>=0 ; i--){
            for(int j=(column-1) ; j>=0 ; j--){
                
                if ( array[i][j] == null){
                    
                    shiftingPart(i,i,j,array);    // shiftingPart bir recursive fonksiyondur.
 
                   
                    
                }
            }
        }
        
        return test;
    }
    public boolean upEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){ // Koordinat üst kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        test = downChecking(rowCoordinate, columnCoordinate, array);
        
        return test;
    }
    public boolean downEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){ // Koordinat alt kenarda bulunuyorsa bu fonksiyon gerçekleşir.
 
        boolean test;
        
        test = upChecking(rowCoordinate, columnCoordinate, array);
        
        return test;
    }
    public boolean rightLeftEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat sol-sağ kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if ( rowCoordinate == 1 || rowCoordinate == 0){

            test = downChecking(rowCoordinate, columnCoordinate, array);
        }
        else if (rowCoordinate == (row-2) || rowCoordinate == (row-1) ){
    
            test = upChecking(rowCoordinate, columnCoordinate, array);
        }
        else{
    
            
            test = upChecking(rowCoordinate, columnCoordinate, array);
            if(test == true) test = downChecking( rowCoordinate, columnCoordinate, array);
        }
        return test;
    }
    public boolean middle(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){ // Koordinat mapin ortasında bulunuyorsa bu fonksiyon gerçekleşir.
 
       boolean test;
       
        if( rowCoordinate == 1 ) {
           
           test = downChecking(rowCoordinate, columnCoordinate, array);
       }
       else if( rowCoordinate == (row-2) ){
           
           test = upChecking(rowCoordinate, columnCoordinate, array);
       }
       else{
           
           test = upChecking(rowCoordinate, columnCoordinate, array);
           if(test == true) test = downChecking(rowCoordinate, columnCoordinate, array);
           
       }

       return test;
    }
    public boolean upChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){   //Koordinat ın 2 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate-1][columnCoordinate] instanceof Triangle && array[rowCoordinate-2][columnCoordinate] instanceof Triangle    ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate-1][columnCoordinate].getPoint() +
                      array[rowCoordinate-2][columnCoordinate].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate-1][columnCoordinate] = null;
            array[rowCoordinate-2][columnCoordinate] = null;
            
            test = false;
        }
        
        return test;
    }
    public boolean downChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 8 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate+1][columnCoordinate] instanceof Triangle && array[rowCoordinate+2][columnCoordinate] instanceof Triangle    ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate+1][columnCoordinate].getPoint() +
                      array[rowCoordinate+2][columnCoordinate].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate+1][columnCoordinate] = null;
            array[rowCoordinate+2][columnCoordinate] = null;
            
            test = false;
        }
        
        return test;
    }
    public Jewel[][] shiftingPart(int firstRow ,int rowCoordinate , int columnCoordinate , Jewel[][] array){ // Gelen koordinatın bulunduğu column daki null ları en üste atar.
        
        if(rowCoordinate < 0){
            
            return array;
        }
        else if( array[rowCoordinate][columnCoordinate] == null ){
            
            return shiftingPart(firstRow , rowCoordinate-1 , columnCoordinate , array );
        }
        else if( array[rowCoordinate][columnCoordinate] != null){
            
            Jewel temp = array[rowCoordinate][columnCoordinate];
            array[rowCoordinate][columnCoordinate] = null;
            array[firstRow][columnCoordinate] = temp;
            
            return shiftingPart(firstRow-1, firstRow-1, columnCoordinate, array);
        }
        
        return array;
    }
}

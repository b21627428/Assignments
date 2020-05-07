
public class Square implements Jewel {

    private String name , type = "Square";
    private int point;

    public Square(){
        
       setName("S");
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
    public boolean compare(int rowCoordinate , int columnCoordinate ,int row , int column , Jewel[][] array) { // Koordinata göre mapimiz ve koordinatlarımız belirli fonksiyonlara gönderilir.
        
        boolean test = true;
        //Kıyaslama kısmı
        if (            (rowCoordinate ==  (row-1) && columnCoordinate == (column-1) ) ||           // Eğer koordinat mapin köşelerinde ise bu koşul gerçekleştirlir.
                        (rowCoordinate ==  (row-1) && columnCoordinate ==     0      ) ||
                        (rowCoordinate ==     0    && columnCoordinate ==     0      ) ||
                         (rowCoordinate ==     0    && columnCoordinate == (column-1) )     ){
                        
            test = upDownEdges(row, column, rowCoordinate, columnCoordinate, array);
        }
        else if (        (0 < rowCoordinate        && rowCoordinate    <    (row-1)   )&& 
                                     (0 < columnCoordinate     && columnCoordinate <   (column-1) )    ){      // Eğer koordinat mapin ortasında ise bu koşul gerçekleştirlir.
                        
            test = middle(row, column, rowCoordinate, columnCoordinate, array); 
        }
        else{        // Eğer koordinat mapin herhangi bir kenarında ise bu koşul gerçekleştirlir. 
                        
            if (        (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == 0           ){
                             
                test = leftEdge(row , column , rowCoordinate , columnCoordinate , array );
            }
            else if (   (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == (column-1)  ){
       
                test = rightEdge(row , column , rowCoordinate , columnCoordinate , array );                 
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == 0        ){
                             
                test = upDownEdges(row , column, rowCoordinate, columnCoordinate, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == (row-1)  ){
                            
                test = upDownEdges(row ,column ,rowCoordinate ,columnCoordinate ,array);
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
    
    public boolean upDownEdges(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat üst-alt kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if ( columnCoordinate == 1 || columnCoordinate == 0 ){

            test = rightChecking( rowCoordinate, columnCoordinate, array);
        }
        else if (columnCoordinate == (column-2)  || columnCoordinate == (column-1) ){

            test = leftChecking( rowCoordinate, columnCoordinate, array);
        }
        else{
            
            test = leftChecking(rowCoordinate, columnCoordinate, array);
            if(test == true) test = rightChecking( rowCoordinate, columnCoordinate, array);
        }
                    
        return test;
    }
    public boolean leftEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){   // Koordinat sol kenarda bulunuyorsa bu fonksiyon gerçekleşir.

        boolean test;
        
        test = rightChecking( rowCoordinate, columnCoordinate, array);
    
        return test;
    }
    public boolean rightEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat sağ kenarda bulunuyorsa bu fonksiyon gerçekleşir.

        boolean test;
        
        test = leftChecking( rowCoordinate, columnCoordinate, array);
        
        return test;
    }
    public boolean middle(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat mapin ortasında bulunuyorsa bu fonksiyon gerçekleşir.

       boolean test;

       if(columnCoordinate == 1){
           
           test = rightChecking(rowCoordinate, columnCoordinate, array);
       }
       else if( columnCoordinate == (column-2)){
           
           test = leftChecking(rowCoordinate, columnCoordinate, array);
       }
       else{
           
            test = leftChecking(rowCoordinate, columnCoordinate, array);
            if(test == true) test = rightChecking(rowCoordinate, columnCoordinate, array);
       } 

       
       return test;
    }
    public boolean leftChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 4 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate][columnCoordinate-1] instanceof Square && array[rowCoordinate][columnCoordinate-2] instanceof Square    ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate][columnCoordinate-1].getPoint() +
                      array[rowCoordinate][columnCoordinate-2].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate][columnCoordinate-1] = null;
            array[rowCoordinate][columnCoordinate-2] = null;
            
            test = false;
        }
        
        return test;
    }
    
    public boolean rightChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){    //Koordinat ın 6 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate][columnCoordinate+1] instanceof Square && array[rowCoordinate][columnCoordinate+2] instanceof Square    ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate][columnCoordinate+1].getPoint() +
                      array[rowCoordinate][columnCoordinate+2].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate][columnCoordinate+1] = null;
            array[rowCoordinate][columnCoordinate+2] = null;
            
            test = false ;
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

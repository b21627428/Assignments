
public class Line extends MathSymbol{
    
    public Line(){
        super("|");
    }

    @Override
    public boolean compare(int rowCoordinate, int columnCoordinate, int row, int column, Jewel[][] array ) { // Koordinata göre mapimiz ve koordinatlarımız belirli fonksiyonlara gönderilir.

        boolean test = true;
        
        if (            (rowCoordinate ==  (row-1) && columnCoordinate == (column-1) ) ||                 // Eğer koordinat mapin köşelerinde ise bu koşul gerçekleştirlir.
                        (rowCoordinate ==  (row-1) && columnCoordinate ==     0      ) ||
                        (rowCoordinate ==     0    && columnCoordinate ==     0      ) ||
                         (rowCoordinate ==     0    && columnCoordinate == (column-1) )     ){
                        
            test = rightLeftEdge(rowCoordinate, columnCoordinate, row, column, array);
        }
        else if (        (0 < rowCoordinate        && rowCoordinate    <    (row-1)   )&& 
                                     (0 < columnCoordinate     && columnCoordinate <   (column-1) )    ){   // Eğer koordinat mapin ortasında ise bu koşul gerçekleştirlir.
                        
            test = middle(rowCoordinate, columnCoordinate, row, column, array);
        }
        else{            // Eğer koordinat mapin herhangi bir kenarında ise bu koşul gerçekleştirlir. 
                        
            if (        (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == 0           ){
                             
                test = rightLeftEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == (column-1)  ){
       
                test = rightLeftEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == 0        ){
                             
                test = upEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == (row-1)  ){
                            
                test = downEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
                        
        }
        
        //Shifting kısmı
        for ( int i=(row-1) ; i>=0 ; i--){
            for(int j=(column-1) ; j>=0 ; j--){
                
                if ( array[i][j] == null){
                    
                    shiftingPart(i,i,j,array);      // shiftingPart bir recursive fonksiyondur.

                   
                    
                }
            }
        }        
        return test;
    }
    
    public boolean rightLeftEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat sol-sağ kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if( rowCoordinate == 0 || rowCoordinate == 1){
            
            test = downChecking(rowCoordinate, columnCoordinate, array);
        }
        else if( rowCoordinate == (row-1) || rowCoordinate == (row-2)){

            test = upChecking( rowCoordinate, columnCoordinate, array);
        }
        else {

            test = upChecking(rowCoordinate, columnCoordinate, array);
            if(test == true) test = downChecking( rowCoordinate, columnCoordinate, array);
        }
        
        return test;
    }

    public boolean upEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){ // Koordinat üstkenarda bulunuyorsa bu fonksiyon gerçekleşir.

        boolean test;
        
        test = downChecking( rowCoordinate, columnCoordinate, array);
        
        return test;
    }
    public boolean downEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat alt kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        test = upChecking( rowCoordinate, columnCoordinate, array);
        
        return test;
    }
    public boolean middle( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){ // Koordinat mapin ortasında bulunuyorsa bu fonksiyon gerçekleşir.

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
    public boolean upChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){ //Koordinat ın 2 kısmını check eder.
        
        boolean test = true;
        
        if( ( array[rowCoordinate-1][columnCoordinate] instanceof Line && array[rowCoordinate-2][columnCoordinate] instanceof MathSymbol ) ||
            ( array[rowCoordinate-1][columnCoordinate] instanceof Plus && array[rowCoordinate-2][columnCoordinate] instanceof MathSymbol )     ){
                
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
    public boolean downChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){ //Koordinat ın 8 kısmını check eder.
        
        boolean test = true;
        
        if( ( array[rowCoordinate+1][columnCoordinate] instanceof Line && array[rowCoordinate+2][columnCoordinate] instanceof MathSymbol ) ||
            ( array[rowCoordinate+1][columnCoordinate] instanceof Plus && array[rowCoordinate+2][columnCoordinate] instanceof MathSymbol )      ){
                
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

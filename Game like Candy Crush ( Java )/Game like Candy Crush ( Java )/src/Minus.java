
public class Minus extends MathSymbol {
    
    public Minus(){
        super("-");
    }

    @Override
    public boolean compare(int rowCoordinate, int columnCoordinate, int row, int column, Jewel[][] array ) { // Koordinata göre mapimiz ve koordinatlarımız belirli fonksiyonlara gönderilir.

        boolean test = true;
        
        if (            (rowCoordinate ==  (row-1) && columnCoordinate == (column-1) ) ||                     // Eğer koordinat mapin köşelerinde ise bu koşul gerçekleştirlir.
                        (rowCoordinate ==  (row-1) && columnCoordinate ==     0      ) ||
                        (rowCoordinate ==     0    && columnCoordinate ==     0      ) ||
                         (rowCoordinate ==     0    && columnCoordinate == (column-1) )     ){
                        
            test = upDownEdges(rowCoordinate, columnCoordinate, row, column, array);
        }
        else if (        (0 < rowCoordinate        && rowCoordinate    <    (row-1)   )&& 
                                     (0 < columnCoordinate     && columnCoordinate <   (column-1) )    ){      // Eğer koordinat mapin ortasında ise bu koşul gerçekleştirlir.
            
            test = middle(rowCoordinate, columnCoordinate, row, column, array);
        }
        else{        // Eğer koordinat mapin herhangi bir kenarında ise bu koşul gerçekleştirlir. 
                        
            if (        (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == 0           ){
                             
                test = leftEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == (column-1)  ){
       
                test = rightEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == 0        ){
                             
                test = upDownEdges(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == (row-1)  ){
                            
                test = upDownEdges(rowCoordinate, columnCoordinate, row, column, array);
            }
        }
        
        //Shifting kısmı
        for ( int i=(row-1) ; i>=0 ; i--){
            for(int j=(column-1) ; j>=0 ; j--){
                
                if ( array[i][j] == null){
                    
                    shiftingPart(i,i,j,array);   // shiftingPart bir recursive fonksiyondur.

                   
                    
                }
            }
        }        
        return test;
    }
    
    public boolean leftEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){   // Koordinat sol kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        test = rightChecking( rowCoordinate, columnCoordinate, array);
        
        return test;
    }
    public boolean rightEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat sağ kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        test = leftChecking( rowCoordinate, columnCoordinate, array);
        
         return test;
    }
    public boolean upDownEdges( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat üst-alt kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if( columnCoordinate == 1 || columnCoordinate == 0){

            test = rightChecking( rowCoordinate, columnCoordinate, array);
        }
        else if( columnCoordinate == (column-2) || columnCoordinate == (column-1) ){
             
            test = leftChecking( rowCoordinate, columnCoordinate, array);
        }
        else{

            test = leftChecking(rowCoordinate, columnCoordinate, array);
            if(test == true) test = rightChecking( rowCoordinate, columnCoordinate, array);

        }
        
        return test;
    }
    public boolean  middle( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){ // Koordinat mapin ortasında bulunuyorsa bu fonksiyon gerçekleşir.

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

    public boolean leftChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){ //Koordinat ın 4 kısmını check eder.
        
        boolean test = true;
        
        if( ( array[rowCoordinate][columnCoordinate-1] instanceof Minus && array[rowCoordinate][columnCoordinate-2] instanceof MathSymbol ) ||
            ( array[rowCoordinate][columnCoordinate-1] instanceof Plus && array[rowCoordinate][columnCoordinate-2] instanceof MathSymbol )    ){
                
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
    public boolean rightChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 6 kısmını check eder.
        
        boolean test = true;
        
        if( ( array[rowCoordinate][columnCoordinate+1] instanceof Minus && array[rowCoordinate][columnCoordinate+2] instanceof MathSymbol ) ||
            ( array[rowCoordinate][columnCoordinate+1] instanceof Plus && array[rowCoordinate][columnCoordinate+2] instanceof MathSymbol )     ){
                
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

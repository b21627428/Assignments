

public class Slash extends MathSymbol {
    
    public Slash() {
        super("/");
    }
    
    
    @Override
    public boolean compare( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ) { // Koordinata göre mapimiz ve koordinatlarımız belirli fonksiyonlara gönderilir.

        boolean test = true;
        

        if (        (0 < rowCoordinate        && rowCoordinate    <    (row-1)   )&& 
                                     (0 < columnCoordinate     && columnCoordinate <   (column-1) )    ){    // Eğer koordinat mapin ortasında ise bu koşul gerçekleştirlir.
                        
            test = middle(rowCoordinate, columnCoordinate, row, column, array);
        }
        else{     // Eğer koordinat mapin herhangi bir kenarında ise bu koşul gerçekleştirlir. 
                        
            if (        (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == 0           ){
                             
                test = leftEdge(rowCoordinate, columnCoordinate, row, column, array);
            }
            else if (   (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == (column-1)  ){
       
                test = rightEdge(rowCoordinate, columnCoordinate, row, column, array);
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
                    
                    shiftingPart(i,i,j,array);     // shiftingPart bir recursive fonksiyondur.
                   
                    
                }
            }
        }        
        return test;
    }
    
    public boolean leftEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){   // Koordinat sol kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test = true;
        
        if(rowCoordinate > 1){
            
            test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        
        return test;
    }
    public boolean rightEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){   // Koordinat sağ kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test = true;
        
        if(rowCoordinate < (row-2) ){

            test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }

        return test;
    }
    public boolean upEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat üst kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test = true;
        
        if( columnCoordinate > 1){

            test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        
        return test;

    }
    public boolean downEdge( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat alt kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test = true;
        
        if( columnCoordinate < (column-2)  ){

            rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        
        return test;
    }
    public boolean middle( int rowCoordinate , int columnCoordinate ,int row ,int column ,Jewel[][] array ){  // Koordinat mapin ortaında bulunuyorsa bu fonksiyon gerçekleşir.

       boolean test;
       
       if( (columnCoordinate == 1 && rowCoordinate > 1) ||(rowCoordinate == (row-2) && columnCoordinate < (column-2)) ) {
           
           test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
       }
       else if ( (columnCoordinate == (column-2) && rowCoordinate < (row-2) ) || (rowCoordinate == 1 && columnCoordinate > 1) ){
           
           test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
       }
       else{

            if ( ! ( ( columnCoordinate == 1 && rowCoordinate == 1 ) || ( columnCoordinate == (column-2) && rowCoordinate == (row-2) ) ) ){
                
                test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);                
            }
            else{
               
                test = true;
            }

       }       

       
       return test;
    }
    
    public boolean rightUpDiagonalChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 3 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate-1][columnCoordinate+1] instanceof Slash && array[rowCoordinate-2][columnCoordinate+2] instanceof MathSymbol    ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate-1][columnCoordinate+1].getPoint() +
                      array[rowCoordinate-2][columnCoordinate+2].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate-1][columnCoordinate+1] = null;
            array[rowCoordinate-2][columnCoordinate+2] = null;
            
            test = false;
        }
        
        return test;
    }
    public boolean leftDownDiagonalChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 7 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate+1][columnCoordinate-1] instanceof Slash && array[rowCoordinate+2][columnCoordinate-2] instanceof MathSymbol     ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate+1][columnCoordinate-1].getPoint() +
                      array[rowCoordinate+2][columnCoordinate-2].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate+1][columnCoordinate-1] = null;
            array[rowCoordinate+2][columnCoordinate-2] = null;
            
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

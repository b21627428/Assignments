
public class Diamond implements Jewel{

    private String name ,type ="Diamond";
    private int point;

    public Diamond(){
        
       setName("D");
       setPoint(30);
        
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
    public boolean compare(int rowCoordinate ,int columnCoordinate , int row ,int column , Jewel[][] array ) {  // Koordinata göre mapimiz ve koordinatlarımız belirli fonksiyonlara gönderilir.
 
        boolean test = true; 
        //Kıyaslama kısmı
        if (            (rowCoordinate ==  (row-1) && columnCoordinate == (column-1) ) ||        // Eğer koordinat mapin köşelerinde ise bu koşul gerçekleştirlir.
                        (rowCoordinate ==  (row-1) && columnCoordinate ==     0      ) ||
                        (rowCoordinate ==     0    && columnCoordinate ==     0      ) ||
                         (rowCoordinate ==     0    && columnCoordinate == (column-1) )     ){
                        
            if (      (rowCoordinate ==  (row-1) && columnCoordinate == (column-1) ) ){
                            
                test = rightEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
            else if ( (rowCoordinate ==  (row-1) && columnCoordinate ==     0      ) ){
                         
                test = leftEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
            else if ( (rowCoordinate ==     0    && columnCoordinate ==     0      ) ){
                            
                test = leftEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
            else if ( (rowCoordinate ==     0    && columnCoordinate == (column-1) ) ){
                            
                test = rightEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
        }
        else if (        (0 < rowCoordinate        && rowCoordinate    <    (row-1)   )&&                        // Eğer koordinat mapin ortasında ise bu koşul gerçekleştirlir.
                                     (0 < columnCoordinate     && columnCoordinate <   (column-1) )    ){ 
                        
            test = middle(row, column, rowCoordinate, columnCoordinate, array);
        }
        else{                // Eğer koordinat mapin herhangi bir kenarında ise bu koşul gerçekleştirlir. 
                        
            if (        (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == 0           ){
                             
                test = leftEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
            else if (   (0 < rowCoordinate        &&  rowCoordinate < (row-1)   )  &&  columnCoordinate == (column-1)  ){
       
                test = rightEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == 0        ){
                             
                test = upEdge(row, column, rowCoordinate, columnCoordinate, array);
            }
            else if (   (0 < columnCoordinate     &&  columnCoordinate < (column-1)   )  &&  rowCoordinate == (row-1)  ){
                            
                test = downEdge(row, column, rowCoordinate, columnCoordinate, array);
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
    public boolean leftEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat sol kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if(rowCoordinate == 1 || rowCoordinate == 0){

            test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        else if(rowCoordinate == (row-2) || rowCoordinate == (row-1) ){
 
            test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
            
        }
        else{

            
            test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
            if(test==true) test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);

        }
        
        return test;
    }
    public boolean rightEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){   // Koordinat sağ kenarda bulunuyorsa bu fonksiyon gerçekleşir.

        boolean test;
        
        if(rowCoordinate == 1 || rowCoordinate == 0){

            test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        else if(rowCoordinate == (row-2) || rowCoordinate == (row-1)){
 
            test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        else{

            test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
            if(test==true) test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        
        return test;
    }
    public boolean upEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat üst kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if(columnCoordinate == 1){

            test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }        
        else if(columnCoordinate == (column-2)){

            test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }

        else{  

            test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
            if(test==true) test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        
        return test;
    }
    public boolean downEdge(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat alt kenarda bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
        
        if(columnCoordinate == 1){

            test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        else if(columnCoordinate == (column-2)){
 
            test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        else{

            test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
            if(test==true) test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
        }
        
        return test;
    }

    public boolean middle(int row , int column , int rowCoordinate , int columnCoordinate , Jewel[][] array){  // Koordinat mapin ortasında bulunuyorsa bu fonksiyon gerçekleşir.
        
        boolean test;
       
        if(rowCoordinate == 1){
            
            if(columnCoordinate == 1){
                
                test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
            }
            else if(columnCoordinate == (column-2)){
                
                test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
            }
            else{
                
                test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
                
            }
        }
        else if(rowCoordinate == (row-2)){
            
            if(columnCoordinate == 1){
                
                test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
            }
            else if(columnCoordinate == (column-2)){
                
                test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
            }
            else{
                
                test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                
            }            
        }
    
        else{
            
            if(columnCoordinate == 1){
                
                test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                
            }
            else if(columnCoordinate == (column-2)){
                
                test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
            }
            else{
                
                test = leftUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = rightDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) test = rightUpDiagonalChecking(rowCoordinate, columnCoordinate, array);
                if(test == true) leftDownDiagonalChecking(rowCoordinate, columnCoordinate, array);
            }
        }


        return test;
    }
    public boolean leftUpDiagonalChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 1 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate-1][columnCoordinate-1] instanceof Diamond && array[rowCoordinate-2][columnCoordinate-2] instanceof Diamond     ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate-1][columnCoordinate-1].getPoint() +
                      array[rowCoordinate-2][columnCoordinate-2].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate-1][columnCoordinate-1] = null;
            array[rowCoordinate-2][columnCoordinate-2] = null;
            
            test = false;
        }
        
        return test;
    }
    public boolean rightDownDiagonalChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){  //Koordinat ın 9 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate+1][columnCoordinate+1] instanceof Diamond && array[rowCoordinate+2][columnCoordinate+2] instanceof Diamond     ){
                
            setPoint( array[rowCoordinate][columnCoordinate].getPoint()     +
                      array[rowCoordinate+1][columnCoordinate+1].getPoint() +
                      array[rowCoordinate+2][columnCoordinate+2].getPoint()   );
                
            array[rowCoordinate][columnCoordinate] = null;
            array[rowCoordinate+1][columnCoordinate+1] = null;
            array[rowCoordinate+2][columnCoordinate+2] = null;
            
            test = false;
        }
        
        return test;
    }
    public boolean rightUpDiagonalChecking( int rowCoordinate , int columnCoordinate , Jewel[][] array ){ //Koordinat ın 3 kısmını check eder.
        
        boolean test = true;
        
        if(  array[rowCoordinate-1][columnCoordinate+1] instanceof Diamond && array[rowCoordinate-2][columnCoordinate+2] instanceof Diamond    ){
                
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
        
        if(  array[rowCoordinate+1][columnCoordinate-1] instanceof Diamond && array[rowCoordinate+2][columnCoordinate-2] instanceof Diamond    ){
                
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
    
   
    
    public Jewel[][] shiftingPart(int firstRow ,int rowCoordinate , int columnCoordinate , Jewel[][] array ){  // Gelen koordinatın bulunduğu column daki null ları en üste atar.
        
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

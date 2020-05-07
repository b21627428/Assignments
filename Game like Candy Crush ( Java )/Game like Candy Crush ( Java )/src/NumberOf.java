
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public abstract class NumberOf {
    
      /*Alttaki method dosyadaki satır sayısını bulup return ediyordur. Buna göre o classlarda arrayler oluşur.Bu sayı boyutu belli eder.*/
    
    public static int getRow(String filename){
        
         String str;
         int row = 0, column ;
        
        try{
            
            FileInputStream fStream  =    new FileInputStream(filename);
            DataInputStream dStream =     new DataInputStream(fStream);
            BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
            while( (str = bReader.readLine() )  != null){
                
                row++;
            }
                  
            dStream.close();
                    
        }catch(Exception e){
            
            e.printStackTrace();
        }
	
                return row;
    }
    
     /*Alttaki method dosyadaki sütun  sayısını bulup return ediyordur. Buna göre o classlarda arrayler oluşur.Bu sayı boyutu belli eder.*/
    
    public static int getColumn(String filename){
        
         String str;
         int  column = 0 ;
        
        try{
                  
            FileInputStream fStream  =    new FileInputStream(filename);
            DataInputStream dStream =     new DataInputStream(fStream);
            BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
          
            str = bReader.readLine();
            column = str.split(" ").length;

                 
            dStream.close();
                    
        }catch(Exception e){
            
            e.printStackTrace();
        }
	
        return column;
       
    }
    
    
}


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class NumberOfLine {
    
      /*Alttaki method dosyadaki satır sayısını bulup return ediyordur. Buna göre o classlarda arrayler oluşur.Bu sayı boyutu belli eder.*/
    
    public static int getNumberOfLine(String filename){
        
         String str;
         int numberOfLine = 0;
        
        try{
                  FileInputStream fStream  =    new FileInputStream(filename);
                  DataInputStream dStream =     new DataInputStream(fStream);
                  BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
                  while( (str = bReader.readLine() )  != null){
                
                        numberOfLine++;
                    }
                  
                    dStream.close();
                    
         }catch(Exception e){
            
            System.err.println("Hata: "+ e.getMessage());
        }
	
                return numberOfLine;
       }
    
    
}

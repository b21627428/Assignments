

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SportProduction {
    
    
    /* Bu method sport.txt deki bilgileri sport nesnelerine atayıp bu nesnelerden oluşan arrayi döndürmeyi sağlar */
    public static Sport[] produceMethod(String filename){
        
        String str;
         int count = 0 ,  numberOfLine= NumberOfLine.getNumberOfLine(filename);
        String [][]data = new String[numberOfLine][];
        Sport []sArray = new Sport[numberOfLine];
        
        /* Alttaki ilk try-catch kısmında sport.txt deki bilgileri çekip data adlı 2 boyutlu listeye atıyoruz */
        try{
	FileInputStream fStream  =    new FileInputStream(filename);
	DataInputStream dStream =     new DataInputStream(fStream);
	BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
	            
                while( (str = bReader.readLine() )  != null){
                        
                        data[count] = str.split("\t");
                        count++;
	                
	}
	
                dStream.close();
                
        } catch(Exception e){
                
            System.err.println("Hata: "+ e.getMessage());
        }
        
         /* Alttaki for döngüsünde data adlı 2 boyutlu listedeki bilgileri sport adlı nesnelerimizin özelliklerine set ediyoruz */
        for(count= 0 ; count< data.length ; count++){
            
            Sport firstSport = new Sport();
                    
            firstSport.setID( Integer.parseInt( data[count][0] ) );
            firstSport.setName( data[count][1] );
            firstSport.setBurnsCalorie( Integer.parseInt( data[count][2] ) );
            
            /* Oluşan sportlarımız sport ları tutan bir arraye atıyoruz */
            sArray[count] = firstSport;
            
          }
          
        /*Foodları tutan arrayimizi return ediyoruz */
          return sArray;
       
    }
    
     
    
   
    
}

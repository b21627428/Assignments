

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FoodProduction {
    
   
    /* Bu method food.txt deki bilgileri food nesnelerine atayıp bu nesnelerden oluşan arrayi döndürmeyi sağlar */
    public static Food[] produceMethod(String filename){
        
        String str;
         int count = 0,  numberOfLine= NumberOfLine.getNumberOfLine(filename);
        String [][]data = new String[numberOfLine][];
        Food []fArray = new Food[numberOfLine];
        
        
        /* Alttaki ilk try-catch kısmında food.txt deki bilgileri çekip data adlı 2 boyutlu listeye atıyoruz */
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
        
        /* Alttaki for döngüsünde data adlı 2 boyutlu listedeki bilgileri food adlı nesnelerimizin özelliklerine set ediyoruz */
        for(count= 0 ; count< data.length ; count++){
            
            Food firstFood = new Food();
            
            firstFood.setID( Integer.parseInt( data[count][0] ) );
            firstFood.setName( data[count][1] );
            firstFood.setGivesCalorie( Integer.parseInt( data[count][2] ) );
            
            /* Oluşan foodlarımızı food ları tutan bir arraye atıyoruz */
            fArray[count] = firstFood;
        }
         
        /*Foodları tutan arrayimizi return ediyoruz */
        return fArray;
    }
    
    
}
    
    



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HumanProduction {
    
        
    
    /* Bu method people.txt deki bilgileri human nesnelerine atayıp bu nesnelerden oluşan arrayi döndürmeyi sağlar */
    public static Human[] produceMethod(String filename){
        
        String str;
         int count = 0, numberOfLine= NumberOfLine.getNumberOfLine(filename);
        String [][]data = new String[numberOfLine][];
        Human []hArray = new Human[numberOfLine];
        
        /* Alttaki ilk try-catch kısmında people.txt deki bilgileri çekip data adlı 2 boyutlu listeye atıyoruz */
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
        
         /* Alttaki for döngüsünde data adlı 2 boyutlu listedeki bilgileri human adlı nesnelerimizin özelliklerine set ediyoruz */
        for(count= 0 ; count< data.length ; count++){
            
            Human firstHuman = new Human();
                    
            for(int count2 = 0 ; count2 <= data[count].length ; count2++){
                        
                        if ( count2 ==0){
                            firstHuman.setID( Integer.parseInt( data[count][count2] ) );
                        }
                        else if( count2 == 1){
                            firstHuman.setName( data[count][count2] );
                        }
                        else if(count2 == 2){
                            firstHuman.setSex( data[count][count2] );
                        }
                        else if( count2 == 3){
                            firstHuman.setWeight( Integer.parseInt( data[count][count2] ) );
                        }
                        else if( count2 == 4){
                            firstHuman.setHeight( Integer.parseInt( data[count][count2] ) );
                        }
                        else if( count2  == 5){
                            firstHuman.setAge( 2018-Integer.parseInt( data[count][count2] ) );
                        }
                        else if ( count2 == 6){
                            
                            if ( firstHuman.getSex().equals("male") ){
                                firstHuman.setDailyNeedsCalorie((int) Math.round (  ( firstHuman.getHeight()  * 5 ) + 66 + (13.75 *  firstHuman.getWeight()  ) - (6.8 *  firstHuman.getAge()  ) ) );
                            }
                            else{
                                firstHuman.setDailyNeedsCalorie((int) Math.round (  665 + (9.6 * firstHuman.getWeight() ) + (1.7* firstHuman.getHeight() ) - (4.7 *  firstHuman.getAge() ) ) );
                            }
                                
                        }
                        
                }
                
                /* Oluşan humanlarımız human ları tutan bir arraye atıyoruz */
                hArray[count] = firstHuman;
                
                    
        }
       
        /*Humanları tutan arrayimizi return ediyoruz */
        return hArray;
       
    }
    
  
    
}

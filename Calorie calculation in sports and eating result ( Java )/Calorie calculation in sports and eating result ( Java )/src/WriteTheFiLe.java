

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class WriteTheFiLe {

       
    public static void commandsCompare( String filename , Human []hArray , Food []fArray , Sport []sArray ){
          
           
         int firstLetter ,lastLetter , Word;
         String str;
         int count = 0,count2, humanID , sportOrFoodID , TimeOrPortion, numberOfHuman=0;
         int  numberOfLine= NumberOfLine.getNumberOfLine(filename);
         String [][]data = new String[numberOfLine][];
         Human []printListArray = new Human[numberOfLine];
         
         /*Alltaki ilk try-catch kısmında args[0] daki bilgiler çekilip data adlı array e atılır */
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
        
        
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        
        try{    
            
              fWriter = new FileWriter("monitoring.txt");    //output dosyası açılır.
              writer =  new BufferedWriter(fWriter);
              
            
              for(count= 0 ; count< data.length ; count++){                  

                  /*Alltaki try -catch de bilgiler  integer a çevirilmeye çalışılır . Eğer integere dönmüyor ve hata veriyorsa catch kısmına girer. 
                  
                  Try kısmında ->  yemek yeme veya spor yapma komutları gerçekleştirilir.
                  
                  Catch kısmında -> print(----) veya printList komutları gerçekleştirilir..
                 
                  */
                  try{

                      humanID = Integer.parseInt(data[count][0] );
                      sportOrFoodID = Integer.parseInt(data[count][1]);
                      TimeOrPortion = Integer.parseInt(data[count][2]);


                      for( int count3 = 0; count3 < hArray.length ; count3++){


                               if (humanID == hArray[count3].getID()){            //   Oluşturulan bütün humanlar arasında args[0] dosyasındaki humanın ID kıyaslaması yapılır.


                                          if ( sportOrFoodID < 2000){    // Eğer sportOrFoodID 2000 den küçükse bu bir yemek ID sidir

                                                   for ( count2 = 0; count2 < fArray.length ; count2++){  

                                                           if  ( sportOrFoodID == fArray[count2].getID()){    //   Oluşturulan bütün foodlar  arasında args[0] dosyasındaki humanın yediği yemeğin  ID  si ile kıyaslama yapılır.
                                                                
                                                               /* Food un özelliklerine ve portion sayısına göre human ın aldığı kaloride setTakesCalorie methodu ile değişiklik yapılır */
                                                                hArray[count3].setTakesCalorie ( hArray[count3].getTakesCalorie() + ( fArray[count2].getGivesCalorie() * TimeOrPortion ) );  
                                                                
                                                                /*Gerçekleşen değişikliğin monitorin.txt ye yazdırılma kısmı  */
                                                                if (count != 0){
                                                                    writer.write("***************");
                                                                    writer.newLine();        
                                                                }
                                                                
                                                                
                                                                writer.write(hArray[count3].getID()+"\thas\ttaken\t"+fArray[count2].getGivesCalorie() * TimeOrPortion+"kcal\tfrom\t"+ fArray[count2].getName());
                                                                writer.newLine();

                                                                /* Aşağıda
                                                                    printList komutu için üzerinde değişiklik yapılan human printListArray e atılır. Ama önceden değişiklik yapılmışsa ve bu arrayde bu human bulunuyorsa 
                                                                    atama gerçekleştirilmez. Bu amaçla boolen variable kullanılmıştır.  numberofHuman değişkeninde de üzerinde değişiklik yapılan human sayısı bulunabilir. */
                                                                
                                                                boolean test = false;


                                                                  for(int count4 = 0 ; count4 < numberOfHuman ; count4++){

                                                                      if (printListArray[count4].getID() == humanID){

                                                                               test = true;
                                                                      }


                                                                 }


                                                                  if ( test != true){

                                                                      printListArray[numberOfHuman] = hArray[count3];

                                                                      numberOfHuman++;


                                                                  }

                                                           }
                                                   }
                                          }

                                          else{   // Eğer sportOrFoodID 2000 den büyükse bu bir sport ID sidir

                                              for ( count2 = 0; count2 < sArray.length ; count2++){

                                                           if  ( sportOrFoodID == sArray[count2].getID()){    //   Oluşturulan bütün sportlar  arasında args[0] dosyasındaki humanın yaptığı sporun  ID  si ile kıyaslama yapılır.
                                                               
                                                               /* Sport un özelliklerine ve time a göre human ın yaktığı kaloride setBurnsCalorie methodu ile değişiklik yapılır */
                                                               hArray[count3].setBurnsCalorie( hArray[count3].getBurnsCalorie() + ( sArray[count2].getBurnsCalorie() * TimeOrPortion/60 ) );
                                                               
                                                               /*Gerçekleşen değişikliğin monitorin.txt ye yazdırılma kısmı  */
                                                               if (count != 0){
                                                                   writer.write("***************");
                                                                   writer.newLine();
                                                               }
                                                              
                                                               
                                                               writer.write(hArray[count3].getID()+"\thas\tburned\t "+sArray[count2].getBurnsCalorie() * TimeOrPortion/60+"kcal \tthanks \tto\t"+ sArray[count2].getName());
                                                               writer.newLine();
                                                               
                                                               
                                                               /* Aşağıda 
                                                                    printList komutu için üzerinde değişiklik yapılan human printListArray e atılır. Ama önceden değişiklik yapılmışsa ve bu arrayde bu human bulunuyorsa 
                                                                    atama gerçekleştirilmez. Bu amaçla boolen variable kullanılmıştır.  numberofHuman değişkeninde de üzerinde değişiklik yapılan human sayısı bulunabilir. */
                                                               
                                                               boolean test = false; 


                                                               for(int count5 = 0 ; count5 < numberOfHuman ; count5++){

                                                                      if (printListArray[count5].getID() == humanID){

                                                                               test = true;
                                                                      }

                                                                 }

                                                                  if ( test != true){

                                                                      printListArray[numberOfHuman] = hArray[count3];

                                                                      numberOfHuman++;



                                                                  }


                                                           }
                                                   }

                                            }

                                 }
                       }




                  }catch(Exception e){

                           if ( data[count][0].equals("printList")  ){  //    if   ->>> Eğer komut printList eşitse      else ->>> Eğer komut print(-----) ise 

                               /* monitoring.txt adlı dosyaya printListArray deki humanlar bastırılır */
                               if (count != 0) {
                                   
                                   writer.write("***************");
                                   writer.newLine();
                               }
                               for( int count3 = 0; count3 < numberOfHuman ; count3++){

                                   writer.write(printListArray[count3].getName()+"\t");
                                   
                                   writer.write(printListArray[count3].getAge()+"\t");
                                   
                                   writer.write(printListArray[count3].getDailyNeedsCalorie()+"kcal\t ");
                                   
                                   writer.write(printListArray[count3].getTakesCalorie()+"kcal\t ");
                                   
                                   writer.write(printListArray[count3].getBurnsCalorie()+"kcal\t ");
                                   
                                   if ( printListArray[count3].getTotalCalorie() < 0){
                                       
                                       
                                       writer.write(printListArray[count3].getTotalCalorie()+"kcal");
                                       
                                   }
                                   else{
                                       
                                       writer.write("+"+printListArray[count3].getTotalCalorie()+"kcal");
                                       
                                   }
                                   writer.newLine();

                               }


                           }
                           else{

                               firstLetter =  data[count][0].indexOf("(")+1;      //  print(12345) örneğindeki "(" karakterinin indeksini alır.
                               lastLetter =  data[count][0].indexOf(")");           // print(12345) örneğindeki  ")" karakterinin indeksini alır.
                               Word  = Integer.parseInt( data[count][0].substring(firstLetter, lastLetter) );     /* print(12345) örneğindeki  parantez arasındaki sayıyı  indeksler yardımyla elde  eder ve Word denilen 
                                                                                                                                                               değişkene atar */

                               if (count != 0){
                                   
                                   writer.write("***************");
                                   writer.newLine();
                               }
                               for( int count3 = 0; count3 < numberOfHuman ; count3++){

                                   if ( Word == printListArray[count3].getID()){   /* monitoring.txt adlı dosyaya printListArray deki   ID si Word ile eşleşen humanın özelliklerini basar */


                                           writer.write(printListArray[count3].getName()+"\t");
                                            
                                            writer.write(printListArray[count3].getAge()+"\t");
                                            
                                            writer.write(printListArray[count3].getDailyNeedsCalorie()+"kcal\t ");
                                            
                                            writer.write(printListArray[count3].getTakesCalorie()+"kcal\t");
                                            
                                            writer.write(printListArray[count3].getBurnsCalorie()+"kcal\t ");
                                            
                                            if ( printListArray[count3].getTotalCalorie() < 0){
                                                
                                               
                                                writer.write(printListArray[count3].getTotalCalorie()+"kcal");
                                                
                                            }
                                            else{
                                                
                                                
                                                writer.write("+"+printListArray[count3].getTotalCalorie()+"kcal");
                                                
                                            }
                                            writer.newLine();
                                   }

                               }




                           }





                   }


               }
              
              writer.close();
        
        }catch(Exception a){
            
            System.err.println("Hata: " + a.getMessage());
            
            
        }
           
         
                
                
        }
            
            
                    
   }
        
           
           
           
           
  

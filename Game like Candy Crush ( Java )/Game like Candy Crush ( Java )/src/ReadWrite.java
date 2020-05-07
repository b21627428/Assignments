

import java.io.*;
import java.util.*;


public abstract class ReadWrite {
    
    private static Jewel array[][];
    private static int row ,column;
    private static Human player = new Human();
    
    public static void createMap(String filename){
        
        row = NumberOf.getRow(filename);         // gameGrid.txt açılıp row sayısı elde edilir.
        column = NumberOf.getColumn(filename);    // gameGrid.txt açılıp column sayısı elde edilir.
               
        array = new Jewel[ row ][ column ];          // 2 boyutlu jewellerden oluşan bir array oyani map oluşturulur.
        
    }
    
    public static void fillMap(String filename) {
        
        String str;
        String[] array2;
        int count = 0;
        
        try{
            
            FileInputStream fStream  =    new FileInputStream(filename);
            DataInputStream dStream =     new DataInputStream(fStream);
            BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
            System.out.println("Game grid:\n");
	            
            while( (str = bReader.readLine() )  != null){         // gameGrid.txt deki map jewellerden oluşan mapimize aktarılır.
                
                array2 = str.split(" ");
                
                for(int i=0 ; i< array2.length ; i++){
                    
                    if ( array2[i].equals("D")   ){
                        
                        array[count][i] = new Diamond();
                    }
                    else if ( array2[i].equals("S")    ){
                        
                        array[count][i] = new Square();
                    }
                    else if ( array2[i].equals("T")    ){
                        
                        array[count][i] = new Triangle();
                    }
                    else if ( array2[i].equals("W")     ){
                        
                        array[count][i] = new Wildcard();
                    }
                    else{
                        
                        if(  array2[i].equals("/")   ){
                            
                            array[count][i] = new Slash();
                        }
                        else if( array2[i].equals("-")  ){
                            
                            array[count][i] = new Minus();
                        }
                        else if( array2[i].equals("+")  ){
                            
                            array[count][i] = new Plus();
                        }
                        else if ( array2[i].equals("|")  ){
                            
                            array[count][i] = new Line();
                        }
                        else{
                            
                            array[count][i] = new ReverseSlash();               
                        }
                        
                    }
                    
                    
                    System.out.print(array[count][i].getName()+" ");
                    
                }
                
                System.out.println("");
                count++;
               
              
	    }
                
	
                dStream.close();
                
        }catch(Exception e){
                
            e.printStackTrace();
        }
    }
    
    public static void playGame(InputStream filename){
       
        
        int rowCoordinate , columnCoordinate ;
        boolean test;
        
        try{
            

            BufferedReader bReader =      new BufferedReader( new InputStreamReader(filename) );
            String str = null;


            System.out.print("\nSelect coordinate or enter E to end the game: ");
            
            while((str = bReader.readLine())!= null){
                
                
                try{      // koordinat kıyaslama kısmı
                    
					System.out.println("");
					
                    rowCoordinate = Integer.parseInt( (str.split(" "))[0] );
                    columnCoordinate = Integer.parseInt( (str.split(" "))[1] );


                    
                    Jewel jewelTemp = array[rowCoordinate][columnCoordinate];
                    
					try{
                        
						test = jewelTemp.compare(rowCoordinate, columnCoordinate ,row,column ,array );
                    }  // array i kıyaslama ve shifting yapma kısmı (her jewel için farklı interface sayseinde)
                    catch(Exception e){
                        
                        test = true;
                    }
                    
                    for(int k=0 ; k<row ; k++){
                        for(int j=0 ; j<column ; j++){
                            if (array[k][j] != null)      System.out.print(array[k][j].getName()+" "); //outputList.add(array[k][j].getName()+" ");
                            else                          System.out.print("  ");   // outputList.add("  ");
                        }
                        System.out.println("");

                    }                    
                    if(test == true){         // Eğer 3 lü eşleşen jewel yoksa bu hata mesajı verilir.
                        
                        System.out.println("\nThere is no match");
                        System.out.println("\nScore: 0 points.");


                    }       
                    else{
                        
                        player.setPoint( player.getPoint() + jewelTemp.getPoint() );   // player pointi güncellenir 
                        System.out.println("\nScore: "+jewelTemp.getPoint()+ " points.");

                    }

                }
                catch(Exception e){
                    
                    System.out.println("Total Score: " + player.getPoint()+" points\n");
                    
                    break;
                    
                    // E kısmı ( oyundan çıkış )
                    
                }
                
                System.out.print("Select coordinate or enter E to end the game: ");
                
            }
            System.out.print("Enter name: ");
            str = bReader.readLine();   // İsmi okur . Oyunun oynayan kişinin ismine atama yapar.
            
            player.setName(str);

                    
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
	
    }
    
    public static void compareLeaderBoard(String filename){
        
        ArrayList<Human> playerArray = new ArrayList<Human>();
        
        String str;
        int count = 0;
       
        FileWriter fWriter = null;
        BufferedWriter writer = null; 
     
        try{
            
            FileInputStream fStream  =    new FileInputStream(filename);
            DataInputStream dStream =     new DataInputStream(fStream);
            BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
            fWriter = new FileWriter(filename,true);    //leaderboard.txt dosyası açılır.
            writer =  new BufferedWriter(fWriter);
            
            while( (str = bReader.readLine() )  != null){
                

                // Leaderboard.txt deki insanları listeye atar
                    
                playerArray.add( new Human( (str.split(" "))[0] , Integer.parseInt( (str.split(" "))[1] ) )  );
                
            }
            
            Collections.sort(playerArray,  new Comparator<Human>() {             // playerArrayi sort eder
                @Override
                public int compare(Human player1, Human player2) {
                    
                    int player1Point = player1.getPoint();
                    int player2Point = player2.getPoint();
                    
                    if(player1Point > player2Point){
                        
                        return -1;
                    }
                    else{
                        
                        return 1;
                    }
                }
            });
            
                
            Human lowerHuman = null;
            Human higherHuman = null;
            int lowerHumanPointDifference = 0 , higherHumanPointDifference = 0,rank = 0,numberOfPlayer = playerArray.size()+1 ;
                
            for( int i=0 ; i< playerArray.size() ; i++){                    

                if(player.getPoint() > playerArray.get(i).getPoint() ){
                        
                    lowerHuman = playerArray.get(i);
                    lowerHumanPointDifference = player.getPoint() - lowerHuman.getPoint();
                    rank = i+1;
                }
                if ( player.getPoint() < playerArray.get(i).getPoint() ){
                        
                    higherHuman = playerArray.get(i);
                    higherHumanPointDifference = higherHuman.getPoint() - player.getPoint();
                    rank = i-1;
                }
                    
            }
            if( lowerHuman != null && higherHuman != null){
                
                System.out.println("Your rank is "+rank+"/"+numberOfPlayer+" your score is "+lowerHumanPointDifference+" points higher than "+ lowerHuman.getName()+ " and "
                                                                                            +higherHumanPointDifference+" points lower than "+ higherHuman.getName()       );
                
            }
            else if( lowerHuman != null && higherHuman == null){
                
                System.out.println("Your rank is 1/"+numberOfPlayer+" your score is "+lowerHumanPointDifference+" points higher than "+ lowerHuman.getName()        );
                                       
            }
            else if( lowerHuman == null && higherHuman != null){
                
                System.out.println("Your rank is "+numberOfPlayer+"/"+numberOfPlayer+" your score is "+higherHumanPointDifference+" points lower than "+ higherHuman.getName()         );
                  
            }
            else if( lowerHuman == null && higherHuman == null){
                
                System.out.println("Your rank is 1/1 your score is "+player.getPoint()     );
            }
            
            System.out.println("\nGood bye!");
            
            writer.newLine();
            writer.write(player.getName()+" "+player.getPoint());
            
            writer.close();      
            dStream.close();
                    
        }catch(Exception e){
            
            e.printStackTrace();
        }        
    
    }


    
    
    
    
    
    
    
    
    
    
    
    
}

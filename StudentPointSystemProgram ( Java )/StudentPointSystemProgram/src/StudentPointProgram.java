import java.io.*;
import java.util.*;

public abstract class StudentPointProgram {

	private static Map<String , Student> studentsMap =  new TreeMap<String , Student>();
	private static  String filename;
	private static Scanner input = new Scanner(System.in);

	public static void Works(String filename) {
		
		StudentPointProgram.filename  = filename;                       String choice;                      int flag = 0;     boolean fileOpenTest;
		
		try {
			
			fileOpenTest = LoadTheStudents();
			 
			if ( fileOpenTest ) {
					
					while( true) {
						
						System.out.print("\n\n1 - AddTheStudent\n2 - RemoveTheStudent\n3 - SearchTheStudent\n4 - ListAllTheStudents\n5 - Exit\n\nEnter a Number : ");
						choice = input.nextLine(); 
						
						try {
							
							switch(Integer.parseInt(choice)){
								
								case 1:        AddTheStudent();           break;
								case 2 :      RemoveTheStudent();   break;
								case 3:       SearchTheStudent();      break;
								case 4 :      ListAllTheStudents();    break;
								case 5 :      flag = 1;                                    break;
								default:    flag = -1;                                  System.out.print("\nYou entered wrong number.\n\n") ;            break;
							
							}
						}catch(Exception e) {
								
							System.out.println("\nYou entered not a number.\n\n");
						}
						if ( flag == 1)  break;
						if ( flag == -1) continue;
									
					}
					SaveTheStudents();
			 }
			
		}catch(Exception e){
			
			System.out.println("Hata : "+ e.getMessage());
		}
	}	
	
	
	public   static boolean LoadTheStudents() {
		
		String information ;       
		String   []tempInformationList;	
		
		try {

			FileInputStream fStream  =    new FileInputStream(filename);            
    		DataInputStream dStream =     new DataInputStream(fStream);				
    		BufferedReader bReader =      new BufferedReader( new InputStreamReader(dStream) );
            
    		while( (information = bReader.readLine() )  != null){     
    			
    			tempInformationList = information.split(" ");
    			
    			studentsMap.put( tempInformationList[0] , new Student(tempInformationList[1] , 
    																																				tempInformationList[2] , 
    																																				tempInformationList[3] ,
    																																				tempInformationList[4]  )  );
    			
    		}
    	}catch(Exception e){
    		System.out.println("The file was not found ");
    		return false ;
    	}
		return true;
	}
	public  static void AddTheStudent() {
			
			float average ;      Student temp = new Student();        String number = null;
			
			for( int counter = 0 ;  counter < 4 ; counter ++) {
				
					if ( counter == 0) {
						
								System.out.print("\nAdd Enter Number  : ");      
								number = input.nextLine();
								
								if ( studentsMap.containsKey( number  ) ) {        
										System.out.print("\nThe student is already on the system..");
										break;
								}
					}
					else if ( counter == 1) {
						
									System.out.print("Name : ");             
									temp.setName( input.nextLine() );

					}
					else if ( counter ==2 ) {
								
								System.out.print("First Exam : ");   
								temp.setFirstExam ( Integer.parseInt( input.nextLine()  ));        
					}			
					else if ( counter == 3) {
								
								System.out.print("Final Exam : ");
								temp.setFinalExam( Integer.parseInt( input.nextLine()  ));
								
								average = ( temp.getFirstExam() * 40 )/100  + (temp.getFinalExam()*60)/100 ;
								if( average >  95)  temp.setAverage("A1");
								else if ( average > 90)  temp.setAverage("A2");
								else if ( average > 85) temp.setAverage("A3");
								else if ( average > 80) temp.setAverage("B1");
								else if( average > 75) temp.setAverage("B2");
								else if (average > 70) temp.setAverage("B3");
								else if( average > 65) temp.setAverage("C1");
								else if (average > 60) temp.setAverage("C2");
								else if ( average >55) temp.setAverage("C3");
								else if ( average > 50) temp.setAverage("D");
								else temp.setAverage("F");
								
								
								studentsMap.put(number , temp );
								System.out.print("\nThe student was added");
					}		
			}
    }
	public  static void RemoveTheStudent() {
			
			String number;                 Student temp = null;
		
			System.out.print("\nRemove Enter Number : ");
			number = input.nextLine();
			
			if ( studentsMap.containsKey (number  ) ) {
					temp =  studentsMap.remove(number);
					System.out.print("\n"+number +" "+ temp.getName()+" was removed.");
			}
			else {
					System.out.print("\nThe student was not found.");
			}
			
	}
	public  static void SearchTheStudent() {
			
			String number ;      Student temp = null;
			
			System.out.print("\nSearch Enter Number : ");
			number = input.nextLine();
			
			if ( studentsMap.containsKey (number  ) ) {
					temp = studentsMap.get(number);
					System.out.print("\n" + number +" "+ temp.getName()+" "+temp.getFirstExam()+" "+ temp.getFinalExam()+" "+ temp.getAverage());
			}
			else {
					System.out.print("\nThe student was not found.");
			}
	}
	public  static void ListAllTheStudents() {
			
			for ( Map.Entry<String, Student >   me : studentsMap.entrySet() ) {
				
					System.out.print("\n" + me.getKey() +" "+ me.getValue().getName()+" "+me.getValue().getFirstExam()+" "+ me.getValue().getFinalExam()+" "+ me.getValue().getAverage());
			}
	}
	
	public  static void SaveTheStudents() {
		
		FileWriter fWriter = null;               BufferedWriter writer = null;	
	    
		try{
			   
			fWriter = new FileWriter(filename);    // filename.txt opens
			writer =  new BufferedWriter(fWriter);
			
			Iterator iterator = studentsMap.entrySet().iterator();
			
			while(iterator.hasNext()) {
				
				Map.Entry<String, Student> temp  = (Map.Entry<String, Student>) iterator.next();
				
				writer.write(temp.getKey()+ " "  + 
											 temp.getValue().getName()+" "+
											 temp.getValue().getFirstExam()+" "+
											 temp.getValue().getFinalExam()+" "+
											 temp.getValue().getAverage()   );
				writer.newLine();
			}
           
           writer.close();
          
		} catch(Exception e){
          
		  System.out.println("Error of SaveTheStudents function");
		  
		}	
	}
	

}

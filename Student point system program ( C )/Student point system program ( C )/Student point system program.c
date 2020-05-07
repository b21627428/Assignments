#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef enum{
	male,
	female
	
}Sex;

typedef struct {
	
	int firstExam, finalExam;
	char name[30];
	char number[10];
	char average[2];
	Sex c;

} Student;



void LoadTheStudentsFromTXT    ( FILE *TXT , Student *studentsArray , int *studentNumber );
void AddTheStudent             ( Student *studentsArray , int *studentNumber );
void RemoveTheStudent          ( Student *studentsArray , int *studentNumber );
void SearchTheStudent          ( Student *studentsArray , int *studentNumber );
void ListAllTheStudents        ( Student *studentsArray , int *studentNumber );
void SaveTheStudentsToTXT      ( FILE *TXT , Student *studentsArray , int *studentNumber , char filename[40] ); 
void sortTheArray              ( Student *studentsArray , int *studentNumber );



int main( int argc , char **argv){
	
	int studentNumber = 0  ,choice  ;       char filename[40];
	
	FILE *TXT;
	
	printf("Enter the file name : ");       scanf("%s",filename);  printf("\n");
	
	if( ( TXT = fopen(strcat ( filename , ".txt" ) ,"r")) != NULL ){
	
	
		Student *studentsArray = ( Student *) malloc( sizeof(Student)*1); 
		
		
		void ( *functions[4] ) (Student * , int *);
		
		functions[0] = AddTheStudent;
		functions[1] = RemoveTheStudent;
		functions[2] = SearchTheStudent;
		functions[3] = ListAllTheStudents;
		
		LoadTheStudentsFromTXT    ( TXT , studentsArray , &studentNumber);
		
		while( 1 ){
			
			printf("\n\n1 - AddTheStudent\n2 - RemoveTheStudent\n3 - SearchTheStudent\n4 - ListAllTheStudents\n5 - Exit\n\nEnter a Number : ");       scanf("%d",&choice);
			
			if (  (choice == 1) || (choice == 2) || (choice == 3) || (choice == 4 )   )  functions[choice-1]( studentsArray , &studentNumber);   
			else if (choice == 5)  break;
			else{	printf("\nYou entered wrong number.\n\n"); continue;	}   
			
		}
	
	
		SaveTheStudentsToTXT      ( TXT , studentsArray , &studentNumber , filename); 	  
	
	}
	
	else printf("The file was not found");
	
	return 0; 
}


void AddTheStudent( Student *studentsArray , int *studentNumber){
	
	Student *p;        int i ,counter = 0  , flag = 0 , j ;    float average ;  char tempNumber[15];
	
	studentsArray = ( Student *) realloc ( studentsArray , ( (*studentNumber)+1 ) * sizeof(Student) );
		
	for( p=studentsArray , i=0 ; i< (*studentNumber) ; i++ , p++);
	
	while (counter <4){
		
		if (counter == 0){
			
			printf("\nAdd Enter Number   : ");  scanf("%s",tempNumber);
			
			for(j=0 ; j< (*studentNumber); j++){
				
				if( strcmp( studentsArray[j].number , tempNumber) == 0 ){
					
					flag = 1;
					printf("\nThere are a student who has same number.\n\n");
				}
			}
			if(flag == 1)  break;
			else  strcpy( (*p).number , tempNumber ); 
		}
		else if (counter == 1){
			printf("Name     : ");  scanf("%s",(*p).name); 
		}
		else if (counter == 2){
			printf("FirstExam: ");  scanf("%d",&(*p).firstExam);
		}
		else{
			printf("LastExam : ");  scanf("%d",&(*p).finalExam);
		}
		counter++;	
	}
	
	
	if(flag == 0){
		
		printf("\nThe student was added\n\n");
		
		average = (  ( ((*p).firstExam*40)/100) + ( ( ((*p).finalExam)*60)/100) );
		
		if      ( average >= 95 )   strcpy( (*p).average , "A1" ) ;  
		else if ( average >= 90 )   strcpy( (*p).average , "A2" ) ;   
		else if ( average >= 85 )   strcpy( (*p).average , "A3" ) ;  
		else if ( average >= 80 )   strcpy( (*p).average , "B1" ) ;   
		else if ( average >= 75 )   strcpy( (*p).average , "B2" ) ;  
		else if ( average >= 70 )   strcpy( (*p).average , "B3" ) ;  
		else if ( average >= 65 )   strcpy( (*p).average , "C1" ) ;  
		else if ( average >= 60 )   strcpy( (*p).average , "C2" ) ;  
		else if ( average >= 55 )   strcpy( (*p).average , "C3" ) ;  
		else if ( average >= 50 )   strcpy( (*p).average , "D"  ) ;  
		else                        strcpy( (*p).average , "F"  ) ;  
		
		(*studentNumber)++;
		
		sortTheArray( studentsArray , studentNumber );		
		
	}
}

void RemoveTheStudent( Student *studentsArray , int *studentNumber){
	
	char number[15];      int counter = 0  , flag = 0;    
	
	printf("\nRemove Enter number: ");     scanf("%s",number);
	
	for( ; counter < (*studentNumber) ; counter++ ){
		
		if( strcmp( studentsArray[counter].number , number) == 0 ){
			
			if(counter != ( (*studentNumber)-1) ){
				
				for ( counter++ ; counter < (*studentNumber) ; counter++){
					
					strcpy( studentsArray[counter-1].number  , studentsArray[counter].number     );
					strcpy( studentsArray[counter-1].name    , studentsArray[counter].name          );
					        studentsArray[counter-1].firstExam = studentsArray[counter].firstExam     ;
					        studentsArray[counter-1].finalExam = studentsArray[counter].finalExam    ;
					strcpy( studentsArray[counter-1].average , studentsArray[counter].average     );
				}				
			}
			(*studentNumber)--;
			
			studentsArray = ( Student * ) realloc ( studentsArray , (*studentNumber) * sizeof(Student) );
			
			flag = 1 ;       printf("\nThe student was removed\n\n");    		sortTheArray( studentsArray , studentNumber ); 
			
			break;
			
		}	
	}	
	
	if(flag == 0)  printf("\nThe student was not found\n\n");

}

void SearchTheStudent( Student *studentsArray , int *studentNumber){
	
	char number[15];      int counter = 0 , flag = 0;      Student *student;  
	
	if ( (*studentNumber != 0) ) {
		
		printf("\nSearch Enter number: ");     scanf("%s",number);
	}
	else flag = -1;
	
	for( ; counter < (*studentNumber) ; counter++ ){
		
		if( strcmp( studentsArray[counter].number , number) == 0 ){
			
			student = &studentsArray[counter];
			
			printf("\n%s %s %d %d %s\n\n", (*student).number, (*student).name , (*student).firstExam , (*student).finalExam , (*student).average );
			
			flag = 1;  
			
		}	
	}
	
	if(flag == 0){
		printf("\nThe student was not found.\n\n");
	}
	else if(flag == -1){
		printf("There is nobody on the system\n\n");
	}

	
}

void ListAllTheStudents ( Student *studentsArray , int *studentNumber){
	
	int counter = 0;    Student student;
	
	if ( (*studentNumber != 0) ) printf("\nNumber--Name---FirstExam---FinalExam---Average\n\n");
	else printf("There is nobody on the system\n\n");

	for( ; counter < (*studentNumber) ; counter++){
		
		student = studentsArray[counter];
		
		printf("%s %s %d %d %s\n", student.number, student.name, student.firstExam, student.finalExam, student.average);
		
		if(counter == (*studentNumber)-1)  printf("\n");
		
	} 
}

void LoadTheStudentsFromTXT( FILE *TXT , Student *studentsArray ,int *studentNumber ){	
	
	int i;   Student *p ;     
	
	while( !feof(TXT) ){
		
		studentsArray = ( Student *) realloc ( studentsArray , ( (*studentNumber) +1) * sizeof(Student) );
		
		for( p=studentsArray , i=0 ; i< (*studentNumber) ; i++ , p++);

		fscanf( TXT , "%s %s %d %d %s",(*p).number , (*p).name ,&(*p).firstExam ,&(*p).finalExam ,(*p).average);	
		
		(*studentNumber)++;
		

	}
	(*studentNumber)--;
	
	
}

void SaveTheStudentsToTXT( FILE *TXT , Student *studentsArray , int *studentNumber , char filename [40] ){
	
	int i ;   Student *p ;         	fclose(TXT);      TXT = fopen(filename,"w");
	
	for( i=0 ; i< (*studentNumber) ; i++){
		
		p = &studentsArray[i];
		fprintf( TXT , "%s %s %d %d %s\n", (*p).number , (*p).name , (*p).firstExam , (*p).finalExam , (*p).average);
	}
}

void sortTheArray( Student *studentsArray , int *studentNumber){
	
	int i , j;    Student student;
	
	for(i=0  ;  i< (*studentNumber )-1 ; i++){
		
		for(j=0 ; j< (*studentNumber)-1 ; j++){
			
			if( atoi( studentsArray[j].number )   >  atoi( studentsArray[j+1].number) ){
				
				strcpy( student.number , studentsArray[j].number);
				strcpy( student.name , studentsArray[j].name);
				strcpy( student.average , studentsArray[j].average);
				student.firstExam = studentsArray[j].firstExam;
				student.finalExam = studentsArray[j].finalExam;				
				
				strcpy( studentsArray[j].number , studentsArray[j+1].number);
				strcpy( studentsArray[j].name , studentsArray[j+1].name);
				strcpy( studentsArray[j].average , studentsArray[j+1].average);
				studentsArray[j].firstExam = studentsArray[j+1].firstExam;
				studentsArray[j].finalExam = studentsArray[j+1].finalExam;				
				
				strcpy( studentsArray[j+1].number , student.number);
				strcpy( studentsArray[j+1].name , student.name );
				strcpy( studentsArray[j+1].average , student.average);
				studentsArray[j+1].firstExam = student.firstExam;
				studentsArray[j+1].finalExam = student.finalExam;				
				
			}
		}
	}	
	
	
}


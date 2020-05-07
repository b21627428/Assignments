//Ýnclude edilen kütüphaneler
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//Structlar
typedef enum{
	male,
	female
	
}Sex;


typedef struct student{
	
	struct student *next;
	int student_number , first_exam , final_exam ;
	char average[3] , name[50];
	Sex gender;
	
}Student;

//Global pointerlar
Student *head = NULL;

//Fonksiyonlarýn prototipleri
void Load();
void Save();

void List();
void Add();
void Remove();
void Search();

int main(){

	int choice;
	
	Load();
	
	void ( *functions[4] ) ();
		
	functions[0] = Add;
	functions[1] = Remove;
	functions[2] = Search;
	functions[3] = List;	
	
	while( 1 ){
			
		printf("\n\n1 - AddTheStudent\n2 - RemoveTheStudent\n3 - SearchTheStudent\n4 - ListAllTheStudents\n5 - Exit\n\nEnter a Number : ");       scanf("%d",&choice);
			
		if (  (choice == 1) || (choice == 2) || (choice == 3) || (choice == 4 )   )  functions[choice-1]();   
		else if (choice == 5)  break;
		else{	printf("\nYou entered wrong number.\n\n"); continue;	}   
			
	}
	
	Save();
}

//-----------------
void Load(){      // Program daha önce kullanýlmýþ ve sistemde öðrenci varsa bu öðrenciler load edilir.
	
	FILE *input = fopen("scoreTable.txt","r");
	
	if( input ){  // Eðer dosya var ve açýlýrsa 
		
		char str[350], *pch;    int counter ;   Student *p = NULL , *tail = NULL;;    
		
		while( !feof(input) ){
			
			fgets(str,350,input);   // Satýr satýr okuma kýsmý
			str[ strcspn(str , "\n")] = 0;
			
			if( strlen(str) > 1 ){  // Eðer boþ satýrsa
				
			    p = (Student*) malloc( sizeof(Student)*1);  // Yeni yer ayýrma kýsmý
				p->next = NULL;
				
				pch = strtok(str," ");    // Split kýsmý
				counter = 0;
				
				while( pch != NULL ){    // Splitin devamý için yazýlýr
					
					switch(counter){  // Split edilen bilgiler oluþturulan öðrencinin bilgilerine atanýr.
						
						case 0: p->student_number = atoi(pch);    break; 
						case 1:	strcpy(p->name , pch );           break;
						case 2: p->first_exam = atoi(pch);        break;
						case 3: p->final_exam = atoi(pch);        break;
						case 4: strcpy(p->average , pch );        break;
					}
					counter++;
					pch = strtok(NULL," ");
				}
				
				if( head == NULL ){
					
					head = tail = p;
				}
				else{
	
					tail->next = p;
					tail = p;			
				}
			}	
		}
		fclose(input);	
	}	
}
//------------------
void Save(){
	
	FILE *output = fopen("scoreTable.txt","w+");
	
	if(output){
		
		Student *p = head;
		
		while(p){
			
			fprintf(output,"%d %s %d %d %s",p->student_number,p->name,p->first_exam,p->final_exam,p->average);
			
			if(p->next != NULL) fprintf(output,"\n");
			
			p = p->next ;
		}
		
		
		
		fclose(output);
	}	
	
	
	
}



//------------------
void Remove(){
	
	
	if( head == NULL){   // Liste boþsa
		
		printf("There is nobody on the system\n");
	}
	else{
		
		int student_number;
		Student *p = head , *q = NULL;
		
		printf("Enter a number: ");   scanf("%d",&student_number);
		
		while(p){
			
			if(p->student_number == student_number)  break;     // Eþleþme varsa döngüden çýk. 
			
			q = p;
			p = p->next;
		}
		if( p == NULL ){  // Öðrenci yoksa
			
			printf("The student was not found\n");
			
		}
		else{        // Öðrenci varsa

			if( q == NULL){   // Listenin baþýndaysa
			
				head = p->next;
				free(p);
			}			
			else{    // Listenin ortasýnda veya sonunda silme durumu
			
				q->next = p->next;
				free(p);
			}
			printf("The student was removed\n");
		}
	}
}
//------------------
void List(){
	
	if( head == NULL ){  // Liste boþsa
		
		printf("There is nobody on the system\n");
	}
	else{
		
		Student *p = head;
		
		while(p){
			
			printf("%d %s %d %d %s\n",p->student_number , p->name , p->first_exam , p->final_exam , p->average );
			
			p = p->next;
		}
	}	
}
//------------------
void Add(){
	
	int counter = 0 , student_number ;
	
	Student *p = head, *q = NULL , *r;
	
	while( counter < 4 ){
		
		if(counter == 0){
	
			printf("Add Enter Number: "); scanf("%d", &student_number);
		
			while(p && p->student_number < student_number ){
			
			
				q = p;
				p = p->next;			
			}
			if(p && p->student_number == student_number){
				
				printf("There is already same number\n");
				break;
				
			}else{
				
				r = (Student*) malloc(sizeof(Student)*1);
				r->student_number = student_number;
				
				if( q == NULL ){
					
					head = r;
					r->next = p;
				}
				else{
					
					q->next = r;
					r->next = p;
				}
			}
			
		}
		else if(counter==1){
			
			printf("Name     : ");  scanf("%s",r->name);
		} 
		else if(counter==2){
			
			printf("FirstExam: ");  scanf("%d",&r->first_exam);
		}
		else if(counter==3){
			
			printf("LastExam : ");  scanf("%d",&r->final_exam);
		}
		counter++;
	}
	
	float average = (  ( (r->first_exam*40)/100) + ( ( (r->final_exam)*60)/100) );
		
	if      ( average >= 95 )   strcpy( r->average , "A1" ) ;  
	else if ( average >= 90 )   strcpy( r->average , "A2" ) ;   
	else if ( average >= 85 )   strcpy( r->average , "A3" ) ;  
	else if ( average >= 80 )   strcpy( r->average , "B1" ) ;   
	else if ( average >= 75 )   strcpy( r->average , "B2" ) ;  
	else if ( average >= 70 )   strcpy( r->average , "B3" ) ;  
	else if ( average >= 65 )   strcpy( r->average , "C1" ) ;  
	else if ( average >= 60 )   strcpy( r->average , "C2" ) ;  
	else if ( average >= 55 )   strcpy( r->average , "C3" ) ;  
	else if ( average >= 50 )   strcpy( r->average , "D"  ) ;  
	else                        strcpy( r->average , "F"  ) ;     	
}

//--------------------
void Search(){
	
	if( head == NULL ){  // Liste boþsa
		
		printf("There is nobody on the system\n");
	}
	else{
		
		Student *p = head;
		int number;
		
		printf("Enter a number: ");    scanf("%d",&number);
		
		while(p){
			
			if(p->student_number == number)  break;
			
			p = p->next;
		}
		if( p == NULL ){
			
			printf("The student was not found\n");
		}
		else{
			
			printf("%d %s %d %d %s\n",p->student_number , p->name , p->first_exam , p->final_exam , p->average );
		}
	}	
	
	
}

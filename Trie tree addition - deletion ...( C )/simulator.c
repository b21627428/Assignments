#include "functions.h"


void simulator(char *inputTextName, char *outputTextName){
	

	FILE *iptr , *optr;
	
	if( iptr = fopen(inputTextName,"r") ){         // input.txt açýlýþyorsa
		
		optr = fopen(outputTextName,"w");
		
		
		
		node *head = (node*) malloc( sizeof(node) * 1 );         // root oluþturma kýsmý
			
		int counter = 0;        char name[35]  ;
			
		while(counter < 26){
				
			head->alphabet[counter] = '\0';
				
			counter++;
		}
			
		head->password = '\0'; 		
		
			
		
		
		
		
		char temp[100] , *pointer , komut[5] , isim[40], sifre[40];
		
			
		while( !feof(iptr)){             // compare yap ona göre fonksiyonlarý çaðýr
			
			fgets(temp,100,iptr);
			
			counter = 0;
			temp[ strcspn(temp , "\r\n") ] =0;
			
			pointer = strtok(temp," ");
			
			
			
			
			while(pointer){          // parametreleri bir araya toplama kýsmý
				
				if(counter==0){
					
					strcpy(komut,pointer);
				}
				else if(counter==1){
					
					strcpy(isim,pointer);
				}
				else if(counter==2){
					
					strcpy(sifre,pointer);
				}
				
				counter++;
				pointer = strtok(NULL," ");
				
			}
			
			
			// KIYASLAMA KISMI
			 
			if( strcmp(komut,"-a") == 0){             
				
				addNode(optr,head,isim, atoi(sifre));
			}
			else if( strcmp(komut,"-s") == 0){
				
				searchNode(optr,head,isim,0);
			}	
			else if( strcmp(komut,"-q") == 0){
				
				LoginSystem(optr,head,isim,atoi(sifre));
			}
			else if( strcmp(komut,"-d") == 0){
				
				deleteNode(optr,head,isim);
			}
			else if( strcmp(komut,"-l") == 0){
				
				int secondCounter = 0,count=0;
				
				ListAll(optr,count,secondCounter,name,head,head);
			}
		}
	
		
		// Dosya kapatma kýsmý
		
		fclose(iptr);         
		fclose(optr);
	}

     
		
}

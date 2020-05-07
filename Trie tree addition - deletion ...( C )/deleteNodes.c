#include "functions.h"

void deleteNode( FILE *optr , node *head , char *name  ){
	
	node *temp = head;
	
	if(temp->alphabet[ (int)name[0]%97] == '\0' ){   // Exception
		
		fprintf(optr,"\"%s\" no record\n",name);
		return;
	}
	else{
		
		int i = 0 ;
		node *temp2 = NULL;
		
		for( ; i< strlen(name) ; i++){
			
			
			if( temp->alphabet[ (int)name[i]%97 ] == '\0' ){   // Exception
				
				fprintf(optr,"\"%s\" incorrect username\n",name);
				
				return;
			}
			
			if( temp->alphabet[ (int)name[i]%97 ]->childNumber != 1 && temp->alphabet[ (int)name[i]%97 ]->childNumber != 0 ){  // En sonki dallanmayý bulma kýsmý
				
				temp2 = temp->alphabet[ (int)name[i]%97 ];
				
			} 
			
			temp = temp->alphabet[ (int)name[i]%97 ];
			
		}
		if(temp->password == '\0'){            // Exception
			
			fprintf(optr,"\"%s\" not enough username\n",name);
			
			return;
		}
		
		
		
		
		else if( temp->password != '\0' ){      // Silme durumu oluþmuþsa
			
			if(temp->childNumber == 0){ // Herhangi bir kelimenin içinde deðilse
				
				if( temp2 != NULL ){              // Dallanma varsa  ( Yani Selim ve Selma varsa )  l noktasý en sonki dalllanmadýr. Ordan itibaren silmeler gerçekleþtirilir.
					
					
					
					
					
					
					node *temp3 = head ,*temp4 = NULL;
					int k = 0 ,j ;
					
					while(temp3!=temp2){
						
						temp3 = temp3->alphabet[ (int)name[k]%97 ];
						k++;
					}
					
					j=k;
					
					temp3 = temp3->alphabet[ (int)name[k]%97 ];
					k++;
		
					for( ; k<strlen(name) ; k++){
						
						temp4 = temp3;
						
						temp3 = temp3->alphabet[ (int)name[k]%97 ];
						
						temp4->alphabet[ (int)name[k]%97 ] = '\0';
						free(temp4);			
					}
					free(temp3);
					
					
					temp2->childNumber--;
					temp2->alphabet[ (int)name[j]%97 ] = '\0';
					
					fprintf(optr,"\"%s\" deletion is successful\n",name);
					
					
					
					
					
				}
				else{               // Dallanma yoksa      ( Yani sadece Hakan varsa )
					
					
					
					node *temp3 = head , *temp4 = NULL;
					
					int k = 0;

					temp3 = temp3->alphabet[ (int)name[k]%97 ];
					k++;
					
					while(temp3){
						
						temp4 = temp3;
						
						temp3 = temp3->alphabet[ (int)name[k]%97 ];
						
						temp4->alphabet[ (int)name[k]%97 ] = '\0';
						free(temp4);
					}
					head->alphabet[(int)name[0]%97] = '\0';
					
					fprintf(optr,"\"%s\" deletion is successful\n",name);
					
					
					
					
					
				}
			}
			else{             // Herhangi büyük bir kelimenin içindeyse
				
				
				temp->password = '\0';
				
				fprintf(optr,"\"%s\" deletion is successful\n",name);
				
			}
			
		}
		
		
	}
	
	
	
}

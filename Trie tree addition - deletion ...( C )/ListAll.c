#include "functions.h"

void ListAll( FILE *optr , int counter ,int secondCounter, char name[]  , node *head , node *temp  ){
	
	int i ,k=0 , flag = 0;
	
	if( temp != head && temp->childNumber > 1  ){             // child durumu
		
		name[counter] = '\0';
		
		i=0;
		
		for( ; i<secondCounter ; i++){
			fprintf(optr,"\t");
			
		}
		fprintf(optr,"-%s\n",name);
	     	
		
		secondCounter++;
		
		flag = 1;		

		
	}
	
	if( flag!= 1 && temp->password != '\0' ){         // mert durumu
		
		name[counter] = '\0';

		i=0;
		
		for( ; i<secondCounter ; i++){
			fprintf(optr,"\t");
			
		}		
		fprintf(optr,"-%s\n",name);
		
	}



	

	while(k!=26){
			
		if(temp->alphabet[k] != '\0'){
				
			name[ counter ] =  97 + k;
				
			ListAll( optr , counter+1 ,secondCounter ,name , head ,temp->alphabet[ k ] );
			
			
		}
			
			
		k++;
	}
	

	
	
}

#include "functions.h"


void addNode( FILE *optr , node *head , char *name , int password ){
	
	node *temp = head;

	int i = 0 ;

	for( ;  i<strlen(name)  ; i++ ){
		
		
		if( temp->alphabet[ (int)name[i]%97 ] == '\0'  ){       // Daha önceden bu harften varmý diye check edilir.
			
			node *temp2 = (node*) malloc( sizeof(node) * 1 );
			
			int counter = 0;
			
			while(counter < 26){
				
				temp2->alphabet[counter] = '\0';
				
				counter++;
			}
			
			temp2->password = '\0';
			temp2->childNumber = 0;

			temp->alphabet[ (int)name[i]%97 ] = temp2;
			temp->childNumber ++;
			
		}

		temp = temp->alphabet[ (int)name[i]%97 ];
		
	
	 
	}
	
	if(temp->password == '\0'){
		
		temp->password = password ;
		
		fprintf(optr,"\"%s\" was added\n",name);
		//printf("%s added\n",name);
	}
	else{
		
		fprintf(optr,"\"%s\" reserved username\n",name);
		//printf("reserved username\n");
	}
	
	
	
	
}

#include "functions.h"

int searchNode( FILE *optr , node *head ,char *name  , int deger){           // Deger parametresine g�re LoginSystem �al���yor. deger 0 sa search i�lemi yap�yor. 1 ise Login system check i�in �al���yor. 2 ise password d�nd�r�yor.
	
	
		node* temp = head;
	

		int i = 0 ;
		
		if( temp->alphabet[ (int)name[0]%97 ] != '\0'){
		
		
			while( name[i] != '\0' ){
				
				
				
				
				if( temp->alphabet[ (int)name[i]%97 ] == '\0' ){
					
					if (deger == 0) fprintf(optr,"\"%s\" incorrect username\n",name); 
			
					return 3;
					
				}
				
				temp = temp->alphabet[ (int)name[i]%97 ];
				
				i++;
				
				
			}
			
			if(temp->password == '\0'){
				
				if (deger == 0) fprintf(optr,"\"%s\" not enough username\n",name); 
				
				return 2;
			}
			else if( temp->password != '\0' ){
				

				if (deger == 0) fprintf(optr,"\"%s\" password \"%d\"\n",name,temp->password); 
				if (deger == 2) return temp->password;
				
				return 1;
			}
		}
		else{
			
			if (deger == 0) fprintf(optr,"\"%s\" no record\n",name); // printf("no record1\n");
			
			return 0;
			
		}

		
		return -1;
	
	
}


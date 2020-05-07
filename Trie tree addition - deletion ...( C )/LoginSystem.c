#include "functions.h"

void LoginSystem( FILE *optr ,node *head , char *name , int password){
	
	
	node *temp = head;
	
	if( searchNode(optr , head , name  , 1 ) == 0 ){
		
		fprintf(optr,"\"%s\" no record\n",name); //printf("no record2\n");
	}
	else if ( searchNode(optr ,head , name , 1 ) == 1 && searchNode(optr ,head , name , 2 ) == password ){
	
	
		fprintf(optr,"\"%s\" successful login\n",name); //printf("succesfull login\n");
	}
	else if( searchNode(optr ,head , name , 1 ) == 1 && searchNode(optr ,head , name , 2 ) != password ){
		
		fprintf(optr,"\"%s\" incorrect password\n",name); //printf("incorrect password\n");
		
	}
	else if( searchNode(optr,head , name , 1) == 2){
		
		
		fprintf(optr,"\"%s\" not enough username\n",name); //printf("not enough username\n");
	}
	else if( searchNode(optr,head , name , 1) == 3){
		
		fprintf(optr,"\"%s\" incorrect username\n",name); //printf("incorrect username\n");
		
	}

	
	
}

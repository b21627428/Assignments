#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void setKeyMatrix(char *textNameOfKeyMatrix , int **keyMatrix , int *sizeOfKeyMatrix ){
	
	FILE *textOfKeyMatrix =	fopen( textNameOfKeyMatrix , "r");    // Opening Part
	
	char *tempArray = (char * ) malloc ( sizeof(char) *150)  ,  *spliter;          
	int counter = 0, secondCounter = 0 ;

	do{
		
		fscanf( textOfKeyMatrix , "%s" , tempArray );	      // Reading Part  
		spliter = strtok(tempArray, " ");
		 	  	
		while (spliter != NULL) {
	  		
			keyMatrix[counter][secondCounter] = atoi(spliter);       // Assigning Part
			
			secondCounter++;
			spliter = strtok(NULL, " ");
	  	}
		if( secondCounter == (*sizeOfKeyMatrix) ){
	  		
	  		counter++;
	  		secondCounter = 0;
		}

   }while( !feof(textOfKeyMatrix) );	
	
	free( tempArray );      // Free Part
	fclose ( textOfKeyMatrix );        // keymatrix.txt Closing Part
}

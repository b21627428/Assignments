#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void setMapMatrix(char *textNameOfMapMatrix , int **mapMatrix , int *widthOfMapMatrix ){
	
	FILE *textOfMapMatrix =	fopen( textNameOfMapMatrix , "r");    // Opening Part
	
	char *tempArray = (char * ) malloc ( sizeof(char) *150)  ,  *spliter; 
	int counter = 0, secondCounter = 0 ;

	do{
		
		fscanf( textOfMapMatrix , "%s" , tempArray );	  // Reading Part
		spliter = strtok(tempArray, " "); 
		 	  	
		while (spliter != NULL) {
	  		
			mapMatrix[counter][secondCounter] = atoi(spliter);    // Assigning Part
			
			secondCounter++;
			spliter = strtok(NULL, " ");
	  	}
		if( secondCounter == (*widthOfMapMatrix) ){
	  		
	  		counter++;
	  		secondCounter = 0;
		}
   }while( !feof(textOfMapMatrix) );
	
	free( tempArray );           // Free Part
	fclose( textOfMapMatrix );    // mapmatrix.txt  Closing Part
}

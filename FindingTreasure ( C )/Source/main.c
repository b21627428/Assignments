#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "functions.h"

int main(int argc , char** argv){

	int widthOfMapMatrix , heightOfMapMatrix , splitCounterForAssignHeightAndWidthOfMapMatrix = 0 ;
	  // Split part
	char *spliter = strtok( argv[1] , "x" ) ;
    while( spliter != NULL){
		
		if  (splitCounterForAssignHeightAndWidthOfMapMatrix == 0)    { heightOfMapMatrix   = atoi(spliter); }
		else													     { widthOfMapMatrix    = atoi(spliter); }
		
		splitCounterForAssignHeightAndWidthOfMapMatrix++;
		spliter = strtok(NULL,"x");
	}

	int   sizeOfKeyMatrix = atoi(argv[2]) ; 
	int subMatrixCenterRowCoordinate = ( sizeOfKeyMatrix / 2 ) , subMatrixCenterColumnCoordinate =  ( sizeOfKeyMatrix / 2 ) ;                               // ÝnitialCoordinates	
	
	char *textNameOfMapMatrix = argv[3] , *textNameOfKeyMatrix = argv[4] ; // mapmatrix.txt and keymatrix.txt assigning to char pointers
	FILE *outputTxt = fopen( argv[5], "w");
	
	int  **mapMatrix , **keyMatrix ,counter;
	// Part Of Creating Dynamic Arrays whose name is mapMatrix and keyMatrix  ,  according to size which are heightOfMapMatrix , widthOfMapMatrix and sizeOfKeyMatrix
	mapMatrix = (int **) malloc ( sizeof(int *) *heightOfMapMatrix );                  // mapMatrix malloc Part with Dynamic Memory
	for(counter=0; counter < heightOfMapMatrix ; counter++)      {             mapMatrix[counter] = (int *) malloc ( sizeof(int) *widthOfMapMatrix);               	   }
	
	keyMatrix = (int **) malloc ( sizeof (int *) *sizeOfKeyMatrix);		  // keyMatrix malloc Part with Dynamic Memory
	for(counter=0; counter < sizeOfKeyMatrix ; counter++){             keyMatrix[counter] = (int *) malloc ( sizeof(int) * sizeOfKeyMatrix);          }

	
	
	setMapMatrix( textNameOfMapMatrix , mapMatrix , &widthOfMapMatrix         );      // This function fiil the mapMatrix according to mapmatrix.txt
	setKeyMatrix( textNameOfKeyMatrix , keyMatrix , &sizeOfKeyMatrix          );      // This function fill the keyMatrix according to keymatrix.txt
	search ( outputTxt , mapMatrix           , keyMatrix  , &subMatrixCenterRowCoordinate , &subMatrixCenterColumnCoordinate , &sizeOfKeyMatrix , &heightOfMapMatrix , &widthOfMapMatrix );  // This is a recursion funcion and search the target
	
	
	
	
	// Free Part For Dynamic Arrays also close part For Txts
	for( counter = 0 ; counter < heightOfMapMatrix ; counter++){
		
		free(mapMatrix[counter]);       
	}
	free(mapMatrix);
	
	for( counter = 0 ; counter < sizeOfKeyMatrix ; counter ++){
		
		free(keyMatrix[counter]);
	}
	free(keyMatrix);
	
	fclose( outputTxt );
	
	return 0;
}

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int mod ( FILE *outputTxt , int **mapMatrix       , int **keyMatrix , int *subMatrixCenterRowCoordinate , int *subMatrixCenterColumnCoordinate , int *sizeOfKeyMatrix  ){
	
	int total = 0 , counter = 0 , secondCounter = 0 , i , j;
	
	for( i = (*subMatrixCenterRowCoordinate) - (*sizeOfKeyMatrix)/2 ; i <= (*subMatrixCenterRowCoordinate) + (*sizeOfKeyMatrix)/2 ; i++ ){
		
		secondCounter = 0;
		
		for( j = (*subMatrixCenterColumnCoordinate) - (*sizeOfKeyMatrix)/2 ; j <= (*subMatrixCenterColumnCoordinate) + (*sizeOfKeyMatrix)/2 ; j++){
			
			total += mapMatrix[i][j]*keyMatrix[counter][secondCounter];         // Multiplication Part
			secondCounter++;
		}
		
		counter++;
	}
	
	fprintf( outputTxt , "%d,%d:%d\n", (*subMatrixCenterRowCoordinate) , (*subMatrixCenterColumnCoordinate) , total );        // the result is written to output.txt in this part
	
	return total;   // returns the multiplication of submatrix and keymatrix
}

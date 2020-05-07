#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "functions.h"

void search ( FILE *outputTxt , int **mapMatrix       , int **keyMatrix , int *subMatrixCenterRowCoordinate , int *subMatrixCenterColumnCoordinate , int *sizeOfKeyMatrix , int *heightOfMapMatrix , int *widthOfMapMatrix ){
	
	int result = mod( outputTxt , mapMatrix , keyMatrix , subMatrixCenterRowCoordinate , subMatrixCenterColumnCoordinate , sizeOfKeyMatrix );  // mod function returns the multiplication of submatrix and keymatrix 
	
	if ( result<0 )  result = (result%5)+5;
	// According to result Of mod function , subMatrixCenterRowCoordinate and subMatrixCenterColumnCoordinate is changing and   going to new function with recursion
	// subMatrixCenterRowCoordinate    = row Coordinate of Submatrix's Center
	// subMatrixCenterColumnCoordinate = column Coordinate Of SubMatrix's Center
	if( result%5 == 0){
		
		return;		
	}
	else{
	
		if        ( result%5 == 1 && ( (*subMatrixCenterRowCoordinate)    - (*sizeOfKeyMatrix) ) < 0                     ) 	    (*subMatrixCenterRowCoordinate)    +=  (*sizeOfKeyMatrix);
		else if   ( result%5 == 1                                                                                        )      (*subMatrixCenterRowCoordinate)    -=  (*sizeOfKeyMatrix);
		else if   ( result%5 == 2 && ( (*subMatrixCenterRowCoordinate)    + (*sizeOfKeyMatrix) ) > *heightOfMapMatrix    )		(*subMatrixCenterRowCoordinate)    -=  (*sizeOfKeyMatrix);
		else if   ( result%5 == 2                                                                                        )		(*subMatrixCenterRowCoordinate)    +=  (*sizeOfKeyMatrix);
		else if   ( result%5 == 3 && ( (*subMatrixCenterColumnCoordinate) + (*sizeOfKeyMatrix) ) > *widthOfMapMatrix     )		(*subMatrixCenterColumnCoordinate) -=  (*sizeOfKeyMatrix);
		else if   ( result%5 == 3                                                                                        )		(*subMatrixCenterColumnCoordinate) +=  (*sizeOfKeyMatrix);	
		else if   ( result%5 == 4 && ( (*subMatrixCenterColumnCoordinate) - (*sizeOfKeyMatrix) ) < 0                     )		(*subMatrixCenterColumnCoordinate) +=  (*sizeOfKeyMatrix);
		else if   ( result%5 == 4                                                                                        )		(*subMatrixCenterColumnCoordinate) -=  (*sizeOfKeyMatrix);		
			
		search( outputTxt , mapMatrix , keyMatrix , subMatrixCenterRowCoordinate , subMatrixCenterColumnCoordinate , sizeOfKeyMatrix , heightOfMapMatrix , widthOfMapMatrix);
	}
}

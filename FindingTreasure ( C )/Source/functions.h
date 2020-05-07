void setMapMatrix (char *textNameOfMapMatrix , int **mapMatrix , int *widthOfMapMatrix);
void setKeyMatrix (char *textNameOfKeyMatrix , int **keyMatrix , int *sizeOfKeyMatrix);
void search(FILE *outputTxt,int **mapMatrix,int **keyMatrix,int *subMatrixCenterRowCoordinate,int *subMatrixCentercolumnCoordinate ,int *sizeOfKeyMatrix,int *heightOfMapMatrix,int *widthOfMapMatrix );
int mod(FILE *outputTxt,int **mapMatrix,int **keyMatrix,int *subMatrixCenterRowCoordinate,int *subMatrixCenterColumnCoordinate ,int *sizeOfKeyMatrix  );


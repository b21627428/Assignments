#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	int x,y,i,j;
	
	x = atoi(argv[1]);
	y = atoi(argv[2]);
	
	for(i=1;i<=x;i++){
		for(j=1;j<=y;j++){
			if((i+j)==x+1 || i==j){
			
				printf("|*|\t");
			}
			else printf("\t");
		}
		printf("\n");
	} 
	
	
	
	
	
	
	
	return 0;
}

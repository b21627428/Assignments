#include <iostream>
#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	int girilen,i,j,x;
	girilen = atoi(argv[1]);
	
	for(i=1;i<=girilen;i+=2){
		x= ((girilen-i)/2);
		
		for(j=0;j<x;j++){
			printf(" ");
		}
		for(j=0;j<i;j++){
			printf("*");
		}
		for (j=0;j<x;j++){
			printf(" ");
		}
		printf("\n");
	}
	for(j=girilen-2;j>=1;j-=2){
		x= ((girilen-j)/2);
		
		for (i=0;i<x;i++){
			printf(" ");
		}
		for(i=0;i<j;i++){
			printf("*");
		}
		for(i=0;i<x;i++){
			printf(" ");
		}
		if (j!=1) printf("\n");
	}
	
	return 0;
}

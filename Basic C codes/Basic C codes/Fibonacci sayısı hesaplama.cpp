#include <iostream>
#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	int x,i;
	x=atoi(argv[1]);
	int array[x];
	
	array[0]=1;
	array[1]=1;
	
	for(i=2;i<x;i++){
		array[i]=array[i-1]+array[i-2];
	}
	for(i=0;i<x;i++){
		printf("%d ",array[i]);
	}
	
	
	
	
	
	
	return 0;
}

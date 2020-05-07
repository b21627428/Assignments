#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int faktoriyel(int a){
	if(a==0) return 1;
	else return (a)*faktoriyel(a-1);
	
}
int kombinasyon(int b,int c){
	
	return faktoriyel(b)/(faktoriyel(c)*faktoriyel(b-c));
	
}
int main(int argc, char** argv) {
	int x,i,j;
	
	x=atoi(argv[1]);
	
	for(i=0;i<=x;i++){
		for(j=0;j<=i;j++){
			printf("%d ",kombinasyon(i,j));
		}
		printf("\n");
	}
	
	getch();
	return 0;
}

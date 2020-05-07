#include <iostream>
#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int kare(int a,int b){
	if (a==2)	return (a*b+1);

	else if (a==1)	return a;
	
	else return (a*b)+(a-1)*(a-1) +1;
}

int main(int argc, char** argv) {
	int x,y;
	
	x=atoi(argv[1]);
	y=atoi(argv[2]);
	
	printf("%d*%d lik bir karede %d adet kare vardýr.",x,y,kare(x,y));
	
	return 0;
}


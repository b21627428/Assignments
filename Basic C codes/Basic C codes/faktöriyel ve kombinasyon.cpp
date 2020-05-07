#include <iostream>
#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int faktoriyel(int a){
	if(a==0) return 1;
	else return (a)*faktoriyel(a-1);
	
}
int kombinasyon(int b,int c){
	
	return faktoriyel(b)/(faktoriyel(c)*faktoriyel(b-c));
	
}

int main(int argc, char** argv) {
	int x,y;
	
	x=atoi(argv[1]);
	y=atoi(argv[2]);
	

	printf("%d in %d li kombinasyonu %d dir",x,y,kombinasyon(x,y));
	
	
	
	return 0;
}



#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int number,x,y,i,j;
	
	number = atoi(argv[1]);
	x = number; y=number+1;
	for(i=1;i<=number;i++){
		for(j=1;j<=(number*2);j++){
			if(j==x) printf("/");
			else if(j==y) printf("\\");
			else printf(" ");
		}
		x--; y++; printf("\n");
	}
	for(i=1;i<=number;i++){
		x++; y--;
		for(j=1;j<=(number*2);j++){
			if(j==x) printf("\\");
			else if(j==y) printf("/");
			else printf(" ");
		}
		printf("\n");
	}
	
	return 0;
}

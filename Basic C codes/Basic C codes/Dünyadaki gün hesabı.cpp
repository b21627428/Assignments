#include <iostream>
#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	int x,y,z;
	int c,v,b;
	
	c = atoi(argv[1]);
	v = atoi(argv[2]);
	b = atoi(argv[3]);
	
	
	printf("\nLutfen dogumgununuzu giriniz: ");
	scanf("%d %d %d",&x,&y,&z );
	
	
	if (y==v && x>=c){
		printf("\n%d",(360 * (b-z))-(x-c));
	}
	else if (y==v && c>=x){
		printf("\n%d",(360*(b-z))+(c-x));
	}
	else if (x==c && v>=y){
		printf("\n%d",(360*(b-z)+(v-y)*30));
	}
	else if (x==c && y>=v){
		printf("\n%d",(360*(b-z)-(y-v)*30));
	}
	else if (c>x && v<y){
		printf("\n%d",(360*(b-z)-(y-v)*30+(c-x)));
	}
	else if (c<x && v>y){
		printf("\n%d",(360*(b-z)+(v-y)*30-(x-c)));
	}
	else if (c<x && v<y){
		printf("\n%d",(360*(b-z)-(y-v)*30-(x-c)));
	}
	else if (c>x && v>y){
		printf("\n%d",(360*(b-z)+(v-y)*30+(c-x)));
	}
	printf(".gunun bu dunyada.Ne mutlu sana...");
	
	return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void xstrlen(char *p2,int *p3){
	int i;
	
	for(i=0; p2[i]!='\0';i++){
		
	}
	
	*p3 = i;
}


int main(){
	
	char *p = (char *) malloc(sizeof(char)*25);
	int x;
	
	printf("Bir karakter dizisi giriniz: "); scanf("%s",p);
	
	xstrlen(p,&x); printf("%s karakter dizisinin uzunlugu %d dir.",p,x);
	
	return 0;
}

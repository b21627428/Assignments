#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	char x;
	FILE *p,*q;
	p=fopen("deneme.txt","r");
	q=fopen("deneme2.txt","w");
	
	while(!feof(p)){
	
		
		x=getc(p);
		printf("%c",x);
		fprintf(q,"%c",x);
}
	fclose(p);
	fclose(q);
	
	
	return 0;
	
	
	
}

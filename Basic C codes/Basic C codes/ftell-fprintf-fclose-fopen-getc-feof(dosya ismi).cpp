#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	
	FILE *dosya,*p; char x; int i=0;
	dosya=fopen("deneme2.txt","r");
	p=fopen("deneme.txt","w");
	
	while(i<8){
		
		x=getc(dosya);
		fprintf(p,"%c",x);
		i++;		
	
	}
	fprintf(p," Said");
	
	while(!feof(dosya)){
		
		x=getc(dosya);
		fprintf(p,"%c",x);

	}
	printf("%d",ftell(p));
	printf(" %d",ftell(dosya));
	fclose(dosya);
	fclose(p);
	
	
	
	return 0;
	
	
	
}

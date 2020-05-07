#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void maxelemanbulma(int *p2,int size,int *p3){
	int i;
	
	*p3 = p2[0];
	for(i=0;i<size;i++){
		if(p2[i]>*p3){
			*p3 = p2[i];
		}
	}
	
}


int main(){
	
	/*char *p = (char *) malloc(sizeof(char)*20);
	
	printf("Ad gir: "); scanf("%s",p);
	printf("%s",p+1);
	*/
	
	int x,i,max=0;
	printf("Kac adet sayi gireceksiniz: "); scanf("%d",&x);
	
	int *p = (int *) malloc (sizeof(int)*x);  int *maxp = &max;
	
	for (i=0;i<x;i++){
		printf("%d.sayiyi gir: ",i+1); scanf("%d",&p[i]);
	}
	
	maxelemanbulma(p,x,maxp);
	
	printf("%d max elemandir.",max);
	
	
	
	return 0;
}

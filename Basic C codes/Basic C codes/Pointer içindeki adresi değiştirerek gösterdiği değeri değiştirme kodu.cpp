#include <stdio.h>
#include <string.h>
#include <stdlib.h>
void function(int *p,int *q){
	int temp=NULL;
	printf("p nin adresi %u deðeri %d                ",p,*p);
	printf("q nun adresi %u degeri %d\n",q,*q);
	temp = *p; *p=*q; *q=temp;
	printf("p nin adresi %u deðeri %d                ",p,*p);
	printf("q nin adresi %u deðeri %d.\n",q,*q);
}

int main(){
	
	int x=10,y=5;
	function(&x,&y);
	
	return 0;
}

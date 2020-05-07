#include <iostream>
#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	int x,i,y,j,temp;
	printf("Kac adet sayi gireceksiniz: "),
	scanf("%d",&x);
	
	int array[x];
	for(i=1;i<=x;i++){
		printf("%d.sayiyi giriniz :",i);
		scanf("%d",&y);
		array[i-1]=y;
		
		}
	printf("Normal array: ");
	for(i=0;i<x;i++){
		printf("%d ",array[i]);
		if (i==x-1) printf("\n");
	}
	for(i=1;i<x;i++){
		for(j=0;j<x-1;j++){
			if(array[j]>array[j+1]){
				temp=array[j];
				array[j]=array[j+1];
				array[j+1]=temp;
				
			}
		}
	}
	printf("Sorted Array: ");
	for(i=0;i<x;i++) printf("%d ",array[i]);
	
	
	
	
	
	return 0;
}

#include <stdio.h>
#include <stdlib.h>
int function(int *array, int length){
	
	int i,j,sayi,number, max = array[0];
	
	for(i=0 ; i<length ; i++){
		
		if ( array[i]> max ) max = array[i];
	}
	
	for(i=1 ; i<=max ; i++){
		
		sayi = 0;
		
		for(j=0 ; j<length ; j++){
			
			if( array[j]%i==0){
				sayi++;
			}
		
		
		}
		
		if (sayi == length) {
			
			
			number = i;
		
		}
	}
	
	return number;
	
	
	
	
}
int main(){
	
	
	int length,number,i;
	printf("Eleman sayisini gir:"); scanf("%d",&length);
	int *array = (int *)malloc(sizeof(int)*length);
	
	for(i=0 ; i<length ; i++){
		scanf("%d",&array[i]);	
	}
	number = function(array,length);
	printf("%d",number);
	
	
	
	return 0;
}

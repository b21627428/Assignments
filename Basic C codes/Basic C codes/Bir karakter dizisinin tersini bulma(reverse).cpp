#include <iostream>
#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void tersinibulma(char array2[],int i){
	
	char temp;
	int j,k;
	
	j=(i/2);
	
	for(k=0;k<j;k++){
		i--;
		temp = array2[k];
		array2[k] = array2[i];
		array2[i] = temp;
		
	}
	printf("Girdiginiz ismin tersi : %s",array2);
}



int main(int argc, char** argv) {
	
	char array[20];
	int i=0;
	printf("Bir karakter dizisi giriniz: ");
	gets(array);
	
	while(array[i]!='\0') i++;
	
	tersinibulma(array,i);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}

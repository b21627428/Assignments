#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char *function(char *array[],int size){
	
	char *gecicibellek=NULL;	int i,j;
	
	for (i=0;i<size-1;i++){
		
		for (j=0;j<size-1;j++){
			
			if (strcmp(array[j],array[j+1])>0){
				
				gecicibellek = array[j];
				array[j] = array[j+1];
				array[j+1] = gecicibellek;
			}
		}
	}
	return array[(size-1)/2];
}

int main(){
	
	char *array[]= {"Ali","Ahmet","Kazim","Veli","Muhammed","Furkan","Yuksel"}; int i;
	
 for(i=0;i<7;i++){
		printf("%s ",array[i]);
	}
	char *p = function(array,7);
	
	
	printf("\nArrayin ortasinda %s var.\n",p);
	
	for(i=0;i<7;i++){
		printf("%s ",array[i]);
	}
	return 0;
}

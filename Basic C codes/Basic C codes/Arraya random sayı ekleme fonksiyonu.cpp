#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void randomsayiekleme(int array2[],int sayi2){
	
	int i,randomsayi,max=0;
	
	srand(time(NULL)); //farklý sayý vermesini saðlýyor...(time.h)
	for (i=0; i<sayi2; i++){
		printf("%d.random sayi: ",i+1);
		
		
		randomsayi = 1+rand()%100; // 1 ile 100 arasýnda random sayý alma...(stdlib.h)
		if (randomsayi>max) max = randomsayi;
		array2[i] = randomsayi;
		printf("%d\n",array2[i]);
	}
	printf("Max random sayi: %d",max);
}


int main(int argc, char** argv) {
	
	int sayi;
	printf("Kac adet random sayi istiyorsunuz: ");
	scanf("%d",&sayi);
	
	int array[sayi];
	
	randomsayiekleme(array,sayi);
	

	
	
	return 0;
}

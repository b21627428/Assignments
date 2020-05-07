#include <iostream>
#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	char sehirler[15][20]; int n,i;
	printf("Kaç adet þehir gireceksiniz : ");	scanf("%d",&n);
	
	sehirler[15][20]=n; // Baþta array eleman sayýsý belli olmayýnca böyle biþey kullanýlabilir...
	
	for(i=0;i<n;i++){
		printf("%d.þehir: ",i+1); scanf("%s",&sehirler[i]); 
	}
	for(i=0;i<n;i++) printf("%d.þehir %s olarak girdiniz.\n",i+1,sehirler[i]); 	
	
	
	
	
	return 0;
}

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	char sehirler[15][20]; int n,i;
	printf("Ka� adet �ehir gireceksiniz : ");	scanf("%d",&n);
	
	sehirler[15][20]=n; // Ba�ta array eleman say�s� belli olmay�nca b�yle bi�ey kullan�labilir...
	
	for(i=0;i<n;i++){
		printf("%d.�ehir: ",i+1); scanf("%s",&sehirler[i]); 
	}
	for(i=0;i<n;i++) printf("%d.�ehir %s olarak girdiniz.\n",i+1,sehirler[i]); 	
	
	
	
	
	return 0;
}

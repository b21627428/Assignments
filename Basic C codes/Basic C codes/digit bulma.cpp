#include <iostream>
#include <stdio.h>
#include <stdlib.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	int x;
	int y;
	int z = 1;
	int k = 1;
	int kalan;
	int sayac = 0,sayac2 = 0;
	
	
	x= atoi(argv[1]);
	y= atoi(argv[2]);
	printf("%d * %d ",x,y);
	for (y;y!=0;y--){
		z = (z * x);
		k = (k * x);
	}
	
	

	printf("= %d =",z);
	
	while(z>=10){
		sayac2++;
		z= (z/ 10);
	}
	
	int kalanlar[sayac2+1];
	
	while(k>=10){
		kalan = (k % 10);
		kalanlar[sayac]=kalan;
		sayac++;
		k = (k / 10);
		
	}
	kalanlar[sayac]=k;
	
	int i = 0,total=0;
	
	for(i;i<=sayac;i++){
		printf(" %d",kalanlar[i]);
		total +=kalanlar[i];
		
		if (i!=sayac) printf(" +");
		else printf(" =");
	
	}
	printf(" %d",total);
	
	
	
	
	
	return 0;
}

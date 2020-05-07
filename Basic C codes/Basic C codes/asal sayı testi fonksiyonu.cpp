#include <iostream>
#include <stdlib.h>
#include <stdio.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int asalsayimi(int x){
	int flag=0,y;
	if (x>=2){
	
		for(y=2;y<x;y++){
			if (x%y==0) flag=1;	
		}
	}
	else flag= -1;
	
	return flag;
}
int main(int argc, char** argv) {
	int x,flag;
	x=atoi(argv[1]);
	
	flag = asalsayimi(x);
	
	if (flag==0) printf("%d asal sayidir",x);
	else if (flag==-1) printf("2 veya 2 den buyuk sayilar giriniz.");
	else printf("%d asal sayi degildir.",x);
	return 0;
}

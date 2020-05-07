#include <iostream>
#include <stdio.h>
#include <math.h> 
#include <stdlib.h>


void kokbulma(int a,int b,int c,float *px1,float *px2,int *pk){
	
	float delta;
	delta = (b*b - 4 * a * c);
	
	if (delta<0.0) *pk = 0;
		
	else if (delta == 0.0){
	
		printf("There is one solution");
		
		*px1 = ((-b - (sqrt(delta))) / (2 * a));
		*px2 = ((-b - (sqrt(delta))) / (2 * a));
		
}
	else{
	 
		printf("There are two solution");
		
		*px1 = ((-b - (sqrt(delta))) / (2 * a));
		*px2 = ((-b + (sqrt(delta))) / (2 * a));
		
}
		
}

int main(int argc, char** argv) {
	
	
	int x,y,z,k=1;
	float x1,x2;
	
	x = atoi(argv[1]);
	y = atoi(argv[2]);
	z = atoi(argv[3]);
	
	
	kokbulma(x,y,z,&x1,&x2,&k);
	
	if (k==0)
		printf("The solution is not real complex");
	else
		printf("\nThe solution are %.2f ve %.2f dir .",x1,x2);
		
	
	
	return 0;
}



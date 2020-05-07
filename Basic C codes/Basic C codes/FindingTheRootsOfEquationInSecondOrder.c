#include <stdlib.h>
#include <stdio.h>
#include <math.h>

void findTheRootsOfEquationInSecondOrder(int a , int b ,int c);

int main(int argc , char **argv){
	
	findTheRootsOfEquationInSecondOrder ( atoi(argv[1]) , atoi(argv[2]) , atoi(argv[3]) );
	
	return 0;
}

void findTheRootsOfEquationInSecondOrder(int a , int b , int c){
	
	float delta = ( pow(b,2)-4*a*c);
	
	if(delta<0){
		
		printf("The solution is not real but complex");
	}
	else if(delta==0){
		
		printf("There is one solution.\n");
		
		float route = (-b - sqrt(delta) ) / 2 * a ;
		
		printf("Solution: %.2f",route);
	}
	else{
		
		printf("There are two solutions.\n");
		
		float firstRoute = (-b - sqrt(delta) ) / 2 * a , secondRoute = (-b + sqrt(delta) ) / 2 * a ;
		
		printf("Solutions: %.2f %.2f",firstRoute,secondRoute);
	}
}

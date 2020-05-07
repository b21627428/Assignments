#include "functions.h"


int main(int argc , char **argv){
	
	if( argc == 3){   // Parametre yeterli mi dye check edilir.
		
		simulator(argv[1] , argv[2]);		
		
	}
 
	
	return 0;
}

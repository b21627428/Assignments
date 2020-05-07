#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	
	char array[20];
	int i,j=0;
	
	while(1){
		printf("\nBir isim giriniz: ");
		gets(array);
		printf("\n%s %d",array,strlen(array));
		if (strlen(array)==1) break;
		printf("Gooo");
}
	/*printf("%s\n",array);
	printf(array);
	
	for(i=0; array[i]; i++){
		printf("\n%c",array[i]);
		j++;
	}
	printf("\n%s ismi %d harften olusur",array,j);
	*/
	
	
	
	
	
	
	return 0;
}

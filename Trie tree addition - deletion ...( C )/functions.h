#include "struct.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void simulator(char *inputTextName, char *outputTextName);
	
 
void addNode( FILE *optr , node *head ,char *name , int password );                              // -a
int searchNode( FILE *optr , node *head ,char *name , int deger );                              // -s
void LoginSystem( FILE *optr , node *head , char *name , int password);                         // -q
void ListAll( FILE *optr, int counter , int secondCounter , char name[]  , node *head , node *temp  );                                                        // -l
void deleteNode( FILE *optr , node *head , char *name  );

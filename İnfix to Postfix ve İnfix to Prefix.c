#include <stdlib.h>
#include <stdio.h>
#include <string.h>


typedef struct isaret{
	
	struct isaret *next;
	struct isaret *prev;
	char ifade;
	int number;

			
}Isaret;

char* reverse(char *infix){
	
	int i = strlen(infix)-1 , j=0;
	char *reversed = (char*) malloc(sizeof(char)*(strlen(infix)+1) );
		
	for ( ; i >= 0; i--, j++){
		reversed[j] = infix[i];
	}
	reversed[j] = '\0';
	return reversed;     	
}

void enqueue(Isaret **head, Isaret **tail , char ifade){
	
	Isaret *newIsaret = (Isaret*) malloc( sizeof(Isaret));
	newIsaret->next = NULL;
	newIsaret->ifade = ifade;

	if(ifade == '+' || ifade == '-' )  newIsaret->number = 5;
	else                               newIsaret->number = 10;
	
	if(*head == NULL){
		
		*head = *tail = newIsaret;
		newIsaret->prev = NULL;
	}
	else{
		
		(*tail)->next = newIsaret;
		newIsaret->prev = *tail;
		*tail = newIsaret;
	}	
}

Isaret* dequeue(Isaret **head , Isaret **tail){
	
	if(*head == NULL){
		
		return NULL;
	}
	else{
		
		Isaret *temp = *head;
		if(*head == *tail){
			
			*head = *tail = NULL;
		}
		else{
			
			*head = temp->next;
			(*head)->prev = NULL;	
		}
		return temp;
	}
	
}

void push(Isaret **head , Isaret **tail , char ifade){
	
	Isaret *newIsaret = (Isaret*) malloc( sizeof(Isaret));
	newIsaret->next = NULL;
	newIsaret->ifade = ifade;

	if(ifade == '+' || ifade == '-' )  newIsaret->number = 5;
	else                               newIsaret->number = 10;
	
	if(*head == NULL){
		
		*head = *tail = newIsaret;
		newIsaret->prev = NULL;
	}
	else{
		
		(*tail)->next = newIsaret;
		newIsaret->prev = *tail;
		*tail = newIsaret;
	}
}

Isaret* pop(Isaret **head , Isaret **tail){
	
	if(*head == NULL){
		
		return NULL;
	}
	else{
		
		Isaret *temp = *tail;
		if(*head == *tail){
			
			*head = *tail = NULL;
		}
		else{
			
			*tail = temp->prev;
			(*tail)->next = NULL;	
		}
		return temp;
	}
	
}

char* infixToPostfix(char *infix ,Isaret *stackHead , Isaret *stackTail , Isaret *queueHead , Isaret *queueTail){
	
	char *postfix = (char*) malloc(sizeof(char)*(strlen(infix)+1));
	
	int i,j=0;
	
	for(i=0 ; i< strlen(infix) ; i++){
		
		if( infix[i] == '+' ||
			infix[i] == '-' ||
			infix[i] == '*' ||
			infix[i] == '/' ){
				 
			if(j!=0){
				enqueue(&queueHead,&queueTail,infix[i]);  
			} 
			j++;
					
		}
	}
	for(i=0 ,j=0; i< strlen(infix) ; i++){
		
		if( infix[i] == '+' ||
			infix[i] == '-' ||
			infix[i] == '*' ||
			infix[i] == '/' ){
				
			if( stackHead == NULL){
				
				push(&stackHead,&stackTail,infix[i]);
			}	
			else{
				
				Isaret *queueTemp = dequeue(&queueHead,&queueTail);
				Isaret *stackTemp = pop(&stackHead,&stackTail);
				
				if(queueTemp && stackTemp && queueTemp->number > stackTemp->number ){
					
					push(&stackHead,&stackTail,stackTemp->ifade);
					push(&stackHead,&stackTail,queueTemp->ifade);
				}
				else{
					while(stackTemp && queueTemp && queueTemp->number <= stackTemp->number){
						
						postfix[j] = stackTemp->ifade;  j++;
						
						stackTemp = pop(&stackHead,&stackTail);	
					}
					push(&stackHead,&stackTail,queueTemp->ifade);						
				}
			}			
		}
		else{
			postfix[j] = infix[i];
			j++;
		}
	}
	while(stackTail){
		
		postfix[j] = pop(&stackHead,&stackTail)->ifade; 
		j++;
	}
	postfix[j] = '\0';
	return postfix;	
}



int main(){
	
	char infix[150] , *postfix , *prefix;
	
	Isaret *stackHead = NULL , *stackTail = NULL;
	Isaret *queueHead = NULL , *queueTail = NULL;
	
	
	printf("Ifade:"); scanf("%s",infix);
	//---------------
	printf("Infix: %s\n",infix);
	//------------
	postfix = infixToPostfix(infix,stackHead,stackTail,queueHead,queueTail);  // infix to postfix
	printf("Postfix: %s\n",postfix);
	//----------------

	prefix = reverse( infixToPostfix( reverse(infix),stackHead,stackTail,queueHead,queueTail) );  // infix to prefix
	printf("Prefix: %s\n",prefix);
			
	
}

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
typedef struct{
	char NAME[40],SITUATION[10];
	int HP,DAMAGE,LOCATION_X,LOCATION_Y,XP;
	
}HERO;
typedef struct{
	char NAME[40],SITUATION[10];
	int HP,DAMAGE,LOCATION_X,LOCATION_Y;

}MONSTER;
typedef struct{
	char type[10];

}CHARACTER;
/*   Bu fonksiyon  ATTACK_HERO içinde kod kalabalýðýný azaltmak amacýyla yazýlmýþtýr... */
int  HELP_ATTACK_HERO (int *i, int *j, int *k, int *w, int *SAYI,  HERO struct_hero_array[], MONSTER struct_monster_array[], char **map_array, char *monster_test_array, char *monster_test_array_2 ,FILE *r){
	
	*SAYI = ( struct_monster_array[(*w)].HP ) - ( struct_hero_array[(*i)].DAMAGE );
	
	if ( *SAYI<=0 && ( strcmp( struct_monster_array[(*w)].SITUATION , "ALÝVE")==0 ) ){
									
		struct_monster_array[(*w)].HP = 0;
		strcpy(struct_monster_array[(*w)].SITUATION,"DEAD");
		map_array[(*j)][(*k)]='.';
		struct_hero_array[(*i)].XP++;
		monster_test_array[(*w)]='-';
									
		if(strcmp(monster_test_array,monster_test_array_2)==0){
			fprintf(r,"ALL MONSTERS ARE DEAD!\n\n");
			return 0;
		}
	}
	else{
		struct_monster_array[(*w)].HP = *SAYI;
							
	}
	return 1;
}
/*   Bu fonksiyon  ATTACK_MONSTER içinde kod kalabalýðýný azaltmak amacýyla yazýlmýþtýr... */
int  HELP_ATTACK_MONSTER (int *i, int *j, int *k, int *w, int *SAYI,  HERO struct_hero_array[], MONSTER struct_monster_array[], char **map_array, char *hero_test_array, char *hero_test_array_2 ,FILE *r){
	
	*SAYI = struct_hero_array[(*w)].HP - struct_monster_array[(*i)].DAMAGE;
	
	if ( *SAYI<=0 && (strcmp(struct_hero_array[(*w)].SITUATION,"ALÝVE")==0) ){
			
		struct_hero_array[(*w)].HP = 0;
		strcpy(struct_hero_array[(*w)].SITUATION,"DEAD");
		map_array[(*j)][(*k)]='.';
		hero_test_array[(*w)]='-';
		
		if(strcmp(hero_test_array,hero_test_array_2)==0){
			fprintf(r,"ALL HEROES ARE DEAD!\n\n");
			return 0;
		}
	}
	else{							
		struct_hero_array[(*w)].HP = *SAYI;
	}
	
	return 1;
}
/*   Hero Structlarýnýn özellikleri dosyaya basar  */
void SHOW_HERO(HERO struct_hero_array[] , int *hero_number , FILE *r ){
	int i;
	fprintf(r,"HERO STATUS\n");
	for(i=0;i<*hero_number;i++){
		fprintf(r,"%s HP: %d XP: %d\n",struct_hero_array[i].NAME, struct_hero_array[i].HP, struct_hero_array[i].XP);
	}
	fprintf(r,"\n");
}
/*   Monster Structlarýnýn özellikleri dosyaya basar  */
void SHOW_MONSTER(MONSTER struct_monster_array[] , int *monster_number , FILE *r){
	int i;
	fprintf(r,"MONSTER STATUS\n");
	for(i=0;i<*monster_number;i++){
		fprintf(r,"%s HP: %d \n",struct_monster_array[i].NAME, struct_monster_array[i].HP);
	}
	fprintf(r,"\n");
}
/*    Map arrayini dosyaya basar  */
void SHOW_MAP(char **map_array,int *height,int *weight,FILE *r){
	int i,j;
	fprintf(r,"MAP STATUS\n");
	for(i=0;i<*height;i++){
		for(j=0;j<2*(*weight);j++){
			if(j%2==0){
				fprintf(r,"%c",map_array[i][j/2]);
			}
			else{
				fprintf(r," ");
			}
		}
		fprintf(r,"\n");
	}
	fprintf(r,"\n");
}
/*  Map i oluþturur  */
void LOAD_MAP(int *height,int *weight,char **map_array){
	int i,j;
	char array[]=".";
	for(i=0;i<*height;i++){
		map_array[i]= (char *)malloc (sizeof(char)*((*weight)+1));
	}
	for(i=0;i<*height;i++){
		for(j=0;j<*weight;j++){
			map_array[i][j]=array[0];
		}
	}
}
/* Hero larý locationlarýna göre map e yerleþtirir... */
void PUT_HERO( int *hero_number, int *location, int *kelime_sayisi, char **map_array, HERO struct_hero_array[], char ***commands_array){
	
	int i,j=0,a,b;
	
	for(i=2;  i<*kelime_sayisi;  i=i+3){
		for(j=0;j<*hero_number;j++){
			if(strcmp(commands_array[(*location)][i],struct_hero_array[j].NAME)==0){
				struct_hero_array[j].LOCATION_X =atoi(commands_array[(*location)][i+1]);
				struct_hero_array[j].LOCATION_Y =atoi(commands_array[(*location)][i+2]);
				a= struct_hero_array[j].LOCATION_X; 
				b= struct_hero_array[j].LOCATION_Y;
				
				map_array[a][b]= (struct_hero_array[j].NAME)[0];
			}
		}
	}
}
/*  Monsterlarý  locationlarýna göre map e yerleþtirir... */
void PUT_MONSTER( int *monster_number, int *location, int *kelime_sayisi, char **map_array, MONSTER struct_monster_array[], char ***commands_array){
	
	int i,j=0,a,b;
	
	for(i=2;  i<*kelime_sayisi;  i=i+3){
		for(j=0;j<*monster_number;j++){
			if(strcmp(commands_array[(*location)][i],struct_monster_array[j].NAME)==0){
				struct_monster_array[j].LOCATION_X = atoi(commands_array[(*location)][i+1]);
				struct_monster_array[j].LOCATION_Y = atoi(commands_array[(*location)][i+2]);
				a=struct_monster_array[j].LOCATION_X;
				b=struct_monster_array[j].LOCATION_Y;
				
				map_array[a][b]= (struct_monster_array[j].NAME)[0];
			}
		}
	}
}
/* Commands arraydeki deðerlere göre  ya hero nun map deki yerini deðiþtirir ya da hata mesajý verir... */
void MOVE_HERO(int *hero_number, int *location, int *kelime_sayisi, char **map_array, HERO struct_hero_array[] , char ***commands_array, int *height, int *weight, FILE *r){
	
	int i,j,a,b,temp1,temp2,temp3,temp4;
	
	fprintf(r,"HEROES MOVED\n");
	for(i=2;  i<*kelime_sayisi;  i=i+3){
		
		for(j=0;j<*hero_number;j++){
			if(strcmp(commands_array[(*location)][i],struct_hero_array[j].NAME)==0){
				
				
				if(strcmp(struct_hero_array[j].SITUATION,"ALÝVE")==0){
				
					a=atoi(commands_array[(*location)][i+1]);
					b=atoi(commands_array[(*location)][i+2]);
					
					if ( (0<=a) && (a<=((*height)-1)) && (0<=b) && (b<=((*weight)-1)) ) {
					
						if(map_array[a][b]=='.'){
							
							temp1 = struct_hero_array[j].LOCATION_X;
							temp2 = struct_hero_array[j].LOCATION_Y;
							
							struct_hero_array[j].LOCATION_X = atoi(commands_array[(*location)][i+1]);
							struct_hero_array[j].LOCATION_Y = atoi(commands_array[(*location)][i+2]);
							
							temp3 = struct_hero_array[j].LOCATION_X;
							temp4 = struct_hero_array[j].LOCATION_Y;
							
							map_array[temp1][temp2]='.';
							map_array[temp3][temp4]= (struct_hero_array[j].NAME)[0];
						}
						else{
							fprintf(r,"%s can't move. Place is occupied.\n",struct_hero_array[j].NAME);
						}
					}
					else{
						fprintf(r,"%s can't move. There is a wall.\n",struct_hero_array[j].NAME);
					}
				}
				else{
					fprintf(r,"%s can't move. Dead.\n",struct_hero_array[j].NAME);
				}
			}
		}
	}
	fprintf(r,"\n");
}
/* Hero lar monsterlara saldýrýr ...   Bu fonksiyonda belirli koþullar vardýr.
    1.Hero nun map in köþesinde olmasý durumu
	2.Hero nun map in kenarlarýnda olmasý durumu
	3.Hero nun map in iç kýsmýnda olmasý durumu				*/
int ATTACK_HERO(char *monster_test_array,char *monster_test_array_2,int *hero_number,int *monster_number,HERO struct_hero_array[],MONSTER struct_monster_array[],char **map_array,int *height,int *weight,FILE *r){
	
	int i,j,k,w,location_x,location_y,test;
	
	fprintf(r,"HEROES ATTACKED\n\n");
		
	for(i=0;i<*hero_number;i++){
			
	location_x = struct_hero_array[i].LOCATION_X;
	location_y = struct_hero_array[i].LOCATION_Y;
	unsigned int SAYI;
	
			
		if(  ((0<location_x) && (location_x<((*height)-1)))  && ((0<location_y) && (location_y<((*weight)-1))) ){
			for(j=location_x-1; j<=location_x+1; j++){
				for(k=location_y-1; k<=location_y+1; k++){
					for(w=0;w<*monster_number;w++){
						if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && ( strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
							}}}}
		}
							
		else if( ((location_x==0)&&(location_y==0)) || ((location_x==0)&&(location_y==(*weight)-1)) || ((location_x==(*height)-1)&&(location_y==0)) || ((location_x==(*height)-1)&&(location_y==(*weight)-1)) ) {
			
			if( ((location_x==0)&&(location_y==0))){
				for(j=location_x; j<=location_x+1; j++){
					for(k=location_y; k<=location_y+1; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
				
			else if( ((location_x==0)&&(location_y==(*weight)-1)) ){
				for(j=location_x; j<=location_x+1; j++){
					for(k=location_y-1; k<=location_y; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}	
										
			else if( ((location_x==(*height)-1)&&(location_y==0)) ){
				for(j=location_x-1; j<=location_x; j++){
					for(k=location_y; k<=location_y+1; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
								
			else if( ((location_x==(*height)-1)&&(location_y==(*weight)-1)) ){
				for(j=location_x-1; j<=location_x; j++){
					for(k=location_y-1; k<=location_y; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
		}
								
		else {
			
			if( (0<location_x)&&(location_x<(*height)-1) && (location_y==0)){
				for(j=location_x-1; j<=location_x+1; j++){
					for(k=location_y; k<=location_y+1; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
								
			else if( (0<location_y)&&(location_y<(*weight)-1) && (location_x==0)){
				for(j=location_x; j<=location_x+1; j++){
					for(k=location_y-1; k<=location_y+1; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
								
			else if( (0<location_y)&&(location_y<(*weight)-1) && (location_x==(*height)-1)){
				for(j=location_x-1; j<=location_x; j++){
					for(k=location_y-1; k<=location_y+1; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) ){
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
								
			else if( (0<location_x)&&(location_x<(*height)-1) && (location_y==(*weight)-1)){
				for(j=location_x-1; j<=location_x+1; j++){
					for(k=location_y-1; k<=location_y; k++){
						for(w=0;w<*monster_number;w++){
							if( ( map_array[j][k] == (struct_monster_array[w].NAME)[0]) && (strcmp(struct_hero_array[i].SITUATION , "ALÝVE")==0) )
								
								test = HELP_ATTACK_HERO(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , monster_test_array , monster_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}
		}
	}
	
	return 1;
}
/* Monster lar herolara saldýrýr ...   Bu fonksiyonda belirli koþullar vardýr.
    1.Monster ýn map in köþesinde olmasý durumu
	2.Monster ýn map in kenarlarýnda olmasý durumu
	3.Monster ýn map in iç kýsmýnda olmasý durumu				*/
int ATTACK_MONSTER(char *hero_test_array,char *hero_test_array_2,int *hero_number, int *monster_number, HERO struct_hero_array[], MONSTER struct_monster_array[], char **map_array, int *height, int *weight,FILE *r){
	
	int i,j,k,w,location_x,location_y,test;
	
	fprintf(r,"MONSTERS ATTACKED\n\n");
		
	for(i=0;i<*monster_number;i++){
		
	location_x = struct_monster_array[i].LOCATION_X;
	location_y = struct_monster_array[i].LOCATION_Y;
	unsigned int SAYI;
			
		if(  ((0<location_x) && (location_x<((*height)-1)))  && ((0<location_y) && (location_y<((*weight)-1))) ){
			for(j=location_x-1; j<=location_x+1; j++){
				for(k=location_y-1; k<=location_y+1; k++){
					for(w=0;w<*hero_number;w++){
						if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
								
							test = HELP_ATTACK_MONSTER (&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
							if (test == 0){
									return 0;
							}
							
							}}}}
		}
			
		else if( ((location_x==0)&&(location_y==0)) || ((location_x==0)&&(location_y==(*weight)-1)) || ((location_x==(*height)-1)&&(location_y==0)) || ((location_x==(*height)-1)&&(location_y==(*weight)-1)) ) {
				
			if( ((location_x==0)&&(location_y==0))){
				for(j=location_x; j<=location_x+1; j++){
					for(k=location_y; k<=location_y+1; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
								
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
				
			else if( ((location_x==0)&&(location_y==(*weight)-1)) ){
				for(j=location_x; j<=location_x+1; j++){
					for(k=location_y-1; k<=location_y; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
									
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
				
			else if( ((location_x==(*height)-1)&&(location_y==0)) ){
				for(j=location_x-1; j<=location_x; j++){
					for(k=location_y; k<=location_y+1; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
									
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
				
			else if( ((location_x==(*height)-1)&&(location_y==(*weight)-1)) ){
				for(j=location_x-1; j<=location_x; j++){
					for(k=location_y-1; k<=location_y; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
								
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
		}
			
		else {
				
			if( (0<location_x)&&(location_x<(*height)-1) && (location_y==0)){
				for(j=location_x-1; j<=location_x+1; j++){
					for(k=location_y; k<=location_y+1; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
									
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
			
			else if( (0<location_y)&&(location_y<(*weight)-1) && (location_x==0)){
				for(j=location_x; j<=location_x+1; j++){
					for(k=location_y-1; k<=location_y+1; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
									
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
			
			else if( (0<location_y)&&(location_y<(*weight)-1) && (location_x==(*height)-1)){
				for(j=location_x-1; j<=location_x; j++){
					for(k=location_y-1; k<=location_y+1; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
									
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
								
			else if( (0<location_x)&&(location_x<(*height)-1) && (location_y==(*weight)-1)){
				for(j=location_x-1; j<=location_x+1; j++){
					for(k=location_y-1; k<=location_y; k++){
						for(w=0;w<*hero_number;w++){
							if( ( map_array[j][k] == (struct_hero_array[w].NAME)[0]) && (strcmp(struct_monster_array[i].SITUATION,"ALÝVE")==0) ){
									
								test = HELP_ATTACK_MONSTER(&i,&j,&k,&w,&SAYI, struct_hero_array , struct_monster_array , map_array , hero_test_array , hero_test_array_2,r);
								if (test == 0){
									return 0;
								}
								
								}}}}}
		}
	}
	
	return 1;
}
	


int main(int argc, char** argv){
	
	/* 1.KISIM  ÖZELLÝKLERÝ ÇEKME KISMI   ->  Dosyadan okuyup structlara özellikleri atma kýsmý */
	
	int hero_number = 0 , monster_number = 0 , count;
	char *array =(char * )malloc (sizeof(char)*150) ; 
	char *ayrac;
		
	FILE *p,*q,*r;
	p= fopen(argv[1],"r");
	q= fopen(argv[2],"r");
	r= fopen(argv[3],"w");
	
	do{
		fscanf(p,"%s",array);	
		ayrac = strtok(array, ",");
	  	while (ayrac != NULL) {
	  		if (strcmp(ayrac,"HERO")==0) hero_number++;
	  		if (strcmp(ayrac,"MONSTER")==0) monster_number++;
	  		ayrac = strtok(NULL, " ,");
	  	}
	  	
   }while(!feof(p));
   
   CHARACTER character;
   
   HERO *struct_hero_array = (HERO * )malloc(sizeof(HERO)*hero_number);
   MONSTER *struct_monster_array = (MONSTER *) malloc(sizeof(MONSTER)*monster_number);
   
   char *hero_test_array = (char *) malloc (sizeof(char)*(hero_number+1));
   char *monster_test_array= (char *) malloc (sizeof(char)*(monster_number+1));
   char *hero_test_array_2 = (char *) malloc (sizeof(char)*(hero_number+1));
   char *monster_test_array_2 = (char *) malloc( sizeof(char)*(monster_number+1));
   
	for(count=0;count<hero_number;count++){
   		hero_test_array[count]='+';
   		hero_test_array_2[count]='-';
   }
   for(count=0;count<monster_number;count++){
   		monster_test_array[count]='+';
   		monster_test_array_2[count]='-';
   }

	fseek(p,0,SEEK_SET);
	
	hero_number = 0;
	monster_number = 0;
	
	do{
		count=0;
		fscanf(p,"%s",array);	
		ayrac = strtok(array, ",");
	  	
		while (ayrac != NULL) {
		  	if (count==0){
				if (strcmp(ayrac,"HERO")==0){
		  			strcpy(character.type,"HERO");
				}
		  		if (strcmp(ayrac,"MONSTER")==0){
					strcpy(character.type,"MONSTER");
				}
			}
			else if (count==1){
				if (strcmp(character.type,"HERO")==0){
					strcpy(struct_hero_array[hero_number].NAME,ayrac);
					strcpy(struct_hero_array[hero_number].SITUATION,"ALÝVE");
					struct_hero_array[hero_number].XP = 0;
				}
				else{
					strcpy(struct_monster_array[monster_number].NAME,ayrac);
					strcpy(struct_monster_array[monster_number].SITUATION,"ALÝVE");
				}
			}
			else if (count==2){
				if (strcmp(character.type,"HERO")==0){
					struct_hero_array[hero_number].HP = atoi(ayrac);
				}
				else{
					struct_monster_array[monster_number].HP = atoi(ayrac);					
				}
			}
			else if (count==3){
				if (strcmp(character.type,"HERO")==0){
					struct_hero_array[hero_number].DAMAGE =atoi(ayrac);
					hero_number++;
				}
				else{
					struct_monster_array[monster_number].DAMAGE = atoi(ayrac);
					monster_number++;
				}
			}
			count++;
			ayrac = strtok(NULL, " ,");
	  	}
	
	}while(!feof(p));
	
	fclose(p);
	
	/* 2.KISIM  COMMANDS KISMI   ->  Dosyadan okuyup commands_array ' e bütün komutlarý atma kýsmý */
	
	char c;
	
	int kelime_sayisi=1,satir_sayisi=1,i=0,j,k;
	
	do{
		c=getc(q);
		if ((int)c==10){
			satir_sayisi++;
		}
	} while(!feof(q));
	
	char ***commands_array = (char ***)malloc(sizeof(char**)*satir_sayisi);
	int *kelime_sayisi_array= (int *) malloc (sizeof(int)*satir_sayisi);
		
	fseek(q,0,SEEK_SET);

	do{
		c=getc(q);
		if ((int)c==32){
			kelime_sayisi++;
		}
		if (((int)c==10) || feof(q)){
			kelime_sayisi_array[i]=kelime_sayisi;
			commands_array[i]=(char ** )malloc(sizeof(char*)*kelime_sayisi);
			i++;
			kelime_sayisi=1;
		}
	} while(!feof(q));
	
	i=0;
	count=0;
	j=0;
	k=0;
	
	fseek(q,0,SEEK_SET);
	
	do{
		fscanf(q,"%s",array);
		if(count!=kelime_sayisi_array[i]){
			
			commands_array[j][k]= (char *) malloc (sizeof(char)*(strlen(array)+1));
			strcpy(commands_array[j][k],array);
			
			k++;
			count++;
		}
		else{
			j++;
			k=0;
			
			commands_array[j][k]= (char *) malloc (sizeof(char)*(strlen(array)+1));
			strcpy(commands_array[j][k],array);
			
			k++;
			i++;
			count=1;
		}
		
	} while(!feof(q));
	
	fclose(q);
	
	/* 3.KISIM  commands_array ile , Dosyayý okuyup kýyaslama yapýp  ona göre fonksiyonlarý çaðýrma kýsmý..
		Bu fonksiyonlarda oluþturulan structlarýn özelliklerinde ve map de deðiþiklik yapýlýr komutlara göre.
	 */
	
	int height,weight,test1=1,test2=1;
	
	for(i=0;i<satir_sayisi;i++){
		if (strcmp(commands_array[i][0],"LOADMAP")==0){
			
			height=atoi(commands_array[i][1]);
			weight=atoi(commands_array[i][2]);
			
		}
	}
	
	char **map_array = (char **)malloc (sizeof(char*) * height);
	LOAD_MAP(&height,&weight,map_array);
	
	i=0;
	while( (i<satir_sayisi) && (test1!=0) & (test2!=0) ){
		
		if (strcmp(commands_array[i][0],"PUT")==0){
			
			if (strcmp(commands_array[i][1],"HERO")==0){
				PUT_HERO( &hero_number, &i, &kelime_sayisi_array[i],map_array, struct_hero_array, commands_array);
			}
			else{
				PUT_MONSTER( &monster_number, &i, &kelime_sayisi_array[i], map_array, struct_monster_array, commands_array);
			}
		}
		
		
		else if(strcmp(commands_array[i][0],"SHOW")==0){
			
			if(strcmp(commands_array[i][1],"HERO")==0){
				SHOW_HERO(struct_hero_array, &hero_number, r);
			}
			
			else if(strcmp(commands_array[i][1],"MONSTER")==0){
				SHOW_MONSTER(struct_monster_array, &monster_number, r);
			}
			else{
				SHOW_MAP(map_array, &height, &weight, r);
			}
		}
		
		else if(strcmp(commands_array[i][0],"ATTACK")==0){
			
			if(strcmp(commands_array[i][1],"HERO")==0){
				test1= ATTACK_HERO( monster_test_array,monster_test_array_2, &hero_number , &monster_number, struct_hero_array , struct_monster_array, map_array,&height,&weight,r);
			}
			else{
				test2= ATTACK_MONSTER(hero_test_array,hero_test_array_2, &hero_number,&monster_number, struct_hero_array , struct_monster_array, map_array,&height,&weight,r);
			}
		}
		else if(strcmp(commands_array[i][0],"MOVE")==0){
			
				MOVE_HERO( &hero_number, &i, &kelime_sayisi_array[i], map_array, struct_hero_array , commands_array, &height, &weight, r);
		}
		
		i++;
		
	}
	
	fclose(r);
	
	free(array);
	free(struct_hero_array);
	free(struct_monster_array);
	
	free(monster_test_array);
	free(monster_test_array_2);
	free(hero_test_array);
	free(hero_test_array_2);
	
	for(i=0;i<height;i++){
		free(map_array[i]);
	}
	free(map_array);
	
	for(i=0;i<satir_sayisi;i++){
		for(j=0;j<kelime_sayisi_array[i];j++){
			free(commands_array[i][j]);
		}
		free(commands_array[i]);
	}
	free(commands_array);

	free(kelime_sayisi_array);

	
	return 0;
}
	

	
	
	
	
	
	


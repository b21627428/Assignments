#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
struct ogr {
       int note;
       char isim[10];
       ogr *next;
};
typedef ogr ogrenci;
int main(){
    ogrenci ilk;
    ogrenci *goster=&ilk;
    int okunanNot=0;
    //ogrenci notlarini okuyan kisim
    while(okunanNot!=-1){
      printf("notunu giriniz\n");
      scanf("%d",&okunanNot);
      if(okunanNot==-1) break;
      goster->note=okunanNot;
      printf("adini girin");
      scanf("%s",goster->isim);
      goster->next=(ogrenci *) malloc(sizeof(ogrenci));
      goster=goster->next;
    }  
    //okunan notlari ekrana basan kisim
    ogrenci *goster2=&ilk;
    while (goster2!= goster){
          printf("ogrenci adi:%s , ",goster2->isim);
          printf("ogrenci notu:%d\n",goster2->note);
          goster2=goster2->next;
          }   
   goster2=&ilk;
   
   //sinif ortalamasi alan kisim
   int sayi=0;
   int toplam=0;
   while (goster2!= goster){
          toplam+=goster2->note;
          sayi++;
          goster2=goster2->next;
   }      
   printf("not ortalamasi : %d \n",toplam/sayi);
   
   // en yuksek notu alan ogrenci icin
   int enyuksek=0;
   goster2=&ilk;
   int sira=0;
   int enyukseksira=0;
   while (goster2!= goster){
          if(goster2->note>enyuksek){
                      enyukseksira=sira;
                      enyuksek=goster2->note;
          }
          sira++;
          goster2=goster2->next;
   }      
   printf("%d notlu ogrenci %d sirasinda bulundu\n",enyuksek,enyukseksira);
   // en yuksek notlu ogrenci kacinsi sirada biliyoruz
   // bu elemana kadar listede gidip adini bulalim
   goster2=&ilk;
   for(int i = 0;i< enyukseksira;i++)
   {
           goster2=goster2->next;
   }
   
   printf("en yuksek not : %d ogrenci adi: %s \n",goster2->note,goster2->isim);
              
          
          getch();
}

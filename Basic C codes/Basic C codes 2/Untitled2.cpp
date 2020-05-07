#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

int * ters(int *a , int size);

int main() {
    int a[10]= {1,2,-3,4,5,2,3,9};
    int *b;
    b= ters(&a[0],8);
    for(int i = 0 ;i<8;i++)
            printf("%d\n",b[i]);

    getch();
    return 0;
}
int * birlestir(int *a, int *b , int size){
        int *x= (int *)malloc(sizeof(int)*size);
        
        for(int i = 0;i<size/2;i++){
                printf("birlesiyor:%d %d",a[i]);
                x[i]=a[i];
        }
        for(int i = 0;i<size/2;i++){
                printf("birlesiyor:%d %d",b[i]);
                x[i+size/2]=b[i];
        }
        return x;
}
    
int * ters(int *a, int size){
    if(size>2){
                                 
        return birlestir(ters(a+size/2,size/2),ters(a,size/2) , size);
    }
    else if(size==2){
         printf("ters: %d %d ",a[0],a[1]);
         int temp=a[0];
         a[0]=a[1];
         a[1]=temp;
         return a;
    }
    else 
         return a;
    
}

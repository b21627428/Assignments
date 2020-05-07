#include 
#include 
#include 
void deepCopy (int *,int *);
void shallowCopy (int *,int *);
void isEqual (int *,int *);
int main(){
    int a[3]={1,2,3};
    int b[3]={3,4,5};
    int c[3];
    int d[3];
    int *p;
    p=(int * )malloc(sizeof(int)*3);
    deepCopy(&a[0],&c[0]);
    deepCopy(&a[0],&p[0]);
    shallowCopy(&b[0],&d[0]);
    shallowCopy(&d[0],&a[0]);
    printf("%d %d",&a[0],&d[0]);
    isEqual(&a[0],&b[0]);
    isEqual(p,&c[0]);
    isEqual(&d[0],&a[0]);
    getch();
}

void deepCopy (int *a,int *b )
{
     
    int i;
    for (i=0;i<3;i++)
    {
     
     b[i]=a[i];
    }
}

void shallowCopy(int *a,int *b )
{
 b=&a[0];
}

void isEqual(int *a,int *b){
     if(&a[0]==&b[0])
                     printf("shallow copy\n");
     else{
          int durum=0;
          for(int i = 0;i<3;i++){
                  if(a[i]!=b[i])
                                durum=1;
          }
          if(durum==0)
                      printf("Deep copy\n");
          else
                      printf("not equal\n");
     }                      
}

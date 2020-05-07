# include <stdio.h>
# include <stdlib.h>
# include <conio.h>

int main ()
{
	int **matris;
	int satir_sayisi, sutun_sayisi;
	int i,k;
    int *dizi;
    	
	void sirala (int satir_sayisi, int *dizi);
	void matris_sirala(int a,int b,int **matris);
	void matris_yazdir(int a,int b,int **matris);

	printf("Girilecek olan dizilerden birisinin uzunlugunu girin (M) > ");
	scanf("%d",& satir_sayisi);
	printf("Kac dizi kullanilacagini girin (N) > ");
	scanf("%d",& sutun_sayisi);

	//satir sayisina göre hafizadan yer ayirma islemleri

	matris = (int **) malloc (satir_sayisi * sizeof(int));
	if (matris==NULL)
		printf("Yetersiz bellek!");

	//her satirda sutun sayisi kadar hücre ayirma islemleri

	for (i=0; i<satir_sayisi; i++)
	{
		matris [i] = (int *) malloc (sutun_sayisi * sizeof(int));
		if (matris[i]==NULL)
		printf("Yetersiz bellek!");
	}

	 for (k=0;k<sutun_sayisi;++k)
	 {
	 dizi = (int *) malloc (satir_sayisi * sizeof(int));

		  {   printf("\n%d. dizinin elemanlari alinacak>\n",k+1);
			printf("[Lutfen elemani girip enter'e basiniz] \n");
				for (i=0;i<satir_sayisi;++i)
			{
					scanf("%d",(dizi+i));
			}

			printf("\n");
			sirala (satir_sayisi, dizi);

			}

			matris[k]=dizi;

		}


    printf("\nOlusan Matris\n\n");
	 matris_yazdir(sutun_sayisi,satir_sayisi,matris);
	 printf("\n");
    matris_sirala(sutun_sayisi,satir_sayisi,matris);  
    printf("Siralanmis matris\n");
	 matris_yazdir(sutun_sayisi,satir_sayisi,matris);



getch();
return 0;
}

void sirala (int satir_sayisi, int *dizi)

{
	int i, item, temp;
	for(item = 0; item< satir_sayisi-1;++item)
		for(i=item+1;i<satir_sayisi;++i)
			if(*(dizi+i)< *(dizi+item))
			{
				temp=*(dizi+item);
				*(dizi+item)=*(dizi+i);
				*(dizi+i)=temp;
			}
	return;
}

void matris_sirala(int a,int b,int **matris)
{
    int i,j,tmp=0,k;
    for (i=0;i<=a;i++)
    {
        for(j=i+1;j<=a;j++)
        {
            if (matris[i][0]>matris[j][0])      //Eðer i. satýrýn ilk elemaný  j.satýrýn ilk elemaný  
            {                                   //ayný ise i.satýr ile j.satýrýn yerini deðiþtir
                for (k=0;k<=b;k++)
                {
                    tmp=matris[i][k];
                    matris[i][k]=matris[j][k];
                    matris[j][k]=tmp;
                }
            }
        }   
    }
}



void matris_yazdir(int a,int b,int **matris)
{
    int i,j;
    
    for (i=0;i<a;++i)
    {
        for (j=0;j<b;++j)
        {
         printf("%5d",matris[i][j]);
        }
    printf("\n");
    }

}      

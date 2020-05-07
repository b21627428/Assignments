import sys
try:
    spp=open(sys.argv[1],"r")
    value=sys.argv[2]
    spd=open("output.txt","w")
    spd.write("Searching value is : {}\n".format(value))
    print("Searching value is : {}".format(value))
    liste=[]
    liste2=[]
    dict={}
    for i in spp.readlines():
        i=i.strip("\n")
        i=i.split(":")
        liste.append(i)
        liste2.append(i[0])

    for i in liste:
        dict[i[0]]=i[1]
    print(*liste2)
    for i in liste2:
        spd.write(i)
        spd.write(" ")
    spd.write("\n")

    kelimedicti={"A":1,"a":1,"B":2,"b":2,"C":3,"c":3,"Ç":4,"ç":4,"D":5,"d":5,"E":6,"e":6,"F":7,"f":7,"G":8,"g":8,"Ğ":9,"ğ":9,"H":8,"h":8,
    "I":9,"ı":9,"İ":10,"i":10,"J":11,"j":11,"K":12,"k":12,"L":13,"l":13,"M":14,"m":14,"N":15,"n":15,"O":16,"o":16,"Ö":17,"ö":17,"P":18,"p":18,
    "Q":19,"q":19,"R":20,"r":20,"S":21,"s":21,"ş":22,"Ş":22,"T":23,"t":23,"U":24,"u":24,"Ü":25,"ü":25,"V":26,"v":26,"W":27,"w":27,"X":28,"x":28,
    "Y":29,"y":29,"Z":30,"z":30}

    liste3=[]
    for i in range(len(liste2)-1):
        x=liste2[i+1]
        z=liste2[:i+1]
        z.reverse()

        for j in z:
            for k in range(len(x)):
                if j[k]!=x[k]:
                    a1=kelimedicti[j[k]]
                    a2=kelimedicti[x[k]]

                    if a1<a2:

                        break

                    else:
                        h = liste2.index(j)
                        h1= liste2.index(x)
                        liste2[h1]=j
                        liste2[h]=x
                        break
    x=liste2[-1]
    for j in z:
        for k in range(len(x)):

            if j[k]!=x[k]:
                a1=kelimedicti[j[k]]
                a2=kelimedicti[x[k]]

                if a1<a2:

                    break

                else:
                    h = liste2.index(j)
                    h1= liste2.index(x)
                    liste2[h1]=j


                    liste2[h]=x
                    break




    def recursion(liste,h0 ):
        for i in liste:
            spd.write(i)
            spd.write(" ")
        spd.write("\n")
        print(*liste)

        if len(liste)%2==0:
            middle=(len(liste)//2)-1
            mid=liste[middle]
        else:
            middle=len(liste)//2
            mid=liste[middle]

        if h0 ==mid or len(liste)==1:
            if h0 ==mid:
                spd.write(mid+"\n")
                print(mid)
                spd.write("\nThe search string is {} and the city is {}".format(h0 ,dict[h0 ]))
                print("\nThe search string is {} and the city is {}".format(h0 ,dict[h0 ]))
            else:
                spd.write("\nThe search string was not found in the file")
                print("\nThe search string was not found in the file")

        else:

            for k in range(len(value)):


                if h0 [k] != mid[k]:
                    a1 = kelimedicti[mid[k]]
                    a2 = kelimedicti[h0 [k]]

                    if a1 < a2:
                        liste=liste[middle+1:]

                        return recursion(liste,h0 )

                    else:
                        liste=liste[:middle]


                        return recursion(liste,h0 )

            if len(mid)>len(value):
                liste = liste[:middle]
                return recursion(liste, h0)

            elif len(value)>len(mid):
                liste = liste[middle + 1:]
                return recursion(liste, h0)


    recursion(liste2,value )

except :
    spd.write("\nThe search string was not found in the file")
    print("\nThe search string was not found in the file")



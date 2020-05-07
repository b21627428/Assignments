import sys
class WrongLetterError(Exception):
    pass
def serialfunction(x):
    try:
        xyz = int(x)
    except ValueError:
        return False
def pricefunction(x):
    try:
        xyz = int(x)
    except ValueError:
        return False
y = True
liste2 = []
try:
    argv = sys.argv[1]
    spd = open(sys.argv[1], "r")
    for i in spd.readlines():
        i = i.strip("\n")
        i = i.strip(";")
        i = i.split(",")
        for j in range(len(i)):
            i[j]=i[j].strip()
            r=""
            for k in i[j]:
                if k==" ":
                    pass
                else:
                    r+=k
            i[j]=r
        liste2.append(i)


except:
    pass
finally:
    try:
        while y == True:
            try:
                print("""---HUBBM DVD----
A: Add new dvd
R: Remove dvd
S: Search dvd 
L: List dvd
E: Edit dvd
H: Hire dvd 
Q: Quit """)
                x = input("Enter a command:")

                x = x.split(",")
                o = 0
                for i in x:
                    i = i.strip('"')
                    i = i.strip('"')
                    i=i.strip()
                    x[o] = i
                    o += 1
                if len(x)>2 and x[0]!="E":
                    try:
                        serial = int(x[1])
                    except ValueError:
                        print("Seriali yanlış girdiniz.Serial sayılardan oluşur.")
                        continue
                    try:
                        price = int(x[2])
                    except ValueError:
                        print("Price yanlış girdiniz.Price sayılardan oluşur.")
                        continue
                elif len(x)>1 and x[0]!="S":
                    try:
                        serial = int(x[1])
                    except ValueError:
                        print("Seriali yanlış girdiniz.Serial sayılardan oluşur.")
                        continue

                if x[0] == "A" and len(x)==6:
                    liste = []
                    liste3 = []
                    serial = x[1]

                    for i in liste2:
                        if i[0] == serial:
                            liste3.append("Y")

                    if "Y" in liste3:
                        print("Aynı serialli dvd tekrar giremezsiniz")

                    else:
                        price = x[2]
                        name = x[3]
                        genre = x[4]
                        director = x[5]
                        state = "Inv"

                        liste.append(str(serial))
                        liste.append(str(price))
                        liste.append(name)
                        liste.append(genre)
                        liste.append(director)
                        liste.append(state)

                        liste2.append(liste)

                elif x[0] == "R" and len(x)==2:

                    liste = []
                    serial = x[1]

                    for i in liste2:
                        if i[0] == serial:
                            liste.append("D")
                            print(*i)

                            a = input("Do you really want to delete this dvd?(Yes/No)")
                            while a != "Yes" and a != "No":
                                a = input("Yes or No:")

                            if a == "Yes" and i[-1] != "Hired":
                                liste2.remove(i)


                            elif i[-1] == "Hired":
                                print("The file is hired.It cannot be removed")

                    if "D" not in liste:
                        print("Böyle bir serial yoktur.")


                elif x[0] == "S" and len(x)==2:

                    try:

                        liste = []
                        liste3 = []
                        name = x[1]
                        x = len(name)
                        for i in liste2:
                            if i[2][:x] == name:
                                liste3.append("D")
                                liste.append(i)
                        if "D" not in liste3:
                            print("{} was not found. ".format(name))
                        else:
                            for i in liste:
                                print(*i)
                    except:
                        print("Bilinmedik bir hata gerçekleşti")
                elif x[0] == "L" and len(x)==1:

                    z0 = len("Serial")
                    z1 = len("Price")
                    z2 = len("Name")
                    z3 = len("Genre")
                    z4 = len("Director")

                    print("Serial" + ((30 - z0) * " ") + "Price" + ((30 - z1) * " ") + "Name" + (
                        (30 - z2) * " ") + "Genre" + ((30 - z3) * " ") + "Director" + ((30 - z4) * " ") + "State")
                    for i in range(5):
                        print("-------------" + (17 * " "), end="")
                    print("-------------" + (17 * " "))

                    liste = []
                    dict = {}
                    for i in liste2:
                        liste13 = []
                        liste13.append(i[2])
                        liste13.append(i[0])
                        liste.append(liste13)

                    liste.sort()

                    liste3 = []
                    for i in liste:
                        for j in liste2:
                            if i[0] == j[2] and i[1] == j[0]:
                                liste3.append(j)

                    liste2 = liste3

                    h = len(liste2)

                    h3 = 0
                    for j in range(h-1):
                        for i in liste2[h3:h3 +1]:
                            y0 = len(i[0])
                            y1 = len(i[1])
                            y2 = len(i[2])
                            y3 = len(i[3])
                            y4 = len(i[4])
                            y5 = len(i[5])

                            print(i[0] + ((30 - y0) * " ") + i[1] + ((30 - y1) * " ") + i[2] + ((30 - y2) * " ") + i[
                                3] + (
                                      (30 - y3) * " ") + i[4] + ((30 - y4) * " ") + i[5])

                            a = input(" ")

                            while a!=" ":
                                print("Yanlış girdiniz.Space+Enter yapınız")
                                a=input(" ")

                        h3 += 1

                    for i in liste2[h3:]:
                            y0 = len(i[0])
                            y1 = len(i[1])
                            y2 = len(i[2])
                            y3 = len(i[3])
                            y4 = len(i[4])
                            y5 = len(i[5])

                            print(i[0], end="")
                            print(((30 - y0) * " "), end="")
                            print(i[1], end="")
                            print(((30 - y1) * " "), end="")
                            print(i[2], end="")
                            print(((30 - y2) * " "), end="")
                            print(i[3], end="")
                            print(((30 - y3) * " "), end="")
                            print(i[4], end="")
                            print(((30 - y4) * " "), end="")
                            print(i[5])

                elif x[0] == "E"and len(x)>2:

                    Serial = x[1]
                    liste = []

                    for i in liste2:
                        if i[0] == Serial:
                            liste.append("D")

                            for k in x[2:]:
                                if ("{" in k) and ("}" in k):
                                    a = 0
                                    for j in k:
                                        if j == "=":
                                            z = k[a + 1:-1]
                                            z = z.strip('"')
                                            z = z.strip('"')
                                            if "Name" in k:
                                                i[2] = z

                                            elif "Price" in k:
                                                i[1] = z
                                            elif "Serial" in k:
                                                print("Serial değiştirilemez")
                                            elif "Genre" in k:
                                                i[3] = z
                                            elif "Director" in k:
                                                i[4] = z
                                            elif "State" in k:
                                                print("State değiştirilemez")
                                        a += 1

                                else:
                                    print("Hatalı giriş yaptınız E,123,{Name='IronMan'},{Price=50} örneği gibi giriniz")
                                    break

                            print(*i)

                    if "D" not in liste:
                        print("Böyle bir serialli dvd yoktur.")


                elif x[0] == "H" and len(x)==2:

                    Serial = x[1]
                    liste = []


                    for i in liste2:
                        if i[0] == Serial and i[-1]!="Hired":
                            liste.append("D")
                            i[-1] = "Hired"
                            print(*i)
                        elif i[0] == Serial and i[-1]=="Hired":
                            liste.append("D")
                            print("Bu dvd zaten kiralanmıştır.İkinci kez tekrar kiralayamazsınız")

                    if "D" not in liste:
                        print("Böyle bir serialli dvd yoktur.")


                elif x[0] == "Q" and len(x)==1:
                    spd = open("dvdStore.txt", "w")

                    print("Quit")
                    for i in liste2:
                        for j in range(len(i)-1):
                            spd.write((i[j]))
                            spd.write(",")
                        spd.write(i[-1]+"\n")

                    y = False
                else:
                    raise WrongLetterError




            except WrongLetterError:
                print(
                    "Yanlış komut girdiniz.Sağdaki örnek gibi bir komut giriniz.-> A,123,25,'Terminator','Action','James Cameron' ")

    except:
        print("Beklenmedik bir hata gerçekleşti.Lütfen islemleri tekrar gerçekleştiriniz.")


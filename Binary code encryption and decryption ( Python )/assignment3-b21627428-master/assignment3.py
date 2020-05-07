import sys
hurap = open(sys.argv[1], "r+")
shuckscii = open(sys.argv[2], "r+")
virus_codes = open(sys.argv[3], "r+")
liste = []  ##keyin olduğu liste
liste1 = []  ## her satırdaki binary yi 4 lü ayıran liste
liste2 = []  ## hexadecimallerin olduğu liste
liste3 = []
liste4 = []
liste5 = []  ## hexanın çevirilmiş halini içerir.              örneğin 'lpsruw#dqqlklodwlrq'
liste6 = []  ## asıl şifreyi verir                             örneğin 'import annihilation'
liste7 = []  ## virus codes deki değişecek kelimeleri verir    örneğin kill self destruct
liste8 = []
liste9 = []  ## mission 10 daki hexadecimal sayıları
dict = {"0000": "0", "0001": "1", "0010": "2", "0011": "3", "0100": "4", "0101": "5", "0110": "6", "0111": "7",
        "1000": "8", "1001": "9",
        "1010": "A", "1011": "B", "1100": "C", "1101": "D", "1110": "E", "1111": "F"}
dict1 = {"0": "0000","1":"0001", "2":"0010", "3": "0011", "4": "0010" , "5":"0101" , "6":"0110" , "7":"0111", "8":"1000", "9":"1001",
         "A":"1010","B":"1011","C":"1100","D":"1101","E":"1110","F":"1111"}
dict2 = {}  # shucksii deki her satırı atan sözlük     örneğin 5F:M
dict3 = {}
dict4 = {}
dict5 = {}
y = 0
shift_amount = 0
for line in shuckscii.readlines():
    line = line.strip("\n")
    liste3.append(line)
for j in liste3:
    liste4.append(str(j).split("\t"))
c = 1
for i in liste4:
    dict2[i[1]] = i[0]
    dict5[i[0]] = i[1]
    dict3[i[0]] = c
    dict4[c] = i[0]
    c += 1
uzunluk = len(liste4)
for i in hurap.readlines():
    i = i.strip("\n")
    liste1 = []
    if i[0] != "1" and i[0] != "0":
        for j in range(len(i)):
            liste.append(i[j])
        liste.remove(liste[0])
        if liste[0] == "1":
            q = 0
            for i in liste:
                if i == "1":
                    liste[q] = 0
                else:
                    liste[q] = 1
                q += 1
            liste.reverse()
            toplam = 0
            for k in range(len(liste)):
                toplam = toplam + ((int(liste[k]) * 2 ** k))
            toplam = -(toplam + 1)
            shift_amount = (toplam + uzunluk) % uzunluk
        else:
            liste.reverse()
            toplam = 0
            for k in range(len(liste)):
                toplam = toplam + ((int(liste[k]) * 2 ** k))
            shift_amount = (toplam + uzunluk) % uzunluk
    else:
        x = 0
        for j in range(len(i) // 4):
            liste1.append(i[x:x + 4])
            x += 4
        B = ""
        for i in liste1:
            B += dict[i]
        liste2.append(B)
        B = ""
        z = 0
        for i in range(len(liste2[y]) // 2):
            B += dict2[liste2[y][z:z + 2]]
            z += 2
        y += 1
        liste5.append(B)
print("*********************\n","    Mission 00","\n*********************\n","\n--- hex of encrypted code ---","\n-----------------------------\n")
for i in liste2:
    print(i)
print("\n--- encrypted code ----","\n-----------------------\n")
for i in liste5:
    print(i)
for i in virus_codes.readlines():
    i = i.strip("\n")
    i = i.split(":")
    liste7.append(i)
for i in liste5:
    A = ""
    for j in i:
        x = int(dict3[j])
        y = x - shift_amount
        if y<0:
            y=uzunluk+y
            A += dict4[y]
        else:
            A += dict4[y]
    liste6.append(A)
print("\n--- decrypted code ----","\n-----------------------\n")
for i in liste6:
    print(i)
for i in liste7:
    x = 0
    for j in liste6:
        if i[0] in j:
            liste6[x] = j.replace(i[0], i[1])
        x += 1
print("\n*********************\n","    Mission 01","\n*********************\n")
for i in liste6:
    print(i)
for i in liste6:
    A = ""
    for j in i:
        x = int(dict3[j])
        y = x + shift_amount
        if y>uzunluk:
            y=y-uzunluk
            A += dict4[y]
        else:
            A += dict4[y]
    liste8.append(A)
print("\n*********************\n","    Mission 10","\n*********************\n","\n--- encrypted code ----","\n-----------------------\n")
for i in liste8:
    print(i)
for i in liste8:
    A = ""
    for j in i:
        A += dict5[j]
    liste9.append(A)
print("\n--- hex of encrypted code ---","\n-----------------------------\n")
for i in liste9:
    print(i)
print("\n--- bin of encrypted code ---","\n-----------------------------\n")
for i in liste9:
    A=""
    for j in i:
        A+=dict1[j]
    print(A)




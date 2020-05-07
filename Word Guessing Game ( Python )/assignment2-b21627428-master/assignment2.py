import sys,re

word=sys.argv[1]
letters=re.split(",",sys.argv[2])

numberOftry = 5 #  guesses left
game="IN"

finish=0# given letters are not finish

result=[]
enteredLettersOnIn=[]
enteredLettersOnOut=[]

print("You have {} guesses left" .format(numberOftry))

#start with -
for i in range(len(word)):
    result.append(""'-'"")
print(result)
print("--------------------------------------------")

for i in letters:

    #all hiden letters are not revealled
    if '-' in result and numberOftry>0:

        # locations of letters
        currentLocation = 0
        numberOfSameLetter = 0
        locations = []
        for j in word:
            if i == j:
                numberOfSameLetter += 1
                locations.append(currentLocation)
            currentLocation += 1

        if game == "IN":

            if i not in enteredLettersOnIn and len(locations) > 0:

                # printing result
                print("Guesses word: {} You are {} mode".format(i, game))
                print("You have {} guesses left".format(numberOftry))

                for k in range(len(locations)):
                    result[locations[k]] = i
                print(result)
                print("--------------------------------------------")

                enteredLettersOnIn.append(i)

            # second time same letter is given  and not in the word
            elif i in enteredLettersOnIn or len(locations) == 0:
                numberOftry -= 1

                if i in enteredLettersOnIn:
                    print("Guesses word: {} is used in {} mode.The game turned into OUT mode".format(i, game))
                else:
                    enteredLettersOnIn.append(i)
                    print("Guessed word {} The game turned into OUT mode".format(i))

                print("You have {} guesses left".format(numberOftry))
                game = "OUT"
                print(result)
                print("--------------------------------------------")

        elif game == "OUT":

            if i not in enteredLettersOnOut and len(locations) == 0:
                game = "IN"
                enteredLettersOnOut.append(i)
                print("Guessed word {} The game turned into IN mode".format(i))
                print("You have {} guesses left".format(numberOftry))
                print(result)
                print("--------------------------------------------")
            else:
                numberOftry -= 1
                print("Guessed word {} You are in OUT mode".format(i))
                print("You have {} guesses left".format(numberOftry))
                print(result)
                print("--------------------------------------------")



    elif numberOftry <= 0 and  '-' not in result:
        finish = 1


if finish ==0 and '-'  in result :
    print("\nYou finished all letters")
    print("You lost the game")
else:
    print("\nYou win the game")
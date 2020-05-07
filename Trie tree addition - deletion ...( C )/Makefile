
output: main.o simulator.o addNode.o searchNode.o LoginSystem.o ListAll.o deleteNodes.o
	gcc main.o simulator.o addNode.o searchNode.o LoginSystem.o ListAll.o deleteNodes.o -o deneme
	
main.o: main.c
	gcc -c main.c

simulator.o: simulator.c functions.h
	gcc -c simulator.c

addNode.o: addNode.c functions.h
	gcc -c addNode.c

searchNode.o: searchNode.c functions.h
	gcc -c searchNode.c
	
LoginSystem.o: LoginSystem.c functions.h
	gcc -c LoginSystem.c
	
ListAll.o: ListAll.c functions.h
	gcc -c ListAll.c

deleteNodes.o: deleteNodes.c functions.h
	gcc -c deleteNodes.c
	
clean:
	rm *.o deneme

output: main.o setMapMatrix.o setKeyMatrix.o search.o mod.o
	g++ main.o setMapMatrix.o setKeyMatrix.o search.o mod.o -o findtreasure
	
main.o: main.c
	g++ -c main.c

setMapMatrix.o: setMapMatrix.c functions.h
	g++ -c setMapMatrix.c

setKeyMatrix.o: setKeyMatrix.c functions.h
	g++ -c setKeyMatrix.c

search.o: search.c functions.h
	g++ -c search.c

mod.o: mod.c functions.h
	g++ -c mod.c

clean:
	rm *.o findtreasure
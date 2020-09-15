testing = hash

all:
	gcc -Wall -c test.c
	gcc -Wall -c $(testing).c
	gcc -o test test.o $(testing).o

clean:
	rm -f test test.o $(testing).o

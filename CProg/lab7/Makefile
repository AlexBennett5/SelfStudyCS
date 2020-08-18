DEBUG_FLAGS = -fsanitize=address -fsanitize=undefined -g -fno-omit-frame-pointer -Wall -pedantic

all:
	gcc -Wall -pedantic -c lab7.c
	gcc -Wall -pedantic -c re.c
	gcc -o lab7 lab7.o re.o

sane:
	gcc ${DEBUG_FLAGS} -c lab7.c
	gcc ${DEBUG_FLAGS} -c re.c
	gcc ${DEBUG_FLAGS} -o lab7 lab7.o re.o

clean:
	rm -f lab7.o re.o lab7


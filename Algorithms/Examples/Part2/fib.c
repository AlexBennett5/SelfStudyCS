#include <stdio.h>

int fib(int n);
void fibwithcounter(int n);

int counter;

int main() {
	fibwithcounter(10);
	fibwithcounter(20);
	fibwithcounter(30);
}

int fib(int n) {
	extern int counter;
	++counter;

	if (n == 0)
		return 1;
	else if (n == 1)
		return 1;
	else
		return fib(n-2) + fib(n-1);
}

void fibwithcounter(int n) {
	extern int counter;
	counter = 0;
	fib(n);
	printf("Fib(%d) took %d function calls\n", n, counter);
}


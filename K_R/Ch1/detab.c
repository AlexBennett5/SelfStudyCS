#include <stdio.h>

#define COL 5

int main() {

	int c, i;

	i = 0;
	while ((c = getchar()) != EOF) {
		++i;
		if (c == '\n') 
			i = 0;
		if (c == '\t') {
			while ((i % COL) != 0) {
				putchar(' ');
				++i;
			}
		} else {
			putchar(c);
		}
	}
}



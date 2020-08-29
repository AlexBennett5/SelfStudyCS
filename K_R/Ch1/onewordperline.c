#include <stdio.h>

#define NEWLINE 10

int main() {

	int c;

	while ((c = getchar()) != EOF) {

		if (c == ' ' || c == '\n' || c == '\t') {
			putchar(NEWLINE);
			while ((c = getchar()) == ' ' || c == '\n' || c == '\t')
				;
			putchar(c);
		} else {
			putchar(c);
		}	

	}
}

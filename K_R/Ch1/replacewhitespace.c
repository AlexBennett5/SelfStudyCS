#include <stdio.h>

#define BACKSLASH 92
#define T 116
#define B 98

int main() {

	int c;

	while ((c = getchar()) != EOF) {
		
		if (c == '\t') {
			putchar(BACKSLASH);
			putchar(T);
		} else if (c == '\b') {
			putchar(BACKSLASH);
			putchar(B);
		} else if (c == '\\') {
			putchar(BACKSLASH);
			putchar(BACKSLASH);
		} else {
			putchar(c);
		}

	}
}



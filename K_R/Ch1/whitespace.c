#include <stdio.h>

int main() {
	int c, ws;

	ws = 0;
	while ((c = getchar()) != EOF)
		if (c == '\n' || c == '\t' || c == ' ')
			++ws;
	printf("%d\n", ws);

}



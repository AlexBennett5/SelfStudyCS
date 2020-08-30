#include <stdio.h>

int main() {

	int c, wl;
	int hist[27];
	for (int i = 0; i < 27; i++)
		hist[i] = 0;

	while ((c = getchar()) != EOF) {

		if (c >= 'A' && c <= 'Z')
			++hist[c - 'A'];
		else if (c >= 'a' && c <= 'z')
			++hist[c - 'a'];
		else
			++hist[26];
	}

	printf("HISTOGRAM\n");

	for (int i = 0; i < 26; i++) {
		printf("%c: ", putchar('A' + i));

		while (hist[i] > 0) {
			printf("#");
			--hist[i];
		}
		printf("\n");
	}

	printf("Other: ");

	while (hist[26] > 0) {
		printf("#");
		--hist[26];
	}

	printf("\n");

}

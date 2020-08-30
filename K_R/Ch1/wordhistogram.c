#include <stdio.h>

int main() {

	int c, wl;
	int hist[10];

	wl = 0;
	for (int i = 0; i < 10; i++)
		hist[i] = 0;

	while ((c = getchar()) != EOF) {

		if ((c == ' ' || c == '\n' || c == '\t') && wl != 0) {

			if (wl >= 10) {
				++hist[9];
			} else {
				++hist[wl-1];
			}
			wl = 0;
		} else if ((c == ' ' || c == '\n' || c == '\t') && wl == 0) {
			;
		} else {	
			wl++;
		}
	}

	printf("HISTOGRAM\n");

	for (int i = 0; i < 9; i++) {
		printf("%d: ", hist[i]);

		while (hist[i] > 0) {
			printf("#");
			--hist[i];
		}
		printf("\n");
	}

	printf("10>=: ");

	while (hist[9] > 0) {
		printf("#");
		--hist[9];
	}

	printf("\n");

}

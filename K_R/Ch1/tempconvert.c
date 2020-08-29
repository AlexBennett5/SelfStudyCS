#include <stdio.h>

int main() {

	float fahr, celsius;
	int lower, upper, step;

	lower = -40;
	upper = 260;
	step = 20;

	celsius = lower;
	printf("===TEMPERATURE TABLE (C to F)===\n");
	while (celsius <= upper) {
		fahr = (9.0/5.0)*celsius + 32.0;
		printf("%6.1f %3.0f\n", celsius, fahr);
		celsius = celsius + step;

	}

}



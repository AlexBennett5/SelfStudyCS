#include <stdio.h>

#define MIN 0
#define STEP 20
#define MAX 300

float fahrtocelsius(float);

int main() {

	float fahr, celsius;
	
	for (fahr = MIN; fahr <= MAX; fahr += STEP)
		printf("%3.0f %6.1f\n", fahr, fahrtocelsius(fahr));
}

float fahrtocelsius(float fahr) {

	return (fahr - 32) * (5.0/9.0);

}

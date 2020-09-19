#include <stdio.h>
#include <ctype.h>

double atof(char s[]);

int main() {

	char a[] = "345.67e2";
	double ret = atof(a);
	printf("%f\n", ret);
}

double atof(char s[]) {
	double val, power;
	int i, sign;

	for (i = 0; isspace(s[i]); i++)
		;
	sign = (s[i] == '-') ? -1 : 1;
	if (s[i] == '+' || s[i] == '-')
		i++;
	for (val = 0.0; isdigit(s[i]); i++)
		val = 10.0 * val + (s[i] - '0');
	if (s[i] == '.')
		i++;
	for (power = 1.0; isdigit(s[i]); i++) {
		val = 10.0 * val + (s[i] - '0');
		power *= 10.0;
	}
	double temp = sign * val / power;
	
	sign = 1;
	if (s[i] == 'e' || s[i] == 'E') {
		i++;
		if (s[i] == '-') {
			sign = -1;
			i++;
		}
	
		int count = 0;
		while (isdigit(s[i]))
			count = 10 * count + (s[i++] - '0');

		if (sign == -1) {
			while (count > 0) {
				temp /= 10.0;
				count--;
			}
		} else {
			while (count > 0) {
				temp *= 10.0;
				count--;
			}
		}
	}

	return temp;
}

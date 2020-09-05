#include <stdio.h>

void lower(char s[]);

int main() {
	char a[] = "THIS IS A TEST";
	lower(a);
	printf("%s\n", a);
}

void lower(char s[]) {
	for (int i = 0; s[i] != '\0'; i++) {
		s[i] = (s[i] >= 'A' && s[i] <= 'Z') ? s[i] + 'a' - 'A' : s[i];
	}
}

#include <stdio.h>

int htoi(char s[]);
int checkbounds(char s[], int i);

int main() {
	printf("%d\n", htoi("0xFFFF"));
}

int htoi(char s[]) {
	int n, c;
	n = c = 0;
	for (int i = 2; checkbounds(s, i); i++) {
		if (s[i] >= '0' && s[i] <= '9')
			c = s[i] - '0';
		if (s[i] >= 'a' && s[i] <= 'f')
			c = s[i] - 'a' + 10;
		if (s[i] >= 'A' && s[i] <= 'F')
			c = s[i] - 'A' + 10;
		n = 16 * n + c;
	}
	return n;
}

int checkbounds(char s[], int i) {
	return (s[i] >= '0' && s[i] <= '9') || (s[i] >= 'a' && s[i] <= 'f') || (s[i] >= 'A' && s[i] <= 'F');
}


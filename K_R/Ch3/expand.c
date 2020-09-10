#include <stdio.h>

#define MAXLEN 300

void expand(char s[], char t[]);
int fillup (int a, int b, char t[], int i);
int filldown (int a, int b, char t[], int i);

int main() {
	char s[] = "H-A";
	char t[MAXLEN];
	expand(s, t);
	printf("%s\n", t);
}

void expand(char s[], char t[]) {
	int i, j;
	i = j = 0;
	int a, b;

	while (s[i] != '\0') {
		
		if (s[i+1] == '-' && s[i] <= s[i+2]) {
			a = s[i++];
			b = s[++i];
			j = fillup(a, b, t, j);	
		} else if (s[i+1] == '-' && s[i] >= s[i+2]) {
			a = s[i++];
			b = s[++i];
			j = filldown(a, b, t, j);
		} else {
			++i;
		}
	}
	t[j] = '\0';
}

int fillup(int a, int b, char t[], int i) {
	int ins = a;
	while (ins <= b) {
		t[i++] = ins++;
	}
	return i;
}

int filldown(int a, int b, char t[], int i) {
	int ins = a;
	while (ins >= b) {
		t[i++] = ins--;
	}
	return i;
}

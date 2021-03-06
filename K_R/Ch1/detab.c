#include <stdio.h>

#define MAXLENGTH 100
#define TABWIDTH 7

int getcharline(char s[], int len);
void detab(char s[], char t[], int len, int tabwidth);

int main() {

	int len;
	char line[MAXLENGTH];
	char detabbed[MAXLENGTH];

	while ((len = getcharline(line, MAXLENGTH)) > 0) {
		detab(line, detabbed, MAXLENGTH, TABWIDTH);
		printf("%s\n", detabbed);
	}

}

int getcharline(char s[], int len) {
	int c, i;

	for (i = 0; i < len - 1 && (c = getchar()) != EOF && c != '\n'; i++)
		s[i] = c;
	if (c == '\n') {
		s[i] = c;
		++i;
	}
	s[i] = '\0';
	return i;
}

void detab(char s[], char t[], int len, int tabwidth) {
	int i, j;
	i = j = 0;
	while (s[i] != '\0') {
		if (s[i] == '\t') {
			int whitespace = tabwidth - (i % tabwidth);
			for (int k = 0; k < whitespace; k++)
				t[j++] = ' ';
		} else {
			t[j++] = s[i];
		}
		++i;
	}
	t[len - 1] = '\0';
}

